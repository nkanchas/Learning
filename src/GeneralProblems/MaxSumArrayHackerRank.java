package GeneralProblems;

import java.util.Scanner;







public class MaxSumArrayHackerRank {
	
	
	
	
	public static int max(int x, int y)
	{ 
		return (y > x)? y : x; 
	}
	 
	public static int findMaxContinousSum2(int a[])
	{
	   int max_so_far = a[0];
	   int maxRunningSum = a[0];
	 
	   for (int i = 1; i < a.length; i++)
	   {
		   maxRunningSum = max(a[i], maxRunningSum+a[i]);
	        max_so_far = max(max_so_far, maxRunningSum);
	   }
	   return max_so_far;
	}
	
	
   
   public static int findMaxNonContinousSum(int[] ary){
       int maxSumSoFar = 0; int maxRunningSum = 0;
       maxRunningSum = ary[0];  maxSumSoFar = ary[0];
       for(int i=1;i<ary.length;++i){            
           //if(ary[i] < 0) continue;
           
           maxRunningSum += ary[i];
           
           if(maxRunningSum < ary[i])    maxRunningSum = ary[i];
           if(maxRunningSum == 0)      maxRunningSum = ary[i];
           
           if(maxRunningSum > maxSumSoFar)   maxSumSoFar = maxRunningSum;
       }
       
       return maxSumSoFar;
   }

   public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       System.out.println("Total no of  Array.");
       int N = scan.nextInt();
       
       //System.out.println("given input  "+ N);
       //read first array
		while (N > 0) {
			System.out.println("Enter Size of 1st array ");
			int sizeArry1 = scan.nextInt();
			System.out.println("Size of 1st array " + sizeArry1);
			int[] arry1 = new int[sizeArry1];
			System.out.println("enter array elements.");
			for (int i = 0; i < sizeArry1; ++i) {
				arry1[i] = scan.nextInt();
			}
			
			//out put for 1st array   
		       
		     //  System.out.print(findMaxNonContinousSum(arry1));
		      // System.out.println(" "+findMaxContinousSum(arry1));
			 System.out.println(" "+findMaxContinousSum2(arry1));
		       
		       --N;
		}
		
		
		
       //read 2nd array
      /* int sizeArry2 = scan.nextInt();
       //System.out.println("Size of 2st array "+ sizeArry2);
       int[] arry2 = new int[sizeArry2];
       for(int i=0;i<sizeArry2;++i){
           arry2[i]= scan.nextInt();
       }  
       //output for 2nd array
        System.out.print(findMaxNonContinousSum(arry2));
       System.out.println(" "+findMaxContinousSum(arry2));*/
       
   }

}
