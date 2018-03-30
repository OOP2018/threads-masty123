
public class ThreadSum {
	public static void main( String[] args )
	{
		// upper limit of numbers to add/subtract to Counter
		final int LIMIT = 10000000;
		// The counter that accumulates a total.
		Counter counter = new Counter();
		Counter counter2 = new CounterWithLock();
		Counter counter3 = new SynchronousCounter();
		Counter counter4 = new AtomicCounter();
		
		System.out.println("Counter");
		runThreads( counter, LIMIT );
		System.out.println("Counter-Withlock");
		runThreads( counter2, LIMIT );
		System.out.println("Synchronous-Counter");
		runThreads( counter3, LIMIT );
		System.out.println("Atomic-Counter");
		runThreads( counter4, LIMIT );
	}
	public static void runThreads( Counter counter, final int limit )
	{
		// two tasks that add and subtract values using same Counter
		AddTask addtask = new AddTask( counter, limit );
		SubtractTask subtask = new SubtractTask( counter, limit );
		// threads to run the tasks
		Thread thread1 = new Thread( addtask );
		Thread thread2 = new Thread( subtask );
		// start the tasks
		System.out.println("Starting threads");
		long startTime = System.nanoTime();
		thread1.start();
		thread2.start();
		// wait for threads to finish
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			System.out.println("Threads interrupted");
		}
		double elapsed = 1.0E-9*( System.nanoTime() - startTime );
		System.out.printf("Count 1 to %,d in %.6f sec\n", limit, elapsed);
		// the sum should be 0. Is it?
		System.out.printf("Counter total is %d\n\n", counter.get() );
	}
}
