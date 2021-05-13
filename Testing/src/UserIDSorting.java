import java.util.Scanner;
import java.util.ArrayList;

public class UserIDSorting {
   //		Write the partitioning algorithm - pick the middle element as the 
   //       pivot, compare the values using two index variables l and h (low and high), 
   //       initialized to the left and right sides of the current elements being sorted,
   //       and determine if a swap is necessary
   public static int partition(ArrayList<String> userIDs, int i, int k) {
	      int l;
	      int h;
	      int midpoint;
	      String pivot;
	      String temp;
	      boolean done;

	      /* Pick middle element as pivot */
	      midpoint = i + (k - i) / 2;
	      pivot = userIDs.get(midpoint);

	      done = false;
	      l = i;
	      h = k;

	      while (!done) {
	         /* Increment l while numbers[l] < pivot */
	         while (userIDs.get(l).compareTo(pivot) < 0) {
	            ++l;
	         }

	         /* Decrement h while pivot < numbers[h] */
	         while (userIDs.get(h).compareTo(pivot) > 0) {
	            --h;
	         }

	         /* If there are zero or one items remaining,
	            all numbers are partitioned. Return h */
	         if (l >= h) {
	            done = true;
	         } 
	         else {
	            /* Swap numbers[l] and numbers[h],
	               update l and h */
	            temp = userIDs.get(l);
	            userIDs.set(l, userIDs.get(h));
	            userIDs.set(h, temp);

	            ++l;
	            --h;
	         }
	      }

	      return h;
   
   }

   //		Write the quicksort algorithm that recursively sorts the low and 
   //       high partitions
   public static void quicksort(ArrayList<String> userIDs, int i, int k) {
	      int j;

	      /* Base case: If there are 1 or zero entries to sort,
	       partition is already sorted */
	      if (i >= k) {
	         return;
	      }

	      /* Partition the data within the array. Value j returned
	         from partitioning is location of last item in low partition. */
	      j = partition(userIDs, i, k);

	      /* Recursively sort low partition (i to j) and
	         high partition (j + 1 to k) */
	      quicksort(userIDs, i, j);
	      quicksort(userIDs, j + 1, k);
   }

   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);

      ArrayList<String> userIDList = new ArrayList<String>();

      String userID;

      userID = scnr.next();
      while (!userID.equals("-1")) {
         userIDList.add(userID);
         userID = scnr.next();
      }
      
      // Initial call to quicksort 
      quicksort(userIDList, 0, userIDList.size() - 1);

      for (int i = 0; i < userIDList.size(); ++i) {
         System.out.println(userIDList.get(i));
      }
   }
}

