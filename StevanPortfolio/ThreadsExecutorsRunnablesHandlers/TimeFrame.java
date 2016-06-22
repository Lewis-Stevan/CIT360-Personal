import java.util.ArrayList;

interface TimeMonitor {
	int getTime();
	}

class CountDownClock extends Thread implements TimeMonitor {
	private int t;

	public CountDownClock(int start) {
		this.t = start;
		}

	public void run() {
		for (; t >= 0; t--) {
			System.out.println(" In T minus " + t);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	public int getTime() {
		return t;
	}
}

class LaunchEvent implements Runnable {
	private int start;
	private String message;
	TimeMonitor tm;

	public LaunchEvent(int start, String message, TimeMonitor monitor) {
		this.start = start;
		this.message = message;
		this.tm = monitor;
	}

	public void run() {
		boolean eventDone = false;
		while (!eventDone) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
			if (tm.getTime() <= start) {
				System.out.println(this.message);
				eventDone = true;
			}
		}
	}
}

public class TimeFrame {
	public static void main(String[] args) {
		// Constructor for the time frame for launch with a start of 20 seconds
		CountDownClock clock = new CountDownClock(20);
		// Array list is used to store the launch sequence event												
		ArrayList<Runnable> events = new ArrayList<Runnable>();
		// At certain event times lines are presented during run													
		events.add(new LaunchEvent(16, "Clear the Pad, and docking doors.", clock));															
		events.add(new LaunchEvent(6, "Begin ignition sequence.", clock));
		events.add(new LaunchEvent(0, "Launch!", clock));

		// The clock is started
		clock.start();

		for (Runnable e : events)
			// A loop starts the thread to run the launch event
			new Thread(e).start();
	}

}