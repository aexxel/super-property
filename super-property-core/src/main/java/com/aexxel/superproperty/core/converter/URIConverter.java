package com.aexxel.superproperty.core.converter;

import com.aexxel.superproperty.core.ValueConverter;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Logger;

/**
 */
public final class URIConverter implements ValueConverter<URI> {

   private static final Logger LOGGER = Logger.getLogger(URIConverter.class.getName());
   private static final long serialVersionUID = 1L;

   /**
    * {@inheritDoc}
    */
   public URI convert(final String value) {
      if (value == null || value.length() < 1) {
         return null;
      }
      final URI result;
      try {
         result = new URI(value);
      }
      catch (final URISyntaxException e) {
         final String message = "The input URI " + value + " could not be parsed";
         LOGGER.warning(message);
         throw new IllegalArgumentException(message, e);
      }
      return result;
   }

   /**
    * {@inheritDoc}
    */
   public Class<URI> getValueClass() {
      return URI.class;
   }

   /**
    */
   public String toString() {
      return "URIConverter{}";
   }
}
