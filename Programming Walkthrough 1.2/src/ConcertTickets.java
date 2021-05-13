import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ConcertTickets {

	private ArrayList<String> listOfPeople1;
	private LinkedList<String> mainLine = new LinkedList<String>();
	private Queue<String> waitList = new LinkedList<String>();

	public ConcertTickets(ArrayList<String> listOfPeople) {
		listOfPeople1 = listOfPeople;
	}
	
	public void removeFromLine(String person) {
		listOfPeople1.remove(person);
	}
	
	public void insertInFront(String person) {
		listOfPeople1.add(0, person);
	}
	
	public Queue<String> printWaitlist() {
		for (int i = 10; i < listOfPeople1.size(); i++)
			waitList.add(listOfPeople1.get(i));
		return waitList;
	}
	
	public LinkedList<String> listTicketHolders() {
		for (int i = 0; i < 10; i++)
			mainLine.add(listOfPeople1.get(i));
		return mainLine;
	}	
	
}//end of class
