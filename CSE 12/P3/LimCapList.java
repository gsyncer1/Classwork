/**
 * A LimCapList is a sequential structure with restricted access and
 * limited capacity.
 * <p>
 * Access is available only at the ends of the structure:
 * <tt>addFront(E)</tt>, <tt>E removeFront()</tt>, and <tt>E peekFront()</tt>
 * operate on the front of the list; 
 * <tt>addBack(E)</tt>, <tt>E removeBack()</tt>, and <tt>E peekBack()</tt>
 * operate on the back of the list.
 * <p>
 * (A sequential structure which, like LimCapList, permits access
 * and modification only at the ends is sometimes called a "deque",
 * pronounced "deck", which is short for "double-ended queue.")
 * <p>
 * An implementation of LimCapList must allow duplicate elements,
 * but must not permit <tt>null</tt> elements, since some of the methods
 * use <tt>null</tt> as a signalling return value.
 * <p>
 * In addition to the methods required in the definition of this interface,
 * a class implementing this interface should provide a public constructor
 * with a single argument of type <tt>int</tt>, which specifies the
 * capacity of the LimCapList.  The constructor should throw an
 * IllegalArgumentException if the specified capacity is negative.
 */
public interface LimCapList<E>  {

  /**
   * Returns the capacity of this LimCapList, that is,
   * the maximum number of elements it can hold.  
   * <br>PRECONDITION: none 
   * <br>POSTCONDITION: the LimCapList is unchanged.  
   * @return the capacity of this LimCapList
   */
  public int capacity();

  /**
   * Returns the number of elements in this LimCapList. 
   * <br>PRECONDITION: none 
   * <br>POSTCONDITION: the LimCapList is unchanged. 
   * @return the number of elements in this LimCapList
   */
  public int size();

  /**
   * Adds the specified element to the front of this LimCapList.
   * Returns true if the operation succeeded, else false. 
   * <br>PRECONDITION: the LimCapList's size is less than its capacity. 
   * <br>POSTCONDITION: the element is now the first element in this 
   * LimCapList, none of the other elements have been changed, and
   * the size is increased by 1. 
   * @param e the element to add to the front of the list
   * @return <tt>true</tt> if the element was added, else <tt>false</tt>.
   * @throws NullPointerException if the specified element is null,
   * and size is less than capacity
   */
  public boolean addFront(E e);

  /**
   * Adds the specified element to the back of this LimCapList.
   * Returns true if the operation succeeded, else false. 
   * <br>PRECONDITION: the LimCapList's size is less than its capacity. 
   * <br>POSTCONDITION: the element is now the last element in this 
   * LimCapList, none of the other elements have been changed, and
   * the size is increased by 1. 
   * @param e the element to add to the back of the list
   * @return <tt>true</tt> if the element was added, else <tt>false</tt>.
   * @throws NullPointerException if the specified element is null,
   * and size is less than capacity
   */
  public boolean addBack(E e);

  
  /**
   * Removes the element at the front of this LimCapList.
   * Returns the element removed, or <tt>null</tt> if there was no such element.
   * <br>PRECONDITION: the LimCapList's size is greater than zero.
   * <br>POSTCONDITION: the first element in this LimCapList has been removed,
   * none of the other elements have been changed, and
   * the size is decreased by 1.
   * @return  the element removed, or <tt>null</tt> if the size was zero.
   */
  public E removeFront();

  /**
   * Removes the element at the back of this LimCapList.
   * Returns the element removed, or <tt>null</tt> if there was no such element.
   * <br>PRECONDITION: the LimCapList's size is greater than zero.
   * <br>POSTCONDITION: the last element in this LimCapList has been removed,
   * none of the other elements have been changed, and
   * the size is decreased by 1.
   * @return  the element removed, or <tt>null</tt> if the size was zero.
   */
  public E removeBack();

  /**
   * Returns the element at the front of this LimCapList,
   * or <tt>null</tt> if there was no such element.
   * <br>PRECONDITION: the LimCapList's size is greater than zero.
   * <br>POSTCONDITION: The LimCapList is unchanged.
   * @return  the element at the front, or <tt>null</tt> if the size was zero.
   */
  public E peekFront();

  /**
   * Returns the element at the back of this LimCapList,
   * or <tt>null</tt> if there was no such element.
   * <br>PRECONDITION: the LimCapList's size is greater than zero.
   * <br>POSTCONDITION: The LimCapList is unchanged.
   * @return  the element at the back, or <tt>null</tt> if the size was zero.
   */
  public E peekBack();

  /**
   * Compares the specified object with this LimCapList for equality.
   * Returns true if and only if the specified object is
   * also a LimCapList of the same type, both have the same size, and the
   * corresponding pairs of elements in the two are
   * equal. Two elements e1 and e2 are equal if e1.equals(e2).
   * "Corresponding pairs" means: the pair of front elements,
   * the pair of next-to-front elements, and so on through to
   * the pair of back elements.
   * @return true if the specified Object is equal to this LimCapList
   * @param  o the Object to compare to this LimCapList for equality
   *
   */
  public boolean equals(Object o);

}
