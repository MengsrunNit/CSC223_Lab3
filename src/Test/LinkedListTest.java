package Test;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utilities.LinkedList; 

class LinkedListTest {
	
	public LinkedList<Integer> build(){
		LinkedList<Integer> list = new LinkedList<Integer>(); 
		list.addToFront(4);
		list.addToFront(20); 
		list.addToFront(10);
		list.addToFront(1);
		list.addToFront(3);
		list.addToFront(7);

     	list.addToBack(7);
		list.addToBack(64);
		list.addToBack(23);
     	list.addToBack(9);
		
		return list; 
	}
	@Test
	void containsTest() {
		LinkedList<Integer> list = build(); 
		assertTrue(list.contains(7)); 
		assertTrue(list.contains(20));
		assertTrue(list.contains(1));
		assertTrue(list.contains(3));
		assertTrue(list.contains(64));
		assertTrue(list.contains(9));
		
	}
	@Test
	void isEmptyTest() {
		LinkedList<Integer> list = build(); 
		assertFalse(list.isEmpty());
		
		//clear
		list.clear();
		assertTrue(list.isEmpty());
	}
	
	void addToFrontTest() {
		
	}
	
	void previousTest() {
		
	}
	
	void removeTest() {
		
	}
	
	void isStringTest() {
		
	}
	
	void addTobackTest() {
		
	}
	
	void reverseTest() {
		
	}
	
}

