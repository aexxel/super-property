package com.aexxel.superproperty.core.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;

public class CollectionsTest {

   @Test
   @SuppressWarnings("unchecked")
   public void test_new_list() throws Exception {
      String expected = "[]";
      String actual = Collections.newList().toString();
      Assert.assertEquals(expected, actual);

      expected = "[Serializable]";
      actual = Collections.newList("Serializable").toString();
      Assert.assertEquals(expected, actual);

      expected = "[interface java.io.Serializable, class java.lang.ref.WeakReference]";
      actual = Collections.newList(Serializable.class, WeakReference.class).toString();
      Assert.assertEquals(expected, actual);

      expected = "[1, 2, 3]";
      actual = Collections.newList(1L, 2L, 3L).toString();
      Assert.assertEquals(expected, actual);
   }

   @Test
   public void test_new_set() throws Exception {
      String expected = "[]";
      String actual = Collections.newSet().toString();
      Assert.assertEquals(expected, actual);

      expected = "[1]";
      actual = Collections.newSet(1L).toString();
      Assert.assertEquals(expected, actual);

      expected = "[1, 2]";
      actual = Collections.newSet(1L, 2L).toString();
      Assert.assertEquals(expected, actual);

      expected = "[1, 2, 3]";
      actual = Collections.newSet(1L, 2L, 3L, 2L, 1L).toString();
      Assert.assertEquals(expected, actual);
   }

   @Test
   @SuppressWarnings("unchecked")
   public void test_new_map() throws Exception {
      final Map.Entry<Integer, String> e1 = new AbstractMap.SimpleEntry<Integer, String>(1, "Batman");
      final Map.Entry<Integer, String> e2 = new AbstractMap.SimpleEntry<Integer, String>(2, "Robin");
      final Map.Entry<Integer, String> e3 = new AbstractMap.SimpleEntry<Integer, String>(3, "Spiderman");

      String expected = "{}";
      String actual = Collections.<Integer, String>newMap().toString();
      Assert.assertEquals(expected, actual);

      expected = "{1=Batman}";
      actual = Collections.newMap(e1).toString();
      Assert.assertEquals(expected, actual);

      expected = "{1=Batman, 2=Robin}";
      actual = Collections.newMap(e1, e2).toString();
      Assert.assertEquals(expected, actual);

      expected = "{1=Batman, 2=Robin, 3=Spiderman}";
      actual = Collections.newMap(e1, e2, e3).toString();
      Assert.assertEquals(expected, actual);
   }

   @Test
   @SuppressWarnings("unchecked")
   public void test_new_concurrent_map() throws Exception {
      final Map.Entry<Integer, String> e1 = new AbstractMap.SimpleEntry<Integer, String>(1, "Batman");
      final Map.Entry<Integer, String> e2 = new AbstractMap.SimpleEntry<Integer, String>(2, "Robin");
      final Map.Entry<Integer, String> e3 = new AbstractMap.SimpleEntry<Integer, String>(3, "Spiderman");

      String expected = "{}";
      String actual = Collections.<Integer, String>newConcurrentMap().toString();
      Assert.assertEquals(expected, actual);

      expected = "{1=Batman}";
      actual = Collections.newConcurrentMap(e1).toString();
      Assert.assertEquals(expected, actual);

      expected = "{2=Robin, 1=Batman}";
      actual = Collections.newConcurrentMap(e1, e2).toString();
      Assert.assertEquals(expected, actual);

      expected = "{2=Robin, 1=Batman, 3=Spiderman}";
      actual = Collections.newConcurrentMap(e1, e2, e3).toString();
      Assert.assertEquals(expected, actual);
   }

   @Test
   public void test_is_empty_collection() throws Exception {
      Assert.assertTrue(Collections.isEmpty((Collection<String>) null));
      Assert.assertTrue(Collections.isEmpty(Collections.newList()));
      Assert.assertFalse(Collections.isEmpty(Collections.newList(1)));
      Assert.assertFalse(Collections.isEmpty(Collections.newList("a", "b")));
   }

   @Test
   public void test_is_empty_array() throws Exception {
      Assert.assertTrue(Collections.isEmpty((Integer[]) null));
      Assert.assertTrue(Collections.isEmpty(new Integer[0]));
      Assert.assertFalse(Collections.isEmpty(new Integer[]{1}));
      Assert.assertFalse(Collections.isEmpty(new String[]{"a", "b"}));
   }

   @Test
   public void test_is_more_than_one_array() throws Exception {
      Assert.assertFalse(Collections.isMoreThanOne(null));
      Assert.assertFalse(Collections.isMoreThanOne(new Integer[0]));
      Assert.assertFalse(Collections.isMoreThanOne(new Integer[]{1}));
      Assert.assertTrue(Collections.isMoreThanOne(new String[]{"a", "b"}));
   }
}
