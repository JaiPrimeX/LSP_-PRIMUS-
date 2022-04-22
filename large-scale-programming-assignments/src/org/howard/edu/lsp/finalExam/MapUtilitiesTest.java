package org.howard.edu.lsp.finalExam;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.HashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MapUtilitiesTest {
	
	/**
	 * This is the junit test cases for MapUtilities.
	 */
	
	@Test
	@DisplayName("Test case both empty maps return 0")
	public void testBothEmpty() throws NullMapException{
		//JUnit test cases for both maps being empty and returning 0
		HashMap<String, String> map1 = new HashMap<>();
		
		HashMap<String, String> map2 = new HashMap<>();
		
		int actual = MapUtilities.commonKeyValuePairs(map1, map2);
		int expected = 0;
		assertEquals(actual,expected);
	}
	
	@Test
	@DisplayName("Test case for map1 null - exception throw")
	public void testNullMap1_throwsException(){
		//JUnit test cases for null Map1 value
		HashMap<String, String> map1 = null;
		
		HashMap<String, String> map2 = new HashMap<>();
		map2.put("Mary","Ecastic");
		map2.put("Bob","Happy");
		map2.put("Tam","Fine");
		map2.put("Felix","Healthy");
		map2.put("Ricardo","Subperb");
		
		Exception exception = assertThrows(NullMapException.class, () -> {
			MapUtilities.commonKeyValuePairs(map1, map2);
		});
		
		String expected = "One or both maps are null!";
		String actual = exception.getMessage();
		assertEquals(actual,expected);
	}
	
	@Test
	@DisplayName("Test case for map2 null - exception throw")
	public void testNullMap2_throwsException(){
		//JUnit test cases for null Map2 value
		HashMap<String, String> map1 = new HashMap<>();
		map1.put("Alice","Healthy");
		map1.put("Mary","Ecastic");
		map1.put("Bob","Happy");
		map1.put("Chuck","Fine");
		map1.put("Felix","Sick");
		
		HashMap<String, String> map2 = null;
		Exception exception = assertThrows(NullMapException.class, () -> {
			MapUtilities.commonKeyValuePairs(map1, map2);
		});
		
		String expected = "One or both maps are null!";
		String actual = exception.getMessage();
		assertEquals(actual,expected);
	}
	
	@Test
	@DisplayName("Test case for both map1 + map2 null - exception throw")
	public void testNullBoth_throwsException(){
		//JUnit test cases for null Map2 value
		HashMap<String, String> map1 = null;
		
		HashMap<String, String> map2 = null;
		Exception exception = assertThrows(NullMapException.class, () -> {
			MapUtilities.commonKeyValuePairs(map1, map2);
		});
		
		String expected = "One or both maps are null!";
		String actual = exception.getMessage();
		assertEquals(actual,expected);
	}
	
	@Test
	@DisplayName("Test case for the same amount of key/value pairs in both map1 + map2")
	public void testEven() throws NullMapException{
		//JUnit test cases for even amount of key/value pairs
		HashMap<String, String> map1 = new HashMap<>();
		map1.put("Alice","Healthy");
		map1.put("Mary","Ecastic");
		map1.put("Bob","Happy");
		map1.put("Chuck","Fine");
		map1.put("Felix","Sick");
		
		HashMap<String, String> map2 = new HashMap<>();
		map2.put("Mary","Ecastic");
		map2.put("Bob","Happy");
		map2.put("Tam","Fine");
		map2.put("Felix","Healthy");
		map2.put("Ricardo","Subperb");
		
		int actual = MapUtilities.commonKeyValuePairs(map1, map2);
		int expected = 2;
		assertEquals(actual,expected);
	}
	
	@Test
	@DisplayName("Test case for less entries in Map1")
	public void testLessMap1() throws NullMapException{
		//JUnit test cases for less key/value pairs in Map1 than Map2
		HashMap<String, String> map1 = new HashMap<>();
		map1.put("Alice","Healthy");
		map1.put("Mary","Ecastic");
		map1.put("Chuck","Fine");
		
		HashMap<String, String> map2 = new HashMap<>();
		map2.put("Mary","Ecastic");
		map2.put("Bob","Happy");
		map2.put("Tam","Fine");
		map2.put("Felix","Healthy");
		map2.put("Ricardo","Subperb");
		
		int actual = MapUtilities.commonKeyValuePairs(map1, map2);
		int expected = 1;
		assertEquals(actual,expected);
	}
	
	@Test
	@DisplayName("Test case for less pairs in Map2")
	public void testLessMap2() throws NullMapException{
		//JUnit test cases for less key/value pairs in Map2 than Map1
		HashMap<String, String> map1 = new HashMap<>();
		map1.put("Alice","Healthy");
		map1.put("Mary","Ecastic");
		map1.put("Chuck","Fine");
		map1.put("Bob","Happy");
		map1.put("Felix","Healthy");
		
		HashMap<String, String> map2 = new HashMap<>();
		map2.put("Felix","Sad");
		map2.put("Chuck","Fine");
		map2.put("Bob","Happy");
		
		int actual = MapUtilities.commonKeyValuePairs(map1, map2);
		int expected = 2;
		assertEquals(actual,expected);
	}
	
	@Test
	@DisplayName("Test case for all matching in Map1 + Map2")
	public void testAllMatch() throws NullMapException{
		//JUnit test cases for all key/value pairs in Map1 and Map2 matching
		HashMap<String, String> map1 = new HashMap<>();
		map1.put("Alice","Healthy");
		map1.put("Mary","Ecastic");
		map1.put("Chuck","Fine");
		map1.put("Bob","Happy");
		map1.put("Felix","Sad");
		map1.put("Bernard","Satisfied");
		map1.put("James","Angry");
		
		HashMap<String, String> map2 = new HashMap<>();
		map2.put("Felix","Sad");
		map2.put("Chuck","Fine");
		map2.put("Bob","Happy");
		map2.put("Alice","Healthy");
		map2.put("Mary","Ecastic");
		map2.put("Bernard","Satisfied");
		map2.put("James","Angry");
		
		int actual = MapUtilities.commonKeyValuePairs(map1, map2);
		int expected = 7;
		assertEquals(actual,expected);
	}
	
	@Test
	@DisplayName("Test case for no matching key/value in Map1 + Map2")
	public void testNoneMatch() throws NullMapException{
		//JUnit test cases for no matching key/value pairs in Map1 and Map2
		HashMap<String, String> map1 = new HashMap<>();
		map1.put("Alice","Hungry");
		map1.put("Mary","Excited");
		map1.put("Chuck","Furious");
		map1.put("Bob","Hopeful");
		map1.put("Felix","Shy");
		map1.put("Bernard","Sad");
		map1.put("James","Anxious");
		
		HashMap<String, String> map2 = new HashMap<>();
		map2.put("Felix","Sad");
		map2.put("Chuck","Fine");
		map2.put("Bob","Happy");
		map2.put("Alice","Healthy");
		map2.put("Mary","Ecastic");
		map2.put("Bernard","Satisfied");
		map2.put("James","Angry");
		
		int actual = MapUtilities.commonKeyValuePairs(map1, map2);
		int expected = 0;
		assertEquals(actual,expected);
	}
	

}
