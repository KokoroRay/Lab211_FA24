package ce181522_v07;

import java.util.Random;

/**
 * Title: This is the main class that initializes the program and starts the
 * LuckNumberGame.
 *
 * @author Nguyen Minh Tam - CE181522
 */
public class CE181522_V07 {

    /**
     * Main method Entry point for the program, responsible for starting the
     * LuckNumberGame.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create an instance of the LuckNumberGame to track statistics
        LuckNumberGame game = new LuckNumberGame();
        Random random = new Random();  // Random object to generate the lucky number
        boolean keepPlaying = true;    // Flag to control the game loop

        while (keepPlaying) {
            // Generates a random lucky number between 0 and the max number in the game
            int luckNumber = random.nextInt(game.getMaxNumber() + 1);
            int guessCount = 0;       // Tracks number of guesses for the current game
            boolean guessedCorrectly = false; // Flag for when the lucky number is guessed

            System.out.println("Game started! The lucky number is between 0 and " + game.getMaxNumber());

            // Inner loop for guessing the lucky number
            while (!guessedCorrectly) {
                int guess = game.getIO().getIntInput(); // Gets user guess
                guessCount++;                      // Increments guess count

                // Provides feedback based on the user's guess
                if (guess > luckNumber) {
                    System.out.println("The lucky number is smaller than your guess.");
                } else if (guess < luckNumber) {
                    System.out.println("The lucky number is larger than your guess.");
                } else {
                    // If the guess is correct, end the guessing round
                    System.out.println("Congratulations! You guessed the lucky number in " + guessCount + " tries.");
                    guessedCorrectly = true;
                }
            }

            // Update statistics after the game ends
            game.incrementTotalGame();                  // Increments total games played
            game.addToTotalGuesses(guessCount);    // Adds guess count to total guesses

            // Updates best game if this game required fewer guesses
            if (guessCount < game.getBestGame()) {
                game.setBestGame(guessCount);
            }

            // Ask the user if they want to play again
            keepPlaying = game.getIO().getYesNoInput();
        }

        // After the game ends, show the statistics report
        game.report();
    }
}
