package ce181522_v04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * SlotMachineGame class that encapsulates the functionality of a simple slot
 * machine game. It manages the user's balance, allows playing the game, saving
 * and loading game state.
 *
 * Author: Nguyen Minh Tam - CE181522
 */
public class SlotMachine {

    // User's current balance
    private double balance;

    // Constants for game costs and prizes
    private final double COST_PER_PLAY = 0.25;
    private final double WIN_TWO_KIND = 0.50;
    private final double WIN_THREE_KIND = 10.00;

    // File name for saving the game state
    private final String SAVE_FILE = "slotmachineSave.txt";

    /**
     * Constructor initializes the balance to a default value.
     */
    public SlotMachine() {
        this.balance = 10.00; // Starting balance
    }

    /**
     * Simulates playing the slot machine. Deducts cost from balance, generates
     * random numbers, and determines winnings based on the generated numbers.
     */
    public void play() {
        // Check if the user has enough balance to play
        if (balance < COST_PER_PLAY) {
            System.out.println("Sorry, you have run out of money to play. Please add more money to your account.");
            return;
        }

        // Deduct the cost of playing
        balance -= COST_PER_PLAY;

        // Generate three random digits (0-9)
        Random rd = new Random();
        int dig1 = rd.nextInt(10);
        int dig2 = rd.nextInt(10);
        int dig3 = rd.nextInt(10);

        // Display the generated digits
        System.out.println("The slot machine shows " + dig1 + dig2 + dig3);

        // Determine winnings based on the generated digits
        if (dig1 == dig2 && dig2 == dig3) {
            System.out.println("You win the big prize, $10.00!");
            balance += WIN_THREE_KIND; // Win for three of a kind
        } else if (dig1 == dig2 || dig2 == dig3 || dig1 == dig3) {
            System.out.println("You win 50 cents!");
            balance += WIN_TWO_KIND; // Win for two of a kind
        } else {
            System.out.println("Sorry, you don't win anything.");
        }
    }

    /**
     * Ends the game session and saves the current balance.
     */
    public void cashOut() {
        System.out.println("Thank you for playing! You end with $" + balance);
        saveGame(); // Save the game state before exiting
    }

    /**
     * Saves the current balance to a file.
     */
    public void saveGame() {
        try (FileWriter writer = new FileWriter(SAVE_FILE)) {
            writer.write(Double.toString(balance)); // Write the balance to the file
        } catch (IOException e) {
            System.out.println("Save game error: " + e.getMessage()); // Handle file write errors
        }
    }

    /**
     * Loads the game state from a file, restoring the user's balance.
     */
    public void loadGame() {
        File fileSave = new File(SAVE_FILE);
        if (fileSave.exists()) {
            try (BufferedReader rd = new BufferedReader(new FileReader(fileSave))) {
                String line = rd.readLine();
                if (line != null) {
                    balance = Double.parseDouble(line); // Parse balance from the file
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error loading game: " + e.getMessage()); // Handle read errors
            }
        } else {
            System.out.println("Previous saved game not found, start over");
        }
    }

    /**
     * Returns the current balance.
     *
     * @return The current balance as a double.
     */
    public double getBalance() {
        return balance;
    }
}
