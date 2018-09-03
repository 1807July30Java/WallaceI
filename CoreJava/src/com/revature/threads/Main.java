package com.revature.threads;

public class Main {

	public static void main(String[] args) {

		Thread t1 = new MyThread();
		t1.start();

		Thread t2 = new MyThread();
		t2.start();

	}

	/*
	 * Two ways to create a thread: extend Thread or implement Runnable and pass it
	 * to a Thread Threadsafe - one thread at time can access (synchronized keyword,
	 * works for methods, variables, objects, code blocks) Thread states - NEW Has
	 * not started yet RUNNABLE Currently executing BLOCKED Waiting for a lock to be
	 * released WAITING Thread is waiting indefinitely for another thread to perform
	 * a particular action wait() with no timeout, join() with no timeout
	 * TIMED_WAITING Thread is waiting for another thread to perform a particular
	 * action for a specified waiting time sleep(), wait() with timeout, join() with
	 * timeout TERMINATED Thread completed execution, terminated
	 * 
	 */

	/*
	 * Thread methods: 
	 * start() //Calls run() 
	 * getPriority() //Values from 1 (lowest)
	 * through 10 (highest) setPriority() //Values from 1 (lowest) through 10
	 * (highest) isAlive() //Checks whether the thread is running wait() //Specify
	 * the amount of time to wait. It can be notified. sleep() //Will pause for the
	 * specified amount of time. Can't be //notified notify() //Wake up sleeping
	 * threads notifyAll() //notify all sleeping threads join() //Wait for another
	 * thread to stop executing. Catches up //with another thread
	 */

}
