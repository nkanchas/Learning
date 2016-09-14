package GeneralProblems;

import java.util.Random;

public class MergeSort {
	private static int[] numbers;
	private static final int MAX = 50;
	private static final int SIZE=7;
	
	
	public void sort(int[] numbers){
		mergesort(0, numbers.length);
	}
	
	public void mergesort(int start, int end){
		
	}
	
	public static void main(String args[]){
		numbers = new int[SIZE];
		Random rd = new Random();
		for(int i=0;i<numbers.length;++i){
			numbers[i]=rd.nextInt(MAX);
		}
	
	
	}
	
	
	
	

}
