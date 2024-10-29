package ce181522_s06;

import java.util.Scanner;
import jdk.nashorn.internal.ir.Symbol;

/**
 * The checkInputValue class contains methods for input validation. It ensures
 * that user inputs are within specified ranges and valid.
 *
 * Author: Nguyen Minh Tam - CE181522
 */
public class checkInputValue {

    Scanner sc = new Scanner(System.in);
    
    /**
     * Method to validate the input number for the array size Ensures the number
     * is within the specified range and greater than 1.
     *
     * @param sc Scanner object to capture user input
     * @param maxValue the maximum value the input number can have
     * @return a valid number within the specified range and greater than 1
     */
    
    public int validateArraySize(int maxValue) {
        int input = -1;  // Initialize input with an invalid value (-1)
        boolean valid = false;  // Flag to indicate if the input is valid

        // Loop until a valid input is received
        while (!valid) {
            try {
                // Capture the input from the user and convert it to an integer
                input = Integer.parseInt(sc.nextLine());

                // Check if the input is less than 2 (array size must be greater than 1)
                if (input < 2) {
                    // Display an error if the input is less than 2
                    System.out.println("Error: Array size must be greater than 1.");
                    System.out.println("Please enter a number greater than 1:");
                } // Check if the input exceeds the maximum allowed value
                else if (input > maxValue) {
                    // Display an error if the input is too large
                    System.out.println("Error: Input number is too large. Max value is " + maxValue + ".");
                    System.out.println("Please enter a number less than or equal to " + maxValue + ":");
                } else {
                    // If the input is valid, exit the loop
                    valid = true;
                }

            } catch (NumberFormatException e) {
                // Display an error if the input is not a valid integer
                System.out.println("Invalid input. Please enter a valid integer!");
            }
        }

        // Return the valid input
        return input;
    }

    /**
     * Method to validate the input number for array elements This method only
     * ensures that the input is a valid integer.
     *
     * @param sc Scanner object to capture user input
     * @return a valid integer input
     */
    public int validateNumber() {
        int input = -1;  // Initialize input with an invalid value (-1)
        boolean valid = false;  // Flag to indicate if the input is valid

        // Loop until a valid input is received
        while (!valid) {
            try {
                // Receive the input from the user and parse it as an integer
                input = Integer.parseInt(sc.nextLine());
                // If successful, mark input as valid
                valid = true;
            } catch (NumberFormatException e) {
                // Print error if input is not a valid integer
                System.out.println("Invalid input. Please enter a valid integer!");
            }
        }

        // Return the valid input
        return input;
    }
}
