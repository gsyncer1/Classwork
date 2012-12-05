/**
 * A stack with limited capacity.
 * Adapts the methods of the Array12 method.
 *
 * @author Glenn Briones cs12faq
 */

public class Stack12<E> implements LimCapStack<E>
{
   private LimCapList<E> stack;

   /**
    * Constructs a Stack12 object with the specified capacity.
    * @param cap the capacity of the stack
    */
   public Stack12(int cap)
   {
      stack = new Array12<E>(cap);
   }

   /**
    * Returns the capacity of this Stack12 object.
    * @return the capacity of this Stack12 object
    */
   public int capacity()
   {
      return stack.capacity();
   }

   /**
    * Returns the number of elements in this Stack12 object.
    * @return the number of elements in this Stack12 object
    */
   public int size()
   {
      return stack.size();
   }

   /**
    * Adds the specified element to the top of this stack. Returns true if
    * the operation succeeded, else false.
    * @param e the element to add to the stack
    * @return true if the element was added, else false
    * @throws NullPointerException if the specified element is null, and
    * size is less than capacity
    */
   public boolean push(E e)
   {
      return stack.addFront(e);
   }

   /**
    * Removes the element at the top of this stack. Returns the element 
    * removed, or null if there was no such element.
    * @return the element removed, or null if the size was zero
    */
   public E pop()
   {
      return stack.removeFront();
   }

   /**
    * Returns the element at the top of this stack, or null if there was no
    * such element.
    * @return the element at the top, or null if the size was zero.
    */
   public E peek()
   {
      return stack.peekFront();
   }

   /**
    * Compares the specified object with this stack for equality. Returns
    * true if the specified object is of the same type, both have the same
    * size, and the corresponding pairs of elements in the two are equal.
    * @param o the Object to compare this stack for equality
    * @return true if the specified Object is equal to this Stack
    */
   public boolean equals(Object o)
   {
      return stack.equals(o);
   }
}
