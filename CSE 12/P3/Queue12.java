/**
 * A queue with limited capacity.
 * Adapts the methods of the Array12 implementation.
 * 
 * @author Glenn Briones cs12faq
 */

public class Queue12<E> implements LimCapQueue<E>
{
   private LimCapList<E> queue;

   /**
    * Constructs a queue with the specified capacity.
    * @param the capacity of the queue
    */
   public Queue12(int cap)
   {
      queue = new Array12<E>(cap);
   }

   /**
    * Returns the capacity of this Queue12 object.
    * @return the capacity of this Queue12 object
    */
   public int capacity(){
      return queue.capacity();
   }

   /**
    * Returns the number of elements in this Queue12 object.
    * @return the number of elements in thsi Queue12 object
    */
   public int size(){
      return queue.size();
   }

   /**
    * Adds the specified element to the tail of this Queue12 object.
    * Returns true if the operation succeeded, else false.
    * @param e the element to add to the queue
    * @return if the element was added, else false
    * @throws NullPointerException if the specified element is null, and
    * size is less than capacity.
    */
   public boolean enqueue(E e)
   {
      return queue.addBack(e);
   }

   /**
    * Removes the element at the head of this Queue12 object.
    * Returns the element removed, or null if there was no such element.
    * @return the element removed, or null if the size was zero
    */
   public E dequeue()
   {
      return queue.removeFront();
   }

   /**
    * Returns the element at the head of this Queue12 object, or null if there
    * was no such element
    * @return the element at the head, or null if the size was zero
    */
   public E peek()
   {
      return queue.peekFront();
   }

   /**
    * Compares the specified object with this Queue12 object for equality.
    * Returns true if and only if the specified object is also of the same 
    * type, both have the same size, and the corresponding pairs of elements 
    * in the two are equal.
    * @param o the Object to compare to this Queue12 object for equality
    * @return true if the specified Object is equal to this Queue12 object
    */
   public boolean equals(Object o)
   {
      return queue.equals(o);
   }
}
