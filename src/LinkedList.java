
public class LinkedList<T> {
	Node _head; 
	Node _tail; 
	int size; 
	
	private class Node{
	
		Node _next; 
		T data; 
		
	public Node(T item, Node n) {
		_next = n; 
		data = item; 
		}
	
	}
	
	
	//constrtor for linkedList
	public LinkedList() {
		this._head= null; 
		this._tail = null; 
		this.size = 0;
	}
	
	//method isEmpthy 
	public boolean isEmpthy() {
		return this._head._next == this._tail; 
	}
	
	// clear method
	public void clear() {
		this._head._next = this._tail;
		 
	}
	
	// return the size 
	public int size() {
		return this.size;
	}
	
	
	// add the element after head
	public void addToFront(T element) {
		_head._next = new Node(element, _head._next); 
		size++; 
	
	}
	public boolean contains(T target) {
		
		for(T n: LinkedList) {
			if(n.equals(target)) return true; 
		}
		return false; 
	}
	
	
	
	
	
	
	
	
	
	
	
}
