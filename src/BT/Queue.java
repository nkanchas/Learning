package BT;

import java.util.LinkedList;

public class Queue<T>  {
    private LinkedList<T> data = new LinkedList<T>();
    public void enqueue(T item) {data.addLast(item);}
    public T dequeue() {return data.removeFirst();}
    public Object peek() {return data.getFirst();}
    public int size() {return data.size();}
    public boolean isEmpty() {return data.isEmpty();}
}