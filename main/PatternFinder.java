// Christian Ortiz
package main;

import util.*;
import util.ArithmeticException;

import java.util.*;

/**
 * This class finds patterns in a randomly generated string
 */

public class PatternFinder {

	/**
	 * This method generates a string made of randomly generated lowercase letters of int 'length'
	 */
    private static String randomStringGenerator(int length) {
	Random random = new Random(System.nanoTime());
	char[] array = new char[length];
	for (int i = 0; i < length; i++)
	    array[i] = (char) ('a' + random.nextInt(26));
	return new String(array);
    }

	/**
	 * This method takes the string parameter 'mine' and looks for singleton patterns of int 'length' given by parameter
	 */
    private static void singletonMiner(String mine, int length) throws SingletonException{
	for (int start = 0; start <= mine.length() - length; start++) {
	    int i;
	    for (i = start + 1; i < start + length; i++)
		if (mine.charAt(i) != mine.charAt(i - 1))
		    break;
	    if (i == start + length)
		throw new SingletonException(mine.substring(start, start + length), start);
	}
    }

	/**
	 * This method takes the string parameter 'aString' and looks for alphabetic arithmetic patterns of int 'length' given by parameter
	 */
	private static void arithmeticStringMiner(String aString, int length) throws ArithmeticException {
		char potentialNextLetter; // used to check what letter would come next alphabetically based on the current letter being checked
		char nextChar; // used to see the letter that is actually coming next in the string
		char currentChar;
		int counter = 1; // counts how many letters in a row are in alphabetic order
		String currentString = "";
		String currentBest = "";
		int start, end, beginningIndex = 0;
		int i;
		for (i = 0; i < aString.length() - length; i++) {
			//currentChar = aString.charAt(i);
			potentialNextLetter = (char) (aString.charAt(i) + 1); // equates to the next alphabetic letter based on the current letter being observed
			nextChar = (aString.charAt(i + 1)); // the actual next character in the string

			if (nextChar == potentialNextLetter) // if the next char is also alphabetically the next letter based on the current char
			{
				counter++;
				if(counter == 2) // if 2 letters are in order
				{
					beginningIndex = i; // we keep the index of the first letter, in case more letters are alphabetic and added to this, we know at what index it started
				}
				start = beginningIndex;
				end = start + counter;
				currentString = aString.substring(start, end); // make a substring from the letters in order
				if (counter < length) { // if the counter aka the current string length is less than the pattern length desired
					if (currentString.length() > currentBest.length()) { // if the current string is longer than our previous longest string in alphabetic order aka current best
						currentBest = currentString; // the current best aka current longest string equals the current string
					}
				}
				else if (counter == length)  // if the current string length is the same as our desired pattern length
				{
					currentBest = currentString;
					throw new ArithmeticException(currentBest, beginningIndex); // throw the exception
				}
			}
			else {
				counter = 1;
			}
		}
	}

	/**
	 * This method takes the string parameter 'aString' and looks for reverse alphabetic arithmetic patterns of int 'length' given by parameter
	 */
	private static void reverseArithmeticStringMiner(String aString, int length) throws ReverseArithmeticException {
		char potentialNextLetter; // used to check what letter would come next reverse alphabetically based on the current letter being checked
		char nextChar; // used to see the letter that is actually coming next in the string
		//char currentChar;
		int counter = 1;  // counts how many letters in a row are in reverse alphabetic order
		String currentString = "";
		String currentBest = "";
		int start, end, beginningIndex = 0;
		int i;
		for (i = 0; i < aString.length() - length; i++) {
			//currentChar = aString.charAt(i);
			potentialNextLetter = (char) (aString.charAt(i) - 1); // equates to the next reverse alphabetic letter based on the current letter being observed
			nextChar = (aString.charAt(i + 1)); // the actual next character in the string

			if (nextChar == potentialNextLetter) // if the next char is also reverse alphabetically the next letter based on the current char
			{
				counter++;

				if(counter == 2) // if 2 letters are in order
				{
					beginningIndex = i; // we keep the index of the first letter, in case more letters are reverse alphabetic and added to this, we know at what index it started
				}
				start = beginningIndex;
				end = start + counter;
				currentString = aString.substring(start, end);  // make a substring from the letters in order
				if (counter < length) { // if the counter aka the current string length is less than the pattern length desired
					if (currentString.length() > currentBest.length()) { // if the current string is longer than our previous longest string in reverse alphabetic order aka current best
						currentBest = currentString; // the current best aka current longest string equals the current string

					}
				}
				else if (counter == length)  // if the current string length is the same as our desired pattern length
				{
					currentBest = currentString;
					throw new ReverseArithmeticException(currentBest, beginningIndex); // throw the exception
				}
			}
			else {
				counter = 1; // if the next char in the string is not in reverse alphabetic order, reset the counter to 1
			}
		}
	}

	/**
	 * This method takes the string parameter 'aString' and looks for balanced bipartite patterns of int 'length' given by parameter
	 */
	private static void balancedBipartiteMiner(String aString, int length) throws BalancedBipartiteException {
		if (length % 2 == 0)
		{
			String firstHalf, secondHalf, testString; // variables to compare two halves of a test string
			for (int start = 0; start <= aString.length() - length; start ++)
			{
				testString = aString.substring(start, start + length); // we grab a substring of aString based on the length given by the parameter
				firstHalf = testString.substring(0, testString.length() / 2); // the first half of that testString
				secondHalf = testString.substring(testString.length() / 2); // the second half of that testString
				if(firstHalf.equals(secondHalf)) //if the two halves are equal
					throw new BalancedBipartiteException(aString.substring(start, start + length), start); //throw the exception
			}
		}
	}

	/**
	 * This method takes the string parameter 'aString' and looks for balanced tripartite patterns of int 'length' given by parameter
	 */
	private static void balancedTripartiteMiner(String aString, int length) throws BalancedTripartiteException
	{
		if (length % 3 == 0)
		{
			// add if pattern length is divisible by 3
			String firstPart, secondPart, thirdPart, testString; // variables to compare thirds of a test string
			for (int start = 0; start <= aString.length() - length; start ++)
			{
				testString = aString.substring(start, start + length); // we grab a substring of aString based on the length given by the parameter
				firstPart = testString.substring(0, testString.length() / 3); // the first third of that testString
				secondPart = testString.substring(testString.length() / 3, (testString.length() / 3) * 2); // the second third of that testString
				thirdPart = testString.substring((testString.length() / 3) * 2); // the last third of that testString
				if(firstPart.equals(secondPart) && secondPart.equals(thirdPart)) // if all thirds are equal
					throw new BalancedTripartiteException(aString.substring(start, start + length), start); // throw the exception
			}
		}
	}

	/**
	 * This method takes the string parameter 'aString' and looks for palindrome patterns of int 'length' given by parameter
	 */
	private static void palindromeMiner(String aString, int length) throws PalindromeException
	{
		char aChar;
		for(int start = 0; start <= aString.length() - length; start++)
		{
			String substring = aString.substring(start, start + length);
			String reverse = "";
			for(int i = 0; i < substring.length(); i++)
			{
				aChar = substring.charAt(i);
				reverse= aChar + reverse;
			}
			if(substring.equalsIgnoreCase(reverse)) // if the reverse string is the same as the original string, its a palindrome
			{
				throw new PalindromeException(substring,start);
			}
		}
	}


	/**
	 * The main method receives input from the user on random string length and pattern length, ensures that it is in the proper format and range,
	 * calls the methods to create the string and to search through it for the patterns of the given length. Once exceptions are found,
	 * it will print the given message from the exception
	 */
    public static void main(String[] args)
	{
	Scanner keyboard = new Scanner(System.in);
	System.out.println("Enter the length of random string: ");
	String randomStringLength;
	int intRandomStringLength;
	while (true) { // this loop ensures the input for the random string length is of valid format and range
		try {
			randomStringLength = keyboard.nextLine();
			intRandomStringLength = Integer.parseInt(randomStringLength);
			if (intRandomStringLength< 100000 || intRandomStringLength > 1000000000) // if the input is not in the correct range
			throw new NumberFormatException();
		}
		catch (InputMismatchException e) // if the input is not an integer
		{
			System.out.println("You did not enter an integer. Try again.");
			continue;
		}
		catch (NumberFormatException e) // if the range is incorrect
		{
			System.out.println("You did enter an integer between 100 thousand and 1 billion. Try again!");
			continue;
	    }
	    break;
	}

	System.out.println("Now enter the max length of the pattern you are looking for.");
	String patternMaxLength;
	int intPatternMaxLength;
		while (true) { // this loop ensures the input for the max pattern length is of valid format and range
			try {
				patternMaxLength = keyboard.nextLine();
				intPatternMaxLength = Integer.parseInt(patternMaxLength);
				if (intPatternMaxLength< 3 || intPatternMaxLength > 15) // if the pattern is not between 3 and 15
					throw new NumberFormatException();
			}
			catch (InputMismatchException e)  // if the input is not an integer
			{
				System.out.println("You did not enter an integer. Try again.");
				continue;
			}
			catch (NumberFormatException e)  // if the range is incorrect
			{
				System.out.println("You did enter an integer between 3 and 15. Try again!");
				continue;
			}
			break;
		}

		//Step 2: generating random string...
	String randomString = randomStringGenerator(intRandomStringLength);
    	try {
    	    for (int length = intPatternMaxLength; length > 0; length--)
			{
				// this loop calls the methods to check for each type of pattern at the given length
				// if it cannot find the given pattern at that length, it will reduce the length by 1 and try again
				// this will repeat until the highest order pattern is found for a given length
				// the method will throw an exception which is caught by this try catch block

				singletonMiner(randomString, length);
				arithmeticStringMiner(randomString, length);
				reverseArithmeticStringMiner(randomString, length);
				balancedBipartiteMiner(randomString, length);
				balancedTripartiteMiner(randomString, length);
				palindromeMiner(randomString, length);

			}

    	} catch (Exception exp) {
    	    System.out.println(exp.getMessage()); // prints the exceptions message
    	}
    }

	
}
