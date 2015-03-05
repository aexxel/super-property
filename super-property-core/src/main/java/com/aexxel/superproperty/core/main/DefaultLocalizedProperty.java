/*
 * Super Property, open source software.
 * Copyright (C) 2015 Aexxel inc.
 * License: Apache License Version 2.0.
 */
package com.aexxel.superproperty.core.main;

import com.aexxel.superproperty.core.LocalizedProperty;

import java.util.Arrays;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 */
final class DefaultLocalizedProperty extends AbstractProperty<String> implements LocalizedProperty {

   private static final Logger LOGGER = Logger.getLogger(DefaultLocalizedProperty.class.getName());
   private static final long serialVersionUID = 1L;
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
         LOGGER.finer("Locale " + locale + " arguments " + Arrays.toString(arguments));
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
