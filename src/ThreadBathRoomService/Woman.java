package ThreadBathRoomService;

import java.util.Random;

/**
 * A woman.
 * It is a person.
 */
public class Woman extends Person {
	/**
	 * The maximum time in seconds that a man spends idle before entering the bathroom.
	 */
	protected static final int MAXIMUM_IDLE_TIME = 1;
	/**
	 * The maximum time in seconds that a man spends in the bathroom.
	 */
	protected static final int MAXIMUM_BATHROOM_TIME = 2;
	
	/**
	 * Create a woman with a number and a bathroom.
	 * 
	 * @param number	the number
	 * @param bathroom	the bathroom
	 */
	public Woman(int number, Bathroom bathroom) {
		super(number, bathroom);
	}
	
	public void run() {
		/* Spend some idle time before entering the bathroom. */
		try {
			Thread.sleep((new Random()).nextInt(MAXIMUM_IDLE_TIME * 1000));
		} catch (InterruptedException interruptedException) {
			interruptedException.printStackTrace();
		}
		
		/* Enter the bathroom. */
		bathroom.enter(this);
		System.out.print("Woman " + number + " entered the toilet.\n");
		
		/* Spend some time in the bathroom. */
		try {
			Thread.sleep((new Random()).nextInt(MAXIMUM_BATHROOM_TIME * 1000));
		} catch (InterruptedException interruptedException) {
			interruptedException.printStackTrace();
		}
		
		/* Leave the bathroom. */
		System.out.print("Woman " + number + " left the toilet.\n");
		bathroom.leave(this);
	}
}

