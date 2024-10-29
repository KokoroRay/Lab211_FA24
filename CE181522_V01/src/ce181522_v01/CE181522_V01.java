package ce181522_v01;

/**
 * Title: Simulate ATM’s operation
 *
 * Entry point for the ATM system simulation. This class contains the main
 * method to start the ATM operations.
 *
 * @author Nguyen Minh Tam - CE181522
 */
public class CE181522_V01 {

    /**
     * Main method to launch the ATM system. It creates an instance of the
     * ATMSystem class and calls the start method.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        ATMSystem atm = new ATMSystem();  // Create an instance of ATMSystem to manage ATM operations
        atm.start();  // Start the ATM system
    }
}
