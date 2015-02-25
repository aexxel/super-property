package com.aexxel.superproperty.core.util;

import org.junit.Assert;
import org.junit.Test;

public class StringsTest {

   @Test
   public void test_is_empty() throws Exception {
      Assert.assertTrue(Strings.isEmpty(null));
      Assert.assertTrue(Strings.isEmpty(""));
      Assert.assertFalse(Strings.isEmpty(" "));
      Assert.assertFalse(Strings.isEmpty("bob"));
      Assert.assertFalse(Strings.isEmpty("  bob  "));
   }

   @Test
   public void test_is_not_empty() throws Exception {
      Assert.assertFalse(Strings.isNotEmpty(null));
      Assert.assertFalse(Strings.isNotEmpty(""));
      Assert.assertTrue(Strings.isNotEmpty(" "));
      Assert.assertTrue(Strings.isNotEmpty("bob"));
      Assert.assertTrue(Strings.isNotEmpty("  bob  "));
   }

   @Test
   public void test_is_blank() throws Exception {
      Assert.assertTrue(Strings.isBlank(null));
      Assert.assertTrue(Strings.isBlank(""));
      Assert.assertTrue(Strings.isBlank(" "));
      Assert.assertFalse(Strings.isBlank("bob"));
      Assert.assertFalse(Strings.isBlank("  bob  "));
   }

   @Test
   public void test_is_not_blank() throws Exception {
      Assert.assertFalse(Strings.isNotBlank(null));
      Assert.assertFalse(Strings.isNotBlank(""));
      Assert.assertFalse(Strings.isNotBlank(" "));
      Assert.assertTrue(Strings.isNotBlank("bob"));
      Assert.assertTrue(Strings.isNotBlank("  bob  "));
   }

   @Test
   public void test_transform_to_java_key() throws Exception {
      Assert.assertEquals("", Strings.transformToJavaKey(null));
      Assert.assertEquals("", Strings.transformToJavaKey(""));
      Assert.assertEquals("hello", Strings.transformToJavaKey("Hello"));
      Assert.assertEquals("property.int", Strings.transformToJavaKey("PROPERTY_INT"));
      Assert.assertEquals("java.home.1", Strings.transformToJavaKey("JAVA_HOME_1"));
   }

   @Test
   public void test_change_token_to_param() throws Exception {
      Assert.assertEquals("Missing message...", Strings.changeTokenToParam(null));
      Assert.assertEquals("Missing message...", Strings.changeTokenToParam(""));
      Assert.assertEquals("Missing message...", Strings.changeTokenToParam("   "));
      Assert.assertEquals("Hello {} Zorro!", Strings.changeTokenToParam("Hello {} Zorro!"));
      Assert.assertEquals("Hello 1 Zorro!", Strings.changeTokenToParam("Hello {} Zorro!", 1));
      Assert.assertEquals("Hello 2 Zorros!", Strings.changeTokenToParam("Hello {} Zorro{}!", 2, "s"));
      Assert.assertEquals("Hello 10 Zorro!", Strings.changeTokenToParam("Hello {} Zorro!", 10, "s"));
      Assert.assertEquals("Hello 10 Zorro{}!", Strings.changeTokenToParam("Hello {} Zorro{}!", 10));
      Assert.assertEquals("Now, Hello Zorro! 1000",
            Strings.changeTokenToParam("{}, Hello Zorro! {}", "Now", 1000L));
      Assert.assertEquals("Then, Hello Zorros! Bang!",
            Strings.changeTokenToParam("{}, Hello Zorro{}! {}", "Then", "s", "Bang!"));
   }
}
