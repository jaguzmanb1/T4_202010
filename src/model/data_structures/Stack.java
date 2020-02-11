package model.data_structures;

import java.util.*;

//import com.sun.tools.classfile.Annotation.element_value;

//import sun.net.www.content.text.plain;

public class Stack<T> implements IStack<T> {
	
	private NodoStack<T> primerElemeto;
	
	private int numeroElementos;
	
	public Stack()
	{
		
		primerElemeto = null;
		numeroElementos = 0;
		
	}

	public int darLongitud()
	{
		return numeroElementos;
	}
	
	public T pop() 
	{
		NodoStack<T> primerElementoAEliminar = primerElemeto;
		primerElemeto = primerElemeto.eliminarPrimerElemento();
		numeroElementos--;
		return primerElementoAEliminar.darElemento();
	}
	
	public void push( T pElemeto) 
	{
		NodoStack<T> nuevoNodo = new NodoStack<T>(pElemeto);
		if ( primerElemeto == null) 
		{
			primerElemeto = nuevoNodo;
		}
		else 
		{
			primerElemeto = primerElemeto.insertarElementoAntesDelActual(nuevoNodo);
		}
		numeroElementos++;
	}
	
	public NodoStack<T> darPrimero() 
	{
		return primerElemeto;
	}
	
	public boolean stackEstaVacio() 
	{
		if (primerElemeto == null) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public Iterator<T> iterador() 
	{
		
		return  new Iterator<T>() {

			private NodoStack<T> current = primerElemeto;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return current != null;
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				if(!hasNext())
					throw new NoSuchElementException();

				NodoStack<T> item = current;
				current = current.darSiguiente();
				return item.darElemento();
			}
		};
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}
}
