package com.aexxel.superproperty.core.converter;

import com.aexxel.superproperty.core.ValueConverter;

import java.util.logging.Logger;

/**
 */
@SuppressWarnings("rawtypes")
public final class ClassConverter implements ValueConverter<Class> {

   private static final Logger LOGGER = Logger.getLogger(ClassConverter.class.getName());

   /**
    * {@inheritDoc}
    */
   public Class<?> convert(final String value) {
      if (value == null || value.length() < 1) {
         return null;
      }
      final Class<?> result;
      try {
         result = Class.forName(value);
      } catch (final ClassNotFoundException e) {
         final String message = "The input class " + value + " could not be found on the classpath";
         LOGGER.warning(message);
         throw new IllegalArgumentException(message, e);
      }
      return result;
   }

   /**
    * {@inheritDoc}
    */
   @SuppressWarnings("unchecked")
   public Class getValueClass() {
      return Class.class;
   }

   /**
    */
   public String toString() {
      return "ClassConverter{}";
   }
}
