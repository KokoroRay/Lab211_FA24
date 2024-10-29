package ce181522_s02;

/**
 * Class that manages an array of strings, including input, display, and sorting
 * operations.
 *
 * Author: Nguyen Minh Tam - CE181522
 */
public class arrayManager {

    private String[] array; // Array to store the strings
    private int size; // Size of the array
    private checkInputValue validator; // Validator object to check input validity

    /**
     * Constructor to initialize the arrayManager with a validator.
     *
     * @param validator Validator object for input validation.
     */
    public arrayManager(checkInputValue validator) {
        this.validator = validator;
    }

    /**
     * Method to input data into the string array.
     */
    public void inputStringArray() {
        // Get the size of the array using the validator, with a maximum size of 100
        size = validator.getArraySize("Enter the number of names:", 100);
        System.out.println("Enter " + size + " names:");

        // Populate the array with validated strings using a regex pattern, maximum length 10
        array = validator.getStringsArray("^[a-z]+$", 10, size);
    }

    /**
     * Method to display the contents of the array.
     */
    public void displayArray() {
        for (int i = 0; i < array.length; i++) { // Iterate through the array
            System.out.println((i + 1) + ". " + array[i]); // Display each name with its index
        }
    }

    /**
     * Method to sort the array using the Bubble Sort algorithm.
     */
    public void bubbleSort() {
        int n = array.length; // Get the length of the array
        boolean swapped; // Flag to check if any swapping occurred in the iteration

        for (int i = 0; i < n - 1; i++) { // Outer loop for each pass
            swapped = false; // Reset the swapped flag at the start of each pass

            for (int j = 0; j < n - 1 - i; j++) { // Inner loop for comparing adjacent elements
                // Compare the current element with the next element
                if (array[j].length() > array[j + 1].length()) { // If current > next
                    // Swap the elements
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true; // Set the flag indicating a swap occurred
                }
            }
            // If no two elements were swapped in the inner loop, the array is sorted
            if (!swapped) {
                break; // Exit the sorting loop early for optimization
            }
        }
    }

}
