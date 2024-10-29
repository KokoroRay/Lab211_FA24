package ce181522_v06;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This class handles user input and validation. It contains methods to get the
 * car, color, price, and sale day inputs from the user and validate them.
 *
 * @author Nguyen Minh Tam - CE181522
 */
public class CheckInputValue {

    private Scanner sc = new Scanner(System.in);  // Scanner object for reading user input

    /**
     * Prompts the user to input an integer and keeps retrying until a valid
     * integer is entered.
     *
     * @param msg the message to prompt the user
     * @return a valid integer entered by the user
     */
    public int getValidInteger(String msg) {
        // Loop until a valid integer is entered
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();
            try {
                // Try converting the input to an integer
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                // If input is not a valid integer, prompt the user again
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

}
