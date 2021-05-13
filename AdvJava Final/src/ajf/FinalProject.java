/* WRITTEN BY: Leon Silas
 * WRITTEN ON: 22/04/21
 * PURPOSE: Final Project
 * NOTE: This is a joke.  I hope you enjoy and I await your project outline :)
 */

package ajf;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FinalProject {

	public static void main(String[] args) {
		Integer i = 1400;
		HashSet<Integer> employeeCodes = new HashSet<Integer>();
		Queue<Integer> customerNums = new LinkedList<Integer>();
		employeeCodes.add(i);
		employeeCodes.remove(1400);
		//System.out.println(employeeCodes.toString());
		customerNums.add(5);

		customerNums.add(2);

		customerNums.add(6);

		customerNums.remove();

		customerNums.remove();

		
		countNum(5);


	}//end of main
	
	   public static void countNum(int num) {

		      if (num <= 0) {

		         System.out.println("Done");

		      }

		      else {

		         System.out.print(num + " ");

		         countNum(num - 2);

		      }

		   }

}//end of FinalProject
