package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import utilities.EquivalenceClasses;
import utilities.LinkedEquivalenceClass;

class EquivalenceClassesTest {
	
	public boolean isPrime(int num){
        if(num<2) return false;
		for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return false;
		}
		
        return true;
    }
	
	Comparator<Integer> c = new Comparator<Integer>() {
		public int compare(Integer x, Integer y)
		{ return isPrime(x)==isPrime(y)? 0:1;}
	};
	
	Comparator<Integer> c2 = new Comparator<Integer>() {
		public int compare(Integer x, Integer y)
		{ return x%9==y%9? 0:1;}
	};
	Comparator<Integer> c3 = new Comparator<Integer>() {
		public int compare(Integer x, Integer y)
		{ return x%7==y%7? 0:1;}
	};
	Comparator<Integer> c4 = new Comparator<Integer>() {
		public int compare(Integer x, Integer y)
		{ return x%11==y%11? 0:1;}
	};
	
	public EquivalenceClasses<Integer> build() {
		EquivalenceClasses<Integer> o = new EquivalenceClasses<Integer>(c);
		
		LinkedEquivalenceClass<Integer> lec1 = new LinkedEquivalenceClass<Integer>(c); 
		LinkedEquivalenceClass<Integer> lec2 = new LinkedEquivalenceClass<Integer>(c2); 
		LinkedEquivalenceClass<Integer> lec3 = new LinkedEquivalenceClass<Integer>(c3); 
		
		lec1.add(3);
		lec2.add(18);
		lec3.add(14);
		lec1.add(5);
		lec2.add(27);
		lec3.add(21);
		lec1.add(11);
		lec2.add(36);
		lec3.add(28);
		lec1.add(13);
		lec2.add(36);
		lec3.add(35);
		
		o._classes.add(lec1);
		o._classes.add(lec2);
		o._classes.add(lec3);
		
		
		return o;	
	}
	
	@Test
	void containsTest() {
		EquivalenceClasses<Integer> o = build();
		System.out.println(o._classes.toString());
		
		//Checks for containment of values that are elements 
		assertTrue(o.contains(5));
		assertTrue(o.contains(27));
		assertTrue(o.contains(21));
		
		//Checks for invalid values
		assertFalse(o.contains(52));
		assertFalse(o.contains(23));
		
	}
	
	@Test
	void sizeTest() {
		EquivalenceClasses<Integer> o = build();
		
		//Checks size
		assertTrue(o.size() == 9);
		
		//Adds one more, then checks again
		o.add(13);
		assertTrue(o.size() == 10);
		
		//Adds another valid, then attempts an invalid add
		o.add(81); // should work
		o.add(6); // shouldn't work
		assertTrue(o.size() == 11);
		
		//Tests adding null value
		o.add(null);
		assertTrue(o.size() == 11);		

	}
	
	@Test
	void numClassesTest() {
		EquivalenceClasses<Integer> o = build();
		
		//Checks number of classes after build
		assertTrue(o.numClasses() == 3);
		
		//Creates a new class, then adds it to the _classes variable, testing it after
		LinkedEquivalenceClass<Integer> lec4 = new LinkedEquivalenceClass<Integer>(c4);
		lec4.add(11);
		lec4.add(22);
		o._classes.add(lec4);
		assertTrue(o.numClasses() == 4);
	}

}
