package ce181522_s12;

/**
 * CE181522_S12 is the main class of the application. This class initiates the
 * number system conversion process by calling the NumberConverter class.
 *
 * Title: Number System Converter (Binary/Octal/Hexadecimal to Decimal)
 *
 * Author: Nguyen Minh Tam - CE181522
 *
 * Description: This program allows the user to convert numbers from binary,
 * octal, or hexadecimal systems into decimal (base 10). The program will ask
 * for user input and handle the conversion using manual algorithms without
 * relying on built-in Java libraries. The conversion logic is handled by the
 * NumberConverter class, and input validation is performed in the
 * CheckInputValue class. The program will run in a loop until the user decides
 * to exit.
 */
public class CE181522_S12 {

    /**
     * The main method of the program. It creates an instance of the
     * NumberConverter class and starts the conversion process.
     *
     * @param args Command line arguments (not used in this program).
     */
    public static void main(String[] args) {
        // Instantiate the NumberConverter object to handle number system conversion
        NumberConverter number = new NumberConverter();

        // Call the Converter method to start the program
        number.converter();
    }
}
