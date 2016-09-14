import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



	/**
	 * 
	 * @author Naresh
	 *
	 */
//http://www.geeksforgeeks.org/find-possible-words-phone-digits/
public class PhoneDialerStringCombinations {
	    
	    
	    private static final Map<Integer, String[]> map = new HashMap<Integer, String[]>();
	    
	    
	    
	    static{    	
	    	
	    	map.put(0,  new String[]{"0"});
	    	map.put(1,  new String[]{"1"});
	    	map.put(2,  new String[]{ "A", "B", "C" });
	    	map.put(3,  new String[]{ "D", "E", "F" });
	    	map.put(4,  new String[]{ "G", "H", "I" });
	    	map.put(5,  new String[] { "J", "K", "L" });
	    	map.put(6,  new String[]{ "M", "N", "O" });
	    	map.put(7,  new String[]{ "P", "Q", "R", "S" });
	    	map.put(8,  new String[]{ "T", "U", "V" });
	    	map.put(9,  new String[]{ "X", "Y", "Z", "W" });
	    	
	    	
	    }
	    private PhoneDialerStringCombinations() {
	       
	    }
	 
	    public static List<String> getAllCombinations(String number) {
	        if (number.startsWith("0") || number.startsWith("1")) {
	            return new ArrayList<String>();
	        }
	 
	        List<String> list = new ArrayList<String>();
	 
	        int[] arr = new int[number.length()];
	        for (int j = 0; j < arr.length; j++) {
	            arr[j] = Integer.parseInt(String.valueOf(number.charAt(j)));
	        }
	        permutations("", arr, 0, list);
	        return list;
	    }
	 
	    //recursion (backtracking)
	    public static void permutations(String root, int[] number, int current,
	            List<String> list) {  
	    	
	    	for (int k = 0; k < map.get(number[current]).length; k++) {	    	
	            if (current == number.length - 1) {
	                list.add(root +  map.get(number[current])[k]);
	            } else {
	            	permutations(root + map.get(number[current])[k], number, current + 1,
	                        list);
	            }
	        }
	    }
	    
	    public static void main(String args[]){
	    	 System.out.println("... "+getAllCombinations("234"));
	    }
}


