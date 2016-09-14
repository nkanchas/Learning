
public class ChildClass extends BaseClass{
protected String name;
	
	protected String department;
	
	
	public ChildClass(String name, String department){
		this.name = name;
		this.department = department;	
	}
	
	public void printValues(){
		printStuff();
	}
	
	
	public static void main(String args[]){
		ChildClass bc = new ChildClass("Sai", "world");
		bc.printValues();
	}
	
	
	public void printStuff(){
		System.out.println("..name "+ name +"...department.."+ department);
	}
	
	

}
