package ce181522_v01;

import java.util.Scanner;

/**
 * Class responsible for handling and validating user inputs. Provides methods
 * to validate integers, card numbers, PINs, balances, and amounts.
 *
 * @author Nguyen Minh Tam - CE181522
 */
public class CheckInputValue {

    Scanner sc = new Scanner(System.in);  // Create Scanner object to capture input from the user

    /**
     * Validates integer input from the user. Loops until the user enters a
     * valid integer that is greater than 0.
     *
     * @param msg Message to display for input prompt.
     * @return A valid integer value.
     */
    public int getInteger(String msg) {
        int n;
        while (true) {  // Loop continuously until a valid integer is entered
            System.out.print(msg);  // Prompt user for input
            String str = sc.nextLine();  // Capture input as a string
            try {
                n = Integer.parseInt(str);  // Attempt to convert string to an integer
                if (n <= 0) {  // Check if the integer is positive
                    throw new IllegalArgumentException();  // Throw exception if the number is not positive
                }
                return n;  // Return valid integer if no exception occurred
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer!");  // Handle invalid integer input
            } catch (IllegalArgumentException e) {
                System.out.println("Please enter a positive number!");  // Handle non-positive integer
            }
        }
    }

    /**
     * Validates card number input based on a regex pattern. Loops until the
     * user enters a card number that matches the regex.
     *
     * @param regex Regular expression pattern for validating card number
     * format.
     * @param msg Message to display for input prompt.
     * @return A valid card number that matches the regex.
     */
    public String validateCardNumber(String regex, String msg) {
        while (true) {  // Loop continuously until a valid card number is entered
            System.out.println(msg);  // Prompt user for card number input
            String input = sc.nextLine();  // Capture card number input as a string
            try {
                if (!input.matches(regex)) {  // Check if the input matches the regex pattern
                    throw new IllegalArgumentException("Invalid card number");  // Throw exception if invalid
                } else {
                    return input;  // Return valid card number
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());  // Display error message if invalid input
            }
        }
    }

    /**
     * Validates PIN input based on a regex pattern. Loops until the user enters
     * a valid PIN that matches the regex.
     *
     * @param regex Regular expression pattern for validating PIN format.
     * @param msg Message to display for input prompt.
     * @return A valid PIN.
     */
    public String validatePin(String regex, String msg) {
        while (true) {  // Loop continuously until a valid PIN is entered
            System.out.println(msg);  // Prompt user for PIN input
            String input = sc.nextLine();  // Capture PIN input as a string
            try {
                if (input.matches(regex)) {  // Check if the input matches the regex pattern
                    return input;  // Return valid PIN if it matches
                } else {
                    throw new IllegalArgumentException("Invalid Pin");  // Throw exception if PIN is invalid
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());  // Display error message if invalid input
            }
        }
    }

    /**
     * Validates balance input from the user. Loops until the user enters a
     * valid non-negative balance.
     *
     * @param msg Message to display for input prompt.
     * @return A valid non-negative balance.
     */
    public double validateBalance(String msg) {
        while (true) {  // Loop continuously until a valid balance is entered
            try {
                System.out.println(msg);  // Prompt user for balance input
                String input = sc.nextLine();  // Capture balance input as a string
                double balance = Double.parseDouble(input);  // Convert input to double
                if (balance >= 0) {  // Check if the balance is non-negative
                    return balance;  // Return valid balance
                } else {
                    throw new IllegalArgumentException("Balance must be positive!");  // Throw exception if invalid
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());  // Display error message if invalid input
            }
        }
    }

    /**
     * Validates amount input from the user. Loops until the user enters a valid
     * positive amount.
     *
     * @param msg Message to display for input prompt.
     * @return A valid amount greater than zero.
     */
    public double validateAmount(String msg) {
        while (true) {  // Loop continuously until a valid amount is entered
            try {
                System.out.println(msg);  // Prompt user for amount input
                String input = sc.nextLine();  // Capture amount input as a string
                double amount = Double.parseDouble(input);  // Convert input to double
                if (amount > 0) {  // Check if the amount is positive
                    return amount;  // Return valid amount
                } else {
                    throw new IllegalArgumentException("Amount must be greater than Zero");  // Throw exception if invalid
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());  // Display error message if invalid input
            }
        }
    }
}
