package ce181522_v06;

import java.util.Scanner;

/**
 * The `Main` class is the primary class for running the showroom program. It
 * handles user interaction, collects inputs, and checks if the selected car,
 * color, and sale day are valid.
 *
 * @author Nguyen Minh Tam - CE181522
 */
public class Main {

    // Create an instance of the input validator class
    CheckInputValue IO = new CheckInputValue();
    CarManagement system = new CarManagement();
    // Scanner for reading user input
    Scanner sc = new Scanner(System.in);

    /**
     * Starts the showroom program. It prompts the user to enter car, color,
     * price, and sale day information, and then checks the validity of these
     * inputs.
     */
    public void start() {
        // The program runs in a loop to allow multiple car sales
        while (true) {
            System.out.println("====== Showroom Car Program ======");

            // Get car information from the user
            CarEnum car = system.getValiCar("Name: ", "Input Information of Car");
            // Get color information
            ColorEnum color = system.getValidColor(car, "Color: ");
            // Get price information
            int price = system.getValidPrice(car, "Price: ");
            // Get the sale day information
            DayEnum day = system.getValidDay(car, "Today: ");

            // Validate the collected inputs
            if (price <= 0) {
                // Display error if the price is invalid
                System.out.println("Can't sell Car");
                System.out.println("Price must be greater than zero");
            } else if (!system.isColorAvailable(car, color)) {
                // Display error if the selected color is not available
                System.out.println("Can't sell Car");
                System.out.println("Color does not exist");
            } else if (!system.isCarAvailableToday(car, day)) {
                // Display error if the car is not available for sale on the selected day
                System.out.println("Can't sell Car");
                System.out.println("Car can't be sold today");
            } else {
                // If all inputs are valid, proceed with the sale
                System.out.println("Car sold successfully!");
                // Ask the user if they want to find more cars
                System.out.print("Do you want to find more? (Y/N): ");
                String choice = sc.nextLine().trim().toLowerCase();
                // Exit the loop if the user doesn't want to continue
                if (choice.equals("n")) {
                    break;
                }
            }
        }
        // Close the scanner when the program finishes
        sc.close();
    }
}
