package singlyLinkedList;


public class SL_List<Type> {
	private Node<Type> head;
	private int size;
	
	public SL_List() {
		head = null;
		size = 0;
	}
	/*
	 *Inserts at the start
	 */
    public void pushStart(Type o)
    {
        Node<Type> nptr = new Node<>(o);    
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
		Node<Type> curr;
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
	public void pushEnd(Type o) {
		Node<Type> nptr = new Node<>(o);
		size++;
		if(head == null) {head = nptr;}
		else {
			Node<Type> curr;
			for(curr = head; curr.getNext() != null; curr = curr.getNext()) {}
			curr.setNext(nptr);
		}
		
	}
	/**
	 * Insert a node at a specific position. With the head node being position 0.
	 * @param o
	 * @param position
	 */
	public void push(Type o, int position) {
		if(position > size) {
			throw new IllegalArgumentException("Position can't be greater than size!");
		}
		if(position == 0) {this.pushStart(o); return;}
		Node<Type> curr, prev;
		int i;
		for(curr = head, prev = null, i = 0; i < position ; prev = curr, curr = curr.getNext(), i++) {}
		Node<Type> nptr = new Node<>(o, curr);
		prev.setNext(nptr);
	}
	/**
	 * Copies the elements of other and appends them to the end of the list being operated on
	 * @param other Is another linked list
	 */
	public void extend(SL_List<Type> other) {
		Node<Type> curr = head;
		for( ; curr.getNext() != null; curr = curr.getNext()) { }
		for(Node<Type> oCurr = other.head; oCurr != null; oCurr = oCurr.getNext(), curr = curr.getNext()) {
			curr.setNext(new Node<>(oCurr.getItem())); //This only copies, will fix later!!
			
		}
	}
	
	public void replace(int position, Type o) {
		Node<Type> curr = head;
		for(int i = 0; i < position; i++, curr = curr.getNext()) {
		}
		curr.setItem(o);
		
	}
	
	public int getSize() {
		return size;
	}
	
	public void destroy() {
		head = null;
		size = 0;
	}
	public void delete(int position) {
		if(position > size || isEmpty()) {
			throw new IllegalArgumentException("No such position exists in the list");
		}
		if(position == 0) {
			head = head.getNext();
			return;
		}
			Node<Type> curr = head;
			Node<Type> prev = null;
			for(int i = 0; i < position - 1; prev = curr, curr = curr.getNext(), i++){
				
			}
			prev.setNext(curr.getNext());
			
		
				
			
	}
	
	public static void main(String[] args) {
		SL_List<Integer> sl = new SL_List<>();
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
		
		SL_List<Integer> sl2 = new SL_List<>();
		sl2.pushStart(new Integer(8));
		sl2.pushStart(new Integer(9));
		sl2.pushStart(new Integer(10));
		sl2.pushStart(new Integer(11));
		sl2.pushStart(new Integer(12));
		
		sl.extend(sl2);
		sl2.printList();
		sl.printList();
		SL_List<Integer> sl3 = new SL_List<>();
		sl3.pushStart(new Integer(4));
		sl.extend(sl3);
		
		sl3.printList();
		sl.printList();
		sl3.pushEnd(33);
		sl3.delete(0);
		sl3.printList();
		sl.printList();
	}

}
