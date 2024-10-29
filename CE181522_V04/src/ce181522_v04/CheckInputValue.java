package ce181522_v04;

import java.util.Scanner;

/**
 * checkInputValue class provides methods for validating user input. It ensures
 * that the input received is of the expected type (integer, double, or
 * non-empty string) and handles any errors gracefully.
 *
 * Author: Nguyen Minh Tam - CE181522
 */
public class CheckInputValue {

    // Scanner object for reading user input
    Scanner sc = new Scanner(System.in);

    /**
     * Prompts the user for an integer input until a valid integer is provided.
     *
     * @return The valid integer input from the user.
     */
    public int getValidInteger() {
        int value;
        while (true) {
            try {
                // Attempt to parse the input as an integer
                value = Integer.parseInt(sc.nextLine());
                break; // Exit the loop if parsing is successful
            } catch (NumberFormatException e) {
                // Inform the user of the error if input is not a valid integer
                System.out.println("Please enter an integer!");
            }
        }
        return value; // Return the valid integer
    }

    /**
     * Prompts the user for a double input until a valid double is provided.
     *
     * @return The valid double input from the user.
     */
    public double getValidDouble() {
        double value;
        while (true) {
            try {
                // Attempt to parse the input as a double
                value = Double.parseDouble(sc.nextLine());
                break; // Exit the loop if parsing is successful
            } catch (NumberFormatException e) {
                // Inform the user of the error if input is not a valid double
                System.out.println("Please enter a real number!");
            }
        }
        return value; // Return the valid double
    }

    /**
     * Prompts the user for a string input until a non-empty string is provided.
     *
     * @return The valid non-empty string input from the user.
     */
    public String getValidString() {
        String value;
        while (true) {
            // Read the input string
            value = sc.nextLine();
            // Check if the string is not empty (after trimming whitespace)
            if (!value.trim().isEmpty()) {
                break; // Exit the loop if input is valid
            } else {
                // Inform the user if the input is empty
                System.out.println("String cannot be empty");
            }
        }
        return value; // Return the valid non-empty string
    }
}
