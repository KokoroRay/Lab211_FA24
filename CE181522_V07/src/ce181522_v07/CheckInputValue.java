package ce181522_v07;

import java.util.Scanner;

/**
 * Input validation class Provides methods to validate and retrieve integer
 * inputs and yes/no answers from the user.
 *
 * @author: Nguyen Minh Tam - CE181522
 */
public class CheckInputValue {

    private Scanner scanner = new Scanner(System.in); // Scanner object to read user input

    /**
     * Method to get integer input from the user Keeps prsompting until a valid
     * integer is entered.
     *
     * @return a valid integer entered by the user
     */
    public int getIntInput() {
        int number = -1;
        boolean isValid = false;

        while (!isValid) {
            try {
                // Prompts the user for an integer guess
                System.out.print("Enter your guess: ");
                number = Integer.parseInt(scanner.nextLine()); // Converts input to an integer
                isValid = true; // Sets flag to true if input is valid
            } catch (NumberFormatException e) {
                // Displays an error message if input is not a valid integer
                System.out.println("Invalid input! Please enter an integer.");
            }
        }
        return number; // Returns the valid integer
    }

    /**
     * Method to get a yes/no answer from the user Keeps prompting until a valid
     * 'y' or 'n' is entered.
     *
     * @return true if user enters 'y' or 'yes', false if 'n' or 'no'
     */
    public boolean getYesNoInput() {
        String input = "";
        boolean isValid = false;

        while (!isValid) {
            // Prompts the user to continue playing or not
            System.out.print("Do you want to continue playing (y/n)? ");
            input = scanner.nextLine().trim().toLowerCase(); // Reads and normalizes input

            if (input.equals("y") || input.equals("yes")) {
                return true; // Returns true for 'y' or 'yes'
            } else if (input.equals("n") || input.equals("no")) {
                return false; // Returns false for 'n' or 'no'
            } else {
                // Displays an error if input is invalid
                System.out.println("Invalid input! Please enter 'y' or 'n'.");
            }
        }
        return false; // Default return if input is invalid
    }
}
