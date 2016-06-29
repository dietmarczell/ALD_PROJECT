package test;

import java.util.ArrayList;

public class Node<Type> {

	ArrayList<String> nv = new ArrayList<>();
	int id;
	/**
	 * Linkes Kind
	 */
	protected Node<Type> left;
	
	/**
	 * Rechtes Kind
	 */
	protected Node<Type> right;
	
	/**
	 * Elternelement
	 */
	protected Node<Type> parent;
	
	/**
	 * Wert des Knotens, hier: String, der Wort enthält
	 */
	protected final Type value;


	/**
	 * Konstruktor
	 * @param value Zu speichernder Wert
	 */
	public Node(Type value) {
		this.value = value;
		//this.id = Integer.parseInt(this.getValue().toString().split(",")[0].substring(1));
	}

	public Node<Type> getLeft() {
		return left;
	}

	public void setLeft(Node<Type> left) {
		this.left = left;
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}

	public Node<Type> getRight() {
		return right;
	}

	public void setRight(Node<Type> right) {
		this.right = right;
	}

	public Node<Type> getParent() {
		return parent;
	}

	public void setParent(Node<Type> parent) {
		this.parent = parent;
	}

	public Type getValue() {
		return value;
	}
	
}
