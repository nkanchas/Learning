package DesignPatterns.ObjectPoolPattern;

public interface ObjectFactory<T> {
	
	public abstract T createNew();

}
