/**
 * List12Tester
 * 
 * Tests the following 13 methods of the List interface as implemented
 * in List12:
 * -public boolean add(E o)
 * -public void add(int index, E element)
 * -public void clear()
 * -public boolean contains(Object o)
 * -public boolean equals(Object o)
 * -public E get(int index)
 * -public int hashCode()
 * -public int indexOf(Object o)
 * -public Iterator<E> iterator()
 * -public boolean isEmpty()
 * -public boolean remove(Object o)
 * -public E set(index, E element)
 * -pubilc int size()
 *
 * @author Glenn Briones, cs12faq
 */


import junit.framework.*;
import junit.extensions.*;


public class List12Tester extends TestCase
{
  /**
   * Test public boolean add(E o)
   * -Checks if object is added to list
   * -Checks if add on the end
   * -Checks if it returns true
   */
  //Check that the List contains the element after adding
  public void testAddContains()
  {
    List12<String> strList = new List12<String>();
    strList.add("A");
    strList.add("B");
    strList.add("Foo");
    assertTrue(strList.contains("A"));
    assertTrue(strList.contains("B"));
    assertTrue(strList.contains("Foo"));

    //Check that none of these strings are contained.
    assertFalse(strList.contains("Bar"));
    assertFalse(strList.contains("FooBar"));
  }

  //Check that the object is added to the end.
  public void testAddGet()
  {
    List12<Integer> intList = new List12<Integer>();
    for(int i=0; i<1000; i++)
    {
      intList.add(i);
    }

    //Integers should be in correct order in ascending sequence.
    //Use get() to check this.
    for(int i=0; i<1000; i++)
    {
      assertEquals(new Integer(i), intList.get(i));
    }
  }

  //Check that add method returns true
  public void testAddReturn()
  {
    List12<String> strList = new List12<String>();
    assertTrue(strList.add("A"));
    assertTrue(strList.add("B"));
    assertTrue(strList.add("A"));
  }
 



  /**
   * Test public void add(int index, E element)
   * -Test if the element was added at the index
   * -Test with a negative value
   * -Test with a value greater than or equal to size
   * -Check if throws exceptions when necessary
   */
  public void testAddElementAtIndex()
  {
    List12<String> strList = new List12<String>();

    //Add "A" to the beginning (to empty set)
    strList.add(0, "A");
    assertTrue(strList.get(0).equals("A"));
    assertEquals(1, strList.size());

    //Add "B" to end
    strList.add(1, "B");
    assertTrue(strList.get(0).equals("A"));
    assertTrue(strList.get(1).equals("B"));
    assertEquals(2, strList.size());

    //Add "C" to index 1. 
    //Check that all elements are in correct order.
    strList.add(1, "C");
    assertTrue(strList.get(0).equals("A"));
    assertTrue(strList.get(1).equals("C"));
    assertTrue(strList.get(2).equals("B"));
    assertEquals(3, strList.size());

    //Add "D" to beginning (index 0)
    //Check that all elements are in correct order.
    strList.add(0, "D");
    assertTrue(strList.get(0).equals("D"));
    assertTrue(strList.get(1).equals("A"));
    assertTrue(strList.get(2).equals("C"));
    assertTrue(strList.get(3).equals("B"));
    assertEquals(4, strList.size());

  }

  //Test that add() throws an IndexOutOfBoundsException
  //when attempting to add at an illegal positive index
  public void testAddAtIndexIllegalPositive()
  {
    List12<String> strList = new List12<String>();
    //Add some elements to the list.
    //Check for IndexOutOfBoundsException
    strList.add("A");
    strList.add("B");
    try
    {
      //Attempt to add at index size of the List
      strList.add(strList.size()+1, "C");
      fail( "Should throw IndexOutOfBoundsException" );
    } 
    catch (IndexOutOfBoundsException e )
    {
      //At this point, Exception thrown. Test passes.
      assertTrue(true);
    }
  }

  //Test that add() throws an IndexOutOfBoundsException
  //when attempting to add at a negative index.
  public void testAddAtIndexNegative()
  {
    List12<String> strList = new List12<String>();
    //Add some elements to the list.
    //Check for IndexOutOfBoundsException
    strList.add("A");
    strList.add("B");
    try
    {
      //Attempt to add at negative index
      strList.add(-1, "C");
      fail( "Should throw IndexOutOfBoundsException" );
    } 
    catch (IndexOutOfBoundsException e )
    {
      //At this point, Exception thrown. Test passes.
      assertTrue(true);
    }
  }




  /**
   * Test public void clear()
   * -Check that all elements from intList are cleared after
   *  adding several Integer objects to the list.
   */
  public void testClear()
  {
    List12<Integer> intList = new List12<Integer>();
    //Add several Integer objects
    for(int i=0; i<1000; i++)
    {
      intList.add(i);
    }
    //Clear the list
    intList.clear();
    //Check that none of the objects are present
    for(int i=0; i<1000; i++)
    {
      assertFalse(intList.contains(i));
    }
  }




  /**
   * Test public boolean contains (Object o)
   * -Add Integers 1 - 1000 to list
   * -Check that contains() returns true when checking for those integers
   * -Check that contains() returns false when check for integers
   *  less than 0 or greater than or equal to 1000
   */
  public void testContains()
  {
    List12<Integer> intList = new List12<Integer>();
    //Add integers to list
    for(int i=0; i<1000; i++)
    {
      intList.add(i);
    }

    //Check that contains() returns true for these Integers.
    for(int i=0; i<1000; i++)
    {
      assertTrue(intList.contains(i));
    }

    //Verify that contains() returns false for other Integers   
    for(int i=-1; i>=-1000; i--)
    {
      assertFalse(intList.contains(i));
    }

    for(int i=1001; i<2000; i++)
    {
      assertFalse(intList.contains(i));
    }
  }




  /**
   * Test public boolean equals(Object o).
   * -Check that the lists have the same size
   * -Check that each pair of elements are equal.
   * --(e1==null ? e2==null: e1.equals(e2))
   */
  public void testEquals()
  {
    List12<Integer> intList1 = new List12<Integer>();
    List12<Integer> intList2 = new List12<Integer>();

    //Initialized lists should be equal. Size==0
    assertTrue(intList1.equals(intList2));

    //Create identical Integer lists. Should be equal.
    for(int i=0; i<1000; i++)
    {
      intList1.add(i);
      intList2.add(i);
    }
    assertTrue(intList1.equals(intList2));

    //Change one element of one list. Should not be equal.
    intList2.set(intList2.size()-1, 0);
    assertFalse(intList1.equals(intList2));

    //Clear each list and create lists of different sizes.
    //Should not be equal.
    intList1.clear();
    intList2.clear();
    for(int i=0; i<1000; i++) //size of 1000
    {
      intList1.add(i);
    }
    for(int i=0; i<=1000; i++) //size of 1001
    {
      intList2.add(i);
    }
    assertFalse(intList1.equals(intList2));
  }




  /**
   * Test public E get(int index)
   * -Check that you get the correct elements
   * -Check that IndexOutOfBoundsException is thrown
   */
  public void testGet()
  {
    List12<Integer> intList = new List12<Integer>();

    //Add elements to an Integer list
    for(int i=0; i<1000; i++)
    {
      intList.add(i);
    }

    //Check that all the elements at each index using get() are correct
    for(int i=0; i<1000; i++)
    {
      assertEquals(i, intList.get(i).intValue());
    }
  }

  //Check that get() throws IndexOutOfBoundsException at index >= size()
  public void testGetAtIndexSize()
  {
    List12<String> strList = new List12<String>();

    strList.add("A");
    strList.add("B");

    try
    {
      strList.get(strList.size());
      fail("Method get() should have thrown IndexOutOfBoundsException");
    }
    catch (IndexOutOfBoundsException e)
    {
      //IndexOutOfBoundsException thrown and caught at this point.
      //Test passes
      assertTrue(true);
    }
  }

  //Check that get() throws IndexOutOfBoundsException at index < 0
  public void testGetAtNegativeIndex()
  {
    List12<String> strList = new List12<String>();

    strList.add("A");
    strList.add("B");

    try
    {
      strList.get(-1);
      fail("Method get() should have thrown IndexOutOfBoundsException");
    }
    catch (IndexOutOfBoundsException e)
    {
      //IndexOutOfBoundsException thrown and caught at this point.
      //Test passes
      assertTrue(true);
    }
  }




  /**
   * Test public int hashCode()
   * -If two Objects are equal, then their hash codes must be equal.
   */
  public void testHashCode()
  {
    List12<String> strList1 = new List12<String>();
    List12<String> strList2 = new List12<String>();
    
    //Two empty initialized lists should be equal, so their
    //hash codes should be equal
    assertTrue(strList1.hashCode() == strList2.hashCode());

    //Add same elements to strList1 and strList2.
    //Hash codes should still be the equal
    strList1.add("A"); strList2.add("A");
    strList1.add("B"); strList2.add("B");
    assertTrue(strList1.hashCode() == strList2.hashCode());

    //Remove last element from strList2.
    //Hash codes should not be equal.
    strList2.remove("B");
    assertFalse(strList1.hashCode() == strList2.hashCode());

    //Add another element back to strList2.
    //Size the same, but hash codes should not be equal.
    strList2.add("C");
    assertFalse(strList1.hashCode() == strList2.hashCode());

    //Clear all elements from each list.
    //Hash codes should be equal again.
    strList1.clear(); strList2.clear();
    assertTrue(strList1.hashCode() == strList2.hashCode());

  }

  //Test the hashCode calculation of hashCode()
  public void testHashCodeCalculation()
  {
    List12<Integer> intList = new List12<Integer>();

    //Add Integers to the list
    for(int i=0; i<100; i++)
    {
      intList.add(i);
    }

    //Independently calculate the hashCode as defined by
    //Java List API
    int hashCode = 1;
    for(Integer e: intList)
    {
      hashCode = 31*hashCode + (e==null ? 0 : e.hashCode());
    }
    //Check that this hashCode is equal to List12's hashCode()
    //calculation.
    assertEquals(hashCode, intList.hashCode());
  }




  /**
   * Test int indexOf(Object o)
   * -Check that the return values of the List12 implementation of
   *  indexOf() are correct.
   */
  public void testIndexOf()
  {
    List12<String> strList = new List12<String>();

    //Nothing in the list.
    //Searching for the index of a string should return -1.
    assertEquals(-1, strList.indexOf("A"));

    //Add "A"
    //indexOf("A") should return 0.
    strList.add(0, "A");
    assertEquals(0, strList.indexOf("A"));

    //Add "B"
    //indexOf("B") should return 1.
    strList.add(1, "B");
    assertEquals(1, strList.indexOf("B"));

    //Add another "A"
    //indexOf("A") should still return 0, the index of the first "A"
    strList.add(2, "A");
    assertEquals(0, strList.indexOf("A"));

    //Set String at index 0 to "C"
    //indexOf("A") should now return 2, the index of the only "A"
    strList.set(0, "C");
    assertEquals(2, strList.indexOf("A"));

    //"D" not added. Should return -1.
    assertEquals(-1, strList.indexOf("D"));
  }




  /**
   * Test public Iterator<E> iterator()
   * -Tests the List12 implementation of iterator()
   */
  public void testIterator()
  {
    List12<String> strList = new List12<String>();

    strList.add("A");
    strList.add("B");
    strList.add("C");

    //iterator() should return an Iterator of strIter such that
    //all the elements are preserved in the iterator in the correct order.
    java.util.Iterator<String> strIter = strList.iterator();
    /* Use iterator methods to move through List to verify implementation 
     * of the iterator() method.
     * For each String in the List, hasNext() should return true
     * and each of the next() methods should return each of the letters
     * in the order they were added.
     */
    assertTrue(strIter.hasNext());
    assertTrue(strIter.next().equals("A"));
    assertTrue(strIter.hasNext());
    assertTrue(strIter.next().equals("B"));
    assertTrue(strIter.hasNext());
    assertTrue(strIter.next().equals("C"));

    //Iterator cursor should reach end of list.
    //hasNext() should then return false.
    assertFalse(strIter.hasNext());
  }

  public void testIteratorRemove()
  {
    List12<String> strList = new List12<String>();
    strList.add("A");

    java.util.Iterator<String> strIter = strList.iterator();
    assertTrue(strIter.hasNext());
    assertTrue(strList.contains("A"));
    assertTrue(strIter.next().equals("A"));
    strIter.remove();
    assertFalse(strList.contains("A"));
  }

  public void testIteratorNextException()
  {
    //Create an empty list
    List12<String> strList = new List12<String>();

    //Get an iterator for the list
    java.util.Iterator<String> strIter = strList.iterator();

    try
    {
      String obj = strIter.next();
      fail("Should have thrown NoSuchElementException");
    }
    catch(java.util.NoSuchElementException e)
    {
      //Test passes
      assertTrue(true);
    }
  }

  public void testIteratorRemoveException()
  {
    List12<String> strList = new List12<String>();
    strList.add("A");
    strList.add("B");

    java.util.Iterator<String> strIter = strList.iterator();
    String str = strIter.next();

    try
    {
      strIter.remove();
      strIter.remove();
      fail("Should have thrown IllegalStateException");
    }
    catch(IllegalStateException e)
    {
      //Test passes
      assertTrue(true);
    }
  }




  /**
   * Test public boolean isEmpty()
   * -Tests the List12 implementation of isEmpty().
   */
  public void testIsEmpty()
  {
    List12<Integer> intList = new List12<Integer>();
    //List should be empty when initialized
    assertTrue(intList.isEmpty());
    //List should not be empty when an element is added
    intList.add(0);
    assertFalse(intList.isEmpty());
    //List should not be empty when adding more elements
    for(int i=1; i<1000; i++)
    {
      intList.add(i);
    }
    assertFalse(intList.isEmpty());
    //Clear list and check if isEmpty returns true
    intList.clear();
    assertTrue(intList.isEmpty());
  }




  /**
   * Test public boolean remove(Object o)
   * -Tests the List12 implementation of remove().
   */
  public void testRemove()
  {
    List12<String> strList = new List12<String>();
    //Try removing object from empty list, should return false.
    assertFalse(strList.remove("A"));
    //Add strings...
    strList.add("A");
    strList.add("B");

    //Remove "A". Should return true.
    assertTrue(strList.remove("A"));
    //Verify that "A" is no longer in strList
    assertFalse(strList.contains("A"));
    //Verify that strList still contains "B"
    assertTrue(strList.contains("B"));

    //When attempting to remove "C",
    //remove() should return false
    assertFalse(strList.remove("C"));

    //Add 2 "D" String objects. Use remove() to remove one of them.
    //strList should still contain one "D"
    strList.add("D");
    strList.add("D");
    assertTrue(strList.remove("D"));
    assertTrue(strList.contains("D"));
  }




  /**
   * public E set(int index, E element)
   * -Check that elements are replaced at the right index.
   * -Check that IndexOutOfBounds Exception is thrown when
   *  an illegal index is used.
   */
  public void testSet()
  {
    List12<String> strList = new List12<String>();

    strList.add("A");
    strList.add("B");
    strList.add("C");

    //Set 0th element to "D". Should be "D" at index 0
    //and unchanged everywhere else.
    strList.set(0, "D");
    assertTrue(strList.get(0).equals("D"));
    assertTrue(strList.get(1).equals("B"));
    assertTrue(strList.get(2).equals("C"));

    //Set 1st element to "E" and change 0th element back to "A"
    //Should then be "A", "E", and "C" and indices 0,1,2 respectively
    strList.set(1, "E");
    strList.set(0, "A");
    assertTrue(strList.get(0).equals("A"));
    assertTrue(strList.get(1).equals("E"));
    assertTrue(strList.get(2).equals("C"));

    //Set 2nd element with a longer string "Foobar"
    //Should be "A", "E", "FooBar" at indices 0,1,2
    strList.set(2, "FooBar");
    assertTrue(strList.get(0).equals("A"));
    assertTrue(strList.get(1).equals("E"));
    assertTrue(strList.get(2).equals("FooBar"));
  }

  public void testSetReturns()
  {
    List12<String> strList = new List12<String>();
    strList.add("A");
    strList.add("B");
    strList.add("C");

    assertTrue(strList.set(1, "D").equals("B"));
  }

  //Check that an IndexOutOfBoundsException is thrown when accessing
  //an illegal index.
  public void testSetPositiveOutOfBoundsException()
  {
    List12<String> strList = new List12<String>();
    //Add some elements to the list.
    //Check for IndexOutOfBoundsException
    strList.add("A");
    strList.add("B");
    try
    {
      strList.set(strList.size(), "C");
      fail( "Should throw IndexOutOfBoundsException" );
    } 
    catch (IndexOutOfBoundsException e )
    {
      //Exception thrown. Test passes.
      assertTrue(true);
    }
  }

  public void testSetNegativeOutOfBoundsException()
  {
    List12<String> strList = new List12<String>();
    //Add some elements to the list.
    //Check for IndexOutOfBoundsException
    strList.add("A");
    strList.add("B");
    try
    {
      strList.set(-1, "C");
      fail( "Should throw IndexOutOfBoundsException" );
    } 
    catch (IndexOutOfBoundsException e )
    {
      //Exception thrown. Test passes.
      assertTrue(true);
    }

  }




  /**
   * Test public int size()
   * -Test that the List12 implementation of size() returns the 
   *  correct size of the List
   */
  public void testSize()
  {
    List12<Integer> intList = new List12<Integer>();

    //size of intList should be 0 when intialized
    assertEquals(0, intList.size());
    //Add elements to list and check size.
    for(int i=0; i<1000; i++)
    {
      intList.add(i);
    }
    assertEquals(1000, intList.size());

    //Clear list and check size is zero
    intList.clear();
    assertEquals(0, intList.size());
  }




   /* Tester main */
   public static void main(String args[])
   {
     junit.textui.TestRunner.main(new String[] {"List12Tester"});
   }
}
