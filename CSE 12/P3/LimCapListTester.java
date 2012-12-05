/**
 * A JUnit tester to test the Array12 implementation of LimCapList
 *
 * @author Glenn Briones cs12faq
 */

import junit.framework.*;
import junit.extensions.*;

public class LimCapListTester extends TestCase
{
   /**
    * Tests if capacity() method returns the correct capacity.
    */
   public void testCapacity()
   {
      //Create an Array12 object with capacity 5
      LimCapList<String> strList = new Array12<String>(5);

      assertEquals(5, strList.capacity());

   }

   /**
    * Tests if size() method returns the correct size.
    */
   public void testSize()
   {
      //Add several elements to the list
      LimCapList<Integer> intList = new Array12<Integer>(1000);

      for(int i=0; i< 1000; i++)
      {
	 intList.addFront(i);
      } // Note to self: Responsibility of add and remove methods to
        // increment and decrement sizes correctly
      //Check that the number of elements it returns is correct.
      assertEquals(1000, intList.size());
   }

   /**
    * Tests if the addFront method adds elements to the front of the list
    */
   public void testAddFront()
   {
      LimCapList<Integer> intList = new Array12<Integer>(1000);

      for(int i=0; i < 1000; i++)
      {
    	  assertTrue(intList.addFront(i));
    	  assertEquals(i, intList.peekFront().intValue());
      }

   }

   /**
    * Tests if the addFront method properly throws a NullPointerException
    */
   public void testAddFrontNull()
   {
      //Do not permit null elements
      LimCapList<String> strList = new Array12<String>(5);
      try{
    	  strList.addFront(null);
    	  fail("addFront did not throw NullPointerException");
      }
      catch(java.lang.NullPointerException e)
      {
    	  //NullPointerException caught. Test passes.
    	  assertTrue(true);
      }
   }

   /**
    * Tests if the addFront method doesn't permit adding beyond capacity
    * by returning false.
    */
   public void testAddFrontBeyondCapacity()
   {
      LimCapList<Integer> intList = new Array12<Integer>(1000);

      for(int i=0; i<1000; i++) intList.addFront(i);

      assertFalse(intList.addFront(1000));
   }

   /**
    * Tests if the addBack method adds elements to the back of the list.
    */
   public void testAddBack()
   {
      LimCapList<Integer> intList = new Array12<Integer>(1000);

      for(int i=0; i<1000; i++)
      {
    	  assertTrue(intList.addBack(i));
    	  assertEquals(i, intList.peekBack().intValue());
      }
   }

   /**
    * Tests if the addBack method properly throws a NullPointerException.
    */
   public void testAddBackNull()
   {
      LimCapList<String> strList = new Array12<String>(5);

      try{
    	  strList.addBack(null);
    	  fail("addBack did not throw NullPointException");
      }
      catch(java.lang.NullPointerException e)
      {
	 //Exception caught. Test passes
	 assertTrue(true);
      }
   }

   /**
    * Tests if the addBack method doesn't permit adding beyond capacity
    * by returning false.
    */
   public void testAddBackBeyondCapacity()
   {
      LimCapList<Integer> intList = new Array12<Integer>(1000);

      for(int i=0; i<1000; i++) intList.addBack(i);

      assertFalse(intList.addFront(1000));
   }

   /**
    * Tests if the removeFront method properly removes elements from the
    * front of the list and returns the removed elements.
    */
   public void testRemoveFront()
   {
	   LimCapList<Integer> intList = new Array12<Integer>(1000);
	   
	   assertTrue(intList.removeFront() == null);
	   
	   for(int i=0; i<1000; i++) intList.addFront(i);
	   
	   for(int i=999; i>=0; i--)
	   {
		   Integer testInt = new Integer(i);
		   assertTrue(intList.removeFront().equals(testInt));
	   }
	   
	   //All elements should be removed
	   //Another call to removeFront should be null
	   assertTrue(intList.removeFront() == null);
   }
   
   /**
    * Tests if the removeBack method properly removes elements from the
    * back of the list and returns the removed elements.
    */
   public void testRemoveBack()
   {
	   LimCapList<Integer> intList = new Array12<Integer>(1000);
	   
	   assertTrue(intList.removeBack() == null);
	   
	   for(int i=0; i<1000; i++) intList.addBack(i);
	   
	   for(int i=999; i>=0; i--)
	   {
		   Integer testInt = new Integer(i);
		   assertTrue(intList.removeBack().equals(testInt));
	   }
	   
	   assertTrue(intList.removeBack() == null);
   }
   
   /**
    * Tests if the peekFront method returns the front element of the list
    * or null if no such element exists.
    */
   public void testPeekFront()
   {
	   LimCapList<Integer>	intList = new Array12<Integer>(1000);
	   
	   assertTrue(intList.peekFront() == null);
	   
	   for(int i=0; i<1000; i++)
	   {
		   intList.addFront(i);
		   assertTrue(intList.peekFront().equals(new Integer(i)));
	   }
	   
	   for(int j=0; j<1000; j++) 
		   assertTrue(intList.peekFront().equals(intList.removeFront()));
	   
	   assertTrue(intList.peekFront() == null);
   }
   
   /**
    * Tests if the peekBack method returns the back element of the list
    * or null if no such element exists.
    */
   public void testPeekBack()
   {
	   LimCapList<Integer> intList = new Array12<Integer>(1000);
	   
	   assertTrue(intList.peekBack() == null);
	   
	   for(int i=0; i<1000; i++)
	   {
		   intList.addBack(i);
		   assertTrue(intList.peekBack().equals(new Integer(i)));
	   }
	   
	   for(int j=0; j<1000; j++)
	   {
		   assertTrue(intList.peekBack().equals(intList.removeBack()));
	   }
	   
	   assertTrue(intList.peekBack() == null);
   }
   
   /**
    * Tests if the equals method returns false when comparing an Array12
    * object with an object of a different type.
    */
   public void testEqualsDifferentTypes()
   {
	   String testStringObj = "";
	   LimCapList<String> testStrListObj = new Array12<String>(1);
	   
	   assertFalse(testStrListObj.equals(testStringObj));
   }
   
   /**
    * Tests if the equals method returns false when comparing two lists
    * of the same type but have different sizes.
    */
   public void testEqualsDifferentSizes()
   {
	   LimCapList<Integer> intList1 = new Array12<Integer>(1000);
	   LimCapList<Integer> intList2 = new Array12<Integer>(1000);
	   
	   for(int i=0; i<1000; i++) intList1.addFront(i);
	   for(int j=0; j<1000; j++)
	   {
		   assertFalse(intList1.equals(intList2));
		   intList2.addFront(j);
	   }
   }
   
   /**
    * Tests if the equals method returns false if two lists are of the 
    * same size but have different elements.
    */
   public void testEqualsDifferentElements()
   {
	   LimCapList<Integer> intList1 = new Array12<Integer>(1000);
	   LimCapList<Integer> intList2 = new Array12<Integer>(1000);
	   
	   for(int i=0; i<1000; i++)
	   {
		   intList1.addFront(i);
		   intList2.addFront(1000-i);
	   }
	   
	   assertFalse(intList1.equals(intList2));
   }
   
   /**
    * Tests if the equals method returns true if the two lists are 
    * indeed equal.
    */
   public void testEqualsEqualLists()
   {
	   LimCapList<Integer> intList1 = new Array12<Integer>(1000);
	   LimCapList<Integer> intList2 = new Array12<Integer>(1000);
	   
	   for(int i=0; i<1000; i++)
	   {
		   intList1.addFront(i);
		   intList2.addFront(i);
	   }
	   
	   assertTrue(intList1.equals(intList2));
   }
   
   public static void main(String args[])
   {
	   junit.textui.TestRunner.main(new String[] {"LimCapListTester"});
   }
}
