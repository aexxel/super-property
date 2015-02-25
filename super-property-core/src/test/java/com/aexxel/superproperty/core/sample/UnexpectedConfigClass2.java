package com.aexxel.superproperty.core.sample;

import com.aexxel.superproperty.core.ConfigProperty;
import com.aexxel.superproperty.core.main.Factory;

import java.math.BigDecimal;

public final class UnexpectedConfigClass2 {

   public static final ConfigProperty<?> GEN_NON_PARAMETERIZED = Factory.createConfig(BigDecimal.TEN);
   public static final ConfigProperty<?> NULL_GEN_NON_PARAMETERIZED = Factory.createConfig();

   public static void initialize() {
      Factory.initialize();
   }
}
