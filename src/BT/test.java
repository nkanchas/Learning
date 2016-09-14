package BT;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class test {

	public static void main(String[] args) {
		String str = "Hi India. I lOVE INDIA.";
		/*StringTokenizer stk = new StringTokenizer(str, " ");
		Map<String, Integer> map = new HashMap<String, Integer>();
		while(stk.hasMoreTokens()){
			String tkn = stk.nextToken();
			if(map.containsKey(tkn)){
				int val = map.get(tkn);
				map.put(tkn, ++val);
				System.out.println("got first duplicate..value is"+str);
			}else{
				map.put(tkn, 1);
			}
		}*/
		
		//String s = " 10";
		
		System.out.println("print:"+str);
		
		System.out.println("print:"+str.trim());


   /* if(this.getInputText_price() != null  &&  this.getInputText_price().getValue() != null)  {


       java.math.BigDecimal price = new java.math.BigDecimal((this.    getInputText_price().getValue().toString()).replaceAll("\\s+"," "));

    }


java.math.BigDecimal qty = new java.math.BigDecimal((this.getInputText_qty().getValue().toString()).replaceAll("\\s+"," "));




java.math.BigDecimal total = price.multiply(qty);
*/
        Object lock = new Object();
        
       /* synchronized (lock) {
			lock = new Object();
			lock.notify();
		}*/
        
        lock.notify();

	}

}
