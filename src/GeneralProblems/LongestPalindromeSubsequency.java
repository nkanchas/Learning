package GeneralProblems;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=Mbav2iuJ7xQ
//http://articles.leetcode.com/2011/11/longest-palindromic-substring-part-i.html
//Time complexity will be very higher as it is recursive approach. we end up in comparing same pairs many times
// so use DP. I have another class PalindromeSubsequencyDP.java
public class LongestPalindromeSubsequency {

	public static void main(String[] args) {
		
		List<String> string = new ArrayList<>();
		//BBABCBCAB
		/*string.add("B");
		string.add("B");
		string.add("A");
		string.add("B");
		string.add("C");
		string.add("B");
		string.add("C");
		string.add("A");
		string.add("B");*/
		
		//case2    XAYBZBA
		string.add("X"); string.add("A"); string.add("Y"); string.add("B"); string.add("Z");
		string.add("B");string.add("A");
		
		
		// case3   AA
		//string.add("A");string.add("A");
		
      System.out.println("longest is "+ new LongestPalindromeSubsequency().longestPalindromicSubsequenceNaive(string));
	}
	
	//O(N3) 
	public int longestPalindromicSubsequenceNaive(List<String> arrayList){
	    return longestPalindromicSubsequenceNaive(arrayList, 0,arrayList.size()-1);
	}
	
	/**
	 *  LP(i,j)  = 1                      if(i == j)
	 *  
	 *           = LP(i+1, j-1) +2       if(X[i] = x[j])      (assume X=ABCBA ex: LP(1,5))
	 *           
	 *           max{ LP(i+1, j), 
	 *                  LP(i, j-1)	      if(X[i] != X[j])      (assume X=PAYBZBA)
	 *              }                             
	 * @param arrayList
	 * @param start
	 * @param end
	 * @return
	 */	
	public int longestPalindromicSubsequenceNaive(List<String> arrayList, int start, int end){	
		
		if( end < 0 || start >= arrayList.size() || end < start) return 0;
		
		
	    if (start == end) {
	        return 1;
	    }
	    
	    
	    if (arrayList.get(start).equalsIgnoreCase(arrayList.get(end))) {
	        return 2 + longestPalindromicSubsequenceNaive(arrayList,start+1, end -1);
	    } else {
	        return Math.max(longestPalindromicSubsequenceNaive(arrayList, start+1,end),
	                longestPalindromicSubsequenceNaive(arrayList, start, end-1));
	    }

	}
	
	
	

}
