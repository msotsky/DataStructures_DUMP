public class LinkedQueue<E> implements QueueADT<E> {
	 /**
	  *  Attributes
	  */
	private int size;
	private Node<E> front, rear;
	
	private static class Node<E> {
		private E data;
		private Node<E> next;

		Node(E data) {
			this.data = data;
			next = null;
		}

		public Node<E> getNext() {
			return this.next;
		}

		public void setNext(Node<E> nextRef) {
			this.next = nextRef;
		}

		public E getData() {
			return this.data;
		}
	}
	
	/** 
	 * Constructor
	 */
	public LinkedQueue() {
		size = 0;
		front = rear = null;
	}
	
	/** 
	 * Add the given value to the queue 
	 * */
	public void enqueue(E elt) {
		Node<E> addNode = new Node<E>(elt);
		if (isEmpty()) 
			front = addNode;
		else
			rear.setNext(addNode);
		rear = addNode;
		size++;
	}
	
	
	/** 
	 * Remove and return the value from the front of the queue 
	 * Assumes that your queue is not empty. 
	 * */
	public E dequeue() {
		if (size == 0) throw new java.util.NoSuchElementException();
		E result = front.getData();
		front = front.getNext();
		size--;
		if (isEmpty())
			rear = null;
		return result;
	}
	
	/** 
	 * Return the value that dequeue would provide without modifying the queue 
	 * */
	
	public E peek() {
		return front.getData();
	}
	
	/** 
	 * Does the queue have any more elements 
	 * */
	
	public boolean isEmpty() {
		return (front==null);
	}
	
	/** 
	 * How many elements are in the queue? 
	 * */
	
	public int getSize() {
		return size;
	}

}
