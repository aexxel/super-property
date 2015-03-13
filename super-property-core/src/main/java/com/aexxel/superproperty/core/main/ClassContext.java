package com.aexxel.superproperty.core.main;

import com.aexxel.superproperty.core.InitializeAdapter;
import com.aexxel.superproperty.core.ValueFetcher;
import com.aexxel.superproperty.core.util.Objects;

import java.io.Serializable;
import java.util.Set;

/**
 */
final class ClassContext implements Serializable {

   private static final long serialVersionUID = 1L;
   private final Class<?> declaringClass;
   private final PropertyManager propertyManager;
   private final ValueFetcherFactory valueFetcherFactory;
   private InitializeAdapter initializeAdapter;
   private ValueFetcher valueFetcher;

   /**
    */
   ClassContext(
         final Class<?> aDeclaringClass,
         final PropertyManager aPropertyManager,
         final ValueFetcherFactory aValueFetcherFactory) {
      Objects.isNull(aDeclaringClass, "The input class should not be null");
      Objects.isNull(aDeclaringClass, "The property manager should not be null");
      Objects.isNull(aValueFetcherFactory, "The value fetcher main should not be null");
      this.declaringClass = aDeclaringClass;
      this.propertyManager = aPropertyManager;
      this.valueFetcherFactory = aValueFetcherFactory;
   }

   /**
    */
   @SuppressWarnings("unchecked")
   <T> Class<T> getDeclaringClass() {
      return (Class<T>) this.declaringClass;
   }

   /**
    */
   PropertyManager getPropertyManager() {
      return this.propertyManager;
   }

   /**
    */
   ValueFetcherFactory getValueFetcherFactory() {
      return this.valueFetcherFactory;
   }

   /**
    */
   InitializeAdapter getInitializeAdapter() {
      return this.initializeAdapter;
   }

   /**
    */
   void setInitializeAdapter(InitializeAdapter aInitializeAdapter) {
      this.initializeAdapter = aInitializeAdapter;
   }

   /**
    */
   ValueFetcher getValueFetcher() {
      return this.valueFetcher;
   }

   /**
    */
   boolean isResolved() {
      return this.propertyManager.isResolved(this);
   }

   /**
    */
   Set<AbstractProperty<?>> initialize() {
      final Set<AbstractProperty<?>> result = this.propertyManager.initialize(this);
      this.valueFetcher = this.valueFetcherFactory.create(this.initializeAdapter);
      for (AbstractProperty<?> property : result) {
         if (property instanceof DefaultConfigProperty) {
            DefaultConfigProperty<?> defaultConfigProperty = (DefaultConfigProperty<?>) property;
            defaultConfigProperty.getValue();
         }
         else if (property instanceof DefaultLocalizedProperty) {
            DefaultLocalizedProperty defaultLocalizedProperty = (DefaultLocalizedProperty) property;
            defaultLocalizedProperty.getMessage(defaultLocalizedProperty.getDefaultLocale());
         }
      }
      return result;
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
      final ClassContext that = (ClassContext) o;
      return this.declaringClass.equals(that.declaringClass);
   }

   /**
    */
   public int hashCode() {
      return this.declaringClass.hashCode();
   }

   /**
    */
   public String toString() {
      return "ClassContext{" +
             "declaringClass=" + this.declaringClass +
             ", initializeAdapter=" + this.initializeAdapter +
             ", valueFetcher=" + this.valueFetcher +
             '}';
   }
}
