/**
 * test thread
 * @author Theeruth Borisuth
 *
 */
public class Main {
	public static void main(String[] args) {
		Counter acc = new Counter();
		acc.add(50);
		acc.add(-15);
		System.out.println(acc.get() );// returns 35
		acc.add(-34);
		System.out.println(acc.get() );// return 1
		
		Counter counter = new CounterWithLock();
		counter.add(50);
		counter.add(-15);
		System.out.println(counter.get() );// returns 35
		counter.add(-34);
		System.out.println(counter.get() );// return 1
		
	}
}
