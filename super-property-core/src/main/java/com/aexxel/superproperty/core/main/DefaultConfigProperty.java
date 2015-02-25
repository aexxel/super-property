package com.aexxel.superproperty.core.main;

import com.aexxel.superproperty.core.ConfigProperty;
import com.aexxel.superproperty.core.Constraint;
import com.aexxel.superproperty.core.ValueConverter;
import com.aexxel.superproperty.core.ValueFetcher;
import com.aexxel.superproperty.core.util.Strings;

import java.util.logging.Logger;

/**
 */
final class DefaultConfigProperty<T> extends AbstractConvertedProperty<T> implements ConfigProperty<T> {

   private static final Logger LOGGER = Logger.getLogger(DefaultConfigProperty.class.getName());
   private T value;

   /**
    */
   DefaultConfigProperty(
         final ClassContext classContext, final T defaultValue, final ValueConverter<T> valueConverter) {
      super(classContext, defaultValue, valueConverter);
   }

   /**
    * {@inheritDoc}
    */
   public T getValue() {
      verifyAndInitialize();
      if (this.value == null) {
         final ValueFetcher valueFetcher = getClassContext().getValueFetcher();
         final String stringValue = valueFetcher.getValue(getKey());
         if (Strings.isNotBlank(stringValue)) {
            this.value = getValueConverter().convert(stringValue);
         }
      }
      if (this.value == null) {
         T defaultValue = getDefaultValue();
         if (defaultValue != null) {
            return defaultValue;
         }
         if (Constraint.MANDATORY.equals(getConstraint())) {
            String message = "This field: " + getName() + " value is mandatory";
            LOGGER.finer(message);
            throw new IllegalStateException(message);
         }
      }
      return this.value;
   }

   /**
    */
   public String toString() {
      return "DefaultConfigProperty{" +
            "value=" + this.value +
            "} " + super.toString();
   }
}
