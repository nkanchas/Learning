import javax.xml.namespace.QName;


public class CircularArrayQueue {
	Object[] Q;
	int rear;
	int front;
	private static final int CAPACITY = 5;
	private final int N;
	

	public CircularArrayQueue(){
		Q = new Object[CAPACITY];
		N = CAPACITY;
		front=-1;
		rear =-1;
	}
	
	public CircularArrayQueue(int CAPACITY){
		N = CAPACITY;
		Q = new Object[CAPACITY];
		front=-1;
		rear =-1;
	}
	
	public boolean isFull(){
		return ((rear+1)%CAPACITY == front);
	}
	
	public boolean isEmpty(){
		return (front == -1);
	}
	
	public void enqueue(Object obj) throws Exception{
		if(isFull())
			throw new Exception("Queue full.");
		
		rear = (rear+1)%N;
		Q[rear] = obj;
		if(front ==-1)
			front = rear;	
	}
	
	public Object dequeue() throws Exception{
		if(isEmpty()) throw new Exception("Queue empty.");
		
         Object ob =  Q[front];
         Q[front] =null;
         if(front == rear) front = rear -1;
         else 
         front = (front+1)%N;
         
         return ob;
	}
	
	public int size(){
	   	return ((CAPACITY-front+rear+1)%CAPACITY);
	}
	
	public static void main(String args[]) throws Exception{
		CircularArrayQueue caq = new CircularArrayQueue();
		caq.enqueue("A");
		caq.enqueue("B");
		caq.enqueue("C");
		caq.dequeue();
		caq.dequeue();
		caq.dequeue();
		caq.enqueue("D");
		caq.enqueue("E");
		
		System.out.println("Queue Size "+ caq.size());
		
	}
}
