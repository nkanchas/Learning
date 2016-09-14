package GeneralProblems;
//http://www.geeksforgeeks.org/to-find-smallest-and-second-smallest-element-in-an-array/
public class FindSecondSmallest {

	public static void main(String[] args) {
		int arr[] = {2, 4, 5, 3, 1, 8, 7, 10};
		new FindSecondSmallest().printSecondSmallest(arr);

	}
	
	//1+2(n-2)=  2n-3  comparisons  ...how to do efficiently with less comparisons
	//use Tournament Algorithm
	public void printSecondSmallest(int[] ar){
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;
		
		for(int i =0; i< ar.length; i++){
			
			if(ar[i] < first){
				second = first;
				first = ar[i];
			}else if(ar[i] < second && ar[i] != first){
				second = ar[i];
			}
			
		}
		
		System.out.println("Smallest Element: "+ first);
		System.out.println("Smallest(2nd) Element: "+ second);
	}

}
