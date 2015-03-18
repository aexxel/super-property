package com.aexxel.superproperty.core;

import java.util.Locale;

/**
 */
public interface ValueFetcher {

   /**
    * Get the string value of a property depending on its key.
    */
   String getValue(String key);

   /**
    * Get the string value of a property depending on its key and the locale.
    * And objects are parameters for the message.
    */
   String getValue(String key, Locale locale, Object... objects);
}
