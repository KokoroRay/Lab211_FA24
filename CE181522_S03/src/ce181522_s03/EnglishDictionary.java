package ce181522_s03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Nguyen Minh Tam - CE181522
 *
 * This class represents an English dictionary where words and their meanings
 * are stored in separate files based on the first letter of the word. It allows
 * adding, editing, and looking up words, and handles file operations
 * accordingly.
 */
public class EnglishDictionary {

    private final String DICTIONARY_FILE = "data/";  // Directory to store index and meaning files
    private CheckInputValue IO;  // Input validation helper object

    /**
     * Constructor for EnglishDictionary. Initializes the input validation
     * object and ensures that the data directory exists.
     */
    public EnglishDictionary() {
        this.IO = new CheckInputValue();  // Initialize input validation
        createDataDir();   // Create data directory if it doesn't exist
    }

    /**
     * Creates the data directory if it doesn't exist. This ensures that the
     * directory to store index and meaning files is available.
     */
    public void createDataDir() {
        File dir = new File(DICTIONARY_FILE);
        if (!dir.exists()) { // Check if the directory already exists
            dir.mkdir(); // Create the directory
        }
    }

    /**
     * Main loop for the dictionary application. Displays a menu and handles
     * user input to perform different actions.
     */
    public void run() {
        Scanner sc = new Scanner(System.in);
        int choice;

        // Infinite loop to continuously display menu options until the user exits
        while (true) {
            System.out.println("1. Create a new word");
            System.out.println("2. Edit a word");
            System.out.println("3. Look up meaning");
            System.out.println("4. Exit");
            choice = IO.getInteger("Please choose a number (1-4): "); // Get user's choice

            // Handle the user's choice
            switch (choice) {
                case 1:
                    addNewWord(); // Add a new word to the dictionary
                    break;
                case 2:
                    editWord(); // Edit an existing word's meaning
                    break;
                case 3:
                    lookUpWord(); // Look up the meaning of a word
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    System.exit(0);  // Exit the program
                    break;
            }
        }
    }

    /**
     * Checks if a word exists in the dictionary by reading the appropriate
     * index file.
     *
     * @param word The word to check
     * @return true if the word exists, false otherwise
     */
    private boolean wordExis(String word) {
        // Determine the index file based on the first letter of the word
        char firstLetter = Character.toLowerCase(word.charAt(0));
        String indexFileName = DICTIONARY_FILE + firstLetter + "_index.dat";  // File for words

        // Try reading the index file
        try (BufferedReader reader = new BufferedReader(new FileReader(indexFileName))) {
            String line;
            // Loop through each line in the index file
            while ((line = reader.readLine()) != null) {
                if (line.equalsIgnoreCase(word)) {
                    return true;  // Word found
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading data in file");
        }
        return false;  // Word not found
    }

    /**
     * Method adds a new word to the dictionary. The word and its meaning are
     * stored in separate files based on the first letter of the word.
     */
    public void addNewWord() {
        // Prompt user for a valid word
        String word = IO.getWord("Enter a word: ", "[a-zA-Z ]+");  // Get a valid word from the user
        // Check if the word already exists
        if (wordExis(word)) {
            System.out.println("Word alreay exists.");
            return;  // Exit the method if the word already exists
        }
        // Get the meaning of the word
        String meaning = IO.getMeaning("Enter the meaning: ");
        // Determine the first letter of the word to decide the file
        char firLett = Character.toLowerCase(word.charAt(0));
        // Write the word and meaning to the appropriate files
        writeWordToFile(word, meaning, firLett);
        System.out.println("Word added successfuly.");
    }

    /**
     * Edits an existing word's meaning. If the word exists, its meaning is
     * updated in the corresponding files.
     */
    public void editWord() {
        // Prompt user for the word to update
        String word = IO.getWord("Enter a word to update: ", "[a-zA-Z ]+");

        // Determine the first letter of the word
        char firstLetter = Character.toLowerCase(word.charAt(0));

        // Check if the word exists in the dictionary
        if (!wordExis(word)) {
            System.out.println("Word not found.");
            return;  // Exit the method if the word doesn't exist
        }

        // Get the new meaning for the word
        String newMeaning = IO.getMeaning("Enter the new meaning: ");

        // Update the word and meaning in the corresponding files
        updateWordInFile(word, newMeaning, firstLetter);
        System.out.println("Word updated successfully.");
    }

    /**
     * Looks up the meaning of a word. If the word exists, its meaning is
     * retrieved and displayed to the user.
     */
    public void lookUpWord() {
        // Prompt user for the word to look up
        String word = IO.getWord("Enter a word to look up: ", "[a-zA-Z ]+");

        // Determine the first letter of the word
        char firstLetter = Character.toLowerCase(word.charAt(0));

        // Check if the word exists in the dictionary
        if (!wordExis(word)) {
            System.out.println("Word not found.");
            return;  // Exit the method if the word doesn't exist
        }

        // Retrieve the meaning from the corresponding file
        String meaning = getMeaningFromFile(word, firstLetter);
        System.out.println("Meaning: " + meaning);  // Display the meaning
    }

    /**
     * Retrieves the meaning of a word from the corresponding file.
     *
     * @param word The word whose meaning is to be retrieved
     * @param firstLetter The first letter of the word, used to decide the file
     * @return The meaning of the word, or null if not found
     */
    public String getMeaningFromFile(String word, char firstLetter) {
        // Determine the file names for the word and meaning
        String indexFileName = DICTIONARY_FILE + firstLetter + "_index.dat";
        String meaningFileName = DICTIONARY_FILE + firstLetter + "_meaning.dat";

        // Try reading the files to find the word and its meaning
        try (BufferedReader indexReader = new BufferedReader(new FileReader(indexFileName));
                BufferedReader meaningReader = new BufferedReader(new FileReader(meaningFileName))) {
            String indexLine, meaningLine;

            // Loop through each word in the index file
            while ((indexLine = indexReader.readLine()) != null) {
                meaningLine = meaningReader.readLine();  // Read the corresponding meaning
                if (indexLine.equalsIgnoreCase(word)) {
                    return meaningLine;  // Return the meaning if the word is found
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file.");
        }
        return null;  // Meaning not found
    }

    /**
     * Writes a new word and its meaning to the appropriate files based on the
     * first letter.
     *
     * @param word The word to add
     * @param meaning The meaning of the word
     * @param firstLetter The first letter of the word, used to decide the file
     */
    public void writeWordToFile(String word, String meaning, char firstLetter) {
        // Determine the file names for the word and meaning
        String indexFileName = DICTIONARY_FILE + firstLetter + "_index.dat";  // File for words
        String meaningFileName = DICTIONARY_FILE + firstLetter + "_meaning.dat";  // File for meanings

        // Append the word and meaning to the respective files
        try (BufferedWriter indexWriter = new BufferedWriter(new FileWriter(indexFileName, true));
                BufferedWriter meaningWriter = new BufferedWriter(new FileWriter(meaningFileName, true))) {

            indexWriter.write(word);  // Write the word
            indexWriter.newLine();  // Move to the next line
            meaningWriter.write(meaning);  // Write the meaning
            meaningWriter.newLine();  // Move to the next line
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    /**
     * Updates the meaning of an existing word in the corresponding files.
     *
     * @param word The word to update
     * @param newMeaning The new meaning for the word
     * @param firstLetter The first letter of the word, used to decide the file
     */
    public void updateWordInFile(String word, String newMeaning, char firstLetter) {
        // 1. Construct the file names for the index and meaning files
        // Each file corresponds to the words starting with the given first letter.
        // For example, if the first letter is 'A', files will be named 'A_index.dat' and 'A_meaning.dat'.
        String indexFileName = DICTIONARY_FILE + firstLetter + "_index.dat";
        String meaningFileName = DICTIONARY_FILE + firstLetter + "_meaning.dat";

        try {
            // 2. Create readers to read the existing content of both index (words) and meaning (definitions) files.
            // BufferedReader is used to read text from a character input stream efficiently.
            BufferedReader indexReader = new BufferedReader(new FileReader(indexFileName));
            BufferedReader meaningReader = new BufferedReader(new FileReader(meaningFileName));

            // 3. Initialize StringBuilder objects to store the updated content of both files.
            // StringBuilder is used because it's more efficient for string concatenation than using regular strings.
            StringBuilder indexContent = new StringBuilder();
            StringBuilder meaningContent = new StringBuilder();

            // 4. Read each line from the index file (which contains words) one by one
            String line;
            while ((line = indexReader.readLine()) != null) {  // Read each word from the index file
                // 5. Append the current word from the index file to the `indexContent`
                // This is to reconstruct the index file exactly as it was before (no changes made to this).
                indexContent.append(line).append("\n");

                // 6. Check if the current word matches the one that needs its meaning updated.
                // The method `equalsIgnoreCase` is used to compare words in a case-insensitive manner.
                if (line.equalsIgnoreCase(word)) {
                    // If the current word matches the word to update, append the new meaning to the `meaningContent`
                    meaningContent.append(newMeaning).append("\n");  // Replaces the old meaning with the new one
                } else {
                    // 7. If the word does not match, append the corresponding meaning from the meaning file to `meaningContent`.
                    // The `meaningReader.readLine()` reads the meaning associated with the current word in the index file.
                    meaningContent.append(meaningReader.readLine()).append("\n");  // Keep the existing meaning for other words
                }
            }

            // 8. Create writers to overwrite the files with the updated content.
            // BufferedWriter is used to write text efficiently to the files.
            BufferedWriter indexWriter = new BufferedWriter(new FileWriter(indexFileName));
            BufferedWriter meaningWriter = new BufferedWriter(new FileWriter(meaningFileName));

            // 9. Write the updated index (word list) back to the index file.
            indexWriter.write(indexContent.toString());

            // 10. Write the updated meanings back to the meaning file.
            meaningWriter.write(meaningContent.toString());

            // 11. Close the readers and writers to release system resources.
            // It's important to close these resources to prevent memory leaks or file locks.
            indexReader.close();
            meaningReader.close();
            indexWriter.close();
            meaningWriter.close();
        } catch (IOException e) {
            // 12. If there's an error during the file read/write operations, print an error message.
            // The catch block ensures that the program doesn't crash and gives feedback about the issue.
            System.out.println("Error updating the file.");
        }
    }
}
