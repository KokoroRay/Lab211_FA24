package ce181522_s10;

/**
 * Title: Count the number of the appearance of letters in a string.
 *
 * Main class to run the program, which takes input from the user and counts the
 * frequency of each letter in the input string.
 *
 * @author Nguyen Minh Tam - CE181522
 */
public class CE181522_S10 {

    /**
     * Main method to run the program.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create an instance of CheckInputValue to handle user input
        CheckInputValue IO = new CheckInputValue();

        // Create an instance of LetterCounter to handle letter counting
        LetterCounter counter = new LetterCounter();

        // Function 1: Prompt the user for a string input
        String input = IO.getStringInput("Please enter a string: ");

        // Function 2: Count the number of appearances of each letter in the input
        counter.countLetters(input);

        // Function 3: Output the letter counts
        counter.displayCounts();
    }
}
