package SearchSortAlgos;

public class BubbleSort {

	static int[] arry = {5, 1, 12, -5, 16};
	static boolean swapped = true;
	static int i=0;
	
	public static void main(String[] args) {
		

		while(swapped){
			swapped = false;
			i++;
			for(int j=0;  j<(arry.length-i); ++j){
				if(arry[j] > arry[j+1])  {swap( j, j+1);swapped = true;}
			}
		}
		
		for(int f=0;f<arry.length;f++){
			System.out.print(" "+arry[f]);
			
		}
		
	}
	
	public static void swap(int a, int b){
		int temp = arry[a];
		arry[a]= arry[b];
		arry[b]= temp; 
	}

}
