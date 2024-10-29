package ce181522_v06;

/**
 * `DayEnum` defines the days of the week when cars are available for sale. It
 * includes a method to find the corresponding day based on a string input.
 *
 * @author Nguyen Minh Tam - CE181522
 */
public enum DayEnum {
    // Enum instances representing each day of the week
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    /**
     * Finds a day enum value by its name, ignoring case sensitivity.
     *
     * @param day the name of the day (entered by the user)
     * @return the matching `DayEnum` instance, or null if not found
     */
    public DayEnum findDay(String day) {
        // Iterate through all the enum values
        for (DayEnum d : DayEnum.values()) {
            // Check if the current enum instance name matches the input, ignoring case
            if (d.name().equalsIgnoreCase(day)) {
                return d;  // Return the valid day if found
            }
        }
        return null;  // Return null if no matching day is found
    }
}
