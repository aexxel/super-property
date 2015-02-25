package com.aexxel.superproperty.core.sample;

import com.aexxel.superproperty.core.ConfigProperty;
import com.aexxel.superproperty.core.main.Factory;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

public final class InitializedConfigClass {

   public static final ConfigProperty<Boolean> PROPERTY_BOOL = Factory.createConfig(true);
   public static final ConfigProperty<Long> PROPERTY_LONG = Factory.createConfig(1000000000000000L);
   public static final ConfigProperty<Integer> PROPERTY_INT = Factory.createConfig(1000000000);
   public static final ConfigProperty<Short> PROPERTY_SHORT = Factory.createConfig((short) 127);
   public static final ConfigProperty<Double> PROPERTY_DOUBLE = Factory.createConfig(Math.PI);
   public static final ConfigProperty<Float> PROPERTY_FLOAT = Factory.createConfig(1.256f);
   public static final ConfigProperty<String> PROPERTY_STRING = Factory.createConfig(
         "This sentence has five words");
   public static final ConfigProperty<Character> PROPERTY_CHAR = Factory.createConfig('c');
   public static final ConfigProperty<BigDecimal> PROPERTY_BIG_D = Factory.createConfig(BigDecimal.TEN);
   public static final ConfigProperty<BigInteger> PROPERTY_BIG_I = Factory.createConfig(BigInteger.ONE);
   public static final ConfigProperty<TimeUnit> PROPERTY_ENUM = Factory.createConfig(TimeUnit.SECONDS);
}
