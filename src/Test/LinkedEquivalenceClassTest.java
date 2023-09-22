package Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Comparator;
import org.junit.jupiter.api.Test;
import utilities.LinkedEquivalenceClass;
class LinkedEquivalenceClassTest {
		
	
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
		{ return x%9==x%9? 0:1;}
	};
	public LinkedEquivalenceClass<Integer> buildPrime(){
		LinkedEquivalenceClass<Integer> lec = new LinkedEquivalenceClass<Integer>(c);
		lec.add(7);
		lec.add(5);
		lec.add(4);
		lec.add(-7);
		lec.add(29);
		lec.add(14);
		lec.add(89);
		lec.add(1299709);
		lec.add(0);
		lec.add(42);
		return lec;
	}
	@Test
	void clearTest(){
		LinkedEquivalenceClass<Integer> lec1 = buildPrime();
		assertEquals (4, lec1.size());
		lec1.clear();
		assertEquals (null, lec1.canonical());
		LinkedEquivalenceClass<Integer> lec2 = new LinkedEquivalenceClass<Integer>(c2);
		
		lec2.add(7);
		lec2.add(49);
		
		
		
		
		assertEquals (7, lec2.canonical());
		lec2.clear();
		
		assertEquals(0, lec2.size());
		assertEquals (7, lec2.canonical());
		lec2.add(9);
		lec2.add(8);
		lec2.add(45);
		lec2.add(72);
		lec2.add(90);
		lec2.add(62);
		lec2.add(108);
		assertEquals (4, lec2.size());
		
	}
	@Test
	void removeCanonicalTest(){
		LinkedEquivalenceClass<Integer> lec = buildPrime();
		assertEquals(4, lec.size());
		assertEquals (7, lec.canonical());
		assertTrue (lec.removeCanonical());
		assertEquals (null, lec.canonical());
		lec.add(8);
		lec.add(47);
		assertEquals(8, lec.canonical());
		lec.clear();
		assertTrue (lec.add(-42));
		lec.add(-42);
		assertEquals (-42, lec.canonical());
		
	}
	@Test
	void AddTest() {
		LinkedEquivalenceClass<Integer> lec = new LinkedEquivalenceClass<Integer>(c);
		assertTrue (lec.isEmpty());
		assertTrue (lec.add(53));
		assertTrue (lec.add(59));
		System.out.println(lec);
		assertEquals (1, lec.size());
		assertFalse (lec.add(4));
		assertEquals (1, lec.size());
		lec.clear();
		assertTrue (lec.isEmpty());
	}
	@Test
	void CanonicalTest() {
		LinkedEquivalenceClass<Integer> lec = buildPrime();
		assertEquals (7, lec.canonical());
		lec.clear();
		assertEquals (null, lec.canonical());
		lec.add(-4);
		assertEquals (-4, lec.canonical());		
	}
	@Test
	void isEmptyTest() {
		LinkedEquivalenceClass<Integer> lec = buildPrime();
		assertFalse (lec.isEmpty());
		lec.clearNonCanonical();
		assertFalse (lec.isEmpty());
		lec.clear();
		assertTrue (lec.isEmpty());
	}
	@Test
	void demoteandsetCanoncialTest() {
//		LinkedEquivalenceClass<Integer> lec = buildPrime();
//		assertTrue (lec.demoteAndSetCanonical(2));
//		assertEquals (2, lec.canonical());
//		assertTrue (lec.demoteAndSetCanonical(89));
//		assertEquals (89, lec.canonical());
//		assertEquals (10, lec.size());
//		assertTrue (lec.demoteAndSetCanonical(4));
//		assertEquals (0, lec.size());
		
		
	}
}