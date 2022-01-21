
public interface StackADT<E> {
	
	/** Determine whether the stack has any elements
	 * 
	 */
	
	public boolean isEmpty();
	
	/** Return the value that pop would provide without modifying the stack
	 * 
	 */
	
	public E peek();
	
	/** Remove and return the value at the top of the stack
	 * 
	 */
	
	public E pop();
	
	/** Add the given value to the stack
	 * 
	 */


	public void push(E data);

}
