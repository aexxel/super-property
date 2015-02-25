package com.aexxel.superproperty.core.sample;

import com.aexxel.superproperty.core.ConfigProperty;
import com.aexxel.superproperty.core.main.Factory;

public final class UnexpectedConfigClass3 {

   public static final ConfigProperty<?> OBJ_NON_PARAMETERIZED = Factory.createConfig(Thread.NORM_PRIORITY);
   public static final ConfigProperty<Object> NULL_OBJ_NON_PARAMETERIZED = Factory.createConfig();

   public static void initialize() {
      Factory.initialize();
   }
}
