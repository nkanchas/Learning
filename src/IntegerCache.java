
public class IntegerCache {

	public static void main(String[] args) {
		Integer i1 = 3;
		Integer i2 = 3;
		
		if(i1==i2)
		   System.out.println("(i1==i2) using autoboxing"+ (i1==i2));
		else
			System.out.println("(i1 != i2)  using autoboxing");
		
		
		Integer ik1 = 300;
		Integer ik2 = Integer.valueOf("300");
		
		
		if(ik1==ik2)
		   System.out.println("(ik1==ik2) using Integer.value of");
		else
			System.out.println("(ik1 != ik2) using Integer value of");
		

	}

}
