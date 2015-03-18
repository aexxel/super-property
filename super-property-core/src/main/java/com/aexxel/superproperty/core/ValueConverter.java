package com.aexxel.superproperty.core;

import java.io.Serializable;

/**
 */
public interface ValueConverter<T> {

   /**
    * Convert from a String to an object of the input class.
    *
    * @throws IllegalArgumentException when the value argument could not be converted.
    */
   T convert(String value);

   /**
    * Get the class of the value for this value converter.
    */
   Class<T> getValueClass();
}
