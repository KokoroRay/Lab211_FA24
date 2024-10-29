package ce181522_s03;

import java.util.Scanner;

/**
 * This class is responsible for validating user input. It provides methods to:
 * - Validate and retrieve a word that only contains alphabetic characters. -
 * Validate and retrieve a non-empty meaning. - Validate and retrieve a positive
 * integer. The class ensures proper error handling by continuously prompting
 * the user until valid input is provided.
 *
 * @author Nguyen Minh Tam - CE181522
 */
public class CheckInputValue {

    // Scanner object to read user input from the console.
    // This object is shared across all methods for input handling.
    Scanner sc = new Scanner(System.in);

    /**
     * This method prompts the user to enter a word, then validates the input
     * using a regular expression. It ensures that the word is non-empty and
     * only contains alphabetic characters (based on the regex provided). The
     * method will continue asking for input until the user provides a valid
     * word.
     *
     * @param msg The message to prompt the user for input.
     * @param regex The regular expression to validate the word format (only
     * alphabetic characters).
     * @return A valid word entered by the user.
     */
    public String getWord(String msg, String regex) {
        String word;  // Variable to store the input word from the user.
        while (true) {  // Keep prompting the user until a valid input is received.
            System.out.println(msg);  // Display the prompt message to the user.
            word = sc.nextLine();  // Read the user's input.
            try {
                if (word.trim().isEmpty()) {  // Check if the input is empty after trimming whitespace.
                    throw new IllegalAccessError("Word cannot be empty!");  // If empty, throw an error.
                }
                if (!word.matches(regex)) {  // Check if the input matches the regex (only alphabetic characters).
                    throw new IllegalAccessError("Word should only contain alphabetic characters");  // If not, throw an error.
                }
                return word;  // If valid, return the word.
            } catch (IllegalArgumentException e) {
                // Catch any IllegalArgumentException, display the error message, and continue the loop.
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * This method prompts the user to enter a meaning, then validates the input
     * to ensure it's non-empty. The method will continue asking for input until
     * a valid non-empty string is provided.
     *
     * @param msg The message to prompt the user for input.
     * @return A valid meaning entered by the user.
     */
    public String getMeaning(String msg) {
        String meaning;  // Variable to store the input meaning from the user.
        while (true) {  // Keep prompting the user until a valid input is received.
            System.out.println(msg);  // Display the prompt message to the user.
            meaning = sc.nextLine();  // Read the user's input.
            try {
                if (meaning.trim().isEmpty()) {  // Check if the input is empty after trimming whitespace.
                    throw new IllegalArgumentException("Meaning cannot be empty!");  // If empty, throw an exception.
                }
                return meaning;  // If valid, return the meaning.
            } catch (IllegalArgumentException e) {
                // Catch any IllegalArgumentException, display the error message, and continue the loop.
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * This method prompts the user to enter an integer, then validates the
     * input to ensure it's a positive integer. It handles both non-integer
     * inputs (e.g., strings) and negative integers. The method will continue
     * asking for input until a valid positive integer is provided.
     *
     * @param msg The message to prompt the user for input.
     * @return A valid positive integer entered by the user.
     */
    public int getInteger(String msg) {
        Scanner sc = new Scanner(System.in);  // Create a new scanner for reading input.
        int n;  // Variable to store the integer input.
        while (true) {  // Keep prompting the user until a valid integer is received.
            System.out.print(msg);  // Display the prompt message to the user.
            String str = sc.nextLine();  // Read the user's input as a string.
            try {
                n = Integer.parseInt(str);  // Attempt to parse the input as an integer.
                if (n <= 0) {  // Check if the integer is non-positive.
                    throw new IllegalArgumentException();  // If not positive, throw an exception.
                }
                return n;  // If valid, return the integer.
            } catch (NumberFormatException e) {
                // Catch any NumberFormatException (e.g., if the input is not a valid integer) and display an error.
                System.out.println("Please enter an integer!");
            } catch (IllegalArgumentException e) {
                // Catch an IllegalArgumentException if the input is not a positive integer and display an error.
                System.out.println("Please enter a positive number!");
            }
        }
    }
}
