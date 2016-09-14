
public class FizzBuzz {
	
	public static void main(String args[]){
		new FizzBuzz().printFizzBuzz(20);
	}
	
	
	public void printFizzBuzz(int N){
		for(int i=1; i<= N; ++i){
			if(i%3 == 0 && i%5 == 0)
				System.out.println(i+": FizzBuzz");
			else if(i%3 == 0 )
			   System.out.println(i+": Fizz");
			else if(i%5 == 0)
				System.out.println(i+": Buzz");
			else
				System.out.println(i);
			
			
		}
	}

}
