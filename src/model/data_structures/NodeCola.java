
package model.data_structures;


/**
 * Nodo de la cola encadenada
 * @param <T> Tipo de elemento que va a contener la cola
 */
public class NodeCola<T> {

    private T elemento;

    private NodeCola<T> sigNodo;

    public NodeCola( T pElemento ){
        elemento = pElemento;
        sigNodo = null;
    }

    public T darElemento( ){
        return elemento;
    }

    public NodeCola<T> desconectarPrimero( ){
        NodeCola<T> p = sigNodo;
        sigNodo = null;
        return p;
    }

    public NodeCola<T> insertarDespues( NodeCola<T> nodo ){
        sigNodo = nodo;
        return nodo;
    }

    public NodeCola<T> darSiguiente( ){
        return sigNodo;
    }

    @Override
    public String toString( )
    {
        return elemento.toString( );
    }
}
