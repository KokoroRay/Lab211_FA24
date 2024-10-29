package ce181522_v08;

import java.util.Scanner;

/**
 * Input validation class Provides methods to get validated integer inputs for
 * various grading tasks.
 *
 * @author: Nguyen Minh Tam - CE181522
 */
public class CheckInputValue {

    private Scanner scanner = new Scanner(System.in); // Scanner to handle user input

    /**
     * Method to get integer input within a specific range Ensures that the user
     * enters a valid integer between min and max values.
     *
     * @param prompt the message to prompt the user
     * @param min the minimum allowable value
     * @param max the maximum allowable value
     * @return a valid integer within the specified range
     */
    public int getIntInput(String prompt, int min, int max) {
        int number = -1;   // Variable to store the input number
        boolean isValid = false;  // Flag to track input validity

        while (!isValid) {
            try {
                System.out.print(prompt);  // Display prompt to the user
                number = Integer.parseInt(scanner.nextLine()); // Parse user input
                if (number >= min && number <= max) {
                    isValid = true; // Mark as valid if within range
                } else {
                    // Inform user if input is out of bounds
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                // Handle non-integer input
                System.out.println("Invalid input! Please enter an integer.");
            }
        }
        return number; // Return the valid number
    }
}
