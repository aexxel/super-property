package com.aexxel.superproperty.core;

/**
 */
public class InitializeAdapter {

   private ValueFetcher valueFetcher;
   private String bundleName;

   /**
    */
   public ValueFetcher getValueFetcher() {
      return this.valueFetcher;
   }

   /**
    */
   public void setValueFetcher(ValueFetcher valueFetcher) {
      this.valueFetcher = valueFetcher;
   }

   /**
    */
   public String getBundleName() {
      return this.bundleName;
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
      if (this.bundleName != null ? !this.bundleName.equals(that.bundleName) : that.bundleName != null) {
         return false;
      }
      if (this.valueFetcher != null ? !this.valueFetcher.equals(that.valueFetcher) : that.valueFetcher != null) {
         return false;
      }
      return true;
   }

   /**
    */
   public int hashCode() {
      int result = this.valueFetcher != null ? this.valueFetcher.hashCode() : 0;
      result = Constant.HASH_31 * result + (this.bundleName != null ? this.bundleName.hashCode() : 0);
      return result;
   }

   /**
    */
   public String toString() {
      return "InitializeAdapter{" +
            "valueFetcher=" + this.valueFetcher +
            ", bundleName='" + this.bundleName + '\'' +
            '}';
   }
}
