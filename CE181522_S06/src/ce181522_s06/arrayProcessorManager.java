package ce181522_s06;

import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;

/**
 * The arrayProcessorManager class handles operations related to an integer
 * array, including taking input, removing duplicates, and displaying results.
 *
 * Author: Nguyen Minh Tam - CE181522
 */
public class arrayProcessorManager {

    // Declare an array to store integer elements
    private int[] array;

    /**
     * Constructor to initialize the arrayProcessorManager with a specified
     * array size.
     *
     * @param size the size of the array to be initialized
     */
    public arrayProcessorManager(int size) {
        // Initialize the array with the specified size
        this.array = new int[size];
    }

    /**
     * Main method to handle array operations like taking input, removing
     * duplicates, and displaying results.
     *
     * @param sc Scanner object to capture user input
     */
    public void star(Scanner sc) {
        checkInputValue input = new checkInputValue();

        // Prompt for the array size and validate the size is greater than 1
        System.out.println("Please enter size of array:");
        int size = input.validateArraySize(100); // Max size set to 100

        arrayProcessorManager proce = new arrayProcessorManager(size);

        // Call the method to input elements into the array
        proce.enterElements(sc);

        // Display the original array
        System.out.println("The original array:");
        proce.dislayArray(proce.array);

        // Remove duplicates from the array
        int[] uniArray = proce.removeDuplicates();

        // Display the array after removing duplicate elements
        System.out.println("The array after removing duplicate elements:");
        proce.dislayArray(uniArray);
    }

    /**
     * Method to enter elements into the array
     *
     * @param sc Scanner object to capture user input
     */
    public void enterElements(Scanner sc) {
        checkInputValue input = new checkInputValue();

        // Loop through the array and capture each element from the user
        for (int i = 0; i < array.length; i++) {
            // Prompt the user for each element's value
            System.out.print("Element[" + i + "] = ");

            // Validate the input as a valid integer and store it in the array
            array[i] = input.validateNumber();  // No need to check limits beyond int's natural range
        }
    }

    /**
     * Method to remove duplicate elements from the array
     *
     * @return an array containing only unique elements from the original array
     */
    public int[] removeDuplicates() {
        // Use a HashSet to store unique elements from the array
        HashSet<Integer> set = new HashSet<>();

        // Use an ArrayList to store unique elements in order
        ArrayList<Integer> uniList = new ArrayList<>();

        // Loop through the original array
        for (int value : array) {
            // Add the value to the HashSet, and if it's unique, add it to the ArrayList
            if (set.add(value)) {
                uniList.add(value);
            }
        }

        // Create a new array to store the unique elements
        int[] uniArray = new int[uniList.size()];

        // Copy the unique elements from the ArrayList to the new array
        for (int i = 0; i < uniList.size(); i++) {
            uniArray[i] = uniList.get(i);
        }

        // Return the array with duplicates removed
        return uniArray;
    }

    /**
     * Method to display the elements of an array
     *
     * @param arr the array whose elements will be displayed
     */
    public void dislayArray(int[] arr) {
        // Loop through the array and print each element
        for (int value : arr) {
            System.out.print(value + "          ");
        }

        // Print a newline after all elements are displayed
        System.out.println();
    }
}
