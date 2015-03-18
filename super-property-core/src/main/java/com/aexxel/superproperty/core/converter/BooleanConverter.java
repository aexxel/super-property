package com.aexxel.superproperty.core.converter;

import com.aexxel.superproperty.core.ValueConverter;

/**
 */
public final class BooleanConverter implements ValueConverter<Boolean> {

   /**
    * {@inheritDoc}
    */
   public Boolean convert(final String value) {
      if (value == null) {
         return Boolean.FALSE;
      }
      return Boolean.parseBoolean(value.trim());
   }

   /**
    * {@inheritDoc}
    */
   public Class<Boolean> getValueClass() {
      return Boolean.class;
   }

   /**
    */
   public String toString() {
      return "BooleanConverter{}";
   }
}
