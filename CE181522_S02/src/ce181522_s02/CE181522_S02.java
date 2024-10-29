package ce181522_s02;

/**
 * Main class that executes the program.
 *
 * @author
 */
public class CE181522_S02 {

    /**
     * The main method that serves as the entry point of the application.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        // TODO: Implement application logic here

        // Create a validator object to check the validity of user inputs
        checkInputValue validator = new checkInputValue();

        // Initialize an arrayManager object with the validator
        arrayManager objectArray = new arrayManager(validator);

        // Receive and process input values
        objectArray.inputStringArray();

        // Display the original array of names
        System.out.println("List of input names:");
        objectArray.displayArray();

        // Use the bubbleSort method to sort the list of names
        objectArray.bubbleSort();

        // After sorting, display the sorted array of names
        System.out.println("List of sorted names:");
        objectArray.displayArray();
    }

}
