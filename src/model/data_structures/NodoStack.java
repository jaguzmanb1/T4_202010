package model.data_structures;


/**
 * Clase generica 
 * Encadena el stck
 * @param <T> Tipo de datos almacenados 
 */
public class NodoStack<T> {
	
	/**
	 * El elemento el nodo
	 */
	private T elemento;
	
	
	/**
	 * El elelmto siguiente en la cadena
	 */
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
	
	public NodoStack<T> insertarElementoAntesDelActual(NodoStack<T> pNodo)
	{
		pNodo.siguienteNodo = this;
		return pNodo;	
	}
	
	public NodoStack<T> darSiguiente() 
	{
		return siguienteNodo;
	}
	
	public String  toString() 
	{
		return elemento.toString();
	}
	
}
