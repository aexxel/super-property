package com.aexxel.superproperty.core.main;

import com.aexxel.superproperty.core.InitializeAdapter;
import com.aexxel.superproperty.core.ValueFetcher;

/**
 */
final class ValueFetcherFactory {

   private static final String CONFIG_NAME = "configuration";
   private static final ValueFetcher VALUE_FETCHER = new DefaultValueFetcher(CONFIG_NAME);

   /**
    * Package scope only.
    */
   ValueFetcherFactory() {
   }

   /**
    */
   ValueFetcher create(final InitializeAdapter initializeAdapter) {
      if (initializeAdapter == null) {
         return VALUE_FETCHER;
      }
      else if (initializeAdapter.getBundleName() != null) {
         return new DefaultValueFetcher(initializeAdapter.getBundleName());
      }
      else if (initializeAdapter.getValueFetcher() == null) {
         return initializeAdapter.getValueFetcher();
      }
      else {
         return VALUE_FETCHER;
      }
   }
}
