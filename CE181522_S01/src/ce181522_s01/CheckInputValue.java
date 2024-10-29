package ce181522_s01;

import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class containing various methods to validate user input.
 *
 * Author: Nguyen Minh Tam - CE181522
 */
public class CheckInputValue {

    /**
     * Method to check the validity of an integer input
     *
     * @param msg displays a message before input
     * @return returns the integer value after validation
     */
    public static int getInteger(String msg) {
        // Create a Scanner object to read input
        Scanner sc = new Scanner(System.in);
        int n;
        while (true) { // Loop until a valid input is received
            System.out.print(msg); // Display the message
            String str = sc.nextLine(); // Read input
            try {
                n = Integer.parseInt(str); // Convert the input to an integer
                if (n <= 0) { // Check if the input is a positive integer
                    throw new IllegalArgumentException(); // Throw an exception if input is invalid
                }
                return n;  // Return the integer if valid
            } catch (NumberFormatException e) { // Handle the case where the input is not an integer
                System.out.println("Please enter an integer!");
            } catch (IllegalArgumentException e) { // Handle the case where the input is not a positive number
                System.out.println("Please enter a positive number!");
            }
        }
    }

    /**
     * Method to check the validity of a double input
     *
     * @param msg displays a message before input
     * @return returns the double value after validation
     */
    public static double getDouble(String msg) {
        // Create a Scanner object to read input
        Scanner sc = new Scanner(System.in);
        double d;
        while (true) { // Loop until a valid input is received
            System.out.print(msg);  // Display the message
            String str = sc.nextLine();  // Read input
            try {
                d = Double.parseDouble(str); // Convert the input to a double
                if (d < 0 || d > 10) { // Check if the input is between 0 and 10
                    throw new IllegalArgumentException(); // Throw an exception if input is invalid
                }
                return d; // Return the double if valid
            } catch (NumberFormatException e) { // Handle the case where the input is not a double
                System.out.println("Please enter a real number!");
            } catch (IllegalArgumentException e) { // Handle the case where the input is out of range
                System.out.println("Please enter a real number from 0 to 10!");
            }
        }
    }

    /**
     * Method to check the validity of a string (non-empty and matches regex)
     *
     * @param msg displays a message before input
     * @param regex the regular expression to validate input
     * @return returns the string after validation
     */
    public static String getStringName(String msg, String regex) {
        // Create a Scanner object to read input
        Scanner sc = new Scanner(System.in);
        String str;
        Pattern pattern = Pattern.compile(regex);

        while (true) { // Loop until a valid input is received
            try {
                System.out.print(msg); // Display the message
                str = sc.nextLine(); // Read input
                Matcher matcher = pattern.matcher(str);

                if (str.isEmpty()) { // Check if the input is empty
                    System.out.println("String cannot be empty. Please try again.");
                } else if (!matcher.matches()) { // Check if the input matches the regex
                    System.out.println("Input does not match the required format. Please try again.");
                } else { // Valid input
                    return str; // Return the valid string
                }

            } catch (Exception e) { // Catch any exceptions
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    /**
     * Method to check if a student code exists in the list
     *
     * @param studentCode the student code to check
     * @param studentList list of students
     * @return returns true if the student code exists, false otherwise
     */
    public static boolean isStudentCodeExists(String studentCode, List<Student> studentList) {
        for (Student student : studentList) {
            if (student.getStudentCode().equalsIgnoreCase(studentCode)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method prompts the user to input a valid date of birth in the format
     * "DD-MMM-YYYY". It checks if the input matches the expected pattern,
     * ensures the year is not in the future, validates the day based on the
     * month and year (including leap year checks), and throws exceptions for
     * any invalid input.
     *
     * @param msg The prompt message displayed to the user for input.
     * @param dobPattern The regular expression pattern to validate the date
     * format.
     * @return A valid date of birth string in the format "DD-MMM-YYYY".
     * @throws IllegalArgumentException If the input contains an invalid day,
     * month, or year.
     */
    public static String getStudentCode(String msg, String regex, List<Student> studentList) {
        Scanner sc = new Scanner(System.in);
        String studentCode;
        Pattern pattern = Pattern.compile(regex); // Create a pattern to validate format

        while (true) {
            System.out.print(msg); // Display the message
            studentCode = sc.nextLine(); // Read student code
            Matcher matcher = pattern.matcher(studentCode); // Check if input matches pattern

            if (matcher.matches()) {
                // Check if student code already exists
                if (isStudentCodeExists(studentCode, studentList)) {
                    System.out.println("Student code already exists, please enter a different one.");
                } else {
                    return studentCode; // Return valid student code
                }
            } else {
                System.out.println("Invalid student code format. Please enter again.");
            }
        }
    }

    /**
     * Method to validate date of birth (based on format)
     *
     * @param msg displays a message before input
     * @param dobPattern regex pattern for a valid date of birth
     * @return returns the valid date of birth string
     */
    public static String getDateOfBirth(String msg, String dobPattern) {
        Scanner sc = new Scanner(System.in);  // Create a Scanner for input
        String dateOfBirth;
        Pattern pattern = Pattern.compile(dobPattern);  // Compile the pattern for date validation
        int currentYear = Year.now().getValue();  // Get the current year

        // Infinite loop to continuously ask for input until a valid date is entered
        while (true) {
            try {
                System.out.print(msg);  // Print the message to prompt the user
                dateOfBirth = sc.nextLine();  // Get the user input for date of birth
                Matcher matcher = pattern.matcher(dateOfBirth);  // Match the input against the pattern

                // If the input matches the pattern (valid format)
                if (matcher.matches()) {
                    // Split the input by '-' to extract day, month, and year
                    String[] parts = dateOfBirth.split("-");
                    String dayStr = parts[0];   // Extract the day as a string
                    String monthStr = parts[1]; // Extract the month as a string
                    String yearStr = parts[2];  // Extract the year as a string

                    int day = Integer.parseInt(dayStr);    // Convert the day to an integer
                    int year = Integer.parseInt(yearStr);  // Convert the year to an integer

                    // Check if the year is not in the future
                    if (year > currentYear) {
                        throw new IllegalArgumentException("Year cannot be in the future.");
                    }

                    // Manually map the three-letter month abbreviation to the Month enum
                    Month month = getMonthFromAbbreviation(monthStr);

                    // Get the maximum number of days in the specified month (consider leap year for February)
                    int maxDaysInMonth = month.length(Year.isLeap(year));

                    // Check if the day is within the valid range for that month
                    if (day < 1 || day > maxDaysInMonth) {
                        throw new IllegalArgumentException(monthStr + " has only " + maxDaysInMonth + " days.");
                    }

                    // If all validations pass, return the valid date of birth
                    return dateOfBirth;

                } else {
                    // If the input doesn't match the pattern, show an error message
                    System.out.println("Invalid date of birth. It should be in the format DD-MMM-YYYY.");
                }
            } catch (IllegalArgumentException e) {
                // Handle specific errors related to invalid date values (day, month, or year)
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                // Catch any other unexpected errors
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    /**
     * This helper method converts a three-letter month abbreviation (e.g.,
     * "Jan", "Feb") into the corresponding Java `Month` enum value. It supports
     * case-insensitive month abbreviations and throws an exception if the
     * abbreviation is invalid.
     *
     * @param monthStr The three-letter abbreviation of the month (e.g., "Jan",
     * "Feb").
     * @return The corresponding `Month` enum value for the given month
     * abbreviation.
     * @throws IllegalArgumentException If the provided month abbreviation is
     * invalid.
     */
    private static Month getMonthFromAbbreviation(String monthStr) {
        switch (monthStr.toLowerCase()) {
            case "jan":
                return Month.JANUARY;
            case "feb":
                return Month.FEBRUARY;
            case "mar":
                return Month.MARCH;
            case "apr":
                return Month.APRIL;
            case "may":
                return Month.MAY;
            case "jun":
                return Month.JUNE;
            case "jul":
                return Month.JULY;
            case "aug":
                return Month.AUGUST;
            case "sep":
                return Month.SEPTEMBER;
            case "oct":
                return Month.OCTOBER;
            case "nov":
                return Month.NOVEMBER;
            case "dec":
                return Month.DECEMBER;
            default:
                throw new IllegalArgumentException("Invalid month abbreviation.");
        }
    }

    /**
     * Method to validate the student's name
     *
     * @param msg displays a message before input
     * @param regex the required name format
     * @param minLength minimum length of the student's name
     * @param maxLength maximum length of the student's name
     * @param allowSpaces whether the name is allowed to contain spaces
     * @param minLengthWord minimum length of each word in the name
     * @param maxLengthWord maximum length of each word in the name
     * @return returns the valid name if conditions are met
     */
    public static String checkName(String msg, String regex, int minLength, int maxLength, boolean allowSpaces, int minLengthWord, int maxLengthWord) {
        // Create a Scanner object to read input
        Scanner sc = new Scanner(System.in);
        // Create a Pattern object to validate the format of the name
        Pattern pattern = Pattern.compile(regex);
        String name;

        while (true) {
            try {
                System.out.print(msg); // Display the message before input
                name = sc.nextLine(); // Read the name input
                if (name.length() < minLength || name.length() > maxLength) { // Check if the name length is within limits
                    System.out.println("Name must be between " + minLength + " and " + maxLength + " characters.");
                    continue; // Retry input
                }
                if (!allowSpaces && name.contains(" ")) { // Check if spaces are allowed
                    System.out.println("Spaces are not allowed in the name.");
                    continue; // Retry input
                }
                if (name.isEmpty()) { // Check if the name is empty
                    System.out.println("String cannot be empty");
                    continue; // Retry input
                }
                String[] words = name.trim().split("\\s+");
                if (words.length < minLengthWord || words.length > maxLengthWord) { // Check if the name has valid word count
                    System.out.println("Name must contain between " + minLengthWord + " and " + maxLengthWord + " words.");
                    continue; // Retry input
                }

                Matcher matcher = pattern.matcher(name);
                if (!matcher.matches()) { // Check if the name matches the format
                    System.out.println("Invalid name format. Please avoid special characters or numbers.");
                    continue; // Retry input
                }
                boolean isCapitalized = true;
                for (String word : words) { // Check each word in the name
                    if (!Character.isUpperCase(word.charAt(0))) { // Ensure each word starts with an uppercase letter
                        isCapitalized = false;
                        break;
                    }
                }
                if (!isCapitalized) { // Handle names that don't start with uppercase letters
                    System.out.println("Each word must start with an uppercase letter.");
                    continue; // Retry input
                }
                // Return the valid name after all checks
                return name;
            } catch (Exception e) { // Catch any exceptions
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }
}
