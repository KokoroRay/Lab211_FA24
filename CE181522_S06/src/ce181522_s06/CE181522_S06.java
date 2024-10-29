package ce181522_s06;

import java.util.Scanner;

/**
 * The CE181522_S06 class serves as the main entry point for the program. It
 * initializes the array processing manager and handles user input.
 *
 * Author: Nguyen Minh Tam - CE181522
 */
public class CE181522_S06 {

    /**
     * The entry point of the program
     *
     * @param args command line arguments (not used in this program)
     */
    public static void main(String[] args) {
        // Initialize a Scanner object to capture user input
        Scanner sc = new Scanner(System.in);

        // Create an instance of the arrayProcessorManager class with an initial array size of 0
        arrayProcessorManager mg = new arrayProcessorManager(0);

        // Start the array processing by calling the star method
        mg.star(sc);

        // Close the Scanner object to free up resources
        sc.close();
    }
}
