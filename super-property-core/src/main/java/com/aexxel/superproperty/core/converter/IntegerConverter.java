package com.aexxel.superproperty.core.converter;

import com.aexxel.superproperty.core.ValueConverter;

import java.util.logging.Logger;

/**
 */
public final class IntegerConverter implements ValueConverter<Integer> {

   private static final Logger LOGGER = Logger.getLogger(IntegerConverter.class.getName());
   private static final long serialVersionUID = 1L;

   /**
    * {@inheritDoc}
    */
   public Integer convert(final String value) {
      if (value == null) {
         return null;
      }
      final int result;
      try {
         result = Integer.parseInt(value.trim());
      }
      catch (final NumberFormatException e) {
         final String message = "The input value " + value + " is not an integer";
         LOGGER.warning(message);
         throw new IllegalArgumentException(message);
      }
      return result;
   }

   /**
    * {@inheritDoc}
    */
   public Class<Integer> getValueClass() {
      return Integer.class;
   }

   /**
    */
   public String toString() {
      return "IntegerConverter{}";
   }
}
