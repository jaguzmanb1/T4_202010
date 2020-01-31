package model.data_structures;

import model.logic.Comparendo;

public class DoubleLinkedList<E> {

	private Node<E> cabeza;
	private Node<E> cola;

	public Node<E> getCabeza() {
		return cabeza;
	}

	public void setCabeza(Node<E> cabeza) {
		this.cabeza = cabeza;
	}

	public Node<E> getCola() {
		return cola;
	}

	public void setCola(Node<E> cola) {
		this.cola = cola;
	}

	public boolean isEmpty() {
		return this.cabeza == null;
	}

	public void pushFront(E key) {
		if (isEmpty()) {
			this.cabeza = this.cola = new Node<E>(null, key, null);
		} else {
			this.cabeza = new Node<E>(null, key, this.cabeza);
			this.cabeza.getSiguiente().setAnterior(this.cabeza);
		}
	}
	
	public void pushBack(E key) {
		Node<E> node = new Node<E>(null, key, null);
		if (isEmpty()) {
			this.cabeza = this.cola = node;
		} 
		else {
			this.cola.setSiguiente(node);
			node.setAnterior(this.cola);
			this.cola = node;
		}
	}

	public E topFront() {
		if (isEmpty()) {
			throw new RuntimeException("La lista está vacia");
		}

		return this.cabeza.getKey();
	}

	public E popFront() {
		if (isEmpty()) {
			throw new RuntimeException("La lista está vacia");
		}

		E key = this.cabeza.getKey();
		if (this.cabeza == this.cola) {
			this.cabeza = this.cola = null;
		} 
		else {
			this.cabeza = this.cabeza.getSiguiente();
			this.cabeza.setAnterior(null);
		}
		return key;
	}

	public E topBack() {
		if (isEmpty()) {
			throw new RuntimeException("La lista está vacia");
		}

		return this.cola.getKey();
	}

	public E popBack() {
		if (isEmpty()) {
			throw new RuntimeException("La lista está vacia");
		}

		E key = this.cola.getKey();
		if (this.cabeza == this.cola) {
			this.cabeza = this.cola = null;
		} 
		else {
			this.cola = this.cola.getAnterior();
			this.cola.setSiguiente(null);
		}
		return key;
	}
	
}