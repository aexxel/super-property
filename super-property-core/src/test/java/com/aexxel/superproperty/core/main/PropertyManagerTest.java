package com.aexxel.superproperty.core.main;

import com.aexxel.superproperty.core.ConfigProperty;
import com.aexxel.superproperty.core.converter.IntegerConverter;
import com.aexxel.superproperty.core.sample.ConfigClass;
import org.junit.Assert;
import org.junit.Test;

public class PropertyManagerTest {

   private final PropertyManager propertyManager = new PropertyManager();

   @Test
   public void test_get_property_fields_1() throws Exception {
      final String expected = "[]";
      final String actual = this.propertyManager.getPropertyFields(ConfigProperty.class).toString();
      Assert.assertEquals(expected, actual);
   }

   @Test
   public void test_get_property_fields_2() throws Exception {
      final String expected = "[]";
      final String actual = this.propertyManager.getPropertyFields(IntegerConverter.class).toString();
      Assert.assertEquals(expected, actual);
   }

   @Test
   public void test_get_property_fields_3() throws Exception {
      final String expected = "[public static final com.aexxel.superproperty.core.ConfigProperty com.aexxel.superproperty.core.sample.ConfigClass.PROPERTY_INT, public static final com.aexxel.superproperty.core.ConfigProperty com.aexxel.superproperty.core.sample.ConfigClass.PROPERTY_STR, private static final com.aexxel.superproperty.core.ConfigProperty com.aexxel.superproperty.core.sample.ConfigClass.PROPERTY_PRIVATE]";
      final String actual = this.propertyManager.getPropertyFields(ConfigClass.class).toString();
      Assert.assertEquals(expected, actual);
   }
}
