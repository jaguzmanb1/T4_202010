package model.data_structures;

import model.data_structures.Node;

public class ListaEncadenada <T extends Comparable>{

	private Node<T> primero;

	private Node<T> ultimo;

	private int numElems;

	public ListaEncadenada( ){
		primero = null;
		ultimo = null;
		numElems = 0;
	}

	public Node<T> darUltimo( ){
		return ultimo;
	}

	public Node<T> darPrimero( ){
		return primero;
	}

	public int darLongitud( ){
		return numElems;
	}

	public T buscar( T modelo ){
		for ( Node<T> p = primero ; p != null ; p = p.darSiguiente( ) ){
			if ( p.darElemento( ).equals( modelo ) ){
				return p.darElemento( );
			}
		}
		return null;
	}
	
	public String buscarPorId(T modelo){
		for ( Node<T> p = primero ; p != null ; p = p.darSiguiente( ) ){
			if ( p.darElemento().compareTo(modelo) == 0 ){
				return p.darElemento( ).toString();
			}
		}
		return null;
	}

	public void insertarAlFrente( T elemento ){
		Node<T> nodo = new Node<T>( elemento );
		if ( primero == null ){
			primero = nodo;
			ultimo = nodo;
		}
		else {
			primero.insertarAntes( nodo );
			primero = nodo;
		}
		numElems++;
	}

	public void insertarAlFinal( T elemento )
	{
		Node<T> nodo = new Node<T>( elemento );
		if ( primero == null ){
			primero = nodo;
			ultimo = nodo;
		}
		else {
			ultimo.insertarDespues( nodo );
			ultimo = nodo;
		}
		numElems++;
	}

	public T eliminarNodo( Node<T> nodo ){
		T r = null;
		if( buscar(nodo.darElemento( )) != null ){
			return null;
		}
		if( primero == nodo ){
			r = primero.darElemento();
			primero = nodo.popPrimero( );

			if( ultimo == nodo ){
				ultimo = null;
			}
		}
		else if (ultimo == nodo ){
			ultimo = nodo.darAnterior( );
			r = ultimo.darElemento();
			nodo.desconectarNodo( );
		}
		return r;
	}

	public T eliminarUltimo( ){
		if ( ultimo == null ){
			return null;
		}
		else {
			T r = ultimo.darElemento();
			eliminarNodo(ultimo);
			numElems--;
			return r;
		}
	}

}
