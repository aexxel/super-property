package com.aexxel.superproperty.core.main;

import com.aexxel.superproperty.core.ValueConverter;
import com.aexxel.superproperty.core.converter.*;
import com.aexxel.superproperty.core.util.Collections;
import com.aexxel.superproperty.core.util.Objects;

import java.util.Map;

/**
 */
final class ValueConverterManager {

   private static final Map<Class<?>, ValueConverter<?>> CONVERTER_MAP = Collections.newMap();

   /**
    * These are the standard value converters.
    */
   static {
      addConverter(new BigDecimalConverter());
      addConverter(new BigIntegerConverter());
      addConverter(new BooleanConverter());
      addConverter(new ByteConverter());
      addConverter(new CharacterConverter());
      addConverter(new ClassConverter());
      addConverter(new DateConverter());
      addConverter(new DoubleConverter());
      addConverter(new FloatConverter());
      addConverter(new IntegerConverter());
      addConverter(new LongConverter());
      addConverter(new ShortConverter());
      addConverter(new StringConverter());
      addConverter(new TimestampConverter());
      addConverter(new URIConverter());
      addConverter(new URLConverter());
   }

   /**
    */
   private static void addConverter(final ValueConverter<?> valueConverter) {
      CONVERTER_MAP.put(valueConverter.getValueClass(), valueConverter);
   }

   /**
    */
   @SuppressWarnings({"rawtypes", "unchecked"})
   <T> ValueConverter<T> getConverter(final Class<T> aValueClass) {
      Objects.isNull(aValueClass, "The input class should not be null");
      final ValueConverter<T> result = (Enum.class.isAssignableFrom(aValueClass)) ?
            new EnumConverter(aValueClass) :
            getEffectiveValueConverter(aValueClass);
      Objects.isNull(result, "The input {} does not have a standard converter", aValueClass);
      return result;
   }

   /**
    */
   @SuppressWarnings("unchecked")
   private <T> ValueConverter<T> getEffectiveValueConverter(final Class<T> aValueClass) {
      return (ValueConverter<T>) CONVERTER_MAP.get(aValueClass);
   }
}
