package com.aexxel.superproperty.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines property constrait as mandatory or optional.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Characteristics {

   /**
    */
   Constraint value() default Constraint.MANDATORY;
}
