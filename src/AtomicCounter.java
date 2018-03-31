import java.util.concurrent.atomic.AtomicLong;
/**
 * Count numbers by using AtomicLong 
 * @author Theeruth Borisuth
 *
 */
public class AtomicCounter extends Counter {
	private AtomicLong total;
	public AtomicCounter() {
		total = new AtomicLong();
	}
	/** add amount to the total. */
	public void add(int amount) {
		total.getAndAdd(amount);
	}
	
	/** subtract amount to the total. */
	public void subtract(int amount) {
		total.getAndAdd(-amount);

	}
	/** return the total as a long value. */
	public long get() {
		return total.longValue();
	}
}