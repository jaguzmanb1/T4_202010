package model.data_structures;

public interface IQueue<T> extends Iterable<T>{
		
	public int size();
	
	public T dequeue();

	public void enqueue(T elemento);
	
}
