package com.aexxel.superproperty.core.converter;

import com.aexxel.superproperty.core.ValueConverter;

import java.math.BigDecimal;
import java.util.logging.Logger;

/**
 */
public final class BigDecimalConverter implements ValueConverter<BigDecimal> {

   private static final Logger LOGGER = Logger.getLogger(BigDecimalConverter.class.getName());
   private static final long serialVersionUID = 1L;

   /**
    * {@inheritDoc}
    */
   public BigDecimal convert(final String value) {
      if (value == null) {
         return null;
      }
      final BigDecimal result;
      try {
         result = new BigDecimal(value.trim());
      }
      catch (final NumberFormatException e) {
         final String message = "The input value " + value + " is not a BigDecimal";
         LOGGER.warning(message);
         throw new IllegalArgumentException(message);
      }
      return result;
   }

   /**
    * {@inheritDoc}
    */
   public Class<BigDecimal> getValueClass() {
      return BigDecimal.class;
   }

   /**
    */
   public String toString() {
      return "BigDecimalConverter{}";
   }
}
