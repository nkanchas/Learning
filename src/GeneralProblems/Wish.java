package GeneralProblems;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Wish {

	public static final String T = "T";
	public static final String P = "P";
	 
	  public static void main(String[] args) {
	       Scanner scan = new Scanner(System.in);
	       Set<String> set = new HashSet<String>();
	       System.out.println("Enter no of Rows in an array");
	       int R = scan.nextInt();
	       System.out.println("Enter no of Columns in an array");
	       int C = scan.nextInt();
	       
	       System.out.println("given Rows "+ R + " Given Cloumns "+ C);
	       scan.nextLine();
	       
	       String[][] mat = new String[R][C];
	       for(int i=0; i < R; i++) {
	          for(int j=0; j<C; j++){
	        	  System.out.println("Array["+i+","+j+"]: ");
	        	  mat[i][j] = scan.nextLine();
	          }
	       }
	       
	       System.out.println("Given Input Array ");
	       print2DArray(mat);
	       

		int column = 0;
		
		while (true) {
            int fCount = 0;
			while (column < C) {
				Set<String> mset = new HashSet<String>();				
				int iCount = 1;
				for (int r = 0; r < R; r++) {
					String val = mat[r][column];
					if (val.equalsIgnoreCase("P")) {
						mat[r][column] = T;
					}

					if (val.equalsIgnoreCase("T")) {
						mat[r][column] = P;
					}
					
					val = mat[r][column];
					for(int cj=1;cj<C; cj++){
						val += mat[r][cj];
					}
					
					boolean operation = mset.add(val);
					if(!operation)  ++iCount;
				}

				if(iCount > fCount)
					fCount = iCount;
				
				column++;
			}
			
			System.out.println("maximum wishes will be "+ fCount);
			break;
		}
	   //end    
	      
	       
	       
	  }
	  
	  public static void print2DArray(String[][] arry){
		  for(int i=0; i<arry.length; i++){
			  for(int j=0; j<arry[i].length;j++){
				  System.out.print(arry[i][j]+" ");
			  }
			  
			  System.out.println("\n");
		  }
	  }

	}


/**
 * Part 2: Coding Challenge (10 attempts, excluding Compilation Errors)
It is well known at Palantir that Director of Engineering Khan is a very skilled engineer. 
What is much less well known is that he is also a skilled ninja, wizard, and genie. Khan has used his impressive wizarding power to create a magic box locked with an M by N grid of two wizarding symbols that look suspiciously like the letters "P" and "T", the initials of Khan's favorite company. The box can only be unlocked by a given person once in that person's lifetime.

Khan has infused the box with his genie powers so that it grants the opener a number of wishes equal to the number of rows in which all the symbols in the row are the same. Before opening the box, a person has the opportunity to flip the symbols in any number of the columns (P will become T and T will become P for each symbol in the column) in order to maximize the number of wishes they receive when opening the box.

On your first day at Palantir, Khan uses his ninja stealth to sneak up to your desk unseen and leaves the box and instructions for you. How will you decide which columns to flip in order to maximize the number of wishes granted by Khan's box? Given a description of the box as input, write a program that outputs a single number, which is the maximum number of wishes you can receive from the box. Remember that a human will be reading your code. Not only should your solution be correct and efficient, it should also be clean and easy to read!

Input:

The first line contains 2 integers M and N separated by a space, the number of rows and the number of columns in the box's lock. M lines follow each line containing N characters (not separated by any space) 'P' or 'T'.

 

Output:

A single number representing the maximum number of wishes you can receive.

 

Constraints

1 <= M <= 100000

1 <= N <= 500

 

 

Example
Input

    5 3
    TTP
    PTP
    TPP
    PTP
    TPT
  
Output

    3
  
 

Explaination

Flipping column 2 yields


    TPP
    PPP
    TTP
    PPP
    TTT
  
Giving us 3 wishes. If we try to get the first row to match instead, we have to either flip columns 1 and 2 or only column 3, and this gives only 1 wish.  If we want to get row 3 to match, we'd have to flip either column 1 or columns 2 and 3, again granting only one wish.
 */

