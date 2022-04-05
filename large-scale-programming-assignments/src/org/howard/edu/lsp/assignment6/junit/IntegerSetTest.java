package org.howard.edu.lsp.assignment6.junit;

import org.howard.edu.lsp.assignment6.integerset.IntegerSet;
import org.howard.edu.lsp.assignment6.integerset.IntegerSetException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class IntegerSetTest {
	
	/**
	 * This is the junit test cases for the IntegerSet
	 */
	
	@Test
	@DisplayName("Test case for equals")
	public void testEquals() {
		//JUnit test cases for checking whether a set equals another
		IntegerSet testSet1 = new IntegerSet();
		IntegerSet testSet2 = new IntegerSet();
		assertTrue(testSet2.equals(testSet1));
		
		testSet1.add(90);
		testSet1.add(56);
		assertFalse(testSet2.equals(testSet1));
		
		testSet2.add(90);
		testSet2.add(56);
		assertTrue(testSet2.equals(testSet1));		
	}
	
	@Test
	@DisplayName("Test case for clear")
	public void testClear() {
		//JUnit test cases for clearing a set
		IntegerSet testSet = new IntegerSet();
		assertTrue(testSet.isEmpty());
		
		testSet.add(5);
		assertFalse(testSet.isEmpty());
		
		testSet.clear();
		assertTrue(testSet.isEmpty());
	}
	
	@Test
	@DisplayName("Test cases for toString method")
	public void testTo_String() {
		//JUnit test cases for if a set is converted to a string
		IntegerSet testSet = new IntegerSet();
		
		testSet.add(20);
		testSet.add(40);
		testSet.add(60);
		assertEquals(testSet.toString(), "20, 40, 60");
	}
	
	
	@Test
	@DisplayName("Test case for length")
	public void testLength() {
		//JUnit test cases for the length of a set
		IntegerSet testSet = new IntegerSet();
		testSet.add(20);
		testSet.add(40);
		testSet.add(80);
		testSet.add(25);
		testSet.add(49);
		testSet.add(12);
		testSet.add(59);
		assertEquals(testSet.length(), 7);
		assertFalse(testSet.length() == 0);
		
		testSet.clear();
		assertTrue(testSet.length() == 0);
	}
	
	@Test
	@DisplayName("Test case for remove")
	public void testRemove() throws Exception {
		//JUnit test cases for removing a number from a set
		IntegerSet testSet = new IntegerSet();
		
		testSet.add(80);
		testSet.add(100);
		assertEquals(testSet.length(), 2);
		
		testSet.remove(100);
		assertEquals(testSet.length(), 1);
		assertFalse(testSet.contains(100));
	}
	
	
	@Test
	@DisplayName("Test case for remove exception throw")
	public void testRemove_throwsException(){
		//JUnit test cases for removing a number exception throw for empty set
		IntegerSet testSet = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, () -> {
			testSet.remove(800); 
		});
		
		String expected = "This set is empty";
		String actual = exception.getMessage();
		assertEquals(actual,expected);
	}
	
	@Test
	@DisplayName("Test case for contains")
	public void testContains() {
		//JUnit test cases for seeing if a set contains a provided number
		IntegerSet testSet = new IntegerSet();
		assertFalse(testSet.contains(0));
		
		testSet.add(0);
		assertTrue(testSet.contains(0));
		assertFalse(testSet.contains(20));
		
		testSet.add(100);
		testSet.add(4);
		assertFalse(testSet.contains(400));
		assertTrue(testSet.contains(100));
		assertTrue(testSet.contains(4));
	}
	
	
	@Test
	@DisplayName("Test case for largest")
	public void testLargest() throws Exception{
		//JUnit test cases for finding the largest number in a set
		IntegerSet testSet = new IntegerSet();
		
		testSet.add(20);
		testSet.add(40);
		testSet.add(60);
		assertEquals(60, testSet.largest());
	}
	
	
	@Test
	@DisplayName("Test case for largest exception throw")
	public void testLargest_throwsException(){
		//JUnit test cases for largest exception with empty set
		IntegerSet testSet = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, () -> {
			testSet.largest(); 
		});
		
		String expected = "This set is empty";
		String actual = exception.getMessage();
		assertEquals(actual,expected);
	}
	
	
	@Test
	@DisplayName("Test case for smallest")
	public void testSmallest() throws Exception{
		//JUnit test cases for finding the smallest number in a set
		IntegerSet testSet = new IntegerSet();
		
		testSet.add(20);
		testSet.add(40);
		testSet.add(60);
		assertEquals(20, testSet.smallest());
	}
	
	
	@Test
	@DisplayName("Test case for smallest exception throw")
	public void testSmallest_throwsException(){
		//JUnit test cases for smallest exception with empty set
		IntegerSet testSet = new IntegerSet();
		Exception exception = assertThrows(IntegerSetException.class, () -> {
			testSet.smallest(); 
		});
		
		String expected = "This set is empty";
		String actual = exception.getMessage();
		assertEquals(actual,expected);
	}
	
	
	@Test
	@DisplayName("Test case for add")
	public void testAdd() {
		//JUnit test cases for adding numbers to a set
		IntegerSet testSet = new IntegerSet();
		assertEquals(testSet.length(),0);
		
		testSet.add(20);
		testSet.add(40);
		testSet.add(60);
		assertEquals(testSet.length(),3);
		assertTrue(testSet.contains(20));
		assertTrue(testSet.contains(40));
		assertTrue(testSet.contains(60));
		
	}
	
	@Test
	@DisplayName("Test case for difference")
	public void testDifference() {
		//JUnit test cases for subtracting sets
		IntegerSet testSet1 = new IntegerSet();
		IntegerSet testSet2 = new IntegerSet();
		IntegerSet testSet3 = new IntegerSet();
		
		testSet1.add(20);
		testSet1.add(40);
		testSet1.add(60);
		testSet1.add(80);
		
		testSet2.add(20);
		testSet2.add(60);
		testSet2.add(80);
		
		testSet3.add(40);
		
		testSet1.diff(testSet2);
		assertTrue(testSet1.equals(testSet3));
		assertTrue(testSet1.contains(40));
		assertFalse(testSet1.contains(20));
	}
	
	
	
	@Test
	@DisplayName("Test case for intersect")
	public void testIntersect() {
		//JUnit test cases for the intersection between two sets
		IntegerSet testSet1 = new IntegerSet();
		IntegerSet testSet2 = new IntegerSet();
		IntegerSet testSet3 = new IntegerSet();
		
		testSet1.add(20);
		testSet1.add(40);
		testSet1.add(60);
		testSet1.add(80);
		
		testSet2.add(60);
		testSet2.add(80);
		testSet2.add(100);
		
		testSet3.add(60);
		testSet3.add(80);
		
		testSet1.intersect(testSet2);
		assertTrue(testSet1.equals(testSet3));
		assertFalse(testSet1.equals(testSet2));
	}
	
	
	@Test
	@DisplayName("Test case for union")
	public void testUnion() {
		//JUnit test cases for the union of sets into one
		IntegerSet testSet1 = new IntegerSet();
		IntegerSet testSet2 = new IntegerSet();
		IntegerSet testSet3 = new IntegerSet();
		
		testSet3.add(98);
		testSet3.add(70);
		testSet3.add(89);
		
		testSet1.add(98);
		testSet2.add(70);
		testSet2.add(89);
		testSet1.union(testSet2);
		assertTrue(testSet1.equals(testSet3));
	}
	
	
	@Test
	@DisplayName("Test cases for isEmpty")
	public void testIsEmpty() {
		//JUnit test cases for if a set is empty
		IntegerSet testSet = new IntegerSet();
		assertTrue(testSet.isEmpty());
		
		testSet.add(40);
		assertFalse(testSet.isEmpty());
		
	}
	
}
