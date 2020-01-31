package model.data_structures;
public class Node<O> {

	private Node<O> anterior;
	private O key;
	private Node<O> siguiente;

	public Node(Node<O> anterior, O key, Node<O> siguiente) {
		super();
		this.anterior = anterior;
		this.key = key;
		this.siguiente = siguiente;
	}

	public Node<O> getAnterior() {
		return anterior;
	}

	public void setAnterior(Node<O> anterior) {
		this.anterior = anterior;
	}

	public O getKey() {
		return key;
	}

	public void setKey(O key) {
		this.key = key;
	}

	public Node<O> getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Node<O> siguiente) {
		this.siguiente = siguiente;
	}

	@Override
	public String toString() {
		return this.key + (this.siguiente == null ? "" : ", ");
	}

}
