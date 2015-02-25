package com.aexxel.superproperty.core.sample;

import com.aexxel.superproperty.core.ConfigProperty;
import com.aexxel.superproperty.core.main.Factory;

@SuppressWarnings("unused")
public final class ConfigClass {

   public static final ConfigProperty<Integer> PROPERTY_INT = Factory.createConfig(20);
   public static final ConfigProperty<String> PROPERTY_STR = Factory.createConfig("Spiderman");
   private static final ConfigProperty<String> PROPERTY_PRIVATE = Factory.createConfig("Batman");
   public static final String STRING = "Superman";
   private Integer number;
   private ConfigProperty<Integer> numberProp;
}
