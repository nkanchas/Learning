
public class SquareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     System.out.println("...."+squareRoot(16));
	}
	
	
	public static int squareRoot(int x){
		int low=0;
		int high=16;
		
		while(low < high){
			int mid = low+high/2;
			if(mid * mid == x)
				return mid;
			else if(mid * mid < x)
				low = mid-1;
			else if(mid * mid > x)
				high = mid-1;
		}
		
		return high;
	}

}
