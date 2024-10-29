package ce181522_s05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * * Main class to run the string analysis application.
 *
 * Class for analyzing the content of a string
 *
 * Author: Nguyen Minh Tam - CE181522
 */
public class AnalysisString {

    private CheckInputValue inputChecker;  // Object to validate user inputs

    /**
     * Constructor for the analysisString class Initializes the inputChecker
     * object.
     */
    public AnalysisString() {
        inputChecker = new CheckInputValue();  // Initialize the inputChecker
    }

    /**
     * Method to start the string analysis process This method collects the
     * input string from the user and performs number and character analysis.
     */
    public void star() {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object for user input

        // Ask the user to input a string
        System.out.println("Enter the input string: ");
        String input = sc.nextLine();  // Read the entire line of input from the user

        // Validate and clean the input string
        input = inputChecker.checkInput(input);

        // Perform number analysis on the input string
        HashMap<String, List<Integer>> numberAnalysis = getNumber(input);
        System.out.println("----- Number Analysis -----");
        // Print the number analysis results
        numberAnalysis.forEach((key, value) -> System.out.println(key + ": " + value));

        // Perform character analysis on the input string
        HashMap<String, StringBuilder> characterAnalysis = getChar(input);
        System.out.println("----- Character Analysis -----");
        // Print the character analysis results
        characterAnalysis.forEach((key, value) -> System.out.println(key + ": " + value));

        // Close the scanner after input
        sc.close();
    }

    /**
     * Method to extract and analyze numbers from the input string
     *
     * @param input the string input from the user
     * @return a HashMap containing various number analysis results
     */
    public HashMap<String, List<Integer>> getNumber(String input) {
        HashMap<String, List<Integer>> result = new HashMap<>();  // HashMap to store results
        List<Integer> allNumbers = new ArrayList<>();  // List to store all numbers
        List<Integer> evenNumbers = new ArrayList<>();  // List to store even numbers
        List<Integer> oddNumbers = new ArrayList<>();  // List to store odd numbers
        List<Integer> squareNumbers = new ArrayList<>();  // List to store square numbers
        int oddSum = 0;

        // Create a Matcher to find numbers in the input string
        Matcher matcher = Pattern.compile("\\d+").matcher(input);
        while (matcher.find()) {
            // Convert the matched number string to an integer
            int number = Integer.parseInt(matcher.group());
            allNumbers.add(number);  // Add number to the list of all numbers

            // Determine if the number is even or odd
            if (number % 2 == 0) {
                evenNumbers.add(number);
            } else {
                oddNumbers.add(number);
                oddSum += number;
            }

            // Check if the number is a perfect square
            if (Math.sqrt(number) == (int) Math.sqrt(number)) {
                squareNumbers.add(number);
            }
        }

        // Store the analysis results in the HashMap
        result.put("All Numbers", allNumbers);
        result.put("Even Numbers", evenNumbers);
        result.put("Odd Numbers", oddNumbers);
        result.put("Square Numbers", squareNumbers);

        System.out.println("Sum odd is" + oddSum);
        return result;  // Return the HashMap with analysis results
    }

    /**
     * Method to analyze characters from the input string
     *
     * @param input the string input from the user
     * @return a HashMap containing various character analysis results
     */
    public HashMap<String, StringBuilder> getChar(String input) {
        HashMap<String, StringBuilder> result = new HashMap<>();  // HashMap to store results
        StringBuilder allChar = new StringBuilder();  // StringBuilder to store all characters
        StringBuilder upperCase = new StringBuilder();  // StringBuilder to store uppercase characters
        StringBuilder lowerCase = new StringBuilder();  // StringBuilder to store lowercase characters
        StringBuilder specChar = new StringBuilder();  // StringBuilder to store special characters

        // Iterate through each character in the input string
        for (char c : input.toCharArray()) {
            allChar.append(c);  // Append character to the list of all characters

            // Check if the character is uppercase, lowercase, or special
            if (Character.isUpperCase(c)) {
                upperCase.append(c);
            } else if (Character.isLowerCase(c)) {
                lowerCase.append(c);
            } else if (!Character.isDigit(c)) {
                specChar.append(c);
            }
        }

        // Store the character analysis results in the HashMap
        result.put("All Characters", allChar);
        result.put("Uppercase Characters", upperCase);
        result.put("Lowercase Characters", lowerCase);
        result.put("Special Characters", specChar);
        return result;  // Return the HashMap with character analysis results
    }

}
