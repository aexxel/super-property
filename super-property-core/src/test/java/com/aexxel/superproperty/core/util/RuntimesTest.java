package com.aexxel.superproperty.core.util;

import org.junit.Assert;
import org.junit.Test;

public class RuntimesTest {

   @Test
   public void test_get_caller_class_1() throws Exception {
      Assert.assertNotNull(Runtimes.getCallerClass());
   }

   @Test
   public void test_get_caller_class_2() throws Exception {
      final String expected = RuntimesTest.class.getName();
      final String actual = OtherClass.call().getName();
      Assert.assertEquals(expected, actual);
   }

   static final class OtherClass {
      static Class<?> call() {
         return Runtimes.getCallerClass();
      }
   }
}
