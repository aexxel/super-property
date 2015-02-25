package com.aexxel.superproperty.core.main;

import com.aexxel.superproperty.core.ValueFetcher;
import com.aexxel.superproperty.core.util.Objects;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 */
final class DefaultValueFetcher implements ValueFetcher {

   private final String configName;
   private final ConcurrentMap<Locale, ResourceBundle> resourceBundles;
   private final ResourceBundle defaultResourceBundle;

   /**
    */
   DefaultValueFetcher(final String aConfigName) {
      Objects.isNull(aConfigName, "The config name should not be null");
      this.configName = aConfigName;
      this.resourceBundles = new ConcurrentHashMap<Locale, ResourceBundle>();
      this.defaultResourceBundle = ResourceBundle.getBundle(this.configName);
   }

   /**
    */
   String getConfigName() {
      return this.configName;
   }

   /**
    * {@inheritDoc}
    */
   public String getValue(final String key) {
      return (key == null) ? null : this.defaultResourceBundle.getString(key);
   }

   /**
    * {@inheritDoc}
    */
   public String getValue(final String key, final Locale locale, Object... objects) {
      if (key == null) {
         return null;
      }
      String result = null;
      ResourceBundle resourceBundle = this.resourceBundles.get(locale);
      if (resourceBundle == null) {
         resourceBundle = ResourceBundle.getBundle(this.configName, locale);
         this.resourceBundles.put(locale, resourceBundle);
      }
      String value = resourceBundle.getString(key);
      if ((value != null) && (objects != null) && (objects.length > 0)) {
         result = MessageFormat.format(value, objects);
      } else {
         result = value;
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
      final DefaultValueFetcher that = (DefaultValueFetcher) o;
      return !(this.configName != null ? !this.configName.equals(that.configName) : that.configName != null);
   }

   /**
    */
   public int hashCode() {
      return this.configName != null ? this.configName.hashCode() : 0;
   }

   /**
    */
   public String toString() {
      return "DefaultValueFetcher{" +
            "configName='" + this.configName + '\'' +
            '}';
   }
}
