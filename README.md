## Threads and Synchronization

This lab illustrates the problem of synchronization when many threads are operating on a shared object.  The general issue is called "thread safety", and it is a major cause of errors in computer software.

## Assignment

To the problems on the lab sheet and record your answers here.

1. Record average run times.
2. Write your explanation of the results.  Use good English and proper grammar.  Also use good Markdown formatting.

## ThreadCount run times

These are the average runtime using 3 or more runs of the application.
The Counter class is the object being shared by the threads.
The threads use the counter to add and subtract values.

| Counter class           | Limit              | Runtime (sec)   |
|:------------------------|:-------------------|-----------------|
| Unsynchronized counter  |  10,000,000        |    0.016599     |
| Using ReentrantLock     |  10,000,000        |    1.067055     |
| Syncronized method      |  10,000,000        |    1.023023     |
| AtomicLong for total    |  10,000,000        |    0.213915     |

## 1. Using unsynchronized counter object

answer the questions (1.1 - 1.3)

1.1 It is not always the same because, resources in the computer are not stable so, the computer might not give the same amount of the previous resources.

1.2  Average time = 0.013719 seconds (limit = 10,000,000).

1.3  Because one of the thread might do task more so, the count might not always be zero.

## 2. Implications for Multi-threaded Applications

How might this affect real applications?  

In Banking situation With multi-thread method, It will help people do more task at the same time like deposit, withdraw and transfer. That is why 
the process can achieve without waiting for another process to start and execute.


## 3. Counter with ReentrantLock

3.1 Yes, it is always zero. Average time is: 1.042252

3.2 Because the thread wait for each other to run so the result will always be the same.

3.3 ReentrantLock is like a light traffic of the threads. It will tell a thread that there is another thread running or not. so, that thread will stay  after another thread is done. The reason that we use ReentrantLock is because to make the thread not interrupt each other.

3.4 Because if an exception gets thrown no code after the try block is executed unless the exception is caught. A finally block is always executed no matter what happen in your try block

## 4. Counter with synchronized method

4.1 Yes, it is. Average time is: 1.0245998

4.2 Same as problem 3 but less efficient. It preventing thread interference and memory consistency error.

4.3 Only one thread can do this task one moment at a time. The reason that we use it is because
	
	

## 5. Counter with AtomicLong

answer question 5

## 6. Analysis of Results

answer question 6

## 7. Using Many Threads (optional)

