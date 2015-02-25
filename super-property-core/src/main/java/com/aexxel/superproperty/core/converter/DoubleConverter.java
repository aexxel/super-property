package com.aexxel.superproperty.core.converter;

import com.aexxel.superproperty.core.ValueConverter;

import java.util.logging.Logger;

/**
 */
public final class DoubleConverter implements ValueConverter<Double> {

   private static final Logger LOGGER = Logger.getLogger(DoubleConverter.class.getName());

   /**
    * {@inheritDoc}
    */
   public Double convert(final String value) {
      if (value == null) {
         return null;
      }
      final double result;
      try {
         result = Double.parseDouble(value.trim());
      } catch (final NumberFormatException e) {
         final String message = "The input value " + value + " is not a double";
         LOGGER.warning(message);
         throw new IllegalArgumentException(message);
      }
      return result;
   }

   /**
    * {@inheritDoc}
    */
   public Class<Double> getValueClass() {
      return Double.class;
   }

   /**
    */
   public String toString() {
      return "DoubleConverter{}";
   }
}
