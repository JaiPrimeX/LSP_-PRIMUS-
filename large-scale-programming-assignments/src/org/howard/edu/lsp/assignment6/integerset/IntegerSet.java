package org.howard.edu.lsp.assignment6.integerset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * An Integer Set Object;
 * 
 * An <code>IntegerSet<code> object contains the parameters and functionality
 * of a set of integers; 
 * 
 * @author Jailynn Primus;
 * 
 */
public class IntegerSet {
	
	private List<Integer> set = new ArrayList<Integer>();
	
	/**
	 * Default Car Constructor; 
	 * 
	 */
	public IntegerSet() {
		this.set = set;
	};

	/**
	 * Clears the set of all values; 
	 * Makes a set empty;
	 * 
	 */
	public void clear() {
		set.clear();
	};

	/**
	 * Gets the amount of items within the set;
	 * 
	 * @return the length of set aka amount of items;
	 */
	public int length() {
		return set.size();
	}; 

	/**
	 * Returns true if the 2 sets are equal, false otherwise;
	 * Two sets are equal if they contain all of the same values in ANY order;
	 * 
	 * @param b the IntegerSet to check if equal to set;
	 * @return true or false whether set equals b;
	 */
	public boolean equals(IntegerSet b) {
		
		ArrayList<Integer> setB = (ArrayList<Integer>) b.set;
		
		if (set == null && setB == null) {
			return true;
		}
	    //Only one of them is null
	    else if(set == null || setB == null) {
	    	return false;
	    }
	    else if(this.length() != setB.size()) {
	    	return false;
	    }
	     
	    //copying to avoid rearranging original lists
	    ArrayList<Integer> setA = (ArrayList<Integer>) set;   
	  
	    Collections.sort(setA);
	    Collections.sort(setB);      
	     
	    return setA.equals(setB);
	}; 

	/**
	 * Returns true if the set contains the value, otherwise false;
	 * 
	 * @param value the number to check is inside of the set;
	 * @return true or false whether value is within set;
	 */
	public boolean contains(int value) {
		int length= set.size();
		for(int i=0; i<length; i++){
			if (set.get(i) == value){
				return true;
			}
		}
		return false;
	};    

	/**
	 * Gets the largest value within the set;
	 * 
	 * @return the largest item in the set;
	 * @throws IntegerSetException if the set is empty;
	 */
	public int largest() throws IntegerSetException {
		if (set.size() == 0) {
			throw new IntegerSetException("This set is empty");
		}
		return Collections.max(set);
	}; 

	/**
	 * Gets the smallest value within the set;
	 * 
	 * @return the smallest item in the set;
	 * @throws IntegerSetException if the set is empty;
	 */
	public int smallest() throws IntegerSetException{
		if (set.size() == 0) {
			throw new IntegerSetException("This set is empty");
		}
		return Collections.min(set);
	};


	/**
	 * Adds an item to the set or does nothing it already there;
	 * 
	 * @param item the value being added to the set;
	 */
	public void add(int item) {
		 if (set.contains(item)) {
			 return;
		 }
		 set.add(item);
	 };

	/**
	 * Removes an item from the set or does nothing if not there
	 * 
	 * @param item the value being removed from the set;
	 * @throws IntegerSetException if the set is empty;
	 */
	public void remove(int item) throws IntegerSetException{
		if (set.size() == 0) {
			throw new IntegerSetException("This set is empty");
		}
		else if (set.contains(item)) {
			set.remove(Integer.valueOf(item));
		} 
	}; 

	/**
	 * Set union
	 * 
	 * @param intSetb the set being added to this.set;
	 */
	public void union(IntegerSet intSetb) {
		Set<Integer> temp = new HashSet<>();
		ArrayList<Integer> setB = (ArrayList<Integer>) intSetb.set;
		
		temp.addAll(set);
		temp.addAll(setB);
		
		set.clear();
		set.addAll(temp);
	};

	/**
	 * Set intersection
	 * 
	 * @param intSetb the set used for finding intersection with this.set;
	 */
	public void intersect(IntegerSet intSetb) {
		set.retainAll(intSetb.set);
	}; 

	/**
	 * Set difference, i.e., s1 –s2
	 * 
	 * @param intSetb the set used to find difference with this.set;
	 */
	public void diff(IntegerSet intSetb) {
		set.removeAll(intSetb.set);
	}; 

	/**
	 * Returns true if the set is empty, false otherwise;
	 * 
	 * @return true or false whether set is empty;
	 */
	public boolean isEmpty() {
		if (set.size() == 0){
			   return true;
		   }
		
		   return false;
	}; 

	/**
	 * Return String representation of your set
	 * 
	 */
	public String toString() {
		String setString = set.stream().map(Object::toString).collect(Collectors.joining(", "));   
		   
		   return setString;
	};


}

/**
 * REFERENCES USED FOR CODE COMPLETION:
 * 
 * https://www.javacodegeeks.com/2019/03/check-two-lists-are-equal-java.html
 * https://rollbar.com/guides/java/how-to-throw-exceptions-in-java/#:~:text=Throwing%20an%20exception%20is%20as,%2C%20server%2C%20backend%2C%20etc.
 * https://www.tutorialspoint.com/find-maximum-element-of-hashset-in-java#:~:text=To%20get%20the%20maximum%20element,max()%20method.
 * https://www.tutorialspoint.com/get-the-union-of-two-sets-in-java#:~:text=To%20get%20the%20union%20of,use%20the%20addAll()%20method.
 * https://www.tutorialspoint.com/get-the-intersection-of-two-sets-in-java
 * https://www.tabnine.com/code/java/methods/java.util.stream.Collectors/joining
 * https://www.youtube.com/watch?v=CAexSdMCuGg
 */
