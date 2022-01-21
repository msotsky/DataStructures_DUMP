
public interface QueueADT<E> {
	
	/** Add the given value to the queue */
	public void enqueue(E elt);
	
	
	/** Remove and return the value from the front of the queue */
	public E dequeue();
	
	/** Return the value that dequeue would provide without modifying the queue */
	
	public E peek();
	
	/** Does the queue have any more elements */
	
	public boolean isEmpty();
	
	/** How many elements are in the queue? */
	
	public int getSize();
	

}
