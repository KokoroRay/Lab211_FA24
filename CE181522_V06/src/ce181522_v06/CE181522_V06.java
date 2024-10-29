package ce181522_v06;

/**
 * Title: Car showroom.
 *
 * This class starts the car showroom program. It creates an instance of the
 * `Main` class and triggers the execution of the program.
 *
 * @author Nguyen Minh Tam - CE181522
 */
public class CE181522_V06 {

    /**
     * This is the main method that starts the program by creating an object of
     * the `Main` class and invoking its start method.
     *
     * @param args command line arguments (not used in this program)
     */
    public static void main(String[] args) {
        // Create an object of `Main` to execute the main logic of the program
        Main car = new Main();
        // Start the program by calling the start method
        car.start();
    }
}
