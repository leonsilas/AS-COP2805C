package fibbseq;

public class SolveFibb {

	public static void main(String[] args) {
		//outputs
		long startTime = System.nanoTime();
		System.out.println("Recursive for 5 is: " + recursiveFib(5));
		System.out.println("Solved in: " + (System.nanoTime() - startTime) + " nanoseconds.");
		
		startTime = System.nanoTime();
		System.out.println("\n" + "Iterative for 5 is: " + iterativeFib(5));
		System.out.println("Solved in: " + (System.nanoTime() - startTime) + " nanoseconds.");
		
		startTime = System.nanoTime();
		System.out.println("\n" + "Recursive for 10 is: " + recursiveFib(10));
		System.out.println("Solved in: " + (System.nanoTime() - startTime) + " nanoseconds.");
		
		startTime = System.nanoTime();
		System.out.println("\n" + "Iterative for 10 is: " + iterativeFib(10));
		System.out.println("Solved in: " + (System.nanoTime() - startTime) + " nanoseconds.");
		
		startTime = System.nanoTime();
		System.out.println("\n" + "Recursive for 15 is: " + recursiveFib(15));
		System.out.println("Solved in: " + (System.nanoTime() - startTime) + " nanoseconds.");
		
		startTime = System.nanoTime();
		System.out.println("\n" + "Iterative for 15 is: " + iterativeFib(15));
		System.out.println("Solved in: " + (System.nanoTime() - startTime) + " nanoseconds.");
		
		startTime = System.nanoTime();
		System.out.println("\n" + "Recursive for 20 is: " + recursiveFib(20));
		System.out.println("Solved in: " + (System.nanoTime() - startTime) + " nanoseconds.");
		
		startTime = System.nanoTime();
		System.out.println("\n" + "Iterative for 20 is: " + iterativeFib(20));
		System.out.println("Solved in: " + (System.nanoTime() - startTime) + " nanoseconds.");

	}//end of main
	
	public static int recursiveFib(int n) {	
		//base case
		if (n <= 1)
			return n;
		
		return recursiveFib(n-1) + recursiveFib(n-2);
	}//end recursiveFib 
	
	public static int iterativeFib(int n) {
		int numOne = 0;
		int numTwo = 1;
		int numSum = 0;
		int foundResult;
		
		//checks for non-usable value
		if (n <= 0)
			return 0;
		
		//iterative loop to calculate value
		for (int i = 2; i <= n; i++) {
			numSum = numOne + numTwo;
			numOne = numTwo;
			numTwo = numSum;
		}
		
		//for visual simplicity
		foundResult = numTwo;
		return foundResult;
	}

}// end of SolveFibb
