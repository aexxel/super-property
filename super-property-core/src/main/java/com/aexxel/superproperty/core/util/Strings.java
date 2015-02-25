package com.aexxel.superproperty.core.util;

/**
 */
public final class Strings {

   private static final String TOKEN = "{}";
   public static final int AVERAGE = 10;
   public static final int OFFSET_INDEX = 2;

   /**
    * No need for utility.
    */
   private Strings() {
   }

   /**
    */
   public static boolean isEmpty(final String string) {
      return (string == null) || (string.length() < 1);
   }

   /**
    */
   public static boolean isNotEmpty(final String string) {
      return !isEmpty(string);
   }

   /**
    */
   public static boolean isBlank(final String string) {
      return (string == null) || (string.trim().length() < 1);
   }

   /**
    */
   public static boolean isNotBlank(final String string) {
      return !isBlank(string);
   }

   /**
    */
   public static String transformToJavaKey(final String name) {
      if (name == null) {
         return "";
      }
      final String result = name.toLowerCase();
      return result.replaceAll("_", ".");
   }

   /**
    */
   public static String changeTokenToParam(final String string, final Object... parameters) {
      if (Strings.isBlank(string)) {
         return "Missing message...";
      }
      if (parameters == null || parameters.length < 1) {
         return string;
      }

      final StringBuilder result = new StringBuilder(string.length() + parameters.length * AVERAGE);
      int startString = 0;
      int indexString = string.indexOf(TOKEN);
      int indexParams = 0;

      while (indexString >= 0 && indexParams < parameters.length) {
         result.append(string.substring(startString, indexString));
         result.append(parameters[indexParams]);

         startString = indexString + OFFSET_INDEX;
         indexString = string.indexOf(TOKEN, startString);
         indexParams++;
      }
      result.append(string.substring(startString));
      return result.toString();
   }
}
