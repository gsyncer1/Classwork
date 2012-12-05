/**
 * An interface that specifies the familiar queue abstraction, but with
 * limited capacity.
 * <p>
 * In addition to the methods required in the definition of this interface,
 * a class implementing this interface should provide a public constructor
 * with a single argument of type <tt>int</tt>, which specifies the
 * capacity of the LimCapQueue.  The constructor should throw an
 * IllegalArgumentException if the specified capacity is negative.
 */
public interface LimCapQueue<E> {

  /**
   * Returns the capacity of this LimCapQueue, that is,
   * the maximum number of elements it can hold.
   * <br>PRECONDITION: none
   * <br>POSTCONDITION: the LimCapQueue is unchanged.
   * @return the capacity of this LimCapQueue
   */
  public int capacity();

  /**
   * Returns the number of elements in this LimCapQueue.
   * <br>PRECONDITION: none
   * <br>POSTCONDITION: the LimCapQueue is unchanged.
   * @return the number of elements in this LimCapQueue
   */
  public int size();

  /**
   * Adds the specified element to the tail of this LimCapQueue.
   * Returns true if the operation succeeded, else false.
   * <br>PRECONDITION: the LimCapQueue's size is less than its capacity.
   * <br>POSTCONDITION: the element is now the tail element in this
   * LimCapQueue, none of the other elements have been changed, and
   * the size is increased by 1.
   * @param e the element to add to the queue
   * @return <tt>true</tt> if the element was added, else <tt>false</tt>.
   * @throws NullPointerException if the specified element is null,
   * and size is less than capacity
   */
  public boolean enqueue(E e);

  /**
   * Removes the element at the head of this LimCapQueue.
   * Returns the element removed, or <tt>null</tt> if there was no such element.
   * <br>PRECONDITION: the LimCapQueue's size is greater than zero.
   * <br>POSTCONDITION: the head element in this LimCapQueue has been removed,
   * none of the other elements have been changed, and
   * the size is decreased by 1.
   * @return  the element removed, or <tt>null</tt> if the size was zero.
   */
  public E dequeue();

  /**
   * Returns the element at the head of this LimCapQueue,
   * or <tt>null</tt> if there was no such element.
   * <br>PRECONDITION: the LimCapQueue's size is greater than zero.
   * <br>POSTCONDITION: The LimCapQueue is unchanged.
   * @return  the element at the head, or <tt>null</tt> if the size was zero.
   */
  public E peek();

  /**
   * Compares the specified object with this LimCapQueue for equality.
   * Returns true if and only if the specified object is
   * also a LimCapQueue of the same type, both have the same size, and the
   * corresponding pairs of elements in the two are
   * equal. Two elements e1 and e2 are equal if e1.equals(e2).
   * "Corresponding pairs" means: the pair of head elements,
   * the pair of next-to-head elements, and so on through to
   * the pair of tail elements.
   * @return true if the specified Object is equal to this LimCapQueue
   * @param  o the Object to compare to this LimCapQueue for equality
   */
  public boolean equals(Object o);


}
