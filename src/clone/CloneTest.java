package clone;

public class CloneTest {

	public static void main(String[] args) throws CloneNotSupportedException{
		Employee naresh = new Employee("Naresh", "LeadEngineer");
		
		
		System.out.println("Original Obj: person: "+ naresh.getPerson().getName()
				+ " band "+ naresh.getBand());
		Employee nareshClone = (Employee) naresh.clone();
		
		System.out.println("Cloned Object: person "+ nareshClone.getPerson().getName() +" band "
				+ nareshClone.getBand());
		
		//modify original object
		naresh.setBand("SeniorArchitech");
		naresh.getPerson().setName("Kanish");
		
		
		System.out.println("(After modify) Original Obj: person: "+ naresh.getPerson().getName()
				+ " band "+ naresh.getBand());
		
		System.out.println("Cloned Object: person "+ nareshClone.getPerson().getName() +" band "
				+ nareshClone.getBand());
		
		

	}

}
