package pw3;
import java.util.*;

public class Walkthrough3 {

	public static void main(String[] args) {
		/* Do some research on "auto-boxing." What is auto-boxing, and why it is useful? Give an example of a use case. 
		 * 		- Auto-boxing is converting a primative value into an object using it's wrapper class.  We've seen this in Generics.
		 * 		- For example, when using a List, you can't pass through int, you use Integer instead, but you can still add int's to it.*/
		
		/*Write a few lines of code that auto-box an int into an Integer, and un-box an Integer to an int.*/
			Integer boxedInt = new Integer(13);
			int unboxedInteger = boxedInt;
			System.out.println(boxedInt + " is the same as " + unboxedInteger + "\n");
			
		/* Declare an ArrayList of Strings. Add 5 names to the collection. 
		 * Output the Strings onto the console using an enhanced for loop.*/
			ArrayList<String> stringList = new ArrayList<String>();
				stringList.add("Coconut Mall");
				stringList.add("Inkopolis Square");
				stringList.add("Station Square");
				stringList.add("Mira HQ");
				stringList.add("Stardew Valley");
			for (String name : stringList)
				System.out.println(name);
		
		/* Take a few minutes to examine the Java Collections API. Shuffle your list using a method from the API. 
		 * Output the shuffled List.  Sort the list, and output the sorted list.*/
			Collections.shuffle(stringList);
			System.out.println("\nShuffled List: \n" + stringList);
			Collections.sort(stringList);
			System.out.println("\nSorted List: \n" + stringList);
		
		/* Note that Collections (with an s) is a class, while Collection is an interface. What does this difference mean to you?
		 * 		- Collections as a class is something that I can use in my code, such as with taking a method to shuffle my list.
		 * 		- Collection as an interface means I'm implementing it into a class of my own in the code.  That s is a huge difference! */
		
		/* Search for a name that can be found in your list.  In which location was it found?  
		 * Search for a name that is not in the list. What location is reported?*/
			 int stringIndex = Collections.binarySearch(stringList, "Station Square");       
	         System.out.println("\nStation Square is at index " + stringIndex); 
		
	         int stringIndexNotFound = Collections.binarySearch(stringList, "Tomato Town");       
	         System.out.println("\nTomato Town is at index " + stringIndexNotFound);  //it is found at -6 since it would be inserted at 5
	         																		  //and binarySearch returns (-5-1) or -6
		
		/*Describe why an equals method and a compareTo method are required to achieve searching and sorting of the elements of a list. 
		 * What is the difference, and how might you use each
		 * 		- Both equals and compareTo can determine if two objects are the same.  (Equals returns a boolean while compareTo returns an int)
		 * 		- CompareTo also can show the ordering between objects with showing if it less than, equal to, or greater than.
		 * 		- I'd use compareTo for sorting and equals for searching since equals will show a true and compareTo can be better used for sorting.
		 * 		- Without either of them you couldn't search or sort at all, so they're very important!*/
		
		/* Convert your ArrayList to an array using toArray(). Output the elements of the array.  
		 * Convert the array back into a list using asList(). Output the elements of the ArrayList.*/
	         Object[] array = stringList.toArray();
	         System.out.println("\nList to Array: \n" + Arrays.toString(array));
	         
	         List<Object> objectList = Arrays.asList(array);
	         System.out.println("\nArray to List: \n" + objectList);
		
		

	}

}
