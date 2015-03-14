package com.aexxel.superproperty.core.converter;

import com.aexxel.superproperty.core.ValueConverter;

import java.util.logging.Logger;

/**
 */
public final class LongConverter implements ValueConverter<Long> {

   private static final Logger LOGGER = Logger.getLogger(LongConverter.class.getName());
   private static final long serialVersionUID = 1L;

   /**
    * {@inheritDoc}
    */
   public Long convert(final String value) {
      if (value == null) {
         return null;
      }
      final long result;
      try {
         result = Long.parseLong(value.trim());
      } catch (final NumberFormatException e) {
         final String message = "The input value " + value + " is not a long";
         LOGGER.warning(message);
         throw new IllegalArgumentException(message);
      }
      return result;
   }

   /**
    * {@inheritDoc}
    */
   public Class<Long> getValueClass() {
      return Long.class;
   }

   /**
    */
   public String toString() {
      return "LongConverter{}";
   }
}
