package GeneralProblems;

public class MaxDiffBtwTwoElements {

	public static void main(String[] args) {
		int[] arry = {2, 3, 10, 6, 4, 8, 1};
		
		int max_diff = arry[1]-arry[0];
		int min_elem = arry[0];
		
		for(int i=1; i< arry.length;++i){
			if((arry[i]-min_elem) > max_diff){
				max_diff = arry[i]-min_elem;
			}
			
			if(arry[i] < min_elem){
				min_elem = arry[i];
			}
		}
		
		System.out.println(" "+ max_diff);

	}

}
