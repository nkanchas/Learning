package SearchSortAlgos;

public class InsertionSort {

	public static void main(String[] args) {
		int[] a ={5,1,6,2,4,3};
		
		int key, j;
		
		for(int i=1;i<a.length;++i){
			j=i-1;
			key = a[i];
			
			while(j>=0 && key < a[j]){
				a[j+1]=a[j];
				j--;
			}
			
			a[++j] = key;
		}
		
		
		for(int m=0; m<a.length; ++m)
			System.out.print(" "+ a[m]);	
		
	}

}
