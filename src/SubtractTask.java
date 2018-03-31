
/**
 * SubtrackTask adds number 1 ... limit to the counter, then exits.
 * @author Theeruth Boris
 */
public class SubtractTask implements Runnable{
	private Counter counter;
	private int limit;
	public SubtractTask(Counter counter, int limit) {
		this. counter = counter;
		this.limit = limit;
	}
	
	@Override
	public void run() {
		for(int k = 0 ; k <= limit; k++) counter.subtract( k );
		// If you want to see when a thread finishes, add this line:
		//System.out.println("Done "+Thread.currentThread().getName());
	}
}
