package com.aexxel.superproperty.core.util;

import java.util.logging.Logger;

/**
 */
public final class Objects {

   private static final Logger LOGGER = Logger.getLogger(Objects.class.getName());

   /**
    * No need for utility.
    */
   private Objects() {
   }

   /**
    */
   public static void isNull(final Object object, final String string, final Object... parameters) {
      if (object == null) {
         final String message = Strings.changeTokenToParam(string, parameters);
         LOGGER.warning(message);
         throw new IllegalArgumentException(message);
      }
   }
}
