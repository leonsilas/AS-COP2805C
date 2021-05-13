import java.util.Scanner;

public class MileageTrackerLinkedList {
   public static void main (String[] args) {
      @SuppressWarnings("resource")
	Scanner scnr = new Scanner(System.in);

      // References for MileageTrackerNode objects
      MileageTrackerNode headNode;                                           
      MileageTrackerNode currNode;
      MileageTrackerNode lastNode;

      double miles;
      String date;
      int i;

      // Front of nodes list                                                                         
      headNode = new MileageTrackerNode();
      lastNode = headNode;

      // Scan the number of nodes
      int numNodes = scnr.nextInt();
         
      // For the scanned number of nodes, scan
      // in data and insert into the linked list
         for (i = 0; i < numNodes; i++){
           miles = scnr.nextDouble();
           date = scnr.next();
           currNode = new MileageTrackerNode(miles, date);
            if (i == 0)
               headNode = currNode;
           lastNode.insertAfter(currNode);
           lastNode = currNode;
         } 

      // Call the printNodeData() method 
      // to print the entire linked list
         currNode = headNode;
         for (i = 0; i < numNodes; i++){
              currNode.printNodeData();
              currNode = currNode.getNext();
           } 

   }
}