package ce181522_v06;

/**
 * `CarEnum` defines a set of cars available in the showroom. Each car has
 * associated attributes including available colors, prices, and the days they
 * are available for sale.
 *
 * @author Nguyen Minh Tam - CE181522
 */
public enum CarEnum {
    // Enum instances, each representing a car with its respective attributes:
    // Colors, Prices, and Days Available for Sale
    AUDI(new String[]{"White", "Yellow", "Orange"}, new int[]{5500, 3000, 4500}, new String[]{"Friday", "Sunday", "Monday"}),
    MERCEDES(new String[]{"Green", "Blue", "Purple"}, new int[]{5000, 6000, 8500}, new String[]{"Tuesday", "Saturday", "Wednesday"}),
    BMW(new String[]{"Pink", "Red", "Brown"}, new int[]{2500, 3000, 3500}, new String[]{"Monday", "Sunday", "Thursday"});

    // Instance variables for each car's attributes: colors, prices, and days of sale
    private String[] colors;
    private int[] prices;
    private String[] daySells;

    /**
     * Constructor to initialize the enum instances with car-specific
     * attributes.
     *
     * @param colors The array of available colors for the car.
     * @param prices The array of prices corresponding to the car's colors.
     * @param daySells The array of days the car is available for sale.
     */
    CarEnum(String[] colors, int[] prices, String[] daySells) {
        this.colors = colors;
        this.prices = prices;
        this.daySells = daySells;
    }

    // Getter methods for accessing each car's colors, prices, and sale days
    /**
     * Returns the array of colors available for the car.
     *
     * @return An array of color options for the car.
     */
    public String[] getColors() {
        return colors;
    }

    /**
     * Returns the array of prices for the car, corresponding to its color
     * options.
     *
     * @return An array of prices for the car.
     */
    public int[] getPrices() {
        return prices;
    }

    /**
     * Returns the array of days when the car is available for sale.
     *
     * @return An array of available sale days for the car.
     */
    public String[] getDaySells() {
        return daySells;
    }

    /**
     * Searches for a car by its name (case-insensitive) among the enum
     * instances. If found, the corresponding `CarEnum` object is returned.
     *
     * @param carName The name of the car to be searched.
     * @return The corresponding `CarEnum` object if a match is found, or null
     * if no match.
     */
    public CarEnum findCar(String carName) {
        // Iterate through all enum values to find the matching car name
        for (CarEnum car : CarEnum.values()) {
            if (car.name().equalsIgnoreCase(carName)) {
                return car;  // Return the matching car instance
            }
        }
        return null;  // Return null if no car matches the input name
    }
}
