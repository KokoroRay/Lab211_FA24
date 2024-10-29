package ce181522_s10;

import java.util.Scanner;

/**
 * This class handles user input validation. It ensures that the input string is
 * not empty and keeps prompting the user until valid input is given.
 *
 * @author Nguyen Minh Tam - CE181522
 */
public class CheckInputValue {

    // Scanner object to read input from the user
    Scanner sc = new Scanner(System.in);

    /**
     * Method to prompt the user for a string and ensure it's valid.
     *
     * @param msg the message to display when prompting for input
     * @return a valid string input from the user
     */
    public String getStringInput(String msg) {
        String input = "";
        boolean valid = false;
        do {
            try {
                // Display the prompt message
                System.out.println(msg);

                // Read the user input
                input = sc.nextLine();

                // Check if the input is empty
                if (input.isEmpty()) {
                    // If input is empty, throw an exception
                    throw new IllegalArgumentException("Input cannot be empty!");
                }

                // If input is valid, exit the loop
                valid = true;
            } catch (Exception e) {
                // Print the error message if input is invalid
                System.out.println("Invalid input: " + e.getMessage());
            }
        } while (!valid); // Repeat until valid input is received
        return input; // Return the valid input
    }
}
