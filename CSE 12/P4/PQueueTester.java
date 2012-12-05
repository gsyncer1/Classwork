/**
 * A JUnit tester to test Heap12's implementation of PQueue
 * 
 * @author Glenn Briones cs12faq
 */

import java.util.Random;
import junit.framework.TestCase;


public class PQueueTester extends TestCase {
	
	/**
	 * Tests that elements are added to the heap and that they
	 * are returned since each element added has highest priority.
	 */
	public void testAdd() {
		Heap12<Integer> testHeap = new Heap12<Integer>();
		for(int i=0; i<1000; i++) {
			testHeap.add(i);
			testHeap.add(i);
			assertEquals(i, testHeap.peek().intValue());
		}
	}
	
	/**
	 * Tests that the <tt>add()</tt> method throws a NullPointerException
	 * when trying to add a null element.
	 */
	public void testAddNull() {
		Heap12<String> testHeap = new Heap12<String>();
		try {
			testHeap.add(null);
			fail("Should have thrown NullPointerException");
		}
		catch(java.lang.NullPointerException e) {
			//Test passes
			assertTrue(true);
		}
	}
	
	/**
	 * Test that the remove method returns the highest priority element from
	 * the heap, or <tt>null</tt> if the heap is empty.
	 */
	public void testRemove() {
		Heap12<Integer> testHeap = new Heap12<Integer>();
		assertNull(testHeap.remove());
		for(int i=0; i<1000; i++) {
			testHeap.add(i);
		}
		for(int j=999; j>=0; j--) {
			assertTrue(testHeap.remove().equals(j));
		}
		assertNull(testHeap.remove());
	}
	
	/**
	 * Tests that the <tt>peek()</tt> method returns the highest priority
	 * element and that it returns the same element returned as 
	 * <tt>remove()</tt>.
	 */
	public void testPeek() {
		Heap12<Integer> testHeap = new Heap12<Integer>();
		assertNull(testHeap.peek());
		for(int i=0; i<1000; i++) {
			testHeap.add(i);
		}
		for(int j=0; j<1000; j++) {
			assertTrue(testHeap.peek().equals(testHeap.remove()));
		}
		assertNull(testHeap.peek());
	}
	
	/**
	 * Tests that the size method returns the number of elements in the
	 * heap.
	 */
	public void testSize() {
		Heap12<Integer> testHeap = new Heap12<Integer>();
		assertEquals(0, testHeap.size());
		for(int i=0; i< 1000; i++) {
			testHeap.add(i);
			assertEquals(i+1, testHeap.size());
		}
		
		for(int j=999; j>=0; j--) {
			testHeap.remove();
			assertEquals(j, testHeap.size());
		}
	}
	
	/**
	 * Tests that <tt>isEmpty()</tt> returns <tt>true</tt> if the heap is
	 * indeed empty and <tt>false</tt> otherwise.
	 */
	public void testIsEmpty() {
		Heap12<Integer> testHeap = new Heap12<Integer>();
		assertTrue(testHeap.isEmpty());
		
		testHeap.add(0);
		assertFalse(testHeap.isEmpty());
		
		for(int i=1; i<1000; i++) {
			testHeap.add(i);
			assertFalse(testHeap.isEmpty());
		}
		
		for(int j=0; j<1000; j++) {
			testHeap.remove();
		}
		
		assertTrue(testHeap.isEmpty());
	}
	
	/**
	 * Tests that the equals method returns false when comparing two objects
	 * of different types.
	 */
	public void testEqualsDifferentObjs() {
		Heap12<Integer> testHeap = new Heap12<Integer>();
		Integer diffObj = new Integer(1);
		
		assertFalse(testHeap.equals(diffObj));
	}
	
	/**
	 * Tests that the equals method returns false when comparing two heaps
	 * of different sizes.
	 */
	public void testEqualsDifferentSizes() {
		Heap12<Integer> testHeap1 = new Heap12<Integer>();
		Heap12<Integer> testHeap2 = new Heap12<Integer>();
		
		for(int i=0; i<1000; i++) testHeap1.add(i);
		for(int j=0; j<1001; j++) testHeap2.add(j);
		
		assertFalse(testHeap1.equals(testHeap2));
	}
	
	/**
	 * Tests that the equals method returns true when comparing two 
	 * identical heaps.
	 */
	public void testEquals() {
		Heap12<Integer> testHeap1 = new Heap12<Integer>();
		Heap12<Integer> testHeap2 = new Heap12<Integer>();
		
		for(int i=0; i<1000; i++) {
			testHeap1.add(i);
			testHeap2.add(i);
		}
		
		assertTrue(testHeap1.equals(testHeap2));
	}
	
	/**
	 * Tests the sort by creating an array of 500 random integers
	 * between -100 and 100 and checks that the sort method returns
	 * the array in order.
	 */
	public void testSort() {
		//Create a an array of random Integers
		int min = -100;
		int max = 100;
		Integer[] intArray = new Integer[500];
		Random randGenerator = new Random();
		for(int i=0; i<intArray.length; i++)
			intArray[i] = new Integer(min + 
			randGenerator.nextInt(max-min+1));
		//Sort the array
		Heap12.sort(intArray);
		//Assert that all the object are sorted into nondecreasing order
		for(int i=0; i<intArray.length-1; i++)
			assertTrue("Integer i: "+intArray[i]+" Integer i+1: " 
			+intArray[i+1], intArray[i] <= intArray[i+1]);
	}
	
	public static void main(String args[]) {
		junit.textui.TestRunner.main(new String[] {"PQueueTester"});
	}
}
