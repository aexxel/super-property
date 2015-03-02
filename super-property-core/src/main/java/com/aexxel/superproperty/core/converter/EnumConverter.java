package com.aexxel.superproperty.core.converter;

import com.aexxel.superproperty.core.ValueConverter;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 */
public final class EnumConverter<T extends Enum<T>> implements ValueConverter<T> {

   private static final Logger LOGGER = Logger.getLogger(EnumConverter.class.getName());
   private static final long serialVersionUID = 1L;
   private final Class<T> valueClass;

   /**
    */
   @SuppressWarnings("unchecked")
   public EnumConverter(final Class<T> aValueClass) {
      if (aValueClass.getEnclosingClass() == null) {
         this.valueClass = aValueClass;
      } else if (Enum.class.isAssignableFrom(aValueClass.getEnclosingClass())) {
         this.valueClass = (Class<T>) aValueClass.getEnclosingClass();
      } else {
         this.valueClass = aValueClass;
      }
   }

   /**
    * {@inheritDoc}
    */
   public T convert(final String value) {
      if (value == null) {
         return null;
      }
      final T result = Enum.valueOf(this.valueClass, value);
      if (LOGGER.isLoggable(Level.FINEST)) {
         LOGGER.finest("Enum value found for " + this.valueClass + " is " + result);
      }
      return result;
   }

   /**
    * {@inheritDoc}
    */
   public Class<T> getValueClass() {
      return this.valueClass;
   }

   /**
    */
   public String toString() {
      return "EnumConverter{" +
            "valueClass=" +
            ((this.valueClass.getEnclosingClass() == null) ?
                  this.valueClass :
                  this.valueClass.getEnclosingClass()) +
            '}';
   }
}
