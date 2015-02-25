package com.aexxel.superproperty.core.sample;

import com.aexxel.superproperty.core.Characteristics;
import com.aexxel.superproperty.core.ConfigProperty;
import com.aexxel.superproperty.core.Constraint;
import com.aexxel.superproperty.core.Property;
import com.aexxel.superproperty.core.main.Factory;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("rawtypes")
public final class NulledConfigClass {

   public static final ConfigProperty<Boolean> NULL_PROPERTY_BOOL = Factory.createConfig();
   public static final ConfigProperty<? extends Long> NULL_PROPERTY_LONG = Factory.createConfig();
   public static final ConfigProperty<Integer> NULL_PROPERTY_INT = Factory.createConfig();
   @Characteristics(Constraint.MANDATORY)
   public static final ConfigProperty<Short> NULL_PROPERTY_SHORT = Factory.createConfig();
   public static final ConfigProperty<Double> NULL_PROPERTY_DOUBLE = Factory.createConfig();
   public static final ConfigProperty<? extends Float> NULL_PROPERTY_FLOAT = Factory.createConfig();
   @Characteristics
   public static final ConfigProperty<String> NULL_PROPERTY_STR = Factory.createConfig();
   @Characteristics(Constraint.OPTIONAL)
   public static final ConfigProperty<Character> NULL_PROPERTY_CHAR = Factory.createConfig();
   @Characteristics(Constraint.OPTIONAL)
   public static final ConfigProperty<BigDecimal> NULL_PROPERTY_BIG_D = Factory.createConfig();
   @Characteristics(Constraint.MANDATORY)
   public static final ConfigProperty<Class<Integer>> NULL_PROPERTY_VALUE = Factory.createConfig();
   public static final ConfigProperty<? super BigInteger> NULL_PROPERTY_BIG_I = Factory.createConfig();
   @Characteristics
   public static final ConfigProperty<? super TimeUnit> NULL_PROPERTY_ENUM = Factory.createConfig();

   private static Set<Property<?>> PROPERTIES;

   static {
      PROPERTIES = Factory.initialize();
   }

   public static void main(String[] args) {
      for (Property<?> property : PROPERTIES) {
         System.out.println("Property " + property);
      }
   }
}
