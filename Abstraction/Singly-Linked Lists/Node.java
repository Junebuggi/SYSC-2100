/**
 * A model of a node used in linked lists. Points to the next node in the list.
 * 
 * @author emmaboulay
 * @version 1.0
 *
 */
public class Node {
	private Object item;
	private Node next;
	//Constructors
	public Node() {
		this(null);
	}
	public Node(Object o) {
		this(o, null);
	}
	public Node(Object o, Node n) {
		this.item = o;
		this.next = n;
	}
	//Accessors
	public Oject getItem() {
		return this.item;
	}
	public Node getNext() {
		return this.next;
	}
	//Mutators
	public void setItem(Object o) {
		this.item = o;
	}
	public void setNext(Node n) {
		this.next = n;
	}
}
