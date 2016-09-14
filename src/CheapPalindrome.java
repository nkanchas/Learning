import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class CheapPalindrome {


	     private static final String A_COST = "aCost";
	     private static final String B_COST = "bCost";
	    
	    public static void main(String args[] ) throws Exception {
	        /*
	         * Read input from stdin and provide input before running

	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        int N = Integer.parseInt(line);
	        for (int i = 0; i < N; i++) {
	            System.out.println("hello world");
	        }
	        */
	        Map<String, Integer> map = new HashMap<String, Integer>();
	       
	        Scanner scan = new Scanner(System.in);
	        int N =  scan.nextInt();
	        for(int i=0; i< N; ++i) {
	          // System.out.println("Enter palindrome string with / character");
	           String gstr =  scan.next();
	       
	          // System.out.println("Enter aCost: ");               
	           int aCost = scan.nextInt();
	           map.put(A_COST, aCost);
	       
	           //System.out.println("Enter bCost: ");           
	           int bCost = scan.nextInt();
	           map.put(B_COST, bCost);
	          
	           StringBuffer sb = new StringBuffer();
	           char[] str = gstr.toCharArray();
	           int tCost = 0;
	           for (i = 0; i < str.length/2; i++){
	                   
	                    if(str[i] != str[str.length-1-i]){
	                         if(str[i] != '/' && str[str.length-i-1] != '/')
	                              break;
	                         else if(str[str.length-i-1] == 'a' || str[i]=='a')
	                              tCost += aCost;
	                         else if(str[str.length-i-1] == 'b' || str[i]=='b')
	                              tCost += bCost;
	                    }
	                    else if(str[i] == '/')
	                         tCost += 2* Math.min(aCost, bCost);
	           }
	           if(i != str.length/2)
	                    sb.append(-1+"\n");
	           else
	                    sb.append(tCost+"\n");
	    
	          
	          
	         
	           System.out.println(tCost);
	        }
	    } //end of main method
	   
	    public void palindromeFilling(String fh, String sh){
	        
	    }
	   
	   
	}
