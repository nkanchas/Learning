package Oops.Takipi;

public class MyClass {
	private String name;
	
	public static void main(String args[]){
		MyClass m1 = new MyClass();
		MyClass m2 = new MyClass();
		
		m1.name = m2.name = "m1";
		
		callMe(m1, m2);
		System.out.println(m1 +" & "+ m2);
	}
	
	private static void callMe(MyClass ...m){
		 m[0] = m[1];
		 m[1].name = "new name";
	}

	@Override
	public String toString() {
		return "MyClass [name=" + name + "]";
	}
	
	

}
