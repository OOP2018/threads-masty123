import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * Count numbers with lock
 * @author Theeruth Borisuth
 *
 */
public class CounterWithLock extends Counter {
	/**lock variable**/
	private Lock lock = new ReentrantLock();
	
	/**
	 * add amount with lock
	 * @param amount
	 */
	@Override
	public void add(int amount){
		try {
			lock.lock();
			super.add(amount);
		} finally {
			lock.unlock();
		}
	}
	
	/**
	 * subtract amount with lock
	 * @param amount
	 */
	@Override
	public void subtract(int amount){
		try {
			lock.lock();
			super.subtract(amount);
		} finally {
			lock.unlock();
		}
	}
	
	
	
}
