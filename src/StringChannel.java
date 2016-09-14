import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import sun.security.util.Length;


public class StringChannel {

	public static void main(String[] args) {
		Map<Character, Character> map = new LinkedHashMap<Character, Character>();
     if(args != null){
    	 for(String str: args){
    		 map.put(str.charAt(0), str.charAt(str.length()-1));
    	 }
     } //O(n)
     
     System.out.println("Given user input "+ map);
     
     //logic
     int lenghtofArray = args.length;
     int count =0;
     for(Character key: map.keySet()){
    	 Character v = map.get(key);
    	 
    	 if(map.containsKey(v)) {
    		 ++count;
    	 }
    	 
    	 if(count == lenghtofArray){
    		 break;
    	 }
     }
     
     if(count == lenghtofArray) System.out.println("yes it forms circle");
     else System.out.println("no...it failed to form circle");

	}
	
	

}
