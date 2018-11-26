/**
 * A class to build a process that implements the comparable 
 * @author Dominik Huffield
 *
 */
public class Process implements Comparable<Process>{

	private int arrivalTime;
	private int priorityLevel;
	private int requiredProcessingTime;

	private int timeNotProcessed;


	/**
	 * A constructor that will take three int values describing the process
	 * 
	 * @param arrivalTime an int for the time the object will take to get to the front of the queue
	 * @param priorityLevel an int for the priority for the object within the queue
	 * @param requiredProcessingTime an int of the time needed to process the object
	 */
	public Process(int arrivalTime, int priorityLevel, int requiredProcessingTime) {
		this.arrivalTime = arrivalTime;
		this.priorityLevel = priorityLevel;
		this.requiredProcessingTime = requiredProcessingTime;

		setTimeNotProcessed(0);	
	}


	/**
	 * Sets time remaining to the given time remaining value
	 * @param newTime  int
	 */
	public void setTimeRemaining(int newTime) {
		this.requiredProcessingTime = newTime;
	}
	/**
	 * Gets the time remaining of the process
	 * @return int
	 */
	public int getTimeRemaining() {
		int remaining = requiredProcessingTime;
		return remaining;
	}


	/**
	 * Gets the priority of the process
	 * @return int
	 */
	public int getPriority() {
		int priority = priorityLevel;
		return priority;
	}
	/**
	 * Increments the priority of the process by one
	 */
	public void incrementPriority() {
		priorityLevel++;
	}

	/**
	 * Decrements the time remaining by one
	 */
	public void reduceTimeRemaining() {
		requiredProcessingTime--;

	}

	/**
	 * Returns a boolean of whether the process is done
	 * @return boolean
	 */
	public boolean finish() {
		boolean finished = (getTimeRemaining() == 0);
		return finished;
	}

	/**
	 * Changes the arrival time of the process to the given time
	 * @param arrival int
	 */
	public void setArrivalTime(int arrival) {
		this.arrivalTime = arrival;
	}
	/**
	 * Returns a value of the time till arrival of the process
	 * @return int
	 */
	public int getArrivalTime() {
		int arrival = arrivalTime;
		return arrival;
	}

	/**
	 * Sets the time not processed of the process to 0
	 */
	public void resetTimeNotProcessed() {
		setTimeNotProcessed(0);

	}
	/**
	 * Gets the time not processed of the process
	 * @return int
	 */
	public int getTimeNotProcessed() {
		return timeNotProcessed;
	}
	/**
	 * Increases the time not processed by one
	 */
	public void incrementTimeNotProcessed() {
		timeNotProcessed++;
	}


	/**
	 * Changes the time not processed to the given int value
	 * @param timeNotProcessed int
	 */
	public void setTimeNotProcessed(int timeNotProcessed) {
		this.timeNotProcessed = timeNotProcessed;
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Process p) {
		if (priorityLevel < p.getPriority()) {
			return -1;
		} else if(priorityLevel > p.getPriority()) {
			return 1;
		} 
		if (arrivalTime <= p.getArrivalTime()) {
			return 1;
		} return -1;
	}

}
