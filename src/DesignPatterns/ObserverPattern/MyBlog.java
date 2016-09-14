package DesignPatterns.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class MyBlog implements Subject {
	private boolean stateChanged = false;
	List<Observer> observers = new ArrayList<Observer>();

	@Override
	public void register(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void unregister(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyAllObservers() {
		for(Observer obs : observers){
			if(stateChanged)
				obs.update();
		}

	}
	
	@Override
	public String getUpdate(){
		if(stateChanged)
			return "Observer Pattern";
		
		return "No New Article";
	}
	
	public void postNewArticle(){
		stateChanged = true;
		notifyAllObservers();
	}
	
	

}
