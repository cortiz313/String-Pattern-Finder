package util;

/**
 * This is a class extending the Exception class which holds a reverse alphabetic string at a given occurrence index
 */

public class ReverseArithmeticException extends Exception {
    private String reverseArithmeticString; // the reverse alphabetic string
    private int occurrenceIndex; // the occurrence index

    /**
     * This method returns a message about the reverse alphabetic string and where it occurs
     */
    @Override
    public String getMessage() {
        return reverseArithmeticString + " is a reverse arithmetic string that is found at index " + occurrenceIndex + "!";
    }

    /**
     * This is the constructor of the ReverseArithmeticException object
     */
    public ReverseArithmeticException(String reverseArithmeticString, int index) {
        this.reverseArithmeticString = reverseArithmeticString;
        occurrenceIndex = index;
    }

}
