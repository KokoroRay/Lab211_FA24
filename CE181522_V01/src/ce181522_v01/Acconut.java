package ce181522_v01;

/**
 * Class representing a bank account in the ATM system. Contains fields for card
 * number, PIN, account name, balance, and currency type. Includes methods for
 * retrieving and updating account details.
 *
 * @author Nguyen Minh Tam - CE181522
 */
public class Acconut {

    // Fields for storing account information
    private String cardNumber;  // Stores the card number of the account
    private String pin;  // Stores the PIN of the account
    private String accName;  // Stores the name of the account holder
    private double balance;  // Stores the current balance of the account
    private String monryType;  // Stores the currency type of the account

    /**
     * Constructor to initialize the account with given details.
     *
     * @param cardNumber The card number associated with the account.
     * @param pin The PIN for accessing the account.
     * @param accName The account holder's name.
     * @param balance The starting balance of the account.
     * @param monryType The currency type (e.g., USD, EUR).
     */
    public Acconut(String cardNumber, String pin, String accName, double balance, String monryType) {
        this.cardNumber = cardNumber;  // Initialize card number
        this.pin = pin;  // Initialize PIN
        this.accName = accName;  // Initialize account holder name
        this.balance = balance;  // Initialize account balance
        this.monryType = monryType;  // Initialize currency type
    }

    // Getter methods to access account details
    /**
     * Returns the card number of the account.
     *
     * @return cardNumber The card number.
     */
    public String getCardNumber() {
        return cardNumber;  // Return the card number
    }

    /**
     * Returns the PIN of the account.
     *
     * @return pin The account's PIN.
     */
    public String getPin() {
        return pin;  // Return the PIN
    }

    /**
     * Returns the account holder's name.
     *
     * @return accName The account holder's name.
     */
    public String getAccName() {
        return accName;  // Return the account holder's name
    }

    /**
     * Returns the current balance of the account.
     *
     * @return balance The current balance.
     */
    public double getBalance() {
        return balance;  // Return the current balance
    }

    /**
     * Returns the currency type of the account.
     *
     * @return moneyType The currency type.
     */
    public String getMoneyType() {
        return monryType;  // Return the currency type
    }

    /**
     * Updates the account balance.
     *
     * @param balance The new balance to set for the account.
     */
    public void setBalance(double balance) {
        this.balance = balance;  // Update the account balance
    }

    /**
     * Deposits a specified amount into the account, updating the balance.
     *
     * @param amount The amount to deposit. Must be positive.
     * @throws IllegalArgumentException if amount is negative or zero.
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive.");
        }
        balance += amount;  // Update the balance with the deposit amount
    }

    /**
     * Withdraws a specified amount from the account, updating the balance.
     *
     * @param amount The amount to withdraw. Must be positive and less than or
     * equal to the current balance.
     * @throws IllegalArgumentException if amount is negative or greater than
     * the balance.
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive.");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance for withdrawal.");
        }
        balance -= amount;  // Update the balance with the withdrawal amount
    }
}
