
public class PowerOf {
	
	
	
	    public double pow(double x, int n) {
	        if (n == 0)
	            return 1.0;
	        if (n == 1)
	            return x;
	        boolean isReciprocal = false;
	        if (n < 0)
	        {
	            isReciprocal = true;
	            n = - n;
	        }
	        int k = n / 2;
	        int l = n - 2 * k;
	        double p1 = pow(x, k);
	        double p2 = pow(x, l);
	        return isReciprocal == true ? (1 / (p1 * p1 * p2)) : (p1 * p1 * p2);
	    }
	

	public static void main(String[] args) {
		System.out.println("...power of "+ new PowerOf().pow(2,6));

	}

}
