package util;

/**
 * This is a class extending the Exception class which holds an alphabetic string at a given occurrence index
 */

public class ArithmeticException extends Exception {
    private String arithmeticString; // the alphabetic string
    private int occurrenceIndex; // the occurrence index


    /**
     * This method returns a message about the alphabetic string and where it occurs
     */
    @Override
    public String getMessage() {
        return arithmeticString + " is an arithmetic string that is found at index " + occurrenceIndex + "!";
    }

    /**
     * This is the constructor of the ArithmeticException object
     */
    public ArithmeticException(String arithmeticString, int index) {
        this.arithmeticString = arithmeticString;
        occurrenceIndex = index;
    }

}
