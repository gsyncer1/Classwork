/**
 * An Array12 is a sequential structure with restricted access
 * and limited capacity. Array12 implements LimCapList and uses
 * a circular array to store data.
 *
 * @author Glenn Briones cs12faq
 */

import java.lang.IllegalArgumentException;
import java.lang.NullPointerException;

public class Array12<E> implements LimCapList<E>
{
   private int capacity; //Capacity of Array12
   private int size = 0; //Track size of list
   private E[] array; //Array to be used for list
   private int front = -1; //point front index before insertion point
   private int back = 0;//point back index before insertion point

   /**
    * Constructs an Array12 object with a specified capacity.
    * @param cap the capacity of the Array12 object
    */
   public Array12(int cap)
   {
      if(cap >= 0) capacity = cap;
      else throw new IllegalArgumentException("" + cap);
      array = (E[]) new Object[capacity];
   }

   /**
    * Returns the capacity of the Array12 object.
    * @return the capacity of the Array12 object
    */
   public int capacity()
   {
      return this.capacity;
   }

   /**
    * Returns the size of the Array12 object.
    * @return the size of the Array12 object
    */
   public int size()
   {
      return this.size;
   }

   /**
    * Adds an element to the front of the list.
    * @param e the element to be added to the list
    * @return <tt>true</tt> if the element was added, else <tt>false</tt>
    */
   public boolean addFront(E e)
   {
      if(size == capacity) return false;
      if(e == null) throw new NullPointerException();

      //Add to front of array
      array[mod(++front,capacity)] = e;
      //Increase the size
      size++;

      return true;
   }

   /**
    * Adds the specified element to the back of this Array12.
    * Returns true if the operation succeeded, else false.
    * @param e the element to add to the back of the list
    * @return <tt>true</tt> if the element was added, else <tt>false</tt>
    */
   public boolean addBack(E e)
   {
      if(size == capacity) return false;
      if(e == null) throw new NullPointerException();

      //Add to back of list
      array[ mod(--back, capacity) ] = e;
      //Increase the size
      size++;

      return true;
   }

   /**
    * Removes the element at the front of this Array12. Returns the element
    * removed, or <tt>null</tt> if there was no such element.
    * @return the element removed, or <tt>null</tt> if the size was zero
    */
   public E removeFront()
   {
      if(size==0) return null;
      E element = array[mod(front,capacity)];
      array[mod(front--,capacity)] = null;
      size--;
      return element;
   }

   /**
    * Removes the element at the back of this Array12. Returns the element
    * removed, or <tt>null</tt> if there was no such element.
    * @return the element removed, or <tt>null</tt> if the size was zero
    */
   public E removeBack()
   {
      if(size==0) return null;
      E element = array[mod(back,capacity)];
      array[mod(back++, capacity)] = null;
      size--;
      return element;
   }

   /**
    * Returns the element at the front of this Array12, or <tt>null</tt>
    * if there was no such element.
    * @return the element at the front, or <tt>null</tt> if the size was zero
    */
   public E peekFront()
   {
      if(size==0) return null;
      return array[mod(front,capacity)];
   }

   /**
    * Returns the element at the back of this Array12, or <tt>null</tt>
    * if there was no such element.
    * @return the element at the back, or <tt>null</tt> if the size was zero
    */
   public E peekBack()
   {
      if(size==0) return null;
      return array[mod(back,capacity)];
   }

   
   /**
    * Compares the specified object with this Array12 for equality. Returns
    * true if and only if the specified object is also an Array12 of the same
    * type, both have the same size, and the corresponding pairs of elements
    * in the two are equal.
    * @param o the Object to compare to this Array12 for equality
    * @return true if the specified Object is equal to this Array12
    */
   public boolean equals(Object o)
   {
      if(o.getClass() != this.getClass()) return false;
      if( ((Array12<E>) o).size() != this.size()) return false;

      Array12<E> testObj = (Array12<E>) o;

      for(int i=back; i<= front; i++)
      {
    	  E thisElement = this.array[mod(i,capacity)];
    	  E testElement = testObj.array[mod(i,capacity)];
    	  if(!(thisElement.equals(testElement)))
    		  return false;
      }

      return true;
   }
   
   /* Helper methods */
   /**
    * Returns the result of dividend mod divisor, which are specified.
    * This method replaces the use of the <tt>%</tt> operator since it
    * is a "remainder" operator, not a modulus operator, which is necessary
    * for this Array12 implementation.
    * @param dividend the dividend of the modulus operation
    * @param divisor the divisor of the modulus operation
    * @return the int value of dividend mod divisor
    */
   private static int mod(int dividend, int divisor)
   {
	   while(dividend < 0) dividend += divisor;
	   return dividend%divisor;
   }
}
