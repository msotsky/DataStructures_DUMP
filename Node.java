/*
Maxime Sotsky 0270251
COMP 2611
2019-11-17
*/
public class Node <E> {
	private E data;
	Node next;
	
	Node(E newData){
		data = newData;
		next = null;
	}
	
	public void setNext(Node newNext){
		next = newNext;
	}
	
	public Node getNext(){
		return next;
	}
	
	public void setData(E newData){
		data = newData;
	}
	
	public E getData(){
		return data;
	}
	
}
