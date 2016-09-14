package DesignPatterns.ObserverPattern;

public class User implements Observer {
	
	private Subject subject;
	private String message;

	@Override
	public void setSubject(Subject subject) {
		this.subject = subject;
		message = "No New Article";

	}

	@Override
	public void update() {
		 message = subject.getUpdate();
		System.out.println("got update...."+ message);
	}
	
	public String getMessage(){
		return message;
	}

}
