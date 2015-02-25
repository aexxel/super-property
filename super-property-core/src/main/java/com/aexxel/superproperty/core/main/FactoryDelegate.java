package com.aexxel.superproperty.core.main;

import com.aexxel.superproperty.core.ConfigProperty;
import com.aexxel.superproperty.core.InitializeAdapter;
import com.aexxel.superproperty.core.LocalizedProperty;
import com.aexxel.superproperty.core.ValueConverter;
import com.aexxel.superproperty.core.util.Collections;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

/**
 *
 */
final class FactoryDelegate {

   private final ConcurrentMap<Class<?>, ClassContext> classContextsMap;
   private final PropertyManager propertyManager;
   private final ValueFetcherFactory valueFetcherFactory;

   /**
    */
   FactoryDelegate() {
      this.classContextsMap = Collections.newConcurrentMap();
      this.propertyManager = new PropertyManager();
      this.valueFetcherFactory = new ValueFetcherFactory();
   }

   /**
    */
   <T> ConfigProperty<T> defineConfigProperty(
         final T defaultValue, final ValueConverter<T> valueConverter, final Class<?> callerClass) {
      if (callerClass == null) {
         return null;
      }
      ClassContext classContext = this.classContextsMap.get(callerClass);
      if (classContext == null) {
         classContext = new ClassContext(callerClass, this.propertyManager, this.valueFetcherFactory);
         this.classContextsMap.put(callerClass, classContext);
      }
      final DefaultConfigProperty<T> result = new DefaultConfigProperty<T>(classContext,
            defaultValue,
            valueConverter);
      this.propertyManager.register(classContext, result);
      return result;
   }

   /**
    */
   LocalizedProperty defineLocalizedProperty(final String defaultValue, final Class<?> callerClass) {
      if (callerClass == null) {
         return null;
      }
      ClassContext classContext = this.classContextsMap.get(callerClass);
      if (classContext == null) {
         classContext = new ClassContext(callerClass, this.propertyManager, this.valueFetcherFactory);
         this.classContextsMap.put(callerClass, classContext);
      }
      final DefaultLocalizedProperty result = new DefaultLocalizedProperty(classContext, defaultValue);
      this.propertyManager.register(classContext, result);
      return result;
   }

   /**
    */
   Set<AbstractProperty<?>> initialize(
         final Class<?> callerClass, final InitializeAdapter initializeAdapter) {
      Set<AbstractProperty<?>> result = Collections.newSet();
      ClassContext classContext = this.classContextsMap.get(callerClass);
      if (classContext == null) {
         Collection<ClassContext> collection = this.classContextsMap.values();
         if (!Collections.isEmpty(collection)) {
            for (ClassContext context : collection) {
               context.setInitializeAdapter(initializeAdapter);
               result.addAll(context.initialize());
            }
         }
      } else {
         classContext.setInitializeAdapter(initializeAdapter);
         result = classContext.initialize();
      }
      return result;
   }

   /**
    */
   public String toString() {
      return "FactoryDelegate{" +
            "classContextsMap=" + this.classContextsMap +
            ", propertyManager=" + this.propertyManager +
            '}';
   }
}
