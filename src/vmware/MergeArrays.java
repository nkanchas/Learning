package vmware;

import java.util.Arrays;

/**
 *  Merging 2 sorted arrays
 * @author Naresh
 *
 */
public class MergeArrays {

	public static void main(String[] args) {
		//Test Case1
		/*int[] a ={3,5,6,9,12,14,18,20,25,39};
		int[] b = {30,32,34,36,38,40,42,44,46,48};*/
		
		//Test Case2
		/*int[] a =  {30,32,34,36,38,40,42,44,46,48};
		int[] b = {3,5,6,9,12,14,18,20,25,39};*/
		
		//TestCase3
		int[] a =  {3,5,6,9,12,14,18,20,25,39};
		int[] b = {13,15,26,29,37,38,43,48,53,64};
		
		merge(a, b, b.length);

	}
	
	public static void merge(int[] a, int[] b, int m){
		
		int i = a.length-1;
		int j = b.length-1;
		int[] answer = new int[a.length+b.length];
		int k = answer.length-1;
		
				
		while(i >= 0 && j >=0){
			if(a[i] > b[j])
				answer[k--]=a[i--];
			else
			   answer[k--]=b[j--];
		}
		
		//lefover A Array
		while(i >=0 && j <=0 && k >=0){
		  	
			answer[k--] = a[i--];
		}
		
		//leftover B Array
		while(i<=0 && j>=0 && k>=0){
			answer[k--] = b[j--];
		}
		System.out.println("printing b array");
		
		print(answer);
		
		
	}
	
	public static void print(int[] arry){
		for(int p=0;p<arry.length;++p)
			System.out.print(" "+arry[p]); 
		
		System.out.println("\n");
	}

}
