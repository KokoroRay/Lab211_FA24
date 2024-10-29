package ce181522_v06;

/**
 * `ExceptionCar` is a custom exception used to handle invalid car-related
 * scenarios, such as invalid prices or other errors in the car showroom
 * program.
 *
 * @author Nguyen Minh Tam - CE181522
 */
class ExceptionCar extends Exception {

    /**
     * Constructor for the `ExceptionCar` class.
     *
     * @param message the error message associated with the exception
     */
    public ExceptionCar(String message) {
        super(message);  // Call the superclass constructor with the provided message
    }
}
