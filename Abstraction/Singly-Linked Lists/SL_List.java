package singlyLinkedList;

public class SL_List {
	private Node head;
	private int size;
	
	public SL_List() {
		head = null;
		size = 0;
	}
	/*
	 *Inserts at the start
	 */
    public void pushStart(Object o)
    {
        Node nptr = new Node(o);    
        size++ ;    
        if(head == null) {head = nptr;}
        else {
        	nptr.setNext(head);
            head = nptr;
        }
    }
    /**
     * 
     * @return
     */
    public boolean isEmpty() {
    	return head == null;
    }
    /**
     * Print list
     */
	public void printList() {
		Node curr;
		if(head == null) {System.out.println("{Empty List}"); return;}
		for(curr = head; curr.getNext() != null; curr = curr.getNext()) {
			System.out.print(curr.getItem() + "->");
		}
		System.out.println(curr.getItem());
	}
	/** 
	 * Insert at end of list
	 * @param o
	 */
	public void pushEnd(Object o) {
		Node nptr = new Node(o);
		size++;
		if(head == null) {head = nptr;}
		else {
			Node curr;
			for(curr = head; curr.getNext() != null; curr = curr.getNext()) {}
			curr.setNext(nptr);
		}
		
	}
	/**
	 * Insert a node at a specific position. With the head node being position 0.
	 * @param o
	 * @param position
	 */
	public void push(Object o, int position) {
		if(position > size) {
			throw new IllegalArgumentException("Position can't be greater than size!");
		}
		if(position == 0) {this.pushStart(o); return;}
		Node curr, prev;
		int i;
		for(curr = head, prev = null, i = 0; i < position ; prev = curr, curr = curr.getNext(), i++) {}
		Node nptr = new Node(o, curr);
		prev.setNext(nptr);
	}
	/**
	 * Copies the elements of other and appends them to the end of the list being operated on
	 * @param other Is another linked list
	 */
	public void extend(SL_List other) {
		Node curr = head;
		for( ; curr.getNext() != null; curr = curr.getNext()) { }
		for(Node oCurr = other.head; oCurr != null; curr = curr.getNext(), oCurr = oCurr.getNext() ) {
			curr.setNext(new Node(new Integer((Integer)oCurr.getItem())));
		}
	}
	
	public static void main(String[] args) {
		SL_List sl = new SL_List();
		System.out.println(sl.isEmpty());
		sl.printList();
		sl.pushStart(new Integer(1));
		sl.printList();
		sl.pushStart(new Integer(2));
		sl.pushStart(new Integer(3));
		sl.pushStart(new Integer(4));
		sl.pushStart(new Integer(5));
		sl.pushStart(new Integer(6));
		sl.pushEnd(new Integer(0));
		sl.push(new Integer(99), 7);
		sl.printList();
		
		SL_List sl2 = new SL_List();
		sl2.pushStart(new Integer(8));
		sl2.pushStart(new Integer(9));
		sl2.pushStart(new Integer(10));
		sl2.pushStart(new Integer(11));
		sl2.pushStart(new Integer(12));
		
		sl.extend(sl2);
		sl2.printList();
		sl.printList();
		SL_List sl3 = new SL_List();
		sl3.pushStart(new Integer(4));
		sl.extend(sl3);
		sl3.printList();
		sl.printList();
	}

}
