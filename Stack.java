// Generic stack
/*
Maxime Sotsky 0270251
COMP 2611
2019-11-17
*/
public class Stack<E> {
	
	private Node<E> top;            // top of stack

	public Stack()
	{		
		top = null;
	}

	private static class Node<E> {
		private E data;
		Node<E> next;
		
		Node(E newData){
			data = newData;
			next = null;
		}
		
		private void setNext(Node<E> newNext){
			next = newNext;
		}
		
		private Node<E> getNext(){
			return next;
		}
		
		private void setData(E newData){
			data = newData;
		}
		
		private E getData(){
			return data;
		}
		
	}

	// Puts an item on the top of the stack
	public void push(E element){
		Node<E> newNode = new Node<E>(element);
		newNode.setNext(top);
		top = newNode;
			
	}
	
	//Removes the top element from the stack and returns it
	public E pop(){
		E toDelete = top.getData();
		top = top.getNext();
		return toDelete;
	}
	
	// Returns value of element at top of the stack
	public E peek() {
		return top.getData();
	}
	
	// True if the stack is empty
	public boolean isEmpty(){
		return (top == null);
	}
	
	
}
