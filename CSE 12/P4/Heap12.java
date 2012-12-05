/**
 * A class that uses a heap-structured array to implement the
 * PQueue interface.
 * @author Glenn Briones cs12faq
 */
public class Heap12<E extends Comparable<? super E>> implements PQueue<E> {
	
	//Fields
	private int size;
	private E[] heap;
	
	//Constructors
	/**
	 * Initialize a Heap12 object.
	 * Initially, a Heap12 object contains no elements.
	 */
	public Heap12() {
		size = 0;
		heap = (E[]) new Comparable[5];
	}
	
	/**
	 * Initialize a Heap12 object as a deep copy of an existing
	 * Heap12 object.
	 * @param existing the existing Heap12
	 */
	public Heap12(Heap12<E> existing) {
		size = existing.size;
		heap = (E[]) new Comparable[existing.heap.length];
		for(int i=0; i<existing.heap.length; i++) {
			heap[i] = existing.heap[i];
		}
	}
	
	/**
	 * Initializes a Heap12 object by setting the heap to the specified
	 * array. Mainly used for the sort method.
	 * @param array
	 */
	private Heap12(E[] array) {
		size = array.length;
		heap = array;
	}

	//Methods
	/**
	 * Adds the specified element to this Heap12
	 * @param e the element to add
	 * @throws java.lang.NullPointerException if the specified element is 
	 * null
	 */
	public void add(E e) {
		if(e==null) throw new java.lang.NullPointerException();
		if(size==this.heap.length) {
			//array is full, create a new backing array with 
			//double the size
			E[] newHeap = (E[]) new Comparable[this.heap.length*2];
			System.arraycopy(this.heap, 0, newHeap, 0, 
				this.heap.length);
			this.heap = newHeap;
		}
		this.heap[size] = e;
		this.bubbleUp(size);
		size++;
	}

	/**
	 * Removes and returns the highest priority element in this Heap12.
	 * If more than one element has the same highest priority, one of them
	 * is removed and returned.
	 * @return the highest priority element in this Heap12, or null if none.
	 */
	public E remove() {
		if(this.isEmpty()) return null;
		E oldTop = heap[0];
		heap[0] = heap[size-1];
		heap[size-1] = null;
		size--;
		this.trickleDown(0);
		return oldTop;
	}

	/**
	 * Returns the element in this Heap12 that would be returned
	 * by <tt>remove()</tt>.
	 * @return the highest priority element in this Heap12
	 */
	public E peek() {
		return heap[0];
	}

	/**
	 * Returns the number of elements in this Heap12.
	 * @return the number of elements in this Heap12
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Determines if this Heap12 contains any elements.
	 * @return <tt>true</tt> if this PQueue ie empty, <tt>false</tt> 
	 * otherwise
	 */
	public boolean isEmpty() {
		return size==0;
	}
	
	/**
	 * Compares the specified object with this Heap12 for equality. Returns
	 * <tt>true</tt> if and only if the specified object is also a Heap12,
	 * both Heap12's have the same size, and corresponding pairs of elements
	 * in the backing heaps of the two are equal.
	 * @param o the object to be compared for equality with this Heap12
	 * @return <tt>true</tt> if the specified object is equal to this Heap12
	 */
	public boolean equals(Object o) {
		if(!(o instanceof Heap12)) return false;
		Heap12<E> testHeap = (Heap12<E>) o;
		if(testHeap.size() != this.size()) return false;
		for(int i=0; i<this.size(); i++) {
			if(!this.heap[i].equals(testHeap.heap[i]))
				return false;
		}
		return true;
	}
	
	/**
	 * Sorts an array of <tt>Comparable<? super T></tt> objects into
	 * nondecreasing order according to the natural ordering of its elements.
	 * This method uses the heapsort algorithm to sort its argument array
	 * 'in place', without allocating a new array.
	 * @param <T> the type of the array to be sorted
	 * @param a the array to sort
	 */
	public static <T extends Comparable<? super T>> void sort(T[] a) {
		//Build the heap in place
		Heap12<T> heapForSorting = new Heap12<T>(a);
		for(int i=0; i<a.length; i++) {
			heapForSorting.bubbleUp(i);
		}
		//Remove from heap in place
		for(int j = a.length-1; j>=0; j--) {
			T temp = a[0];
			a[0] = a[j];
			a[j] = temp;
			heapForSorting.size--;
			heapForSorting.trickleDown(0);
		}
	}
	
	/**
	 * Trickles down the element at the specified index of the heap's
	 * backing store until it reaches a leaf or the element is greater
	 * than its children. This maintains that the heap is a max heap.
	 * @param index the index of the element to trickle down
	 */
	private void trickleDown(int index) {
		int i=index;
		while((2*i+1<size) && (heap[i].compareTo(heap[2*i+1])<0) ||
			(2*i+2<size) && (heap[i].compareTo(heap[2*i+2])<0)) {
		//Swap with left child if no right child or left child is
		//greater than or equal to right child
		if((2*i+2 >= size) || 
		    (heap[2*i+1].compareTo(heap[2*i+2]) >= 0)) {
				E temp = heap[i];
				heap[i] = heap[2*i+1];
				heap[2*i+1] = temp;
				i = 2*i+1;
			//Swap with right child otherwise	
			} else {
				E temp = heap[i];
				heap[i] = heap[2*i+2];
				heap[2*i+2] = temp;
				i = 2*i+2;
			}
		}
	}
	
	/**
	 * Bubbles up the element at the specified index of the heap's backing
	 * store until it reaches the root or the element is less than or equal
	 * to its parent. This maintains that the heap is a max heap.
	 * @param index the index of the element to be bubbled up
	 */
	private void bubbleUp(int index) {
		int i=index;
		//Bubble up the element until root is reached or element is
		//less than or equal to its parent
		while( (i!=0) && (heap[i].compareTo(heap[(i-1)/2]) > 0) ) {
			E temp = heap[i];
			heap[i] = heap[(i-1)/2];
			heap[(i-1)/2] = temp;
			i = (i-1)/2;
		}
	}

}
