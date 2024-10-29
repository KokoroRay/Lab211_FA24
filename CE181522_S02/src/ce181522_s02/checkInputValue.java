package ce181522_s02;

import java.util.Scanner;

/**
 * Class to validate and handle user inputs. Includes methods to check array
 * size and validate string formats.
 */
public class checkInputValue {

    private Scanner sc = new Scanner(System.in); // Scanner object to read user input

    /**
     * Method to validate the size of the array input by the user.
     *
     * @param msg The message to display before prompting for input.
     * @param maxSize The maximum allowable size for the array.
     * @return A valid array size within the specified range.
     */
    public int getArraySize(String msg, int maxSize) {
        int size;
        while (true) { // Loop until a valid size is entered
            System.out.println(msg); // Display the prompt message
            String input = sc.nextLine(); // Read user input
            try {
                size = Integer.parseInt(input); // Attempt to parse the input as an integer
                if (size > 0 && size <= maxSize) { // Check if size is within the valid range
                    return size; // Return the valid size
                } else { // If size is out of range
                    throw new IllegalArgumentException("The input size must be within the range of 1 to " + maxSize + "!");
                }
            } catch (NumberFormatException e) { // Handle non-integer inputs
                System.out.println("Please enter a valid integer!");
            } catch (IllegalArgumentException e) { // Handle sizes out of the valid range
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Method to receive and validate an array of strings from the user.
     *
     * @param regex The regex pattern that each string must match.
     * @param maxLength The maximum allowed length for each string.
     * @param size The number of strings to be entered.
     * @return An array of validated strings.
     */
    public String[] getStringsArray(String regex, int maxLength, int size) {
        String[] array = new String[size]; // Initialize the array with the specified size
        for (int i = 0; i < size; i++) { // Loop to populate each element of the array
            array[i] = getStringName(regex, maxLength); // Assign a validated string to each array element
        }
        return array; // Return the populated array
    }

    /**
     * Method to receive and validate a single string input from the user.
     *
     * @param regex The regex pattern that the string must match.
     * @param maxLength The maximum allowed length for the string.
     * @return A validated string that meets all criteria.
     */
    public String getStringName(String regex, int maxLength) {
        String input;
        while (true) { // Loop until a valid string is entered
            input = sc.nextLine(); // Read user input
            try { // Attempt to validate the input
                if (input.trim().isEmpty()) { // Check if the string is empty or only whitespace
                    System.out.println("Please enter data into the string!");
                    continue; // Prompt the user to enter again
                }
                if (input.contains(" ")) { // Check if the string contains spaces
                    System.out.println("String must not contain spaces!");
                    continue; // Prompt the user to enter again
                }
                if (input.length() > maxLength) { // Check if the string exceeds the maximum length
                    System.out.println("String must be " + maxLength + " characters or less!");
                    continue; // Prompt the user to enter again
                }
                if (!input.matches(regex)) { // Check if the string matches the specified regex pattern
                    System.out.println("String must contain only lowercase letters (no numbers or special characters)!");
                    continue; // Prompt the user to enter again
                }
            } catch (IllegalArgumentException e) { // Handle any unexpected exceptions
                System.out.println(e.getMessage());
            }
            return input; // Return the validated string
        }
    }
}
