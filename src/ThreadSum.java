import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/**
 * A thread runner class, use to test many threads and multi-threads.
 * @author Theeruth Borisuth
 *
 */
public class ThreadSum {
	/**
	 * Run the class
	 * @param args
	 */
	public static void main( String[] args )
	{
		// upper limit of numbers to add/subtract to Counter
		final int LIMIT = 10000000;
		// The counter that accumulates a total.
		Counter counter = new Counter();
		Counter withlock = new CounterWithLock();
		Counter syncCounter = new SynchronousCounter();
		Counter  atomicCounter = new AtomicCounter();
		
		System.out.println("Counter");
		runThreads(5, counter, LIMIT );
		System.out.println("Counter-Withlock");
		runThreads(5, withlock, LIMIT );
		System.out.println("Synchronous-Counter");
		runThreads(5, syncCounter, LIMIT );
		System.out.println("Atomic-Counter");
		runThreads(5, atomicCounter, LIMIT );		
		
	}
	
	/**
	 * A old thread runner class
	 * @param counter
	 * @param limit
	 */
//	public static void runThreads( Counter counter, final int limit )
//	{
//		// two tasks that add and subtract values using same Counter
//		AddTask addtask = new AddTask( counter, limit );
//		SubtractTask subtask = new SubtractTask( counter, limit );
////		// threads to run the tasks
////		Thread thread1 = new Thread( addtask );
////		Thread thread2 = new Thread( subtask );
////		// start the tasks
////		System.out.println("Starting threads");
////		long startTime = System.nanoTime();
////		thread1.start();
////		thread2.start();
////		// wait for threads to finish
////		try {
////			thread1.join();
////			thread2.join();
////		} catch (InterruptedException e) {
////			System.out.println("Threads interrupted");
////		}
////		double elapsed = 1.0E-9*( System.nanoTime() - startTime );
////		System.out.printf("Count 1 to %,d in %.6f sec\n", limit, elapsed);
//		// the sum should be 0. Is it?
//		System.out.printf("Counter total is %d\n\n", counter.get() );
//	}
	
	/**
	 * Multiple thread-runner class
	 * @param nthread
	 * @param counter
	 * @param limit
	 */
	public static void runThreads(int nthread, Counter counter, final int limit )
	{
		ExecutorService executor = Executors.newFixedThreadPool(2 * nthread);
		// start the tasks
		System.out.println("Starting threads");
		long startTime = System.nanoTime();
		for (int k = 1 ; k <= nthread ; k ++ ){
			Runnable addtask =  new AddTask(counter, limit);
			Runnable subtask = new SubtractTask(counter, limit);
			executor.submit(addtask);
			executor.submit(subtask);
		}
		// wait for threads to finish
		try {
				executor.shutdown();
				executor.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			System.out.println("Threads interrupted");
		}
		System.out.println("All down");
		double elapsed = 1.0E-9*( System.nanoTime() - startTime );
		System.out.printf("Count 1 to %,d in %.6f sec\n", limit, elapsed);
		// the sum should be 0. Is it?
		System.out.printf("Counter total is %d\n\n", counter.get() );
	}
}
