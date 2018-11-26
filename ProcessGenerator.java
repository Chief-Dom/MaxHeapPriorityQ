import java.util.Random;

/**
 * A class that generates processes 
 * @author Dominik Huffield
 *
 */
public class ProcessGenerator {
	private double probability;
	Random random;
	
	/**
	 * A constructor that takes in a probability 
	 * @param probability double
	 */
	public ProcessGenerator(double probability) {
		this.probability = probability;
		random = new Random();
	}

	/**
	 * Compares the probability of the object to a randomly genrated probability  
	 * @return boolean
	 */
	public boolean query() {
		double randomProbability = random.nextDouble();
		boolean query = randomProbability < probability;
		return query;
	}
	
	/**
	 * Takes values for a process and randomly generates a priority and a processing time and builds a new process
	 * @param currentTime int
	 * @param maxProcessTime int
	 * @param maxLevel int
	 * @return Process
	 */
	public Process getNewProcess(int currentTime, int maxProcessTime, int maxLevel) {
		int priority = random.nextInt(maxLevel) +1;
		int requiredProcessingTime = random.nextInt(maxProcessTime)+1;
		Process newProcess = new Process(currentTime, priority, requiredProcessingTime);
		return newProcess;
	}
}
