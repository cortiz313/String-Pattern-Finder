package util;

/**
 * This is a class extending the Exception class which holds a singleton string at a given occurrence index
 */

public class SingletonException extends Exception{//e.g. "bbbbbbb", "mmmm", "nn"
    private String singletonString;  // the singleton string
    private int occurrenceIndex; // the occurrence index

    /**
     * This method returns a message about the singleton string and where it occurs
     */
    @Override
    public String getMessage()
    {
	return singletonString + " is a singleton string that is found at index " + occurrenceIndex + "!";
    }

    /**
     * This is the constructor of the SingletonException object
     */
    public SingletonException(String singletonString, int index) {
	this.singletonString = singletonString; 
	occurrenceIndex = index;
    }

}
