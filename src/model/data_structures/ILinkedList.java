package model.data_structures;

public interface ILinkedList<T> {
	
	public boolean isEmpty();
	
	public int size();
	
	public void insertarAlFinal(T elemento);
	
	public void insertarAlFrente(T elemento);

}
