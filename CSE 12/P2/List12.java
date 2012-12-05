/**
 * List12 implements the java List interface to represent a list of objects.
 * Includes an inner class Node that serves as the elements in the list and
 * an Iterator class to return an iterator as defined by the List interface.
 *
 * @author Glenn Briones cs12faq
 */

public class List12<E> implements java.util.List<E>
{
   /**
    * A pointer to a dummy head node, which points to the first node in the
    * list.
    */
   private Node<E> head;
   /**
    * Keeps track of the size of the list
    */
   private int size;

   /**
    * A Node object consists of a pointer to the next node in the list
    * and a variable that stores the data of the object.
    */
   private static class Node<T>
   {
      /**
       * Contains the data in the object.
       */
      private T data;
      /**
       * Points to the next node in the list.
       */
      private Node<T> next;

      /**
       *  Constructs a node with no references to data or another node.
       */
      private Node()
      {
	 this.data = null;
	 this.next = null;
      }

      /**
       * Creates a node containing the data with no pointer to the next
       * node.
       *
       * @param data the data to be stored in the node
       */
      private Node(T data)
      {
	 this.data = data;
	 this.next = null;
      }

      /**
       * Creates a node containing the data with a pointer to the specified
       * node.
       */
      private Node(T data, Node<T> next)
      {
	 this.data = data;
	 this.next = next;
      }
   }

   /**
    * Iterator implements the java Iterator interface to return an iterator
    * through the elements of a List12 object.
    */
   private class Iterator implements java.util.Iterator<E>
   {
      /**
       * Points to the next node to be visited.
       */
      private Node<E> nextNode;
      /**
       * Points to the last visited node.
       */
      private Node<E> lastReturned;
      /**
       * Points to the predecessor of the last returned Node.
       * Used when removing a node with the iterator.
       */
      private Node<E> pred;

      /**
       * Constructs an iterator object to iterate through the lists's elements.
       */
      public Iterator() 
      { 
	 nextNode = head.next;
	 lastReturned = head;
	 pred = null;
      }

      /**
       * Returns true if there is a next node that can be visited by the 
       * iterator.
       *
       * @return <code>true</code> if there is a next node
       */
      public boolean hasNext() { return nextNode != null; }

      /**
       * Returns the next object in the list.
       *
       * @return the data of the next node in the list
       * @throws NoSuchElementException if <code>next()</code> was called
       * before <code>hasNext()</code> has been called
       */
      public E next()
      {
	 if (nextNode == null) throw new java.util.NoSuchElementException();

	 //If node was previously removed, don't move pred to next node.
	 if(lastReturned != null) 
	    pred = lastReturned;
	 lastReturned = nextNode;
	 nextNode = nextNode.next;

	 return lastReturned.data;
      }

      /**
       * Removes the node last visited by <code>next()</code> from the list.
       *
       * @throws IllegalStateException if <code>remove()</code> is called
       * before <code>next()</code> is called
       */
      public void remove()
      {
	 if(lastReturned == null) throw new IllegalStateException();

	 /* splice around lastReturned */
	 pred.next = nextNode;
	 size--;

	 lastReturned = null;
      }
   }

   /**
    * Constructs a new list by creating a dummy head node to point to the
    * first node in the list and initializes the size to 0.
    */
   public List12()
   {
      head = new Node<E>();
      size = 0;
   }


   /**
    * Adds an object to the end of this list.
    * 
    * @param o 	the object to the added to the end of the list
    * @return true if an object was added to the list
    */
   public boolean add(E o)
   {
      //Create new Node
      Node<E> newNode = new Node<E>(o);

      //Find the last node.
      Node<E> cursor = head;
      while(cursor.next != null) cursor = cursor.next;

      //Point the last node's next pointer to the new node. Increment size.
      newNode.next = cursor.next;
      cursor.next = newNode;
      size++;
      return true;
   }



   /**
    * Adds an object to this list at the specified index.
    *
    * @param index      the index at which the object is to be added in the list
    * @param element    the object to be added to the list
    */
   public void add(int index, E element)
   {
      //Check index >= 0 && index <= size
      if(index < 0 || index > size) throw new IndexOutOfBoundsException();

      Node<E> cursor = head;
      //List is empty if head.next is null. Add to empty list if so.
      while(index-- > 0) cursor = cursor.next;

      //Create new node
      Node<E> newNode = new Node<E>(element);

      //Set the newNode's next to be the cursor's next
      newNode.next = cursor.next;

      //Set the cursor's next to the new node
      cursor.next = newNode;

      //Increment size
      size++;
   }

   /**
    * Removes all of the elements from this list.
    */
   public void clear()
   {
      head.next = null; //Removes reference to all other elements in list
      size = 0; //Sets the size of the now cleared list to 0.
   }

   /**
    * Returns <tt>true</tt> if this list contains the specified element.
    *
    * @param o the object to search for in the list
    * @return <code>true</code> if the list contains the object
    */
   public boolean contains(Object o)
   {
      //Create cursor node.
      Node<E> cursor = new Node<E>();

      //Point cursor to the beginning of the list.
      cursor = head.next;

      //Traverse though list to find the object.
      while(cursor != null)
      {
	 if(cursor.data.equals(o)) return true;
	 cursor = cursor.next;
      }

      //At this point, exited from while loop, object not found
      return false;
   }

   /**
    * Compares the specified object with this list for equality.
    *
    * @param o	the object to be compared to this List12 object.
    * @return <tt>true</tt> if the specified object is equal to this list
    */
   public boolean equals(Object o) throws RuntimeException
   {
      if(!(o instanceof List12))
	 return false;

      List12<E> testList = (List12<E>) o;

      if(testList.size() != this.size())
	 return false;

      java.util.Iterator<E> thisIter = this.iterator();
      java.util.Iterator<E> objIter = testList.iterator();

      while(thisIter.hasNext() && objIter.hasNext())
      {
	 if( !(thisIter.next().equals(objIter.next())) )
	    return false;
      }

      //At this point, all corresponding elements are equal.
      return true;
   }

   /**
    * Returns the element at the specified position in this list.
    *
    * @param index	index of the element to return
    * @return the element at the specified position in this list
    * @throws IndexOutOfBoundsException	if the index is out of range
    */
   public E get(int index)
   {
      if(index < 0 || index >= size) throw new IndexOutOfBoundsException();

      Node<E> cursor = new Node<E>();
      cursor = head.next;
      while(index-- > 0) cursor = cursor.next;

      return cursor.data;
   }

   /**
    * Returns the hash code value of this List12 object.
    *
    * @return the hash code value for this list
    */
   public int hashCode()
   {
      int hashCode = 1;
      java.util.Iterator<E> iter = this.iterator();
      while(iter.hasNext())
      {
	 E obj = iter.next();
	 hashCode = 31*hashCode + (obj==null ? 0 : obj.hashCode());
      }

      return hashCode;
   }

   /**
    * Returns the index of the first occurrence of the specified element in
    * this list, or -1 if this list does not contain the element.
    *
    * @param o the element to search for in the list
    * @return the index of the first occurrence of the specified object
    */
   public int indexOf(Object o)
   {
      int index = -1; //the index to be returned
      int atIndex = 0; //the variable to keep track of what index we're at
      java.util.Iterator<E> iter = this.iterator();

      while(iter.hasNext())
      {
	 if( o.equals(iter.next()) )
	 {
	    index = atIndex;
	    break;
	 }
	 atIndex++;
      }

      return index;
   }

   /**
    * Returns true if this list is empty.
    *
    * @return true if the list is empty (size is 0)
    */
   public boolean isEmpty()
   {
      return size==0 ? true : false;
   }

   /**
    * Returns an iterator for this list.
    *
    * @return an <code>Iterator</code> object for this list
    */
   public java.util.Iterator<E> iterator()
   {
      return new Iterator();
   }

   /**
    * Removes the first occurrence of the specified element from this list,
    * if it is present. If this list does not contain the element, it is
    * unchanged.
    *
    * @param o	element to be removed from this list, if present
    * @return <tt>true</tt> if this list contained the specified element
    */
   public boolean remove(Object o)
   {
      boolean removed = false; //indicates if object was removed
      Node<E> cursor = new Node<E>();
      Node<E> target = new Node<E>();

      cursor = head;
      while(cursor.next != null && !removed)
      {
	 if(cursor.next.data.equals(o))
	 {
	    target = cursor.next;
	    cursor.next = target.next;
	    removed = true;
	    size--;
	    break;
	 }
	 cursor = cursor.next;
      }

      return removed;
   }

   /**
    * Replaces the element at the specified index with the specified element.
    *
    * @param index the index at which the element is to be put
    * @param element the element to put into the list
    * @return the element that was replaced
    */
   public E set(int index, E element)
   {
      //Pointer to the element that was replaced
      Node<E> replaced = new Node<E>();

      //Check index >= 0 && index < size
      if(index < 0 || index >= size) throw new IndexOutOfBoundsException();

      //Advance cursor to point to node just before insertion point
      Node<E> cursor = head;
      while(index-- > 0) cursor = cursor.next;

      //Create new node
      Node<E> newNode = new Node<E>(element);

      //Get the object to be removed
      replaced = cursor.next;

      //Set the newNode's next to point to the replaced node's next
      newNode.next = replaced.next;

      //Set cursor's next to point to the new node.
      cursor.next = newNode;

      //Return the replaced node
      return replaced.data;
   }

   /**
    * Returns the size of the list.
    *
    * @return the size of the <code>List12</code> object
    */
   public int size()
   {
      return size;
   }



   /* The following methods are unsupported */

   public boolean addAll(java.util.Collection<? extends E> c)
   {
      throw new UnsupportedOperationException();
   }

   public boolean addAll(int index, java.util.Collection<? extends E> c)
   {
      throw new UnsupportedOperationException();
   }

   public boolean containsAll(java.util.Collection<?> c)
   {
      throw new UnsupportedOperationException();
   }

   public int lastIndexOf(Object o)
   {
      throw new UnsupportedOperationException();
   }

   public java.util.ListIterator<E> listIterator()
   {
      throw new UnsupportedOperationException();
   }

   public java.util.ListIterator<E> listIterator(int index)
   {
      throw new UnsupportedOperationException();
   }

   public E remove(int index)
   {
      throw new UnsupportedOperationException();
   }

   public boolean removeAll(java.util.Collection<?> c)
   {
      throw new UnsupportedOperationException();
   }

   public boolean retainAll(java.util.Collection<?> c)
   {
      throw new UnsupportedOperationException();
   }

   public java.util.List<E> subList(int fromIndex, int toIndex)
   {
      throw new UnsupportedOperationException();
   }

   public Object[] toArray()
   {
      throw new UnsupportedOperationException();
   }

   public <T> T[] toArray(T[] a)
   {
      throw new UnsupportedOperationException();
   }
}
