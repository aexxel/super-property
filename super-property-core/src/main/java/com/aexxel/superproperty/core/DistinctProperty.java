package com.aexxel.superproperty.core;

/**
 */
public interface DistinctProperty<T> extends ConvertedProperty<T> {

   /**
    * Get the value of the property. Its type is the generic type of the DistinctProperty.<br/>
    * If the value is null then the default value is fetched.<br/>
    * The enumeration name is used as a discriminant.
    */
   T getValue(Enum<?> enumeration);

   /**
    * Get the default value of the property. Its type is the generic type of the ConfigProperty.
    */
   T getDefaultValue();
}
