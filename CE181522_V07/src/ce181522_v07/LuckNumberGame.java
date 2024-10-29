package ce181522_v07;

import java.util.Random;

/**
 * Game logic class Implements the lucky number game, tracks guesses, games
 * played, and statistics.
 *
 * @author: Nguyen Minh Tam - CE181522
 */
public class LuckNumberGame {

    private static final int MAX_NUMBER = 100; // The maximum number for the lucky number
    private int totalGame = 0;                 // Tracks total games played
    private int totalGuesses = 0;              // Tracks total number of guesses
    private int bestGame = Integer.MAX_VALUE;  // Tracks the best game (fewest guesses)

    CheckInputValue IO = new CheckInputValue(); // Uses CheckInputValue for input validation

    /**
     * Method to start the game Manages the game loop, allows multiple games to
     * be played, and tracks statistics.
     */
    public void play() {

    }

    /**
     * Method to display game statistics Prints total games played, total
     * guesses, average guesses per game, and the best game.
     */
    public void report() {
        // Displays overall statistics of the game session
        System.out.println("Total games played: " + totalGame);
        System.out.println("Total guesses made: " + totalGuesses);
        System.out.println("Average guesses per game: " + (double) totalGuesses / totalGame);
        System.out.println("Best game (fewest guesses): " + bestGame);
    }

    public int getMaxNumber() {
        return MAX_NUMBER;
    }

    // Getter for IO
    public CheckInputValue getIO() {
        return IO;
    }

    // Getter for totalGame
    public int getTotalGame() {
        return totalGame;
    }

    // Increment totalGame
    public void incrementTotalGame() {
        totalGame++;
    }

    // Getter for totalGuesses
    public int getTotalGuesses() {
        return totalGuesses;
    }

    // Add to totalGuesses
    public void addToTotalGuesses(int guesses) {
        totalGuesses += guesses;
    }

    // Getter for bestGame
    public int getBestGame() {
        return bestGame;
    }

    // Setter for bestGame
    public void setBestGame(int bestGame) {
        this.bestGame = bestGame;
    }
}
