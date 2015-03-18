package com.aexxel.superproperty.core;

/**
 */
public interface Property<T> {

   /**
    * Get the declaring class of the property, which class defines this property.<br/>
    * The declaring class and the name of the property defines its uniqueness.
    */
   Class<?> getDeclaringClass();

   /**
    * Get the Java name of the property, which is always a String.<br/>
    * The declaring class and the name of the property defines its uniqueness.
    */
   String getName();

   /**
    * Get the key of the property, which is always a String.<br/>
    * Its format follows the usual convention seen in Java properties.
    *
    * @see System#getProperties()
    */
   String getKey();

   /**
    * Get the default value of the property. Its type is the generic type of the ConfigProperty.
    */
   T getDefaultValue();

   /**
    * Get the fetcher that is used to fetch the value (ResourceBundle properties, Database, Excel file, OpenOffice spreadsheet, etc).
    */
   ValueFetcher getValueFetcher();

   /**
    * Get the constraints on the value of the property.
    */
   Constraint getConstraint();
}
