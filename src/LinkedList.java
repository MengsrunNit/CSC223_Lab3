
public class LinkedList<T> {
	Node _head; 
	Node _tail; 
	int size; 
	
	private class Node{
		Node _prev; 
		Node _next; 
		T node; 
		
	public Node(Node p, T item, Node n) {
		_prev = p; 
		_next = n; 
		node = item; 
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
	
	public void clear() {
		this._head._next = this._tail;
		this._tail._prev = this._head; 
	}
	
	public int size() {
		return this.size;
	}
	
	
	
	
	
	
	
	
}
