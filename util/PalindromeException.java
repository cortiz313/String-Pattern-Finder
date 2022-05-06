package util;

/**
 * This is a class extending the Exception class which holds a palindrome string at a given occurrence index
 */

public class PalindromeException extends Exception {
    private String palindromeString; // the palindrome string
    private int occurrenceIndex; // the occurrence index

    /**
     * This method returns a message about the palindrome string and where it occurs
     */
    @Override
    public String getMessage() {
        return palindromeString + " is a palindrome string that is found at index " + occurrenceIndex + "!";
    }

    /**
     * This is the constructor of the PalindromeException object
     */
    public PalindromeException(String palindromeString, int index) {
        this.palindromeString = palindromeString;
        occurrenceIndex = index;
    }

}
