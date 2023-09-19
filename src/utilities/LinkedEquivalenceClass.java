package utilities;

import java.util.Comparator;

public class LinkedEquivalenceClass<T> {
	protected T _canonical;
	protected Comparator<T> _comparator;
	protected LinkedList<T> _rest;
	
	public LinkedEquivalenceClass(Comparator<T> comparator) {
		_canonical = null;
		_comparator =comparator;
		_rest = new LinkedList<T>();
	}
	public T canonical(){
		return _canonical;
	}
	public boolean isEmpty(){
		return _rest.isEmpty() && _canonical==null;
	}
	public void clear() {
		_canonical=null;
		_rest.clear();
	}
	public void clearNonCanonical() {
		_rest.clear();
	}
	public int size() {
		return _rest.size();
	}
	public boolean add(T element) {
		if (isEmpty()) {
			_canonical=element;
			return true;
		}
		if (_comparator.compare(_canonical,element)==0) {
			_rest.addToBack(element);
			return true;
		}
		return false;
	}
	// This is likely wrong
	public boolean contains(T target) {
		return _rest.contains(target);
	}
	public boolean belongs(T target) {
		if(target.equals(_canonical)) return true;
		return false;
	}
	public boolean remove(T target) {
		return _rest.remove(target);
	}
	//this is probably also wrong
	public boolean removeCanonical(){
		_canonical=null;
		return true;
	}
	public boolean demoteAndSetCanonical(T element) {
		
	}
	public String toString() {
		return "" + _canonical + "|" + _rest.toString();
	}
}
