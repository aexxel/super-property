package com.aexxel.superproperty.core.converter;

import com.aexxel.superproperty.core.ValueConverter;

import java.sql.Date;

/**
 * Converts a string to a date, format yyyy-[m]m-[d]d.
 */
public final class DateConverter implements ValueConverter<Date> {

   /**
    * {@inheritDoc}
    */
   public Date convert(final String value) {
      if (value == null) {
         return null;
      }
      return Date.valueOf(value.trim());
   }

   /**
    * {@inheritDoc}
    */
   public Class<Date> getValueClass() {
      return Date.class;
   }

   /**
    */
   public String toString() {
      return "DateConverter{}";
   }
}
