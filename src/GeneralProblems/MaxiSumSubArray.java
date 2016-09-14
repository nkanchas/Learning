package GeneralProblems;

import java.util.Scanner;

public class MaxiSumSubArray {

	public static void main(String[] args) {
		MaxiSumSubArray max = new MaxiSumSubArray();
		Scanner scan = new Scanner(System.in);
		System.out.println("Kadane Algorithm Test");
		
	   System.out.println("Enter the size of array");
       int N =  scan.nextInt();
       int[] arry = new int[N];
       
       System.out.println("Enter "+N +" elements of the Array");
       for(int i=0;i<N;++i){    	   
    	   arry[i]= scan.nextInt();
       }
       
       int sum = max.findMaxSum(arry);
       
       System.out.println("Max sum is "+ sum);
       
	}
	
	public int findMaxSum(int[] ary){
		int maxSumSoFar = ary[0]; int maxRunningSum = ary[0];
		
		for(int i=1; i<ary.length;++i){
			
			maxRunningSum += ary[i];
			
			if(maxRunningSum < ary[i])
				maxRunningSum = ary[i];
			
			if(maxRunningSum == 0){
				maxRunningSum = ary[i];
			}
			
			if(maxRunningSum > maxSumSoFar)
				maxSumSoFar = maxRunningSum;
		}
		
		return maxSumSoFar;
		
	}

}
