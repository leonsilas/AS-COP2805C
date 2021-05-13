package chapter1Labs;

import java.util.Scanner;

public class WhatOrder <TheType extends Comparable<TheType>> {
	
	public static <TheType extends Comparable<TheType>> int checkOrder(TheType var1, TheType var2, TheType var3, TheType var4){
			if (var1.compareTo(var2) < 0 && var2.compareTo(var3) < 0 && var3.compareTo(var4) < 0)
				return -1;
			else if (var1.compareTo(var2) > 0 && var2.compareTo(var3) > 0 && var3.compareTo(var4) > 0)
				return 1;
			else
				return 0;
	  	}//end of checkOrder
	  
	  public static void main(String[] args) {
	      Scanner scnr = new Scanner(System.in);
	
	      // Check order of four strings
	      System.out.println("Order: " + checkOrder(scnr.next(), scnr.next(), scnr.next(), scnr.next())); 
	
	      // Check order of four doubles
	      System.out.println("Order: " + checkOrder(scnr.nextDouble(), scnr.nextDouble(), scnr.nextDouble(), scnr.nextDouble()));
	      
	  }//end of main
   
}//end of WhatOrder
      
