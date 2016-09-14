
public class ConvertDecimalToBinary {
	
	public static void main(String args[]){
		/*System.out.println("3%2="+7%2);
		System.out.println("3/2="+7/2);*/
		
		
		int num = Integer.parseInt(args[0]);
		System.out.println("..given number.."+num);
		String binarynum="";
		int bit=1;
		for(int i=0; i<32; ++i){
			binarynum += (((num&bit)==0)?0:1);
			//System.out.print(" "+(((num&bit)==0)?0:1) );
			bit*=2;
		}
		
		System.out.println(binarynum);
		
		System.out.println("convert back to decimal");
		int n = convertBinaryToDecimal(binarynum);
		System.out.println("..."+n);
		
		
	}
	
	public static int convertBinaryToDecimal(String bin){
	    long bina =  Long.parseLong(bin,2);
		int decimal =0;
		int p=0;
		int binary = (int) bina;
		while(true){
			
			if(binary == 0) break;
			else {
				int temp = binary%10;
				decimal += temp * Math.pow(2, p);
				binary = binary/10;
			    ++p;
			}
			
		}
		 
		return decimal;
	}

}
