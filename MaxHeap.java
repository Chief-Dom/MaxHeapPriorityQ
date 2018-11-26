import java.util.ArrayList;

/**
 * A class that takes in a list and builds a heap data structure 
 * @author Dominik Huffield
 *
 * @param <T> A 
 */
public class MaxHeap <T> {

	private int heapSize;
	private ArrayList<Process> heap;
	
	
	/**
	 * A constructor for the class that takes no parameters 
	 */
	public MaxHeap() {
		heap = new ArrayList<Process>();
		heapSize = 0;
		BuildMaxHeap(heap);
	}

	/**
	 * A constructor that takes in an array list of processes
	 * @param objects
	 */
	public MaxHeap(ArrayList<Process> objects) {
		heap = new ArrayList<Process>();
		this.heap = objects;
		heapSize = objects.size();
		BuildMaxHeap(heap);
	}
	/**
	 * A recursive function the sort an object downward in the form of a heap
	 * @param i the index being sorted
	 */
	public void MaxHeapifyDown(int i) {
		int l = Left(i);
		int r = Right(i);
		int largest;
		if( l < heapSize && heap.get(i).compareTo(heap.get(l)) < 0 ) {
			largest = l;
		} else {
			largest = i;
		}
		if(r < heapSize &&  heap.get(largest).compareTo(heap.get(r)) < 0 ) {
			largest = r;
		}
		if (largest != i) {
			exchange(i, largest);
			MaxHeapifyDown(largest);
		}
	}
	/**
	 * A recursive function that sorts an object upward in the form of a heap
	 * @param i the index being sorted
	 */
	public void MaxHeapifyUp(int i) {
		int p = Parent(i);
		if (i != 0 && heap.get(i).compareTo(heap.get(p)) > 0) {
			exchange(i, p);
			MaxHeapifyUp(p);
		}
	}
	/**
	 * A getter method to return the object at an index
	 * @param n the index of an object
	 * @return A process object at the indexed value
	 */
	public Process heapObjectAt(int n) {
		if (n < 0 || n >= heapSize) {
			return null;
		}
		Process value = heap.get(n);
		return value;
	}
	/**
	 * Takes an array list and builds a max heap using the heap insert method  
	 * 
	 * @param objects an array list comprised of processes 
	 */
	public void BuildMaxHeap(ArrayList<Process> objects) {
		heapSize = objects.size();
		for (int i = 0; i < objects.size(); i++) {
			heapInsert(objects.get(i), i);
		}
	}
	/**
	 * Inserts a process at the end of the heap and increases the size
	 * @param object the process being added
	 */
	public void heapInsertRear(Process object) {
		heap.add(object);
		MaxHeapifyUp(heapSize);
		heapSize++;
	}
	/**
	 * Inserts a function at a specific index
	 * 
	 * @param object a process to be inserted
	 * @param index the index in which the object is being inserted 
	 */
	public void heapInsert(Process object, int index) {
		heap.add(index, object);
		if (index == heapSize) {
			heapSize++;
		}
	}
	/** 
	 * Returns the size of the heap
	 * @return an integer value of the heap size
	 */
	public int getHeapSize() {
		return heapSize;
		
	}
	/**
	 * Exchanges the processes at the two given indexes 
	 * @param i int
	 * @param j int
	 */
	private void exchange(int i, int j) {
		Process tempNode = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, tempNode);
	}
	/**
	 * returns a boolean of whether the heap has objects
	 * @return boolean
	 */
	public boolean isEmpty() {
		boolean empty = heapSize < 1;
		return empty;
	}
	/**
	 * Returns the process the is at the top of the heap
	 * @return Process
	 */
	public Process heapMaxValue() {
		if (heap.isEmpty()) {
			return null;
		}
		Process max = heap.get(0);
		return max;
	}
	/**
	 * Returns the Process at the top of the heap and removes it from the structure
	 * @return Process
	 */
	public Process extractMax() {
		if (heap.isEmpty()) {
			throw new IndexOutOfBoundsException("heap underflow");
		}
		Process max = heap.get(0);
		exchange(0, heapSize-1);
		heap.remove(heapSize-1);
		heapSize--;
		MaxHeapifyDown(0);
		return max;
	}
	/**
	 * Finds the parent index of the given index
	 * @param i current index
	 * @return Parent index
	 */
	private int Parent(int i) {
		return (i-1)/2;
	}
	
	/**
	 * Find the left leaf index of the given index
	 * @param i current index
	 * @return left leaf index
	 */
	private int Left(int i) {
		return (2*i+1);
	}
	
	/**
	 * Finds the right leaf index of the given index
	 * @param i current index
	 * @return right leaf index
	 */
	private int Right(int i) {
		return (2*i+2);
	}
}
