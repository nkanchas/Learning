package ThreadBathRoomService;

import java.util.concurrent.Semaphore;

/**
 * A bathroom with a number of toilets and a waiting room in front of the bathroom.
 * The bathroom is deadlock free. There is no circular waiting and thus the Coffman conditions cannot be satisfied and consequently deadlocks cannot occur.
 * This bathroom is not starvation free. A consecutive number of persons from one gender can block the other gender.
 */
public class Bathroom {
	/**
	 * The men counter.
	 * It counts the number of men that are either waiting for the bathroom or in the bathroom.
	 */
	private int menCounter;
	/**
	 * A mutex for the exclusive access to the men counter.
	 */
	private Semaphore menCounterMutex;
	/**
	 * The women counter.
	 * It counts the number of women that are either waiting for the bathroom or in the bathroom.
	 */
	private int womenCounter;
	/**
	 * A mutex for the exclusive access to the women counter.
	 */
	private Semaphore womenCounterMutex;
	/**
	 * A mutex for the bathroom.
	 * This mutex can be shared by a number of men or a number of women. It cannot be shared by both men and women.
	 */
	private Semaphore bathroomMutex;
	/**
	 * The men multiplex.
	 * It restricts the number of men in the bathroom.
	 */
	private Semaphore menMultiplex;
	/**
	 * The women multiplex.
	 * It restricts the number of women in the bathroom.
	 */
	private Semaphore womenMultiplex;

	/**
	 * Create a bathroom with the given number of toilets.
	 * 
	 * @param numberOfToilets	the number of toilets
	 */
	public Bathroom(int numberOfToilets) {
		menMultiplex = new Semaphore(numberOfToilets, true);
		
		womenMultiplex = new Semaphore(numberOfToilets, true);
		
		menCounter = 0;
		womenCounter = 0;
		menCounterMutex = new Semaphore(1, true);
		womenCounterMutex = new Semaphore(1, true);
		bathroomMutex = new Semaphore(1, true);
	}

	/**
	 * Let the entering person get into the bathroom.
	 * 
	 * @param enteringPerson	the entering person
	 */
	public void enter(Person enteringPerson) {
		/* Check whether the entering person is a man or a woman. */
		if (enteringPerson instanceof Man) {
			/* The entering person is a man. */
			
			/* Acquire the men counter mutex. */
			try {
				menCounterMutex.acquire();
			} catch (InterruptedException interruptedException) {
				interruptedException.printStackTrace();
			}
			
			/* Increase the men counter. */
			menCounter += 1;
			
			/* Check whether there are other men in the bathroom. */
			if (menCounter == 1) {
				/* There is no other man in the bathroom. From this we can conclude that the bathroom mutex has not been acquired for men. */
				/* Acquire the bathroom mutex on behalf of all men. */
				try {
					bathroomMutex.acquire();
				} catch (InterruptedException interruptedException) {
					interruptedException.printStackTrace();
				}
			}

			/* Release the men counter mutex. */
			menCounterMutex.release();

			/* Acquire the men multiplex to make sure that there are not too many men in the bathroom. */
			try {
				menMultiplex.acquire();
			} catch (InterruptedException interruptedException) {
				interruptedException.printStackTrace();
			}
		} else {
			/* The entering person is a woman. */

			/* Acquire the women counter mutex. */
			try {
				womenCounterMutex.acquire();
			} catch (InterruptedException interruptedException) {
				interruptedException.printStackTrace();
			}
			
			/* Increase the women counter. */
			womenCounter += 1;
			
			/* Check whether there are other women in the bathroom. */
			if (womenCounter == 1) {
				/* There is no other woman in the bathroom. From this we can conclude that the bathroom mutex has not been acquired for women. */
				/* Acquire the bathroom mutex on behalf of all women. */
				try {
					bathroomMutex.acquire();
				} catch (InterruptedException interruptedException) {
					interruptedException.printStackTrace();
				}
			}
			
			/* Release the women counter mutex. */
			womenCounterMutex.release();
			
			/* Acquire the women multiplex to make sure that there are not too many women in the bathroom. */
			try {
				womenMultiplex.acquire();
			} catch (InterruptedException interruptedException) {
				interruptedException.printStackTrace();
			}
		}
	}
	
	/**
	 * Make the person leave the bathroom.
	 * 
	 * @param leavingPerson	the person
	 */
	public void leave(Person leavingPerson) {
		/* Check whether the entering person is a man or a woman. */
		if (leavingPerson instanceof Man) {
			/* The entering person is a man. */
			menMultiplex.release();
			
			/* Acquire the men counter mutex. */
			try {
				menCounterMutex.acquire();
			} catch (InterruptedException interruptedException) {
				interruptedException.printStackTrace();
			}
			
			/* Increase the men counter. */
			menCounter -= 1;
			
			/* Check whether the leaving person was the last men in the bathroom. */
			if (menCounter == 0) {
				/* The leaving person was the last man in the bathroom. From this we can conclude that the bathroom mutex is not used by men anymore. */
				/* Release the bathroom mutex. */
				bathroomMutex.release();
			}
			
			/* Release the men counter mutex. */
			menCounterMutex.release();
		} else {
			/* The entering person is a woman. */
			womenMultiplex.release();
			
			/* Acquire the women counter mutex. */
			try {
				womenCounterMutex.acquire();
			} catch (InterruptedException interruptedException) {
				interruptedException.printStackTrace();
			}
			
			/* Increase the women counter. */
			womenCounter -= 1;
			
			/* Check whether the leaving person was the last women in the bathroom. */
			if (womenCounter == 0) {
				/* The leaving person was the last woman in the bathroom. From this we can conclude that the bathroom mutex is not used by women anymore. */
				bathroomMutex.release();
			}
			
			/* Release the women counter mutex. */
			womenCounterMutex.release();
		}
	}
}

