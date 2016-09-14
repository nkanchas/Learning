package grabtaxi;

import java.util.HashMap;
import java.util.Map;

public class TestM {
   private static  Map<String, String> match = new HashMap<String, String>();
    
    static{
    	match.put("AB","AA");
    	match.put("BA","AA");
    	match.put("CB","CC");
    	match.put("BC","CC");
    	match.put("AA","A");
    	match.put("CC","C");
    	
    	
    }
       
	public static void main(String[] args) {
		//String S = "ABBCC";
		String S = "AABCC";
		boolean foundMatch = true;
		
		while (foundMatch) {
			foundMatch = false;
			String getValue = "";
			int matchIndex = -1;
			for (int i = 0; i < S.length() - 1; i++) {
				String temp = String.valueOf(S.charAt(i)) + S.charAt(i + 1);
				if (match.containsKey(temp)) {
					foundMatch = true;
					getValue = match.get(temp);
					matchIndex = i;
					break;
				}
			}
			
			if(foundMatch){
				String temp ="";
				int rindex = 0;
				for (int i = 0; i < S.length(); i++) {
					if(i == matchIndex){
						temp = temp + getValue.charAt(0);
						if(getValue.length() > 1)
						   temp = temp + getValue.charAt(1);
						i = i+1;
					}else{
						temp += S.charAt(i);
					}
				}
				
				S = temp;
			}
			
			System.out.println("..."+S);
		}
		
		System.out.println("final String >>> "+ S);
	}

}
