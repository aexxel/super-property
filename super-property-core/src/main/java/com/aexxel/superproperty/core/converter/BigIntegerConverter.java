package com.aexxel.superproperty.core.converter;

import com.aexxel.superproperty.core.ValueConverter;

import java.math.BigInteger;
import java.util.logging.Logger;

/**
 */
public final class BigIntegerConverter implements ValueConverter<BigInteger> {

   private static final Logger LOGGER = Logger.getLogger(BigIntegerConverter.class.getName());
   private static final long serialVersionUID = 1L;

   /**
    * {@inheritDoc}
    */
   public BigInteger convert(final String value) {
      if (value == null) {
         return null;
      }
      final BigInteger result;
      try {
         result = new BigInteger(value.trim());
      }
      catch (final NumberFormatException e) {
         final String message = "The input value " + value + " is not a BigInteger";
         LOGGER.warning(message);
         throw new IllegalArgumentException(message);
      }
      return result;
   }

   /**
    * {@inheritDoc}
    */
   public Class<BigInteger> getValueClass() {
      return BigInteger.class;
   }

   /**
    */
   public String toString() {
      return "BigIntegerConverter{}";
   }
}
