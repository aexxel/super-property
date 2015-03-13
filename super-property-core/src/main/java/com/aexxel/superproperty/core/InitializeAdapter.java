package com.aexxel.superproperty.core;

import java.io.Serializable;

/**
 */
public class InitializeAdapter implements Serializable {

   private static final long serialVersionUID = 1L;
   private ValueFetcher valueFetcher;
   private String bundleName;

   /**
    */
   public ValueFetcher getValueFetcher() {
      return valueFetcher;
   }

   /**
    */
   public void setValueFetcher(ValueFetcher valueFetcher) {
      this.valueFetcher = valueFetcher;
   }

   /**
    */
   public String getBundleName() {
      return bundleName;
   }

   /**
    */
   public void setBundleName(String bundleName) {
      this.bundleName = bundleName;
   }

   /**
    */
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      InitializeAdapter that = (InitializeAdapter) o;
      if (bundleName != null ? !bundleName.equals(that.bundleName) : that.bundleName != null) {
         return false;
      }
      if (valueFetcher != null ? !valueFetcher.equals(that.valueFetcher) : that.valueFetcher != null) {
         return false;
      }
      return true;
   }

   /**
    */
   public int hashCode() {
      int result = valueFetcher != null ? valueFetcher.hashCode() : 0;
      result = Constant.HASH_31 * result + (bundleName != null ? bundleName.hashCode() : 0);
      return result;
   }

   /**
    */
   public String toString() {
      return "InitializeAdapter{" +
             "valueFetcher=" + valueFetcher +
             ", bundleName='" + bundleName + '\'' +
             '}';
   }
}
