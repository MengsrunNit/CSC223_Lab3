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
	void removeCanonicalTest(){
		LinkedEquivalenceClass<Integer> lec = buildPrime();
		assertEquals (7, lec.canonical());
		assertTrue (lec.removeCanonical());
		assertEquals (null, lec.canonical());
		assertTrue (lec.removeCanonical());
		assertEquals (null, lec.canonical());
		lec.add(8);
		lec.add(47);
		assertEquals(8, lec.canonical());
		assertTrue(lec.removeCanonical());
		lec.add(-42);
		assertEquals (-42, lec.canonical());
		
	}
	@Test
	void AddTest() {
		LinkedEquivalenceClass<Integer> lec = new LinkedEquivalenceClass<Integer>(c);
		assertTrue (lec.isEmpty());
		assertTrue (lec.add(53));
		assertTrue (lec.add(59));
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