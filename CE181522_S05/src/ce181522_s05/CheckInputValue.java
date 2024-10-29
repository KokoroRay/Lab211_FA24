package ce181522_s05;

/**
 * Class for validating user input. This class provides a method to check if a
 * string input is valid. The method ensures that the input is neither null nor
 * empty. If the input is invalid, an exception is thrown.
 *
 * Author: Nguyen Minh Tam - CE181522
 */
public class CheckInputValue {

    /**
     * Method to validate a given input string. This method checks if the input
     * is null or an empty string (after trimming any leading or trailing
     * whitespace). If the input is invalid, an IllegalArgumentException is
     * thrown with a detailed error message.
     *
     * @param input The string input to be validated.
     * @return The validated input string.
     * @throws IllegalArgumentException if the input is null or an empty string.
     */
    public String checkInput(String input) throws IllegalArgumentException {
        // Check if the input is null or an empty string (after trimming whitespace).
        if (input == null || input.trim().isEmpty()) {
            // Throw an exception with a message explaining the issue.
            throw new IllegalArgumentException("Input cannot be null or empty");
        }
        // Return the valid input.
        return input;
    }
}
