package ce181522_v04;

import java.util.Scanner;

/**
 * MainMenu class that provides the interface for the slot machine game. It
 * allows users to interact with the game through a simple console menu.
 *
 * @author Nguyen Minh Tam - CE181522
 */
public class MainMenu {

    /**
     * Starts the main menu loop for the slot machine game.
     */
    public void star() {
        // Create a Scanner object for user input
        Scanner sc = new Scanner(System.in);

        // Create instances of input validation and slot machine game classes
        CheckInputValue IO = new CheckInputValue();
        SlotMachine gameSlot = new SlotMachine();  // Updated here

        // Load the game state (e.g., user balance, previous game data)
        gameSlot.loadGame();

        // Infinite loop to keep the menu active until the user chooses to exit
        while (true) {
            // Display current balance to the user
            System.out.println("You have $" + gameSlot.getBalance());
            System.out.println("Choose one of the following menu options:");
            System.out.println("1) Play the slot machine.");
            System.out.println("2) Save game.");
            System.out.println("3) Cash out.");

            // Get a valid integer input from the user
            int choice = IO.getValidInteger();

            // Switch statement to handle user input
            switch (choice) {
                case 1:
                    // User chooses to play the slot machine
                    gameSlot.play();
                    break;
                case 2:
                    // User chooses to save the game state
                    System.out.println("Your money has been saved!");
                    gameSlot.saveGame();
                    break;
                case 3:
                    // User chooses to cash out and exit the game
                    gameSlot.cashOut();
                    System.exit(0);
                    break;
                default:
                    // Handle invalid selections
                    System.out.println("Please re-enter, invalid selection!");
            }
        }
    }
}
