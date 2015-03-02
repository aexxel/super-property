package com.aexxel.superproperty.core.converter;

import com.aexxel.superproperty.core.ValueConverter;

import java.util.logging.Logger;

/**
 */
public final class ByteConverter implements ValueConverter<Byte> {

   private static final Logger LOGGER = Logger.getLogger(ByteConverter.class.getName());
   private static final long serialVersionUID = 1L;

   /**
    * {@inheritDoc}
    */
   public Byte convert(final String value) {
      if (value == null) {
         return null;
      }
      final byte result;
      try {
         result = Byte.parseByte(value.trim());
      } catch (final NumberFormatException e) {
         final String message = "The input value " + value + " is not a byte";
         LOGGER.warning(message);
         throw new IllegalArgumentException(message);
      }
      return result;
   }

   /**
    * {@inheritDoc}
    */
   public Class<Byte> getValueClass() {
      return Byte.class;
   }

   /**
    */
   public String toString() {
      return "ByteConverter{}";
   }
}
