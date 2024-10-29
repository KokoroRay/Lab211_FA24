package ce181522_s10;

import java.util.Arrays;

/**
 * This class handles counting the frequency of each letter in a string.
 * It ignores case and only counts alphabetical letters (A-Z, a-z).
 * 
 * @author Nguyen Minh Tam - CE181522
 */
public class LetterCounter {

    // Array to store the frequency of each letter (26 letters in the alphabet)
    private int[] letterCounts;

    /**
     * Constructor that initializes the letter count array.
     */
    public LetterCounter() {
        // Initialize the array to hold counts for 26 letters (a to z)
        letterCounts = new int[26];
    }

    /**
     * Method to count the occurrences of each letter in the input string.
     * It ignores case and non-alphabetical characters.
     * 
     * @param input the string to count letters from
     */
    public void countLetters(String input) {
        // Convert the input string to a character array for easy iteration
        char[] charArray = input.toCharArray();

        // Loop through each character in the array
        for (char c : charArray) {
            // Check if the character is an alphabetical letter
            if (isalpha(c)) {
                // If it's an uppercase letter, convert it to lowercase
                if (isupper(c)) {
                    c = (char) tolower(c);
                }

                // Increment the count for the corresponding letter
                letterCounts[c - 'a']++;
            }
        }
    }

    /**
     * Method to display the count of each letter that appears in the input.
     */
    public void displayCounts() {
        System.out.println("Letter Frequency:");
        
        // Loop through the letterCounts array and print non-zero counts
        for (int i = 0; i < letterCounts.length; i++) {
            if (letterCounts[i] > 0) {
                // Print the letter and its count (i + 'a' converts index to letter)
                System.out.printf("%c: %d\n", (char) (i + 'a'), letterCounts[i]);
            }
        }
    }

    /**
     * Helper method to check if a character is an alphabetical letter.
     * @param c the character to check
     * @return true if the character is a letter (A-Z or a-z), false otherwise
     */
    private boolean isalpha(int c) {
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

    /**
     * Helper method to check if a character is an uppercase letter.
     * @param c the character to check
     * @return true if the character is uppercase, false otherwise
     */
    private boolean isupper(int c) {
        return c >= 'A' && c <= 'Z';
    }

    /**
     * Helper method to convert an uppercase letter to lowercase.
     * @param c the character to convert
     * @return the lowercase version of the character, or the original if it's lowercase
     */
    private int tolower(int c) {
        // Convert uppercase letters (A-Z) to lowercase by adding 32
        if (isupper(c)) {
            return c + 32;
        }
        return c; // Return the original character if it's already lowercase
    }
}
