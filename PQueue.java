import java.util.ArrayList;

/**
 * Creates a priority of type T by overloading the comparable function to store priorities within T
 * The queue structure uses a max heap of processes to store the objects  
 * @author Dominik Huffield
 * 
 */
public class PQueue {
	
	MaxHeap<Process> maxheap;
	/**
	 * A constructor that takes in no parameters 
	 */
	public PQueue() {
		maxheap = new MaxHeap<Process>();
	}
	/**
	 * A constructor the takes in an array list of processes 
	 * @param objects an array list of processes
	 */
	public PQueue(ArrayList<Process> objects) {
		maxheap.BuildMaxHeap(objects);;
	}
	/**
	 * Adds a process to the rear of the queue
	 * @param p a process
	 */
	public void enPQueue(Process p) {
		maxheap.heapInsertRear(p);
		
	}
	/**
	 * Returns a boolean for whether the queue is empty
	 * @return a boolean
	 */
	public boolean isEmpty() {
		boolean empty = maxheap.isEmpty();
		return empty;
	}
	/**
	 * Removes the front object from the queue
	 * @return a Process
	 */
	public Process dePQueue() {
		maxheap.heapMaxValue().resetTimeNotProcessed();
		Process max = (Process) maxheap.extractMax();
		return max;
	}
	/**
	 * @param timeToIncrementLevel integer value of the 
	 * @param maxLevel integer of the highest level priority
	 */
	public void update(int timeToIncrementLevel, int maxLevel) {
		if (!maxheap.isEmpty()) {	
			for (int i = 0; i < maxheap.getHeapSize(); i++) {
				maxheap.heapObjectAt(i).incrementTimeNotProcessed();
				if (maxheap.heapObjectAt(i).getTimeNotProcessed() >= timeToIncrementLevel) {
					maxheap.heapObjectAt(i).resetTimeNotProcessed();
					if (maxheap.heapObjectAt(i).getPriority() < maxLevel) {
						maxheap.heapObjectAt(i).incrementPriority();
						maxheap.MaxHeapifyUp(i);
					}
				}
			}
		}
	}

}
