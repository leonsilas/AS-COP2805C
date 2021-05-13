/********************************************************************************************************
 * Written By..: Leon Silas
 * Date Written: 4/2/21
 * Purpose.....: Show use of Linked Lists and Queues with concert test case.
 ********************************************************************************************************/

import java.util.ArrayList;

public class ConcertTicketsTest {
    public static void main(String[] args) {
        ArrayList<String> listOfPeople = new ArrayList<String>();

        //adding list of people to queue
		listOfPeople.add("Moira");
		listOfPeople.add("Roland"); //will be removed
		listOfPeople.add("Stevie");
		listOfPeople.add("Trevor");
		listOfPeople.add("Ricky");  //will be removed
		listOfPeople.add("Ronnie");
		listOfPeople.add("Lucy");
		listOfPeople.add("Patrick");
		listOfPeople.add("Gail");
		listOfPeople.add("David");
		listOfPeople.add("Wayne");
		listOfPeople.add("Alexis");		
		listOfPeople.add("Sarah");
		listOfPeople.add("Julian");
		listOfPeople.add("Stuart");

        ConcertTickets ct= new ConcertTickets(listOfPeople);
        
        //scalpers
        ct.removeFromLine("Ricky");
        ct.removeFromLine("Roland");

        //raffle winner
        ct.insertInFront("Twyla");

        //showing 10 people in line, and rest on waiting list
        System.out.println("Waitinglist: " + ct.printWaitlist());
        System.out.println("Ticketholders: " + ct.listTicketHolders());
        
    }
}
