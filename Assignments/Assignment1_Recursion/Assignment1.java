
public class Assignment1 {
	/**
	 * Uses recursion to find the number of k combinations with elements c.
	 *
	 * @param n An integer representation of the total number of elements
	 * @param k An integer representation of the number of subsets of a set of n elements
	 * @return An integer representation of the total number of k combinations with elements c
	 */
	public static int c(int n, int k) {
		//Base Case
		if(k == 0 || n == k) {
			System.out.println("c(" + n + "," + k + ") = 1");
			return 1;
		}
		//Recursive Case
		else {
			System.out.println("c("+ n + "," + k + ") = c(" + (n-1) + "," + (k-1) + ") + c(" + (n-1) + "," + k + ")");
			return c(n-1, k-1) + c(n-1, k);
			
		}
	}
	/**
	 * Problem: Organizing a Parade
	 * A parade is made up of floats and bands. However, no two bands can be next to each other. This method
	 * returns the total number of possible combinations that can be made with n, floats and bands.
	 * 
	 * @param n The total number of floats and bands combined
	 * @return The total number of arrangements that are possible
	 */
	public static int P(int n) {
		if (n == 1) //Base Case 1. If only 1 object is in the parade, the two possible permutations are 1 float or 1 band: P = {(F), (B)}
			return 2;
		if (n == 2) //Base Case 2. If only 2 objects are in the parade, the 3 possible permutations are FF, FB, BF. BB is not possible since two bands cannot be next to each other
			return 3;
		else
			return P(n-1) + P(n-2); //Recursive case
	}
	/**
	 * This method uses recursion to print a user-specified character, ch, n times
	 * 
	 * @param ch A char representation of the character to be printed
	 * @param n An integer representation of the number of characters to be printed
	 */
	public static void writeLine(char ch, int n) {
		if (n == 1) // Base Case (Only 1 char to be printed)
			System.out.println(ch);
		else {
			System.out.print(ch); // Recursive case
			writeLine(ch, n-1);
		}
	}
	/**
	 * This method uses recursion to print m lines of a user-specified character, ch, n times
	 * 
	 * @param ch A char representation of the character to be printed
	 * @param n An integer representation of the number of characters to be printed
	 * @param m An integer representation of the number of lines to be printed
	 */
	public static void writeBlock(char ch, int n, int m) {
		if(m == 1) //Base Case (only 1 line to be printed)
			writeLine(ch, n);
		else {
			writeBlock(ch, n, m - 1); //Recursive Case
			writeLine(ch, n);
		}
	}
	/**
	 * This method uses recursion to print a number in reverse order
	 * 
	 * @param number An integer representation of the number to be printed backwards
	 */
	public static void reverseDigits(int number) {
		if (number < 10) // Base case 
			System.out.println(number); 
		else { //Recursive case
			System.out.print(number % 10);
	        reverseDigits(number/10);
		}
	}
	/**
	 * This method uses recursion to find the index of a given value in an lexicographically ordered array of strings
	 * Precondition: 0 <= first, last <= SIZE-1
	 * 
	 * @param anArray A lexicographically ordered array of strings (Array must be sorted!)
	 * @param first The first index that brackets the value
	 * @param last The last index that brackets the value
	 * @param value A string representation of the value being searched for
	 * @return An integer representation of the index of the value. If the value is not found returns -1.
	 */
	public static int myBinarySearch(String[] anArray, int first, int last, String value) {
		int index;
		if (first > last) //Base Case 1
			return -1; //value not in original array
		else {
			int mid = (first + last)/2;
			if (value.equals(anArray[mid]))   //Base Case 2
				index = mid;  //value found at anArray[mid]
			else if (value.compareTo(anArray[mid]) < 0)
				index = myBinarySearch(anArray, first, mid - 1, value); //Recursive Case
			else 
				index = myBinarySearch(anArray, mid + 1, last, value); //Recursive Case
		}
		return index;
		// end binary search
					
	}
	
	public static void main(String[] args) {
		
		System.out.println(c(3,2));
		writeLine('*', 5);
		writeBlock('*', 5, 3);
		reverseDigits(123);
		String[] myArray = {"apples","bananas", "cats"};
		System.out.println(myBinarySearch(myArray, 0, myArray.length, "cats"));
		
	}

}
