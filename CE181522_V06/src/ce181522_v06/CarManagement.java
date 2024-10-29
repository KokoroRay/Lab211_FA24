package ce181522_v06;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * The CarManagement class provides methods for managing car-related operations,
 * including validating car names, colors, prices, and sale days. It interacts
 * with enums for cars, colors, and days to ensure that inputs are valid and
 * match the predefined options.
 *
 * @author Nguyen Minh Tam - CE181522
 */
public class CarManagement {

    private Scanner sc = new Scanner(System.in);

    /**
     * Validates if the input string is non-null, non-empty, and does not
     * contain special characters.
     *
     * @param input the string input to validate
     * @return true if the input is valid, otherwise false
     */
    public boolean isValidString(String input) {
        // Check if input is not null, not empty (ignoring spaces), and contains no special characters
        return input != null && !input.trim().isEmpty() && !containsSpecialCharacters(input);
    }

    /**
     * Checks if the string contains any special characters.
     *
     * @param input the string to check
     * @return true if the input contains special characters, otherwise false
     */
    private boolean containsSpecialCharacters(String input) {
        // Use regular expression to allow only letters, digits, and spaces
        return !Pattern.matches("[a-zA-Z0-9 ]+", input);
    }

    /**
     * Prompts the user to input a valid car name and validates it using the
     * CarEnum.
     *
     * @param msg the message to prompt the user
     * @param mess an additional message to display
     * @return a valid CarEnum object
     */
    public CarEnum getValiCar(String msg, String mess) {
        CarEnum carEnum = CarEnum.AUDI;  // Temporary CarEnum object for validation
        while (true) {
            System.out.println(mess);
            System.out.print(msg);
            String carInput = sc.nextLine().trim().toUpperCase();
            if (!isValidString(carInput)) {
                System.out.println("Invalid input. Please enter a valid car name.");
                continue;
            }
            CarEnum car = carEnum.findCar(carInput);  // Use the findCar method from CarEnum to validate the input
            if (car != null) {
                return car;  // Return the valid CarEnum object
            } else {
                System.out.println("Can't sell Car");
                System.out.println("Car not available");
            }
        }
    }

    /**
     * Prompts the user to input a valid color name and validates it using the
     * ColorEnum.
     *
     * @param car the car selected by the user
     * @param msg the message to prompt the user
     * @return a valid ColorEnum object
     */
    public ColorEnum getValidColor(CarEnum car, String msg) {
        ColorEnum colorEnum = ColorEnum.WHITE;  // Temporary ColorEnum object for validation
        while (true) {
            System.out.print(msg);
            String colorInput = sc.nextLine().trim().toUpperCase();
            if (!isValidString(colorInput)) {
                System.out.println("Invalid input. Please enter a valid color name.");
                continue;
            }
            ColorEnum color = colorEnum.findColor(colorInput);  // Use the findColor method from ColorEnum to validate
            if (color != null) {
                return color;  // Return the valid ColorEnum object
            } else {
                System.out.println("Can't sell Car");
                System.out.println("Color does not exist");
            }
        }
    }

    /**
     * Prompts the user to input a valid price for the selected car and
     * validates it.
     *
     * @param car the car selected by the user
     * @param msg the message to prompt the user
     * @return a valid price from the list of valid prices for the car
     */
    public int getValidPrice(CarEnum car, String msg) {
        while (true) {
            System.out.print(msg);
            String priceInput = sc.nextLine().trim();
            try {
                int price = Integer.parseInt(priceInput);
                // Get the list of valid prices for the selected car
                int[] validPrices = car.getPrices();
                boolean isValid = false;
                // Check if the entered price matches any of the valid prices
                for (int validPrice : validPrices) {
                    if (price == validPrice) {
                        isValid = true;
                        break;
                    }
                }
                if (isValid) {
                    return price;  // Return the valid price
                } else {
                    throw new ExceptionCar("Invalid price for " + car.name());  // Throw custom exception if price is invalid
                }
            } catch (NumberFormatException e) {
                System.out.println("Price must be a valid number.");
            } catch (ExceptionCar e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Prompts the user to input a valid sale day for the selected car and
     * validates it using the DayEnum.
     *
     * @param car the car selected by the user
     * @param msg the message to prompt the user
     * @return a valid DayEnum object
     */
    public DayEnum getValidDay(CarEnum car, String msg) {
        DayEnum dayEnum = DayEnum.MONDAY;  // Temporary DayEnum object for validation
        while (true) {
            System.out.print(msg);
            String dayInput = sc.nextLine().trim().toUpperCase();
            if (!isValidString(dayInput)) {
                System.out.println("Invalid input. Please enter a valid day.");
                continue;
            }
            DayEnum day = dayEnum.findDay(dayInput);  // Use the findDay method from DayEnum to validate the input
            if (day != null) {
                return day;  // Return the valid DayEnum object
            } else {
                System.out.println("Can't sell Car");
                System.out.println("Invalid day");
            }
        }
    }

    /**
     * Checks if the selected color is available for the selected car.
     *
     * @param car the car selected by the user
     * @param color the color selected by the user
     * @return true if the color is available, otherwise false
     */
    public boolean isColorAvailable(CarEnum car, ColorEnum color) {
        // Iterate through the list of available colors for the car
        for (String c : car.getColors()) {
            if (c.equalsIgnoreCase(color.name())) {
                return true;  // Return true if color is available
            }
        }
        return false;  // Return false if color is not available
    }

    /**
     * Checks if the selected car is available for sale on the selected day.
     *
     * @param car the car selected by the user
     * @param day the day selected by the user
     * @return true if the car is available for sale on the selected day,
     * otherwise false
     */
    public boolean isCarAvailableToday(CarEnum car, DayEnum day) {
        // Iterate through the list of days when the car is available for sale
        for (String d : car.getDaySells()) {
            if (d.equalsIgnoreCase(day.name())) {
                return true;  // Return true if car is available on the selected day
            }
        }
        return false;  // Return false if car is not available on the selected day
    }

}
