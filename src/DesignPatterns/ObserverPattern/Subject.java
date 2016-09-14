package DesignPatterns.ObserverPattern;

public interface Subject {
	public void register(Observer observer);
	public void unregister(Observer observer);
	public void notifyAllObservers();
	public String getUpdate();
}
