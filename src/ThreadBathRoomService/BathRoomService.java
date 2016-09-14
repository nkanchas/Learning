package ThreadBathRoomService;

import java.util.Random;

/**
 *  An office. An office contains a bathroom and a number of people.
 */
public class BathRoomService {
	/**
	 * The bathroom. 
	 */
	private Bathroom bathroom;
	
	/**
	 * Create an office with a bathroom and a number of employees.
	 * 
	 * @param args	the number of toilets in the bathroom in the first argument, the number of women to be hired in the second argument, and the number of men to be hired in the third argument
	 */
    public static void main(String[] args) {
    	new BathRoomService(
    		3,
    		3,
    		3
    	);
    }
    
    /**
     * Create an office with a bathroom and a number of employees.
     * 
     * @param numberOfToilets			the number of toilets
     * @param numberOfWomenToBeHired	the number of women to be hired
     * @param numberOfMenToBeHired		the number of men to be hired
     */
    public BathRoomService(int numberOfToilets, int numberOfWomenToBeHired, int numberOfMenToBeHired) {
    	/* Create the bathroom. */
    	bathroom = new Bathroom(numberOfToilets);
    	
    	/* Hire the employees. */
    	for (int i = 0, numberOfHiredWomen = 0, numberOfHiredMen = 0; i < numberOfWomenToBeHired + numberOfMenToBeHired; i++) {
        	/* Determine randomly whether the hire a woman or a man. */
    		if ((new Random()).nextBoolean() == true) {
    			/* A woman should be hired, if possible. */
    			/* Check whether there are already enough women in the office. */
        		if (numberOfHiredWomen < numberOfWomenToBeHired) {
        			/* There are not enough women in the office. */
        			/* Hire a woman. */
            		numberOfHiredWomen += 1;
            		(new Woman(i, bathroom)).start();
        		} else {
        			/* There are enough women in the office. */
        			/* Hire a man. */
            		numberOfHiredMen += 1;
            		(new Man(i, bathroom)).start();
        		}
        	} else {
        		/* A man should be hired, if possible. */
        		/* Check whether there are already enough men in the office. */
        		if (numberOfHiredMen < numberOfMenToBeHired) {
        			/* There are not enough men in the office. */
        			/* Hire a man. */
            		numberOfHiredMen += 1;
            		(new Man(i, bathroom)).start();
        		} else {
        			/* There are enough men in the office. */
        			/* Hire a woman. */
            		numberOfHiredWomen += 1;
            		(new Woman(i, bathroom)).start();
        		}
        	}
    	}
    }
}
