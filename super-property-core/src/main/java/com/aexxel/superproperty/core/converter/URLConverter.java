package com.aexxel.superproperty.core.converter;

import com.aexxel.superproperty.core.ValueConverter;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

/**
 */
public final class URLConverter implements ValueConverter<URL> {

   private static final Logger LOGGER = Logger.getLogger(URLConverter.class.getName());

   /**
    * {@inheritDoc}
    */
   public URL convert(final String value) {
      if (value == null || value.length() < 1) {
         return null;
      }
      final URL result;
      try {
         result = new URL(value);
      } catch (final MalformedURLException e) {
         final String message = "The input URL " + value + " could not be parsed";
         LOGGER.warning(message);
         throw new IllegalArgumentException(message);
      }
      return result;
   }

   /**
    * {@inheritDoc}
    */
   public Class<URL> getValueClass() {
      return URL.class;
   }

   /**
    */
   public String toString() {
      return "URLConverter{}";
   }
}
