package com.aexxel.superproperty.core.main;

import com.aexxel.superproperty.core.LocalizedProperty;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 */
final class DefaultLocalizedProperty extends AbstractProperty<String> implements LocalizedProperty {

   private static final Logger LOGGER = Logger.getLogger(DefaultLocalizedProperty.class.getName());
   private String message;

   /**
    */
   DefaultLocalizedProperty(final ClassContext classContext, final String defaultValue) {
      super(classContext, defaultValue);
   }

   /**
    * {@inheritDoc}
    */
   public String getMessage(Locale locale) {
      if (LOGGER.isLoggable(Level.FINER)) {
         LOGGER.finer("Locale " + locale);
      }
      verifyAndInitialize();
      return this.message;
   }

   /**
    * {@inheritDoc}
    */
   public String getMessage(Locale locale, Object... arguments) {
      if (LOGGER.isLoggable(Level.FINER)) {
         LOGGER.finer("Locale " + locale + " arguments " + arguments);
      }
      verifyAndInitialize();
      return this.message;
   }

   /**
    * {@inheritDoc}
    */
   public Locale getDefaultLocale() {
      verifyAndInitialize();
      return Locale.ENGLISH;
   }

   /**
    */
   public String toString() {
      return "DefaultLocalizedProperty{" +
            "message=" + this.message +
            "} " + super.toString();
   }
}
