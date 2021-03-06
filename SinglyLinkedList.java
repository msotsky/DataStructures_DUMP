
public class SinglyLinkedList{ //implements List{

	private Node head;
	private int size;
	
	//Constructor 
	public SinglyLinkedList() {
		head = null;
		size = 0;
	}

	private static class Node {
		private Object data; // reference to the data 
		private Node next;	 // reference to the next node
		
		// Constructors
		
		/** Creates a new node with a null next field.
		 * 
		 *  @param dataItem The data we want to store
		 *   
		 */
		
		private Node(Object dataItem) {
			data = dataItem;
			next = null;
		}
		
		/** Creates a new node that references another node.
		 * 
		 *  @param dataItem The data we want to store
		 *  @param nodeRef The node references by the new node
		 *  
		 */
		
		private Node(Object dataItem, Node nodeRef) {
				data = dataItem;
				next = nodeRef;
			}
		
		private Node getNext() {
			return next;
		}
		
		private void setNext(Node aRef) {
			this.next = aRef;
		}
		
		private void setData(Object dataItem) {
			this.data = dataItem;
		}
		
		private Object getData() {
			return this.data;
		}
		
	}
	
	//Implementation of abstract methods
	
	public void add(Object dataItem) {
		this.addFirst(dataItem);
		//this.size++;
	}
	
	public Object remove() {
		return this.removeFirst();
	}
	
	public boolean remove(Object dataItem) {
		// if dataItem is in the linked list, remove it and return true
		// otherwise return false
		return false;
	}
	
	// Getters and Setters
	public int getSize() {
		return this.size;
	}
	
	/** Add an item to the front of the list.
	 * 
	 * @param item The item to be added
	 * 
	 */
	private void addFirst(Object item) {
		head = new Node(item, head);
		size++;
	}
	
	private void addAfter(Node aNode, Object item) {
		aNode.setNext(new Node(item, aNode.getNext()));
		size++;
	}
	
	/** Remove the node after a given node
	 * 
	 * @param aNode The node before the one to be removed
	 * @return The data from the removed node or null if there is no node to remove
	 * 
	 */
	private Object removeAfter(Node aNode) {
		Node temp = aNode.getNext();
		if (temp!=null) {
			aNode.setNext(temp.getNext());
			size--;
			return temp.getData();
		}
		else {
			return null;
		}
	}
	
	/** Remove the first node from the list
	 * 
	 * @return the returned node's data or null if the list is empty
	 * 
	 */
	
	private Object removeFirst() {
		Node temp = head;
		if (head != null) {
			head = head.getNext();
		}
		if (temp != null) {
			size--;
			return temp.getData();
		}
		else {
			return null;
		}
	}
	
	/** Helper method for deletion, inserton
	 * 
	 * @return success when there at least one node in the list
	 */
	private boolean isEmpty() {
		return (head==null);
	}
		  /*
	  1. Write a private method called makeAlternatingList that returns a linked list
	constructed from the values in an array. The linked list contains the same values in the
	array but the values with even indexes appear before the values with odd indexes (the
	order of the values with even indexes is the same as the order in the array, and the
	same for odd indexes). 
	*/

public String toString() { 
	Object obj;
	String result = "[  ";
	Node current = head;

	while (current != null) {
	  obj = current.data;
	  result = result + obj.toString() + "  ";
	  current = current.next;
	}
	result = result + "]";
	return result;
  }
  public Node getHead(){ //gets head of list
	  return head;
  }

	public static Node leapFrogging (Node head){
		//need to get rid of head.next
		Node aNode = head.next;//what to skip over
		if (head == null || aNode == null) //base case
			return null;
		else{
			head.next = aNode.next;//unlinking OG head.next
			return leapFrogging(aNode);		
		}
	}
}