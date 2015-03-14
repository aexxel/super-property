package com.aexxel.superproperty.core.util;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 */
public final class Collections {

   /**
    * No need for utility.
    */
   private Collections() {
   }

   /**
    */
   public static <T> List<T> newList(final T... elements) {
      final List<T> result = new ArrayList<T>();
      if (elements != null) {
         java.util.Collections.addAll(result, elements);
      }
      return result;
   }

   /**
    */
   public static <T> Set<T> newSet(final T... elements) {
      final Set<T> result = new LinkedHashSet<T>();
      if (elements != null) {
         java.util.Collections.addAll(result, elements);
      }
      return result;
   }

   /**
    */
   public static <K, V> Map<K, V> newMap() {
      return new LinkedHashMap<K, V>();
   }

   /**
    */
   public static <K, V> Map<K, V> newMap(final Map.Entry<K, V>... elements) {
      final Map<K, V> result = new LinkedHashMap<K, V>();
      if (elements != null) {
         for (final Map.Entry<K, V> entry : elements) {
            if (entry != null) {
               result.put(entry.getKey(), entry.getValue());
            }
         }
      }
      return result;
   }

   /**
    */
   public static <K, V> ConcurrentMap<K, V> newConcurrentMap() {
      return new ConcurrentHashMap<K, V>();
   }

   /**
    */
   public static <K, V> ConcurrentMap<K, V> newConcurrentMap(final Map.Entry<K, V>... elements) {
      final ConcurrentMap<K, V> result = new ConcurrentHashMap<K, V>();
      if (elements != null) {
         for (final Map.Entry<K, V> entry : elements) {
            if (entry != null) {
               result.put(entry.getKey(), entry.getValue());
            }
         }
      }
      return result;
   }

   /**
    */
   public static <T> boolean isEmpty(final Collection<T> collection) {
      return collection == null || collection.isEmpty();
   }

   /**
    */
   public static <T> boolean isEmpty(final T[] array) {
      return array == null || array.length < 1;
   }

   /**
    */
   public static <T> boolean isMoreThanOne(final T[] array) {
      return array != null && array.length > 1;
   }
}
