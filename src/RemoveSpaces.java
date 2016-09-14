import java.util.Arrays;

public class RemoveSpaces {
	
	public static String removeSpaces(String str){
		char[] chr = str.toCharArray();
		
		int numSpaces=0;
		for(int i=0; i< chr.length-1; i++){
			if(chr[i] == ' '){
				++numSpaces;
			}else{
				chr[i-numSpaces] = chr[i]; 
			}
		}
		
		chr = Arrays.copyOf(chr, chr.length-numSpaces);
		return new String(chr);
	}

	public static void main(String[] args) {
		String strWithSpaces    = "  Hi there, how  are you   doing? ";
        String strWithoutSpaces = removeSpaces(strWithSpaces);
         
        System.out.println(strWithoutSpaces);

	}

}
