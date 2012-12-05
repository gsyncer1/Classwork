/**
 * An interface that specifies the familiar stack abstraction, but with
 * limited capacity.
 * <p>
 * In addition to the methods required in the definition of this interface,
 * a class implementing this interface should provide a public constructor
 * with a single argument of type <tt>int</tt>, which specifies the
 * capacity of the LimCapStack.  The constructor should throw an
 * IllegalArgumentException if the specified capacity is negative.
 */
public interface LimCapStack<E> {

  /**
   * Returns the capacity of this LimCapStack, that is,
   * the maximum number of elements it can hold.
   * <br>PRECONDITION: none
   * <br>POSTCONDITION: the LimCapStack is unchanged.
   * @return the capacity of this LimCapStack
   */
  public int capacity();

  /**
   * Returns the number of elements in this LimCapStack.
   * <br>PRECONDITION: none
   * <br>POSTCONDITION: the LimCapStack is unchanged.
   * @return the number of elements in this LimCapStack
   */
  public int size();

  /**
   * Adds the specified element to the top of this LimCapStack.
   * Returns true if the operation succeeded, else false.
   * <br>PRECONDITION: the LimCapStack's size is less than its capacity.
   * <br>POSTCONDITION: the element is now the top element in this
   * LimCapStack, none of the other elements have been changed, and
   * the size is increased by 1.
   * @param e the element to add to the stack
   * @return <tt>true</tt> if the element was added, else <tt>false</tt>.
   * @throws NullPointerException if the specified element is null,
   * and size is less than capacity
   */
  public boolean push(E e);

  /**
   * Removes the element at the top of this LimCapStack.
   * Returns the element removed, or <tt>null</tt> if there was no such element.
   * <br>PRECONDITION: the LimCapStack's size is greater than zero.
   * <br>POSTCONDITION: the top element in this LimCapStack has been removed,
   * none of the other elements have been changed, and
   * the size is decreased by 1.
   * @return  the element removed, or <tt>null</tt> if the size was zero.
   */
  public E pop();

  /**
   * Returns the element at the top of this LimCapStack,
   * or <tt>null</tt> if there was no such element.
   * <br>PRECONDITION: the LimCapStack's size is greater than zero.
   * <br>POSTCONDITION: The LimCapStack is unchanged.
   * @return  the element at the top, or <tt>null</tt> if the size was zero.
   */
  public E peek();

  /**
   * Compares the specified object with this LimCapStack for equality.
   * Returns true if and only if the specified object is
   * also a LimCapStack of the same type, both have the same size, and the
   * corresponding pairs of elements in the two are
   * equal. Two elements e1 and e2 are equal if e1.equals(e2).
   * "Corresponding pairs" means: the pair of top elements,
   * the pair of next-to-top elements, and so on through to
   * the pair of bottom elements.
   * @return true if the specified Object is equal to this LimCapStack
   * @param  o the Object to compare to this LimCapStack for equality
   */
  public boolean equals(Object o);

}
