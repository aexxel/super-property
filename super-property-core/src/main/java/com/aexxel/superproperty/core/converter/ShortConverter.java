package com.aexxel.superproperty.core.converter;

import com.aexxel.superproperty.core.ValueConverter;

import java.util.logging.Logger;

/**
 */
public final class ShortConverter implements ValueConverter<Short> {

   private static final Logger LOGGER = Logger.getLogger(ShortConverter.class.getName());

   /**
    * {@inheritDoc}
    */
   public Short convert(final String value) {
      if (value == null) {
         return null;
      }
      final short result;
      try {
         result = Short.parseShort(value.trim());
      } catch (final NumberFormatException e) {
         final String message = "The input value " + value + " is not a short";
         LOGGER.warning(message);
         throw new IllegalArgumentException(message, e);
      }
      return result;
   }

   /**
    * {@inheritDoc}
    */
   public Class<Short> getValueClass() {
      return Short.class;
   }

   /**
    */
   public String toString() {
      return "ShortConverter{}";
   }
}
