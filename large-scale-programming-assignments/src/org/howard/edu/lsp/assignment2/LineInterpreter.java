package org.howard.edu.lsp.assignment2;
import java.util.Scanner; 

class LineInterpreter {
	
	/**
	 * This is a method that prompts user for a typed line of integers, each
	 * separated by a space. The sum and product of all the numbers is calculated and returned.
	 * 
	 * This process repeats while(true).
	 * Once user types "Goodbye", program is terminated. 
	 */
	
  public static void main(String[] args) {
	
    while(true){
    Scanner enterStr = new Scanner(System.in);         //Scanner input opened.
    String breakCondition = "Goodbye";                //Break Condition defined.

    System.out.println("String?"); 
    String[] tokens = enterStr.nextLine().split(" ");
    //enterStr.close();                                //Scanner input is closed.
    
    //If user entered "Goodbye" the program terminates.
    if (tokens[0].equals(breakCondition)){break;}  

    System.out.println("Tokens:");
    int sum = 0;                        //Sum variable initialized to 0.
    int product = 1;                    //Product variable initialized to 1.
    
    //Prints out each integer and calculates the Sum + Product.
    for(int i = 0;i<tokens.length; i++){
      System.out.println(tokens[i]);
      sum= Integer.parseInt(tokens[i]) + sum;
      product = Integer.parseInt(tokens[i]) * product;
    }
    
    //Print out of the Sum and Product.
    System.out.println("Sum: " + sum);
    System.out.println("Product: " + product);

   
    }
  }
}