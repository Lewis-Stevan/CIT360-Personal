// Author: Steve Lewis

public class Thread2 {

	public static void main(String args[]) throws Exception {

		// NOTE - Multiple threads share the same object when we "implement
		// runnable".
		System.out.println("Running single threads to showcase extends thread and "
				+ "implements runnable\n");

		// Create runnableImplement Object
		RunnableImplement ri = new RunnableImplement("[ImplementsRunnable-1]");

		// Create two threads and run them using runnableImplement
		Thread t1 = new Thread(ri);
		t1.start();
		Thread.sleep(1000);

		// Put the MAIN thread to sleep for one second to allow the t1 thread to
		// finish then run t2
		Thread t2 = new Thread(ri);
		t2.start();
		Thread.sleep(1000);

		// Create threadextension object and start the te1 thread
		ThreadExtension te1 = new ThreadExtension("[ThreadExtension-1]");
		te1.start();
		Thread.sleep(1000);

		// MAIN thread sleep to allow te1 to finish then start te2
		ThreadExtension te2 = new ThreadExtension("[ThreadExtension-2]");
		te2.start();
		Thread.sleep(1000);

		System.out.println("\n[MAIN] - Running two threads at the same time\n");

		// Show case parallel processing
		RunnableImplement ri2 = new RunnableImplement("[ImplementsRunnable-2]");

		Thread t3 = new Thread(ri2);
		t3.start();

		Thread t4 = new Thread(ri2);
		t4.start();
	}
}

// ThreadExtension Class example
class ThreadExtension extends Thread {

	private int count = 1;
	private String threadName;

	// Constructor
	ThreadExtension(String name) {
		threadName = name;
	}

	// Run method()
	public void run() {
		System.out.println("Starting: " + threadName + "running...");
		try {
			for (int i = 0; i < 5; i++) {
				Thread.sleep(50);
				System.out.println("Thread output: " + count);
				count++;
			}
		} catch (InterruptedException e) {
			System.out.println("Thread  " + threadName + " interrupted.");
		}

		// Exiting the thread
		System.out.println("Thread:   " + threadName + " exiting.");
	}
}

// RunnableImplement Class example
class RunnableImplement implements Runnable {

	private int count = 1;
	private String threadName;

	// Constructor
	RunnableImplement(String name) {
		threadName = name;
	}

	// Run method()
	public void run() {
		System.out.println("Starting: " + threadName + "running...");
		try {
			for (int i = 0; i < 5; i++) {
				Thread.sleep(50);
				System.out.println("Thread output: " + count);
				count++;
			}
		} catch (InterruptedException e) {
			System.out.println("Thread  " + threadName + " interrupted.");
		}

		// Exiting the thread
		System.out.println("Thread:   " + threadName + " exiting.");
	}
}