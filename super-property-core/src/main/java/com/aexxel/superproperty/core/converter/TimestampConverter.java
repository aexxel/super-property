package com.aexxel.superproperty.core.converter;

import com.aexxel.superproperty.core.ValueConverter;

import java.sql.Timestamp;

/**
 * Converts a string to a timestamp, format yyyy-mm-dd hh:mm:ss.[fff...].
 */
public final class TimestampConverter implements ValueConverter<Timestamp> {

   /**
    * {@inheritDoc}
    */
   public Timestamp convert(final String value) {
      if (value == null) {
         return null;
      }
      return Timestamp.valueOf(value.trim());
   }

   /**
    * {@inheritDoc}
    */
   public Class<Timestamp> getValueClass() {
      return Timestamp.class;
   }

   /**
    */
   public String toString() {
      return "TimestampConverter{}";
   }
}
