package ce181522_s12;

import java.util.Scanner;

/**
 * CheckInputValue class handles the validation of binary, octal, and
 * hexadecimal inputs from the user. It ensures the input matches the expected
 * format for each number system before processing.
 *
 * @author Nguyen Minh Tam - CE181522
 */
public class CheckInputValue {

    private Scanner sc; // Instance variable to handle user input

    /**
     * Constructor to initialize the scanner object for input reading.
     *
     * @param sc The Scanner object passed from the main program.
     */
    public CheckInputValue(Scanner sc) {
        this.sc = sc;
    }

    /**
     * Validates if the input is a valid binary number. A valid binary number
     * contains only the digits '0' and '1'.
     *
     * @return A valid binary string from the user.
     */
    public String checkBinaryInput() {
        String binaryInput = "";
        // Loop until a valid binary number is entered
        while (true) {
            System.out.print("Enter binary number: ");
            binaryInput = sc.nextLine();
            // Validate that the input contains only '0' or '1'
            if (binaryInput.matches("[01]+")) {
                return binaryInput; // Valid input, return the binary number
            } else {
                System.out.println("Invalid binary number! Please enter only 0s and 1s.");
            }
        }
    }

    /**
     * Validates if the input is a valid octal number. A valid octal number
     * contains digits between '0' and '7'.
     *
     * @return A valid octal string from the user.
     */
    public String checkOctalInput() {
        String octalInput = "";
        // Loop until a valid octal number is entered
        while (true) {
            System.out.print("Enter octal number: ");
            octalInput = sc.nextLine();
            // Validate that the input contains only digits between '0' and '7'
            if (octalInput.matches("[0-7]+")) {
                return octalInput; // Valid input, return the octal number
            } else {
                System.out.println("Invalid octal number! Please enter digits between 0 and 7.");
            }
        }
    }

    /**
     * Validates if the input is a valid hexadecimal number. A valid hexadecimal
     * number contains digits between '0-9' and letters 'A-F'
     * (case-insensitive).
     *
     * @return A valid hexadecimal string from the user.
     */
    public String checkHexInput() {
        String hexInput = "";
        // Loop until a valid hexadecimal number is entered
        while (true) {
            System.out.print("Enter hexadecimal number: ");
            hexInput = sc.nextLine();
            // Validate that the input contains only digits and letters in the hexadecimal range
            if (hexInput.matches("[0-9A-Fa-f]+")) {
                return hexInput; // Valid input, return the hexadecimal number
            } else {
                System.out.println("Invalid hexadecimal number! Please enter digits between 0-9 and A-F.");
            }
        }
    }
}
