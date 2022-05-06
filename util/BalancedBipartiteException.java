package util;

/**
 * This is a class extending the Exception class which holds a balanced bipartite string at a given occurrence index
 */

public class BalancedBipartiteException extends Exception {
    private String bipartiteString; // the bipartite string
    private int occurrenceIndex;  // the occurrence index

    /**
     * This method returns a message about the bipartite string and where it occurs
     */
    @Override
    public String getMessage() {
        return bipartiteString + " is a bipartite string that is found at index " + occurrenceIndex + "!";
    }

    /**
     * This is the constructor of the BalancedBipartiteException object
     */
    public BalancedBipartiteException(String bipartiteString, int index) {
        this.bipartiteString = bipartiteString;
        occurrenceIndex = index;
    }

}
