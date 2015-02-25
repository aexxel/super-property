package com.aexxel.superproperty.core.sample;

import com.aexxel.superproperty.core.ConfigProperty;
import com.aexxel.superproperty.core.Property;
import com.aexxel.superproperty.core.main.Factory;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("rawtypes")
public final class UnexpectedConfigClass0 {

   public static final ConfigProperty NON_PARAMETERIZED = Factory.createConfig(10);
   public static final ConfigProperty NULL_NON_PARAMETERIZED = Factory.createConfig();
   private static final Logger LOGGER = Logger.getLogger(UnexpectedConfigClass0.class.getName());

   public static void initialize() {
      Set<Property<?>> properties = Factory.initialize();
      if (LOGGER.isLoggable(Level.FINE)) {
         for (Property<?> property : properties) {
            LOGGER.fine("Property " + property);
         }
      }
   }
}
