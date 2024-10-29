package ce181522_l02;

import java.util.Scanner;

/**
 * L02_Create a Java console program to manage Candidates of a company.
 *
 * The CheckInputValue class provides utility methods for input validation. It
 * helps ensure that user inputs are within valid ranges or formats, such as
 * ensuring integer inputs fall within a range or string inputs match a required
 * regular expression pattern.
 *
 * This class contains methods to: - Validate integers within a specified range.
 * - Ensure non-empty string inputs. - Validate string inputs using regular
 * expressions. - Confirm user actions with 'Y' or 'N'.
 *
 * The class relies on the Scanner class to capture user inputs from the
 * console.
 *
 * Author: Nguyen Minh Tam - CE181522
 */
public class CheckInputValue {

    // Scanner object to read input from the console
    Scanner sc = new Scanner(System.in);

    /**
     * Prompts the user to enter an integer within a specified range and
     * validates the input.
     *
     * If the input is invalid (e.g., not an integer or out of range), it will
     * keep prompting the user until a valid integer is entered.
     *
     * @param msg The prompt message to display when asking for input.
     * @param errorMsg The error message to display when input is invalid.
     * @param min The minimum valid integer value.
     * @param max The maximum valid integer value.
     * @return A valid integer input from the user.
     */
    public int getInteger(String msg, String errorMsg, int min, int max) {
        int n;  // Variable to store the input integer
        while (true) {
            try {
                // Display the prompt message and read input
                System.out.print(msg);
                n = Integer.parseInt(sc.nextLine());  // Attempt to parse the input as an integer

                // Check if the input is within the specified range
                if (n < min || n > max) {
                    throw new Exception();  // If out of range, throw an exception
                }

                return n;  // If input is valid, return the integer value
            } catch (Exception e) {
                // Display an error message if input is invalid
                System.out.println(errorMsg);
            }
        }
    }

    /**
     * Prompts the user to enter a non-empty string and validates the input.
     *
     * The method ensures that the string input is not empty (i.e., it has at
     * least one non-whitespace character). It will keep prompting the user
     * until a valid input is provided.
     *
     * @param msg The prompt message to display when asking for input.
     * @param errorMsg The error message to display when input is empty.
     * @return A non-empty string input from the user.
     */
    public String getString(String msg, String errorMsg) {
        String input;  // Variable to store the input string
        while (true) {
            // Display the prompt message and read input
            System.out.print(msg);
            input = sc.nextLine().trim();  // Trim leading/trailing whitespace

            // Check if the input string is not empty
            if (input.length() == 0) {
                // If input is empty, display an error message
                System.out.println(errorMsg);
            } else {
                return input;  // If input is valid, return the string
            }
        }
    }

    /**
     * Prompts the user to enter a string that matches a specified regular
     * expression pattern and validates the input.
     *
     * The method ensures that the string input conforms to the provided regular
     * expression format. It will keep prompting the user until a valid input is
     * provided.
     *
     * @param msg The prompt message to display when asking for input.
     * @param errorMsg The error message to display when input is invalid.
     * @param format The regular expression pattern that the input must match.
     * @return A string input that matches the specified format.
     */
    public String regexString(String msg, String errorMsg, String format) {
        String input;  // Variable to store the input string
        boolean isValid;  // Flag to indicate whether the input matches the format
        while (true) {
            // Display the prompt message and read input
            System.out.print(msg);
            input = sc.nextLine().trim();  // Trim leading/trailing whitespace

            // Check if the input matches the provided regular expression format
            isValid = input.matches(format);

            // If input is empty or doesn't match the format, display an error message
            if (input.length() == 0 || !isValid) {
                System.out.println(errorMsg);
            } else {
                return input;  // If input is valid, return the string
            }
        }
    }

    /**
     * Asks the user for confirmation with a 'Y' or 'N' input.
     *
     * The method ensures that the user provides either 'Y' (yes) or 'N' (no) as
     * input, ignoring case. It will keep prompting the user until a valid input
     * is provided.
     *
     * @param msg The prompt message to display when asking for confirmation.
     * @return True if the user confirms with 'Y', false if they decline with
     * 'N'.
     */
    public boolean getConfirm(String msg) {
        // Call regexString method to validate that the input is 'Y' or 'N'
        String input = regexString(msg, "Just y or n", "^[YyNn]$");

        // Return true if input is 'Y' (case-insensitive), false otherwise
        return input.equalsIgnoreCase("y");
    }
}
