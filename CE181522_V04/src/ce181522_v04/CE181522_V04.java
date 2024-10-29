package ce181522_v04;

/**
 * CE181522_V04 class serves as the entry point for the slot machine game
 * application. It initializes the main menu and starts the game.
 *Title: Simple Slot Machine
 * Author: Nguyen Minh Tam - CE181522
 */
public class CE181522_V04 {

    /**
     * Main method that executes when the program is run.
     *
     * @param args The command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Create an instance of the mainMenu class
        MainMenu user = new MainMenu();

        // Call the star method to display the menu and start the game
        user.star();
    }
}
