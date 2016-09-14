import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class StringChain {

	public static void main(String[] args) {
		String arr[] = {"for", "geek", "rig", "kaf"};
		//String arr[] = {"aaa", "bbb", "baa", "aab"};
		Map<Character, List<Character>> map = new HashMap();
		
		for(String str: arr){
			Character sc = str.charAt(0);
			Character ec = str.charAt(str.length()-1);
			
			List<Character> list =null;
			if(map.get(sc) != null){
				list = map.get(sc);
			}else{
				list = new ArrayList<Character>();
			}
			
			list.add(ec);
			
			map.put(sc, list);
			
		}
		
		//Map Ready
		System.out.println("map..."+map);

	}

}










/*http://www.geeksforgeeks.org/given-array-strings-find-strings-can-chained-form-circle/
 * 
 Input: arr[] = {"geek", "king"}
Output: Yes, the given strings can be chained.
Note that the last character of first string is same
as first character of second string and vice versa is
also true.

Input: arr[] = {"for", "geek", "rig", "kaf"}
Output: Yes, the given strings can be chained.
The strings can be chained as "for", "rig", "geek" 
and "kaf"

Input: arr[] = {"aab", "bac", "aaa", "cda"}
Output: Yes, the given strings can be chained.
The strings can be chained as "aaa", "aab", "bac" 
and "cda"

Input: arr[] = {"aaa", "bbb", "baa", "aab"};
Output: Yes, the given strings can be chained.
The strings can be chained as "aaa", "aab", "bbb" 
and "baa"

Input: arr[] = {"aaa"};
Output: Yes

Input: arr[] = {"aaa", "bbb"};
Output: No*/