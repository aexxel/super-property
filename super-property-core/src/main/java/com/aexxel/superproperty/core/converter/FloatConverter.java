package com.aexxel.superproperty.core.converter;

import com.aexxel.superproperty.core.ValueConverter;

import java.util.logging.Logger;

/**
 */
public final class FloatConverter implements ValueConverter<Float> {

   private static final Logger LOGGER = Logger.getLogger(FloatConverter.class.getName());

   /**
    * {@inheritDoc}
    */
   public Float convert(final String value) {
      if (value == null) {
         return null;
      }
      final float result;
      try {
         result = Float.parseFloat(value.trim());
      } catch (final NumberFormatException e) {
         final String message = "The input value " + value + " is not a float";
         LOGGER.warning(message);
         throw new IllegalArgumentException(message);
      }
      return result;
   }

   /**
    * {@inheritDoc}
    */
   public Class<Float> getValueClass() {
      return Float.class;
   }

   /**
    */
   public String toString() {
      return "FloatConverter{}";
   }
}
