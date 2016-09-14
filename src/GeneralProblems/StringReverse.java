package GeneralProblems;

public class StringReverse {
	
	
	public static String reverse(String str){
		
		if(str == null || str.length() <= 0) return "";
		
		String k = str.substring(1, str.length());
		String firstChar = String.valueOf(str.charAt(0));
		return   reverse(k) + firstChar;
	}

	public static void main(String[] args) {
		String str = "liril";
		
		System.out.println("reverse string is "+ reverse(str));

	}

}
