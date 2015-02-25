package com.aexxel.superproperty.core.sample;

import com.aexxel.superproperty.core.ConfigProperty;
import com.aexxel.superproperty.core.main.Factory;

public final class UnexpectedConfigClass1 {

   public static final ConfigProperty<?> PAR_NON_PARAMETERIZED = Factory.createConfig("");
   public static final ConfigProperty<Class<? extends Long>> NULL_PAR_NON_PARAMETERIZED = Factory.createConfig();

   public static void initialize() {
      Factory.initialize();
   }
}
