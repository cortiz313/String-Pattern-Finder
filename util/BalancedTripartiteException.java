package util;

/**
 * This is a class extending the Exception class which holds a balanced tripartite string at a given occurrence index
 */

public class BalancedTripartiteException extends Exception {
    private String tripartiteString; // the tripartite string
    private int occurrenceIndex; // the occurrence index

    /**
     * This method returns a message about the tripartite string and where it occurs
     */
    @Override
    public String getMessage() {
        return tripartiteString + " is a tripartite string that is found at index " + occurrenceIndex + "!";
    }

    /**
     * This is the constructor of the BalancedTripartiteException object
     */
    public BalancedTripartiteException(String tripartiteString, int index) {
        this.tripartiteString = tripartiteString;
        occurrenceIndex = index;
    }

}
