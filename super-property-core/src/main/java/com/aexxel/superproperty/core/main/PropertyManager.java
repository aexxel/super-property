package com.aexxel.superproperty.core.main;

import com.aexxel.superproperty.core.Characteristics;
import com.aexxel.superproperty.core.ConfigProperty;
import com.aexxel.superproperty.core.ValueConverter;
import com.aexxel.superproperty.core.util.Collections;
import com.aexxel.superproperty.core.util.Objects;
import com.aexxel.superproperty.core.util.Strings;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the main class of the Super Property project.</br>
 * It manages all the super properties created by the super property main.
 */
final class PropertyManager {

   private static final Logger LOGGER = Logger.getLogger(PropertyManager.class.getName());
   public static final int PARAMETRIZED_TYPE_INDEX = 1;
   public static final int WILDCARD_TYPE_INDEX = 2;
   public static final int OTHER_TYPE_INDEX = 3;
   public static final String ON_THIS_FIELD = " on this field ";
   private final ValueConverterManager valueConverterManager;
   private final ConcurrentMap<ClassContext, List<AbstractProperty<?>>> registeredProperties;
   private final ConcurrentMap<ClassContext, Lock> classLocks;
   private final ConcurrentMap<ClassContext, ConcurrentMap<String, AbstractProperty<?>>> resolvedProperties;

   /**
    */
   PropertyManager() {
      this.valueConverterManager = new ValueConverterManager();
      this.registeredProperties = Collections.newConcurrentMap();
      this.classLocks = Collections.newConcurrentMap();
      this.resolvedProperties = Collections.newConcurrentMap();
   }

   /**
    */
   void register(final ClassContext classContext, final AbstractProperty<?> property) {
      if (classContext == null || property == null) {
         return;
      }
      List<AbstractProperty<?>> list = this.registeredProperties.get(classContext);
      if (list == null) {
         list = Collections.newList();
         this.registeredProperties.put(classContext, list);
         this.classLocks.put(classContext, new ReentrantLock());
      }
      list.add(property);
   }

   /**
    */
   boolean isResolved(final ClassContext classContext) {
      return this.resolvedProperties.containsKey(classContext);
   }

   /**
    */
   Set<AbstractProperty<?>> initialize(final ClassContext classContext) {
      Objects.isNull(classContext, "The input class context should not be null");
      final Set<AbstractProperty<?>> result = Collections.newSet();
      final Lock lock = this.classLocks.get(classContext);
      final List<AbstractProperty<?>> registeredList = this.registeredProperties.get(classContext);

      if (lock == null || registeredList == null) {
         final String message = "The class context " + classContext + " is not registered";
         LOGGER.warning(message);
         throw new IllegalStateException(message);
      } else {
         final Set<AbstractProperty<?>> set = initialize(classContext, lock, registeredList);
         result.addAll(set);
      }
      return result;
   }

   /**
    */
   private Set<AbstractProperty<?>> initialize(
         final ClassContext classContext, final Lock lock, final List<AbstractProperty<?>> registeredList) {
      final Set<AbstractProperty<?>> result = Collections.newSet();

      lock.lock();
      try {
         ConcurrentMap<String, AbstractProperty<?>> resolvedMap = this.resolvedProperties.get(classContext);
         if (resolvedMap == null) {
            resolvedMap = Collections.newConcurrentMap();
            final List<Field> propertyFields = getPropertyFields(classContext.getDeclaringClass());
            for (final Field field : propertyFields) {
               final AbstractProperty<?> found = findProperty(registeredList, resolvedMap, field);
               if (found == null) {
                  final String
                        message =
                        "No defined or configured property for " + field.getName() + " field";
                  LOGGER.warning(message);
                  throw new IllegalStateException(message);
               } else {
                  result.add(found);
               }
            }
            this.resolvedProperties.put(classContext, resolvedMap);
         }
      } finally {
         lock.unlock();
      }
      return result;
   }

   /**
    */
   List<Field> getPropertyFields(final Class<?> aClass) {
      Objects.isNull(aClass, "The input class should not be null");
      final List<Field> result = Collections.newList();
      final Field[] fields = aClass.getDeclaredFields();
      for (final Field field : fields) {
         final int modifiers = field.getModifiers();
         final Class<?> type = field.getType();
         if (Modifier.isStatic(modifiers) && (ConfigProperty.class.isAssignableFrom(type))) {
            result.add(field);
         }
      }
      return result;
   }

   private AbstractProperty<?> findProperty(
         final List<AbstractProperty<?>> registeredList,
         final ConcurrentMap<String, AbstractProperty<?>> map,
         final Field field) {
      AbstractProperty<?> result = null;
      final Object reference = getReference(field);
      for (final AbstractProperty<?> property : registeredList) {
         if (reference == property) {
            result = property;
            final String name = field.getName();
            property.setName(name);
            property.setKey(Strings.transformToJavaKey(name));
            map.put(name, property);
            if (property instanceof AbstractConvertedProperty) {
               AbstractConvertedProperty<?> convertedProperty = (AbstractConvertedProperty<?>) property;
               if (convertedProperty.isValueConverterMissing()) {
                  final Class<?> valueClass = getGenericType(field);
                  setValueConverterNoWarnings(convertedProperty, valueClass);
               }
            }
            if (field.isAnnotationPresent(Characteristics.class)) {
               Annotation annotation = field.getAnnotation(Characteristics.class);
               Characteristics characteristics = (Characteristics) annotation;
               property.setConstraint(characteristics.value());
            }
            break;
         }
      }
      return result;
   }

   /**
    * Input field is supposed to be of a static modifier.
    */
   private Object getReference(final Field field) {
      Objects.isNull(field, "The input field should not be null");
      final Object result;
      try {
         field.setAccessible(true);
         result = field.get(null);
      } catch (final IllegalAccessException e) {
         final String message = "Could not access field " + field.getName();
         LOGGER.log(Level.WARNING, message, e);
         throw new IllegalStateException(message, e);
      }
      return result;
   }

   /**
    */
   private Class<?> getGenericType(final Field field) {
      Objects.isNull(field, "The input field should not be null");
      final Type genericType = field.getGenericType();
      Objects.isNull(genericType, "The {} field should be of a generic type", field);
      final Class<?> result;

      if (genericType instanceof ParameterizedType) {
         final Type type = getType((ParameterizedType) genericType, field);

         if (type instanceof ParameterizedType) {
            final Type classType = getType((ParameterizedType) type, field);
            result = getClass(classType, PARAMETRIZED_TYPE_INDEX, genericType, field);
         } else if (type instanceof WildcardType) {
            final Type classType = getType((WildcardType) type, field);
            result = getClass(classType, WILDCARD_TYPE_INDEX, genericType, field);
         } else {
            result = getClass(type, OTHER_TYPE_INDEX, genericType, field);
         }
      } else {
         final String message = "This generic type is not supported " +
               genericType +
               ON_THIS_FIELD +
               field;
         LOGGER.warning(message);
         throw new IllegalArgumentException(message);
      }
      return result;
   }

   /**
    */
   private Type getType(final ParameterizedType parameterizedType, final Field field) {
      final Type[] types = parameterizedType.getActualTypeArguments();
      if (Collections.isEmpty(types)) {
         final String message = "There should be at least one type argument for " +
               parameterizedType +
               ON_THIS_FIELD +
               field;
         LOGGER.warning(message);
         throw new IllegalArgumentException(message);
      }
      if (types.length > 1) {
         final String message = "There should be only one type argument for " +
               parameterizedType +
               ON_THIS_FIELD +
               field;
         LOGGER.warning(message);
         throw new IllegalArgumentException(message);
      }
      return types[0];
   }

   /**
    */
   private Type getType(final WildcardType wildcardType, final Field field) {
      final Type[] upperTypes = wildcardType.getUpperBounds();
      final Type[] lowerTypes = wildcardType.getLowerBounds();
      if (Collections.isMoreThanOne(lowerTypes)) {
         final String message = "There should be only one lower bound for " +
               wildcardType +
               ON_THIS_FIELD +
               field;
         LOGGER.warning(message);
         throw new IllegalArgumentException(message);
      }
      if (Collections.isMoreThanOne(upperTypes)) {
         final String message = "There should be only one upper bound for " +
               wildcardType +
               ON_THIS_FIELD +
               field;
         LOGGER.warning(message);
         throw new IllegalArgumentException(message);
      }
      if (Collections.isEmpty(upperTypes) && Collections.isEmpty(lowerTypes)) {
         final String message = "Could not find any bounds for " +
               wildcardType +
               ON_THIS_FIELD +
               field +
               ". Therefore, String is considered as the value type";
         LOGGER.warning(message);
         throw new IllegalArgumentException(message);
      }
      if (lowerTypes.length > 0) {
         return lowerTypes[0];
      }
      return upperTypes[0];
   }

   /**
    */
   private Class<?> getClass(final Type type, final int index, final Type genericType, final Field field) {
      final Class<?> result;
      if (type instanceof Class) {
         result = (Class<?>) type;
         if (Object.class.equals(result)) {
            final String message = "Object of generic type is not supported " +
                  genericType +
                  ON_THIS_FIELD +
                  field +
                  ", index " +
                  index;
            LOGGER.warning(message);
            throw new IllegalArgumentException(message);
         }
      } else {
         final String message = "This generic type is not supported " +
               genericType +
               ON_THIS_FIELD +
               field +
               ", index " +
               index;
         LOGGER.warning(message);
         throw new IllegalArgumentException(message);
      }
      return result;
   }

   /**
    */
   @SuppressWarnings({"rawtypes", "unchecked"})
   private void setValueConverterNoWarnings(
         final AbstractConvertedProperty<?> property, final Class<?> valueClass) {
      final ValueConverter valueConverter = this.valueConverterManager.getConverter(valueClass);
      property.setValueConverter(valueConverter);
   }

   /**
    */
   public String toString() {
      return "PropertyManager{" +
            "registeredProperties=" +
            (this.registeredProperties == null ? "" : this.registeredProperties.keySet()) +
            '}';
   }
}
