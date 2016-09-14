package DesignPatterns.ObjectPoolPattern;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

//https://www.javacodegeeks.com/2012/09/a-generic-and-concurrent-object-pool.html
public class BoundedBlockingPool<T> implements Pool<T>{
	
	private BlockingQueue<T> objects;
	private int size;
	private ExecutorService service = Executors.newCachedThreadPool();
	private boolean shutdown = false;
	private ObjectFactory<T> objectFactory;
	
	public BoundedBlockingPool(int size, ObjectFactory<T> objectFacotry){
		this.size = size;
		this.objectFactory = objectFactory;
		
		objects = new LinkedBlockingQueue<>(size);
		initializeObjects();
		shutdown=false;
	}
	
	private void initializeObjects(){
		
		for(int i=0; i< size; i++){
			objects.add(objectFactory.createNew());
		}
	}

	@Override
	public T get() {
		T t = null;
		if (!shutdown) {
			try {
				t = objects.take();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

		return t;
	}

	@Override
	public void release(T t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shutdown() {
		// TODO Auto-generated method stub
		
	}
	
	
	private class ObjectRunner<E> implements Callable<Void>{
		E e;
		BlockingQueue<T> queue;
		
		public ObjectRunner(BlockingQueue<T> queue, E e){
			this.e = e;
			this.queue = queue;
		}

		@Override
		public Void call() throws Exception {
			
			return null;
		}
		
	}

	

}
