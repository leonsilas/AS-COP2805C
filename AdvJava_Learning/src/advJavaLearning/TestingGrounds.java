package advJavaLearning;

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class TestingGrounds {

	public static void main(String[] args) {
	      Scanner scnr = new Scanner(System.in);
	      String personName = "";
	      int counter = 1;
	      int youPosition = 0;

	      Queue<String> peopleInQueue = new LinkedList<String>();
	      
	      //initial list input
	      personName = scnr.nextLine();
	      while (!personName.equals("-1")) {
	    	  peopleInQueue.add(personName);
	    	  if (personName.equals("You"))
	    		  youPosition = counter;
	    	  counter++;         
	         personName = scnr.nextLine();
	      }
	      
	      //current program
	      System.out.println("Welcome to the ticketing service... ");
	      System.out.println("You are number " + youPosition + " in the queue.");
	      while (!peopleInQueue.peek().equals("You")) {
		      System.out.println(peopleInQueue.remove() + " has purchased a ticket.");
		      youPosition--;
		      System.out.println("You are now number " + youPosition);
	      }
	      
	      System.out.println("You can now purchase your ticket!");                               
	
	}//end of main

}//end of TestingGrounds
