package ThreadsMisc;

public class AccessThread4 extends Thread{
private Employee e;
	
	public AccessThread4(Employee e){
		this.e = e;
	}
	
	public void run(){
		Employee.m4();
	}


}
