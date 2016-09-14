package SearchSortAlgos;

public class SelectionSort {

	public static void main(String[] args) {
		int[] a ={5,1,6,2,4,3};
		
		int key=0;
		for(int i=0; i<a.length;++i){
			
			for(int j=i+1; j <a.length;++j)
				if(a[j]< a[i])
					 swap(a,i,j);
		}
		
		for(int n=0;n<a.length;++n)
			System.out.print(" "+ a[n]);

	}
	
	public static void swap(int[] a, int i, int j){
		int temp = a[j];
		a[j]=a[i];
		a[i] = temp;
		
	}

}
