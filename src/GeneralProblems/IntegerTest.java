package GeneralProblems;

public class IntegerTest {
    Integer i = 127;
    IntegerTest it = new IntegerTest();
    
    public void displayInteger(){
    	System.out.println("display..."+i);
    }
    
    public boolean isIntegerInLimit(Integer y){
    	return i==y;
    }
    
	public static void main(String[] args) {
		IntegerTest i = new IntegerTest();
		i.displayInteger();
		i.isIntegerInLimit(127);

	}

}
