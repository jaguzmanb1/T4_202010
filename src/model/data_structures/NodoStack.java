package model.data_structures;

public class NodoStack<T> {

	private T elemento;
	
	private NodoStack<T> siguienteNodo;
	
	public NodoStack( T pInfo)
	{
		
		elemento = pInfo;
		siguienteNodo = null;
		
	}
	
	public T darElemento() 
	{
		return elemento;
	}
	
	public NodoStack<T> eliminarPrimerElemento()
	{
		NodoStack<T> p = siguienteNodo;
		siguienteNodo = null;
		return p;
	}
	
	
	
}
