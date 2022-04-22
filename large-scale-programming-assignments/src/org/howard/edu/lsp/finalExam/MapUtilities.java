package org.howard.edu.lsp.finalExam;

import java.util.HashMap;
import java.util.Map;


public class MapUtilities {
	/**
	 * To count how many key/value pairs two HashMaps have in common. ; 
	 * 
	 */
	public static int commonKeyValuePairs(
	        HashMap<String, String> map1,
	        HashMap<String, String> map2)throws NullMapException {
		if (map1 == null || map2 == null) {
			throw new NullMapException("One or both maps are null!");
		}
		
		int count = 0;
		
		for (Map.Entry<String, String> mapElement : map1.entrySet()) {
			String key = mapElement.getKey();
			String value1 = mapElement.getValue();
			if (map2.containsKey(key)) {
				String value2 = map2.get(key);
				if (value1.equals(value2)) {count++;}
			}
			}
		return count;
		
	
 }

}
