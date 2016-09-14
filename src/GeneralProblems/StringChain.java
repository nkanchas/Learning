package GeneralProblems;

import java.util.HashMap;
import java.util.Map;

public class StringChain {

	public static void main(String[] args) {
		String[] sc = {"a", "b", "ba","bca","bda","bdca"};
		Map<String, String> map = new HashMap<String, String>();
		
		int maxl = 0;
		String fstr = null;
		for(int i=0; i<sc.length;++i){
			map.put(sc[i], sc[i]);
			if(sc[i].length() > maxl){
				fstr = sc[i];
			}
		}
		
		
		System.out.println(fstr);
		
		for(int i=0; i< fstr.length(); i++){
			char[] chr = fstr.toCharArray();
			String cStr = "";
			int counter=0;
			for(char c : chr){
			  	if(counter == i) {
			  		++counter;
			  		continue;
			  	}
			  	else  cStr += String.valueOf(c);
			  	++counter;
			}
			
			System.out.println("xx "+cStr);
		}

	}

}
