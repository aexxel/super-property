package com.aexxel.superproperty.core.main;

import com.aexxel.superproperty.core.ConvertedProperty;
import com.aexxel.superproperty.core.ValueConverter;

/**
 */
abstract class AbstractConvertedProperty<T> extends AbstractProperty<T> implements ConvertedProperty<T> {

   private ValueConverter<T> valueConverter;

   /**
    */
   AbstractConvertedProperty(
         final ClassContext classContext, final T defaultValue, final ValueConverter<T> aValueConverter) {
      super(classContext, defaultValue);
      this.valueConverter = aValueConverter;
   }

   /**
    * {@inheritDoc}
    */
   public ValueConverter<T> getValueConverter() {
      verifyAndInitialize();
      return this.valueConverter;
   }

   /**
    */
   boolean isValueConverterMissing() {
      return this.valueConverter == null;
   }

   /**
    */
   void setValueConverter(final ValueConverter<T> aValueConverter) {
      this.valueConverter = aValueConverter;
   }

   /**
    * {@inheritDoc}
    */
   public Class<T> getValueClass() {
      verifyAndInitialize();
      return (this.valueConverter == null) ? null : this.valueConverter.getValueClass();
   }

   /**
    */
   public String toString() {
      return "AbstractConvertedProperty{" +
            "valueConverter=" + this.valueConverter +
            "} " + super.toString();
   }
}
