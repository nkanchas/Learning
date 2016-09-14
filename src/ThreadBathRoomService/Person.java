package ThreadBathRoomService;

/**
 * A person that is identified with a number. A person knows where a bathroom is.
 */
public abstract class Person extends Thread {
	/**
	 * The bathroom.
	 */
	protected Bathroom bathroom;
	/**
	 * The number.
	 */
	protected int number;
	
	/**
	 * Create a person with a number and a bathroom.
	 * 
	 * @param number	the number
	 * @param bathroom	the bathroom
	 */
	public Person(int number, Bathroom bathroom) {
		this.number = number;
		this.bathroom = bathroom;
	}
}
