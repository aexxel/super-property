package com.aexxel.superproperty.core.main;

import com.aexxel.superproperty.core.ConfigProperty;
import com.aexxel.superproperty.core.InitializeAdapter;
import com.aexxel.superproperty.core.LocalizedProperty;
import com.aexxel.superproperty.core.Property;
import com.aexxel.superproperty.core.ValueConverter;
import com.aexxel.superproperty.core.util.Collections;
import com.aexxel.superproperty.core.util.Objects;
import com.aexxel.superproperty.core.util.Runtimes;

import java.util.Set;

/**
 * A main that createConfig a ConfigProperty and  initialize all the super properties from the calling class.
 */
public final class Factory {

   private static final FactoryDelegate FACTORY_DELEGATE = new FactoryDelegate();
   private static final ValueConverterManager VALUE_CONVERTER_MANAGER = new ValueConverterManager();
   private static final String DEFAULT_VALUE_MSG = "The default value should not be null";

   /**
    * Hidden constructor for an utility class.
    */
   private Factory() {
   }

   /**
    */
   public static <T> ConfigProperty<T> createConfig() {
      final Class<?> callerClass = Runtimes.getCallerClass();
      return FACTORY_DELEGATE.defineConfigProperty(null, null, callerClass);
   }

   /**
    */
   @SuppressWarnings("unchecked")
   public static <T> ConfigProperty<T> createConfig(final T aDefaultValue) {
      final Class<?> callerClass = Runtimes.getCallerClass();
      Objects.isNull(aDefaultValue, DEFAULT_VALUE_MSG);
      ValueConverter<T> valueConverter = null;
      if (aDefaultValue != null) {
         valueConverter = (ValueConverter<T>) VALUE_CONVERTER_MANAGER.getConverter(aDefaultValue.getClass());
      }
      return FACTORY_DELEGATE.defineConfigProperty(aDefaultValue, valueConverter, callerClass);
   }

   /**
    */
   public static <T> ConfigProperty<T> createConfig(
         final T aDefaultValue, final ValueConverter<T> aValueConverter) {
      final Class<?> callerClass = Runtimes.getCallerClass();
      Objects.isNull(aDefaultValue, DEFAULT_VALUE_MSG);
      Objects.isNull(aValueConverter, "The input value converter should not be null");
      return FACTORY_DELEGATE.defineConfigProperty(aDefaultValue, aValueConverter, callerClass);
   }

   /**
    */
   public static LocalizedProperty createLocalized() {
      final Class<?> callerClass = Runtimes.getCallerClass();
      return FACTORY_DELEGATE.defineLocalizedProperty(null, callerClass);
   }

   /**
    */
   @SuppressWarnings("unchecked")
   public static LocalizedProperty createLocalized(final String aDefaultValue) {
      final Class<?> callerClass = Runtimes.getCallerClass();
      Objects.isNull(aDefaultValue, DEFAULT_VALUE_MSG);
      return FACTORY_DELEGATE.defineLocalizedProperty(aDefaultValue, callerClass);
   }

   /**
    */
   public static Set<Property<?>> initialize() {
      final Class<?> callerClass = Runtimes.getCallerClass();
      final Set<Property<?>> result = Collections.newSet();
      Set<AbstractProperty<?>> properties = FACTORY_DELEGATE.initialize(callerClass, null);
      for (AbstractProperty<?> property : properties) {
         result.add(property);
      }
      return result;
   }

   /**
    */
   public static Set<Property<?>> initialize(final InitializeAdapter initializeAdapter) {
      final Class<?> callerClass = Runtimes.getCallerClass();
      Objects.isNull(initializeAdapter, "The initialize adapter should not be null");
      final Set<Property<?>> result = Collections.newSet();
      Set<AbstractProperty<?>> properties = FACTORY_DELEGATE.initialize(callerClass, initializeAdapter);
      for (AbstractProperty<?> property : properties) {
         result.add(property);
      }
      return result;
   }

   /**
    */
   public static Set<Property<?>> initialize(
         final Class<?> callerClass, final InitializeAdapter initializeAdapter) {
      Objects.isNull(callerClass, "The input class should not be null");
      Objects.isNull(initializeAdapter, "The initialize adapter should not be null");
      final Set<Property<?>> result = Collections.newSet();
      Set<AbstractProperty<?>> properties = FACTORY_DELEGATE.initialize(callerClass, initializeAdapter);
      for (AbstractProperty<?> property : properties) {
         result.add(property);
      }
      return result;
   }
}
