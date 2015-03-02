package com.aexxel.superproperty.core.converter;

import com.aexxel.superproperty.core.ValueConverter;

/**
 */
public final class StringConverter implements ValueConverter<String> {

   private static final long serialVersionUID = 1L;

   /**
    * {@inheritDoc}
    */
   public String convert(final String value) {
      return value;
   }

   /**
    * {@inheritDoc}
    */
   public Class<String> getValueClass() {
      return String.class;
   }

   /**
    */
   public String toString() {
      return "StringConverter{}";
   }
}
