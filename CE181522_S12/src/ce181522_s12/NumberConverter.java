package ce181522_s12;

import java.util.Scanner;

/**
 * NumberConverter class provides a menu-driven program for converting binary,
 * octal, and hexadecimal numbers to decimal. This version implements manual
 * conversion algorithms for each number system.
 *
 * Author: Nguyen Minh Tam - CE181522
 */
public class NumberConverter {

    private String binary;
    private String octal;
    private String hex;

    /**
     * Converter method provides the main logic for the program. It displays a
     * menu for the user to choose the conversion type, validates input,
     * performs the conversion, and displays the results.
     */
    public void converter() {
        Scanner sc = new Scanner(System.in);
        CheckInputValue validator = new CheckInputValue(sc);
        int choice;

        // The main loop that keeps showing the menu until the user chooses to exit
        do {
            System.out.println("1. Convert binary number to decimal number");
            System.out.println("2. Convert octal number to decimal number");
            System.out.println("3. Convert hexadecimal number to decimal number");
            System.out.println("4. Exit");
            System.out.print("Please choose number (1 – 4): ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        binary = validator.checkBinaryInput(); // Validate and set binary input
                        int decimalBinary = convertBinaryToDecimal(); // Manual binary to decimal conversion
                        System.out.println("Decimal number is: " + decimalBinary);
                        break;
                    case 2:
                        octal = validator.checkOctalInput(); // Validate and set octal input
                        int decimalOctal = convertOctalToDecimal(); // Manual octal to decimal conversion
                        System.out.println("Decimal number is: " + decimalOctal);
                        break;
                    case 3:
                        hex = validator.checkHexInput(); // Validate and set hex input
                        int decimalHex = convertHexToDecimal(); // Manual hexadecimal to decimal conversion
                        System.out.println("Decimal number is: " + decimalHex);
                        break;
                    case 4:
                        System.out.println("Exiting program...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please choose a number between 1 and 4.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                choice = -1;
            }
        } while (choice != 4);

        sc.close();
    }

    /**
     * Convert the binary instance variable to a decimal integer manually.
     *
     * @return The decimal equivalent of the binary number.
     */
    private int convertBinaryToDecimal() {
        int decimal = 0; // Result variable
        int length = binary.length(); // Length of the binary string

        // Loop through each character in the binary string
        for (int i = 0; i < length; i++) {
            char bit = binary.charAt(length - 1 - i); // Get the bit at the current position
            if (bit == '1') {
                decimal += Math.pow(2, i); // Add 2^position for '1' bits
            }
        }
        return decimal;
    }

    /**
     * Convert the octal instance variable to a decimal integer manually.
     *
     * @return The decimal equivalent of the octal number.
     */
    private int convertOctalToDecimal() {
        int decimal = 0; // Result variable
        int length = octal.length(); // Length of the octal string

        // Loop through each character in the octal string
        for (int i = 0; i < length; i++) {
            char digit = octal.charAt(length - 1 - i); // Get the digit at the current position
            decimal += (digit - '0') * Math.pow(8, i); // Multiply the digit by 8^position and add it
        }
        return decimal;
    }

    /**
     * Convert the hex instance variable to a decimal integer manually.
     *
     * @return The decimal equivalent of the hexadecimal number.
     */
    private int convertHexToDecimal() {
        int decimal = 0; // Result variable
        int length = hex.length(); // Length of the hexadecimal string

        // Loop through each character in the hexadecimal string
        for (int i = 0; i < length; i++) {
            char digit = hex.charAt(length - 1 - i); // Get the digit/character at the current position

            // Convert hexadecimal digit to its decimal equivalent
            int decimalValue;
            if (digit >= '0' && digit <= '9') {
                decimalValue = digit - '0'; // '0' to '9' -> 0 to 9
            } else if (digit >= 'A' && digit <= 'F') {
                decimalValue = 10 + (digit - 'A'); // 'A' to 'F' -> 10 to 15
            } else {
                decimalValue = 10 + (digit - 'a'); // 'a' to 'f' -> 10 to 15
            }

            decimal += decimalValue * Math.pow(16, i); // Multiply the decimal value by 16^position
        }
        return decimal;
    }
}
