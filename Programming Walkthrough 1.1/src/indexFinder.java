
public class indexFinder <TheType extends Comparable<TheType>> {
	
	private TheType[] array1;
	private TheType item1;
	
	public indexFinder(TheType[] array, TheType item) {
		array1 = array;
		item1 = item;
	}

	public int findIndex() {
		int indexValue = 0;
		
		for (int i = 0; i < array1.length; i++) {
			if (array1[i].compareTo(item1) == 0) {
				indexValue = i;
				return indexValue;
			}
		}//end for loop
		
		return indexValue;
	}//end findIndex
	
}//end whichIndex
