package utilities;

public class LinkedList<T> {
	protected Node _head; 
	protected Node _tail; 
	protected int size; 
	
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
		this._head= new Node(null, _tail); 
		this._tail = new Node(null,null); 
		this.size = 0;
	}
	
	//method isEmpty 
	public boolean isEmpty() {
		return (this._head._next == this._tail); 
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
//		if (isEmpty()) {
//			Node n = new Node(element, _tail);
//			_head._next=n;
//		}
		this._head._next = new Node(element, _head._next); 
		size++; 
	
	}
	public boolean contains(T target) {
		// check if the target is null
		if(target.equals(null)) return false; 
	
		return contains(target, _head._next); // call helper method
	}
	private boolean contains(T target, Node n ) {
		// base case node search is tail 
		if(n.equals(_tail)) return false; 
		
		//if target equals Node 
		if (n.data.equals(target)) {
			return true; 
		}
		
		// call the recursive 
		return contains(target, n._next);
		
	}
	
	// private method 
	private Node previous(T target) {
		if (!contains(target)) return null;
		return previous(target, _head._next);	
		}
	// helper method Previous
	private Node previous(T target, Node n) {
		if (n.data.equals(target)) return n;
		return previous(target, n._next);
	}
	
	public boolean remove(T target) {
		//checking for containment before looping
		if (!(contains(target))) return false;
		
		//loops through, checking for equality
		for (Node n = _head._next; n != _tail; n = n._next){
			if (n.data.equals(target)) {
				
				//sets the previous nodes next to the node after target, excluding target
				previous(n.data)._next = n._next;
				return true;
			}
		}
		size--; 
		return false;
	}
	
	public String toString() {
		return toString(_head._next);	
	}
	
	private String toString(Node n) {
		String result; 
		if(n.equals(_tail)) return " ";
		result = "" + n.data +", "; 
		return (result + toString(n._next));
	}
	
	//add to back 
	public void addToBack(T target){
		last()._next = new Node (target, _tail);
		//previous(_tail.data)._next = new Node (target, _tail);
		size++;
	}
	
	// Last metod 
	
	private Node last() {
	if (isEmpty()) return null;
	return last(_head._next, 0);
	}
	
	private Node last(Node n, int index) {
		if (index==(size-1)) return n;
		return last(n._next, index+1);
	}
	
	
	public void reverse() {
		reverse(_head._next, last(), 0);
	}
	private void reverse(Node front, Node back, int i) {
		//base case
		if(!(i == size/2)){
			
		//Making place holders
		T val1 = back.data;
		T val2 = front.data;
		
		//Removing originals
		remove(back.data);
		remove(front.data);
		
		//Swapping the values
		addToBack(val1);
		addToFront(val2);
		reverse(front._next, previous(back.data), ++i);
		}
	}
	
	
	
	
	
	
	
	
	
}
