
public class StackArray<E> implements StackADT<E> {
	
	private int maxSize;        // size of stack array
	private E[] stackArray;		// the actual array to store elements of type E
	private int top;            // top of stack

	StackArray(int sizeOfArray){
		maxSize = sizeOfArray;
		stackArray = (E[]) new Object[maxSize];	// when creating the array, cast the array of Objects as an array of type E
		top = -1; 	
	}
	// Fill in the push, pop, peek and isEmpty methods
	
	@Override
	public boolean isEmpty() {
		return (top==-1);
	}
	
	@Override
	public E peek() {
		return stackArray[top];
	}
	
	@Override
	public E pop() {
		E poppedElement = stackArray[top];
		top--;
		return poppedElement;
	}
	
	//@Override
	public void push(Object data) {
		stackArray[top+1] = (E)data;
		top++; 	// increment top to allow for insertion of new element
	}
	

	
}
