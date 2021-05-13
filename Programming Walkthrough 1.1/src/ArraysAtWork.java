/********************************************************************************************************
 * Written By..: Leon Silas
 * Date Written: 4/2/21
 * Purpose.....: Show use of Generics, Interfaces, Objects, and Arrays.
 ********************************************************************************************************/

public class ArraysAtWork {

	public static void main(String[] args) {

		//initializing arrays (you could take user input for any size array and this should work)
		Integer[] array1 = {1, 2, 3, 4};
		Double[] array2 = {10.1, 11.2, 12.3, 3.14};
		String[] array3 = {"nah", "yes", "no", "nope"};
		
		//creating finders for arrays with the thing you want to find
		indexFinder<Integer> arrayInts = new indexFinder<Integer>(array1, 1);
		indexFinder<Double> arrayDoubles = new indexFinder<Double>(array2, 3.14);
		indexFinder<String> arrayStrings = new indexFinder<String>(array3, "yes");
		
		//testing index method output
		System.out.println("Index for Ints found at: " + arrayInts.findIndex());
		System.out.println("Index for Doubles found at: " + arrayDoubles.findIndex());
		System.out.println("Index for Strings found at: " + arrayStrings.findIndex());
		
	}//end of main

}//end of class
