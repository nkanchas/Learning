package DesignPatterns.ObjectPoolPattern;

public interface Pool<T> {
	
	T get();
	void release(T t);
	void shutdown();

}
