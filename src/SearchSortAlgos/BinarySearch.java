package SearchSortAlgos;

public class BinarySearch {

	//elements should be in sorted order for binary search
	public static void main(String[] args) {
		int[]a = {1, 2, 3, 4, 5, 7, 17,  19 };
		
		int n = 19;
		System.out.println(" does array contains "+n+" ans:"+contains(a, n));

	}
	
	public static boolean contains(int[] a, int n){
		int low = 0;
		
		int high = a.length-1;
		
		while(low < high){
			int middle = low+high/2;
			
			if(n > a[middle]){
				low = middle+1;				
			}else 	
			if(n  < a[middle]){
				high = middle-1;
			}else{
				return true;
			}			
		}
		
		return false;
	}

}
