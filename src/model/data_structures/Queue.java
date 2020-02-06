package model.data_structures;

import java.util.Iterator;

public class Queue<T> implements IQueue<T>{
	
	protected NodeCola<T> primero;
	
	protected NodeCola<T> ultimo;

	protected int numElems;

	public Queue( ){
		primero = null;
		ultimo = null;
		numElems = 0;
	}
	
	public int size( ){
		return numElems;
	}
	
	@Override
	public T dequeue( )
	{
		NodeCola<T> p = primero;
		primero = primero.desconectarPrimero( );
		if( primero == null )
			ultimo = null;
		numElems--;
		return p.darElemento( );

	}
	
	@Override
	public void enqueue(T elemento) {
		NodeCola<T> nodo = new NodeCola<T>( elemento );
		if( primero == null ){
			primero = nodo;
			ultimo = nodo;
		}
		else{
			ultimo = ultimo.insertarDespues( nodo );
		}
		numElems++;
	}
	
	public NodeCola<T> darPrimero( ){
		return primero;
	}
	
	public NodeCola<T> darUltimo( ){
		return ultimo;
	}
	
	@Override
	public Iterator<T> iterator() {
		return  new Iterator<T>() {

			private NodeCola<T> current = primero;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return current != null;
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				if(!hasNext())
					return null;

				NodeCola<T> item = current;
				current = current.darSiguiente();
				return item.darElemento();
			}
		};
	}
	
}
