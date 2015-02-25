package com.aexxel.superproperty.core;

/**
 */
public interface ConfigProperty<T> extends ConvertedProperty<T> {

   /**
    * Get the value of the property. Its type is the generic type of the ConfigProperty.<br/>
    * If he value is null then the default value is fetched.
    */
   T getValue();
}
