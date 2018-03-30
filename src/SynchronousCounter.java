
public class SynchronousCounter extends Counter {
	@Override
	public synchronized void add(int amount) {
		super.add(amount);
	}
	
	@Override
	public synchronized void subtract(int amount) {
		super.subtract(amount);
	}
}
