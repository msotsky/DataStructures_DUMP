
public class StackList<E> implements StackADT<E>{
	
		
		private Node<E> top;            // top of stack
		
		
		public StackList(){		
			top = null;
		}
		
		
		/** Inner class for linked list node 
		 * 
		 */
		
		private static class Node <E> {
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

		/** Stack methods
		 * 
		 */
		
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

