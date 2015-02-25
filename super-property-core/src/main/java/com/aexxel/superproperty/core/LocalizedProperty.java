package com.aexxel.superproperty.core;

import java.util.Locale;

/**
 */
public interface LocalizedProperty extends Property<String> {

   /**
    * Get the localized message of the property. It depends on the input Locale.<br/>
    * When the input Locale is null, values are taken from the default bundle file, i.e. message.properties file.
    */
   String getMessage(Locale locale);

   /**
    * Same as <code>getMessage(Locale)</code>.<br/>
    * The arguments list is used by a MessageFormat to format the message.<br/>
    * The apostrophe "problem" is taken care by this method.
    *
    * @see java.text.MessageFormat
    */
   String getMessage(Locale locale, Object... arguments);

   /**
    * Get the default locale which is the locale of the default bundle file, i.e. message.properties file.<br/>
    * This is not the same as the JVM default locale.
    *
    * @see java.util.Locale
    */
   Locale getDefaultLocale();
}
