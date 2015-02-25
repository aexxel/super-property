package com.aexxel.superproperty.core;

/**
 */
public interface ConvertedProperty<T> extends Property<T> {

   /**
    * Get the class of the value of the property.<br/>
    * This class is the generic type of the ConvertedProperty.
    */
   Class<T> getValueClass();

   /**
    * Get the converter that is used to convert the value from String to its type.
    */
   ValueConverter<T> getValueConverter();
}
