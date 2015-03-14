package com.aexxel.superproperty.core;

import com.aexxel.superproperty.core.sample.*;
import org.junit.Assert;
import org.junit.Test;

public class ConfigPropertyFactoryTest {

   @Test
   public void test_get_value_1() {
      final String expected = "Spiderman";
      final String actual = ConfigClass.PROPERTY_STR.getDefaultValue();
      Assert.assertEquals(expected, actual);
   }

   @Test
   public void test_get_value_2() {
      final Integer expected = 20;
      final Integer actual = ConfigClass.PROPERTY_INT.getDefaultValue();
      Assert.assertEquals(expected, actual);
   }

   @Test
   public void test_get_different_data_1() {
      Assert.assertEquals("class com.aexxel.superproperty.core.sample.InitializedConfigClass",
            InitializedConfigClass.PROPERTY_INT.getDeclaringClass().toString());
      Assert.assertEquals("PROPERTY_INT", InitializedConfigClass.PROPERTY_INT.getName());
      Assert.assertEquals("property.int", InitializedConfigClass.PROPERTY_INT.getKey());
      Assert.assertEquals("1000000000", InitializedConfigClass.PROPERTY_INT.getDefaultValue().toString());
      Assert.assertEquals("class java.lang.Integer",
            InitializedConfigClass.PROPERTY_INT.getValueClass().toString());
      Assert.assertEquals("IntegerConverter{}",
            InitializedConfigClass.PROPERTY_INT.getValueConverter().toString());
      Assert.assertEquals("DefaultValueFetcher{configName='configuration'}",
            InitializedConfigClass.PROPERTY_INT.getValueFetcher().toString());
      Assert.assertEquals("2000000000", InitializedConfigClass.PROPERTY_INT.getValue().toString());
   }

   @Test
   public void test_get_different_data_2() {
      Assert.assertEquals("class com.aexxel.superproperty.core.sample.InitializedConfigClass",
            InitializedConfigClass.PROPERTY_ENUM.getDeclaringClass().toString());
      Assert.assertEquals("PROPERTY_ENUM", InitializedConfigClass.PROPERTY_ENUM.getName());
      Assert.assertEquals("property.enum", InitializedConfigClass.PROPERTY_ENUM.getKey());
      Assert.assertEquals("SECONDS", InitializedConfigClass.PROPERTY_ENUM.getDefaultValue().toString());
      Assert.assertEquals("class java.util.concurrent.TimeUnit",
            InitializedConfigClass.PROPERTY_ENUM.getValueClass().toString());
      Assert.assertEquals("EnumConverter{valueClass=class java.util.concurrent.TimeUnit}",
            InitializedConfigClass.PROPERTY_ENUM.getValueConverter().toString());
      Assert.assertEquals("DefaultValueFetcher{configName='configuration'}",
            InitializedConfigClass.PROPERTY_ENUM.getValueFetcher().toString());
      Assert.assertEquals("MINUTES", InitializedConfigClass.PROPERTY_ENUM.getValue().toString());
   }

   @Test
   public void test_get_different_data_3() {
      Assert.assertEquals("class com.aexxel.superproperty.core.sample.NulledConfigClass",
            NulledConfigClass.NULL_PROPERTY_INT.getDeclaringClass().toString());
      Assert.assertEquals("NULL_PROPERTY_INT", NulledConfigClass.NULL_PROPERTY_INT.getName());
      Assert.assertEquals("null.property.int", NulledConfigClass.NULL_PROPERTY_INT.getKey());
      Assert.assertNull(NulledConfigClass.NULL_PROPERTY_INT.getDefaultValue());
      Assert.assertEquals("class java.lang.Integer",
            NulledConfigClass.NULL_PROPERTY_INT.getValueClass().toString());
      Assert.assertEquals("IntegerConverter{}",
            NulledConfigClass.NULL_PROPERTY_INT.getValueConverter().toString());
      Assert.assertEquals("DefaultValueFetcher{configName='configuration'}",
            NulledConfigClass.NULL_PROPERTY_INT.getValueFetcher().toString());
      Assert.assertEquals("888888", NulledConfigClass.NULL_PROPERTY_INT.getValue().toString());
   }

   @Test
   public void test_get_different_data_4() throws Exception {
      for (int i = 0; i < 1000000; i++) {
         Assert.assertEquals("class com.aexxel.superproperty.core.sample.NulledConfigClass",
               NulledConfigClass.NULL_PROPERTY_ENUM.getDeclaringClass().toString());
         Assert.assertEquals("NULL_PROPERTY_ENUM", NulledConfigClass.NULL_PROPERTY_ENUM.getName());
         Assert.assertEquals("null.property.enum", NulledConfigClass.NULL_PROPERTY_ENUM.getKey());
         Assert.assertNull(NulledConfigClass.NULL_PROPERTY_ENUM.getDefaultValue());
         Assert.assertEquals("class java.util.concurrent.TimeUnit",
               NulledConfigClass.NULL_PROPERTY_ENUM.getValueClass().toString());
         Assert.assertEquals("EnumConverter{valueClass=class java.util.concurrent.TimeUnit}",
               NulledConfigClass.NULL_PROPERTY_ENUM.getValueConverter().toString());
         Assert.assertEquals("DefaultValueFetcher{configName='configuration'}",
               NulledConfigClass.NULL_PROPERTY_ENUM.getValueFetcher().toString());
         Assert.assertEquals("HOURS", NulledConfigClass.NULL_PROPERTY_ENUM.getValue().toString());
      }
   }

   @Test
   public void test_unexpected_0() {
      try {
         UnexpectedConfigClass0.initialize();
         Assert.fail("This test should not fail here");
      } catch (final Exception e) {
         final String expected = "This generic type is not supported interface com.aexxel.superproperty.core.ConfigProperty on this field public static final com.aexxel.superproperty.core.ConfigProperty com.aexxel.superproperty.core.sample.UnexpectedConfigClass0.NULL_NON_PARAMETERIZED";
         final String actual = e.getMessage();
         Assert.assertEquals(expected, actual);
      }
   }

   @Test
   public void test_unexpected_1() {
      try {
         UnexpectedConfigClass1.initialize();
         Assert.fail("This test should not fail here");
      } catch (final Exception e) {
         final String expected = "This generic type is not supported com.aexxel.superproperty.core.ConfigProperty<java.lang.Class<? extends java.lang.Long>> on this field public static final com.aexxel.superproperty.core.ConfigProperty com.aexxel.superproperty.core.sample.UnexpectedConfigClass1.NULL_PAR_NON_PARAMETERIZED, index 1";
         final String actual = e.getMessage();
         Assert.assertEquals(expected, actual);
      }
   }

   @Test
   public void test_unexpected_2() {
      try {
         UnexpectedConfigClass2.initialize();
         Assert.fail("This test should not fail here");
      } catch (final Exception e) {
         final String expected = "Object of generic type is not supported com.aexxel.superproperty.core.ConfigProperty<?> on this field public static final com.aexxel.superproperty.core.ConfigProperty com.aexxel.superproperty.core.sample.UnexpectedConfigClass2.NULL_GEN_NON_PARAMETERIZED, index 2";
         final String actual = e.getMessage();
         Assert.assertEquals(expected, actual);
      }
   }

   @Test
   public void test_unexpected_3() {
      try {
         UnexpectedConfigClass3.initialize();
         Assert.fail("This test should not fail here");
      } catch (final Exception e) {
         final String expected = "Object of generic type is not supported com.aexxel.superproperty.core.ConfigProperty<java.lang.Object> on this field public static final com.aexxel.superproperty.core.ConfigProperty com.aexxel.superproperty.core.sample.UnexpectedConfigClass3.NULL_OBJ_NON_PARAMETERIZED, index 3";
         final String actual = e.getMessage();
         Assert.assertEquals(expected, actual);
      }
   }

   @Test
   public void test_unexpected_4() {
      try {
         UnexpectedConfigClass4.initialize();
         Assert.fail("This test should not fail here");
      } catch (final Exception e) {
         final String expected = "No defined or configured property for NOT_INITIALIZED_AND_NULL field";
         final String actual = e.getMessage();
         Assert.assertEquals(expected, actual);
      }
   }
}
