package GeneralProblems;

import java.util.Scanner;

public class UniqueCharAtString {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size of array");
		String N = scan.next();
		
		StringBuilder sb = new StringBuilder();
		System.out.println("count of deleted chars "+new UniqueCharAtString().deleteChar(N.toCharArray(), sb));

	}
	
	public int deleteChar(char[] arry, StringBuilder sb){
		char prevChar=arry[0];
		
		sb.append(prevChar);
		int count=0;
		
		for(int i=1; i<arry.length;i++){
			if(arry[i] != prevChar){
				sb.append(arry[i]);
				prevChar = arry[i];
			}else{
				++count;
			}
		}
		
		return count;
	}

}
