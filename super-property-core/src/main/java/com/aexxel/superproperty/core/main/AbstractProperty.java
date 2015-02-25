package com.aexxel.superproperty.core.main;

import com.aexxel.superproperty.core.Constant;
import com.aexxel.superproperty.core.Constraint;
import com.aexxel.superproperty.core.Property;
import com.aexxel.superproperty.core.ValueFetcher;
import com.aexxel.superproperty.core.util.Objects;

/**
 */
abstract class AbstractProperty<T> implements Property<T> {

   private final ClassContext classContext;
   private String name;
   private String key;
   private final T defaultValue;
   private Constraint constraint;

   /**
    */
   AbstractProperty(final ClassContext aClassContext, final T aDefaultValue) {
      Objects.isNull(aClassContext, "The class context should not be null");
      this.classContext = aClassContext;
      this.defaultValue = aDefaultValue;
      this.constraint = Constraint.MANDATORY;
   }

   /**
    */
   ClassContext getClassContext() {
      return this.classContext;
   }

   /**
    * {@inheritDoc}
    */
   public Class<?> getDeclaringClass() {
      return this.classContext.getDeclaringClass();
   }

   /**
    * {@inheritDoc}
    */
   public String getName() {
      verifyAndInitialize();
      return this.name;
   }

   /**
    */
   void setName(final String aName) {
      this.name = aName;
   }

   /**
    * {@inheritDoc}
    */
   public String getKey() {
      verifyAndInitialize();
      return this.key;
   }

   /**
    */
   void setKey(final String aKey) {
      this.key = aKey;
   }

   /**
    * {@inheritDoc}
    */
   public T getDefaultValue() {
      return this.defaultValue;
   }

   /**
    * {@inheritDoc}
    */
   public Constraint getConstraint() {
      return this.constraint;
   }

   /**
    */
   void setConstraint(final Constraint aConstraint) {
      this.constraint = aConstraint;
   }

   /**
    * {@inheritDoc}
    */
   public ValueFetcher getValueFetcher() {
      verifyAndInitialize();
      return this.classContext.getValueFetcher();
   }

   /**
    */
   void verifyAndInitialize() {
      if (!this.classContext.isResolved()) {
         this.classContext.initialize();
      }
   }

   /**
    */
   public boolean equals(final Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      final AbstractProperty that = (AbstractProperty) o;
      return this.classContext.equals(that.classContext) && this.name.equals(that.name);
   }

   /**
    */
   public int hashCode() {
      int result = this.classContext.hashCode();
      result = Constant.HASH_31 * result + this.name.hashCode();
      return result;
   }

   /**
    */
   public String toString() {
      return "AbstractProperty{" +
            "classContext=" + this.classContext +
            ", name='" + this.name + '\'' +
            ", key='" + this.key + '\'' +
            ", defaultValue='" + this.defaultValue + '\'' +
            ", constraint=" + this.constraint +
            '}';
   }
}
