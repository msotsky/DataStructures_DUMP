

public class LinkedList<T> {
	
	// INSTANCE VARIABLES
	
	private Node<T> head;
	private Node<T> tail;
	private int size;

	  /**
	   *  SList() constructs an empty list.
	   **/

	  public LinkedList() {
	    size = 0;
	    head = null;
	    
	  }

	  private class Node<T> {
		  private T item;
		  private Node<T> next;

		  /**
		   *  Node() (with one parameter) constructs a list node referencing the
		   *  item "obj"
		   */

		  Node(T obj) {
		    item = obj;
		    next = null;
		  }

		  /**
		   *  Node() (with two parameters) constructs a list node referencing the
		   *  item "obj", whose next list node is to be "next".
		   */

		  Node(T obj, Node<T> nexty) {
		    item = obj;
		    this.next = nexty;
		  }
		  
		  public Node<T> getNext() {
			  return this.next;
		  }
		  
		  public void setNext(Node<T> nexty) {
			  this.next = nexty;
		  }
		  
		  public T getElt () {
			  return this.item;
		  }
		  
		  public void setItem(T obj) {
			  item = obj;
		  }

		}

	  
	  
	  /**
	   *  isEmpty() indicates whether the list is empty.
	   *  @return true if the list is empty, false otherwise.
	   **/

	  public boolean isEmpty() {
	    return size == 0;
	  }

	  /**
	   *  length() returns the length of this list.
	   *  @return the length of this list.
	   **/

	  public int length() {
	    return size;
	  }

	  /**
	   *  insertFront() inserts item "obj" at the beginning of this list.
	   *  @param obj the item to be inserted.
	   **/

	  public void insertFront(T obj) { // tail does not change here, only head does
		  Node<T> addMe = new Node<T>(obj);
		  if (isEmpty()) {
			head = addMe;
			//tail = addMe;
		  }
		  else {
			  addMe.setNext(head);
			  head = addMe;
	     }
		  
	    size++;
	  }

	  /**
	   *  insertEnd() inserts item "obj" at the end of this list.
	   *  @param obj the item to be inserted.
	   **/

	 public void insertEnd(T obj) {
	    if (head == null) {
	      head = new Node<T>(obj);
	      tail = head;
	    } else {
	      tail.setNext(new Node<T>(obj));
	      tail = tail.getNext();
	    }
	    size++;
	  }


	  /**
	   *  toString() converts the list to a String.
	   *  @return a String representation of the list.
	   **/

	  public String toString() {
	    int i;
	    T obj;
	    String result = "[  ";

	    Node<T> cur = head;

	    while (cur != null) {
	      obj = cur.item;
	      result = result + obj.toString() + "  ";
	      cur = cur.next;
	    }
	    result = result + "]";
	    return result;
	  }

	  
	  

	 

}

