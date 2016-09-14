package clone;

public class Employee implements Cloneable{
	
	private Person person;
	private String band;
	
	public Employee(String name, String band){
		person = new Person(name);
		this.band = band;
	}
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getBand() {
		return band;
	}
	public void setBand(String band) {
		this.band = band;
	}
	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}

	@Override
	public String toString() {
		return "Employee [person=" + person.getName() + ", band=" + band + "]";
	}
	
	

}
