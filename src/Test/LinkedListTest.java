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
	@Test
	void addToFrontTest() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addToFront(5);	
		assertTrue (list.contains(5));
		list.addToFront(80);
		assertEquals (2, list.size());
		}
	@Test
	void previousTest() {
		
	}
	@Test
	void removeTest() {
		
		LinkedList<Integer> list = build();
		assertEquals (10, list.size());
		assertTrue (list.contains(20));
		assertTrue (list.remove(20));
		assertFalse (list.contains(20));
		
		assertTrue (list.contains(7));
		assertTrue (list.remove(7));
		assertEquals (8, list.size());
		assertTrue (list.contains(7));
		assertTrue (list.remove(7));
		assertEquals (7, list.size());
		assertFalse (list.contains(7));
		
		assertFalse (list.contains(75));
		assertFalse (list.remove(75));
		
		assertTrue(list.contains(9));
		assertTrue (list.remove(9));
		assertFalse(list.contains(9));
		
		assertEquals (6, list.size());
		
		assertTrue (list.contains(1));
		list.clear();
		assertFalse (list.remove(1));
	}
	@Test
	void toStringTest() {
		LinkedList<Integer> list= build();

		
	}
	@Test
	void addTobackTest() {
		
	}
	@Test
	void reverseTest() {
		
	}
	
}

