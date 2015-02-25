package com.aexxel.superproperty.core.util;

/**
 */
public final class Runtimes {

   private static final RuntimeManager RUNTIME_MANAGER = new RuntimeManager();
   public static final int CALLER_CLASS_INDEX = 4;

   /**
    * No need for utility.
    */
   private Runtimes() {
   }

   /**
    */
   public static Class<?> getCallerClass() {
      final Class<?>[] classes = RUNTIME_MANAGER.getStackClasses();
      return (classes.length > CALLER_CLASS_INDEX) ? classes[CALLER_CLASS_INDEX] : null;
   }

   /**
    */
   private static class RuntimeManager extends SecurityManager {
      private Class<?>[] getStackClasses() {
         return getClassContext();
      }
   }
}
