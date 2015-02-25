package com.aexxel.superproperty.core.util;

import org.junit.Assert;
import org.junit.Test;

public class ObjectsTest {

   @Test
   public void test_exception_1() throws Exception {
      Objects.isNull("", "No exception here");

      try {
         Objects.isNull(null, "Hello Zorro!");
         Assert.fail("This test should not fail here");
      } catch (final IllegalArgumentException e) {
         final String expected = "Hello Zorro!";
         final String actual = e.getMessage();
         Assert.assertEquals(expected, actual);
      }
   }

   @Test
   public void test_exception_2() throws Exception {
      try {
         Objects.isNull(null, "Hello {} Zorro!", 1);
         Assert.fail("This test should not fail here");
      } catch (final IllegalArgumentException e) {
         final String expected = "Hello 1 Zorro!";
         final String actual = e.getMessage();
         Assert.assertEquals(expected, actual);
      }
   }

   @Test
   public void test_exception_3() throws Exception {
      try {
         Objects.isNull(null, "Hello {} Zorro{}!", 2, "s");
         Assert.fail("This test should not fail here");
      } catch (final IllegalArgumentException e) {
         final String expected = "Hello 2 Zorros!";
         final String actual = e.getMessage();
         Assert.assertEquals(expected, actual);
      }
   }

   @Test
   public void test_exception_4() throws Exception {
      try {
         Objects.isNull(null, "Hello {} Zorro!", 10, "s");
         Assert.fail("This test should not fail here");
      } catch (final IllegalArgumentException e) {
         final String expected = "Hello 10 Zorro!";
         final String actual = e.getMessage();
         Assert.assertEquals(expected, actual);
      }
   }

   @Test
   public void test_exception_5() throws Exception {
      try {
         Objects.isNull(null, "Hello {} Zorro{}!", 10);
         Assert.fail("This test should not fail here");
      } catch (final IllegalArgumentException e) {
         final String expected = "Hello 10 Zorro{}!";
         final String actual = e.getMessage();
         Assert.assertEquals(expected, actual);
      }
   }
}
