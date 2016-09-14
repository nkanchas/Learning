
public abstract class BaseClass {
	protected String name;
	
	protected String department;
	
	public BaseClass(){
		super();
	}
	
	public BaseClass(String name, String department){
		this.name = name;
		this.department = department;
	}
	
	
	public void printStuff(){
		System.out.println("..name "+ name +"...department.."+ department);
	}
	
	
	
	
	

}
