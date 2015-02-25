package com.aexxel.superproperty.core.converter;

import com.aexxel.superproperty.core.ValueConverter;

/**
 */
public final class CharacterConverter implements ValueConverter<Character> {

   /**
    * {@inheritDoc}
    */
   public Character convert(final String value) {
      if (value == null || value.length() < 1) {
         return null;
      }
      return value.trim().charAt(0);
   }

   /**
    * {@inheritDoc}
    */
   public Class<Character> getValueClass() {
      return Character.class;
   }

   /**
    */
   public String toString() {
      return "CharacterConverter{}";
   }
}
