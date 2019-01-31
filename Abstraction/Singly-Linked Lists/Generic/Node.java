package singlyLinkedList;

/**
 * A model of a node using a Generic class
 * @author emmaboulay
 * @version 2.0
 * @param <Type>
 */
public class Node<Type> {
	private Type item;
	private Node<Type> next;
	
	//Constructors
	public Node() {
		this(null);
	}
	public Node(Type o) {
		this(o, null);
	}
	public Node(Type o, Node<Type> n) {
		this.item = o;
		this.next = n;
	}
	
	//Accessors
	public Type getItem() {
		return this.item;
	}
	public Node<Type> getNext() {
		return this.next;
	}

	//Mutators
	public void setItem(Type o) {
		this.item = o;
	}
	public void setNext(Node<Type> head) {
		this.next = head;
	}
	
	public static void main(String[] args) {
		Node<Integer> n = new Node<>(new Integer(7));
		Node<Integer> head = new Node<>(new Integer(5), n);
		System.out.println("" + head.getItem() + " " + head.getNext().getItem());
	}
}
