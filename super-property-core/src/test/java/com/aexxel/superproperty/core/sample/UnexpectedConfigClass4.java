package com.aexxel.superproperty.core.sample;

import com.aexxel.superproperty.core.Characteristics;
import com.aexxel.superproperty.core.ConfigProperty;
import com.aexxel.superproperty.core.Constraint;
import com.aexxel.superproperty.core.main.Factory;

import java.math.BigDecimal;

public final class UnexpectedConfigClass4 {

   @Characteristics(Constraint.OPTIONAL)
   public static final ConfigProperty<BigDecimal> NULL_PROPERTY_BIG_D = Factory.createConfig();
   public static final ConfigProperty<Integer> NOT_INITIALIZED_AND_NULL = null;

   public static void initialize() {
      Factory.initialize();
   }

   public static void main(String[] args) {
      System.out.println("NULL_PROPERTY_BIG_D " + NULL_PROPERTY_BIG_D);
      System.out.println("NOT_INITIALIZED_AND_NULL " + NOT_INITIALIZED_AND_NULL);
   }
}
