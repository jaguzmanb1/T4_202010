package model.data_structures;

public class Node<O>{

	private Node<O> anterior;
	private O elemento;
	private Node<O> siguiente;

	public Node(O elemento) {
		super();
		anterior = null;
		siguiente = null;
		this.elemento = elemento;
	
	}
	
	public O darElemento( )
    {
        return elemento;
    }
	
    public void desconectarNodo( ){
        Node<O> ant = anterior;
        Node<O> sig = siguiente;
        anterior = null;
        siguiente = null;
        ant.siguiente = sig;
        if( sig != null )
        {
            sig.anterior = ant;
        }
    }
	

	public Node<O> darAnterior() {
		return anterior;
	}

	public Node<O> darSiguiente() {
		return siguiente;
	}

	public void insertarAntes( Node<O> nodo ){
		nodo.siguiente = this;
		nodo.anterior = anterior;
		if( anterior != null )
			anterior.siguiente = nodo;
		anterior = nodo;
	}

	public void insertarDespues( Node<O> nodo ){
		nodo.siguiente = siguiente;
		nodo.anterior = this;
		if( siguiente != null )
			siguiente.anterior = nodo;
		siguiente = nodo;
	}

	public Node<O> popPrimero( ){
		Node<O> tmp = siguiente;
		siguiente = null;
		if( tmp != null ){
			tmp.anterior = null;
		}
		return tmp;
	}

}