package ce181522_v06;

/**
 * `ColorEnum` defines the available colors for cars in the showroom. It
 * provides a method to find a color based on user input.
 *
 * @author Nguyen Minh Tam - CE181522
 */
public enum ColorEnum {
    // Enum instances representing different available colors
    WHITE, YELLOW, ORANGE, GREEN, BLUE, PURPLE, PINK, RED, BROWN, NO_COLOR;

    /**
     * Finds a color enum value by its name, ignoring case sensitivity.
     *
     * @param color the name of the color (entered by the user)
     * @return the matching `ColorEnum` instance, or null if not found
     */
    public ColorEnum findColor(String color) {
        // Iterate through all the enum values
        for (ColorEnum c : ColorEnum.values()) {
            // Check if the current enum instance name matches the input, ignoring case
            if (c.name().equalsIgnoreCase(color)) {
                return c;  // Return the valid color if found
            }
        }
        return null;  // Return null if no matching color is found
    }
}
