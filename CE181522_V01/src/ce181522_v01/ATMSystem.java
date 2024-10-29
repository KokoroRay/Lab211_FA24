package ce181522_v01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * This class represents an ATM system that allows users to perform various
 * banking operations such as logging in, registering accounts, withdrawing
 * money, transferring money, and logging out. The system reads account
 * information from a file and allows for transactions to be recorded.
 *
 * @author Nguyen Minh Tam - CE181522
 */
public class ATMSystem {

    private final String ACCOUNT = "accounts.txt";  // File path for storing account details
    private final String TRANSACTIONS = "transactions.txt";  // File path for storing transaction records

    public List<Acconut> accs = new ArrayList<>();  // List to hold all accounts
    public Acconut currentAcc;  // The currently logged-in account

    CheckInputValue IO = new CheckInputValue();  // Instance of CheckInputValue for input validation
    Scanner sc = new Scanner(System.in);  // Scanner for user input

    /**
     * Constructor for ATMSystem. Initializes the system and loads existing
     * accounts from the file.
     */
    public ATMSystem() {
        loadAcc();  // Load accounts from the file when the ATM system starts
    }

    /**
     * Main method to display the ATM menu and handle user choices. Continuously
     * loops until the user chooses to exit the application.
     */
    public void start() {
        while (true) {
            // Display ATM menu
            System.out.println("======== ATM Menu ========");
            System.out.println("1. Login");
            System.out.println("2. Register Acconut");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Logout");
            System.out.println("6. Exit");

            // Get user choice
            int choice = IO.getInteger("Please chooce an option: ");

            // Handle user choice with switch-case
            switch (choice) {
                case 1:
                    login();  // Call login method
                    break;
                case 2:
                    registerAcc();  // Call account registration method
                    break;
                case 3:
                    withdraw();  // Call withdrawal method
                    break;
                case 4:
                    transfer();  // Call transfer method
                    break;
                case 5:
                    logout();  // Call logout method
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM");
                    System.exit(0);  // Exit the application
                default:
                    System.out.println("Invalid option. Please choose again!!!");  // Handle invalid input
                    break;
            }
        }
    }

    /**
     * Method to handle user login. Validates the card number and PIN, and sets
     * the current account.
     */
    public void login() {
        if (currentAcc != null) {
            System.out.println("Already logged in.");  // Check if user is already logged in
            return;
        }
        // Validate card number and PIN using the CheckInputValue class
        String cardNum = IO.validateCardNumber("\\d{14}", "Enter card number (14 digits): ");
        String pinNum = IO.validatePin("\\d{6}", "Enter PIN (6 digits): ");

        // Check if the entered card number and PIN match any account
        for (Acconut acconut : accs) {
            if (acconut.getCardNumber().equalsIgnoreCase(cardNum) && acconut.getPin().equalsIgnoreCase(pinNum)) {
                currentAcc = acconut;  // Set the current account
                System.out.println("Login successful");
                return;
            }
        }
        System.out.println("Invalid card number or PIN! Please try again!!!!");  // Handle invalid login
    }

    /**
     * Method to register a new account. Validates input and adds the new
     * account to the account list.
     */
    public void registerAcc() {
        // Validate input for card number, PIN, account name, balance, and currency type
        String cardNumber = IO.validateCardNumber("\\d{14}", "Enter card number (14 digits): ");
        String pin = IO.validatePin("\\d{6}", "Enter PIN (6 digits): ");
        System.out.print("Enter account name: ");
        String accName = sc.nextLine();
        double balance = IO.validateBalance("Enter initial balance: ");
        System.out.print("Enter money type (USD, VND, etc.): ");
        String moneyType = sc.nextLine();

        // Create a new account object and add it to the list
        Acconut newAcc = new Acconut(cardNumber, pin, accName, balance, moneyType);
        accs.add(newAcc);
        saveAcc(newAcc);  // Save the new account to the file
        System.out.println("Account registered successfully");
    }

    /**
     * Method to withdraw money from the current account. Validates the amount
     * and updates the balance.
     */
    public void withdraw() {
        if (currentAcc == null) {
            System.out.println("Please login first!");  // Check if user is logged in
            return;
        }
        double amount = IO.validateAmount("Enter amount to withdraw: ");  // Validate withdrawal amount
        // Check if the current account has sufficient balance
        if (currentAcc.getBalance() >= amount) {
            currentAcc.setBalance(currentAcc.getBalance() - amount);  // Update account balance
            updateAccFile();  // Update account file
            saveTransaction("Withdraw", amount);  // Save transaction record
            System.out.println("Withdrawal successful");
        } else {
            System.out.println("Insufficient balance");  // Handle insufficient balance
        }
    }

    /**
     * Method to transfer money to another account. Validates input and updates
     * the balances of both accounts.
     */
    public void transfer() {
        if (currentAcc == null) {
            System.out.println("Please login first");  // Check if user is logged in
            return;
        }
        String destinationCard = IO.validateCardNumber("\\d{14}", "Enter destination card number (14 digits): ");  // Validate destination card number
        double amount = IO.validateAmount("Enter amount to transfer: ");  // Validate transfer amount
        Acconut destinationAccount = findAccountByCard(destinationCard);  // Find destination account
        // Check if the destination account exists and if there are sufficient funds
        if (destinationAccount != null && currentAcc.getBalance() >= amount) {
            currentAcc.setBalance(currentAcc.getBalance() - amount);  // Deduct amount from current account
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);  // Add amount to destination account
            updateAccFile();  // Update account files for both accounts
            saveTransaction("Transfer", amount);  // Save transaction record
            System.out.println("Transfer successful");
        } else {
            System.out.println("Transfer failed. Check account balance or destination account.");  // Handle errors
        }
    }

    /**
     * Method to log out of the current account.
     */
    public void logout() {
        if (currentAcc != null) {
            System.out.println("Logged out from account: " + currentAcc.getAccName());  // Display logout message
            currentAcc = null;  // Clear the current account
        } else {
            System.out.println("No account is logged in.");  // Handle no active account
        }
    }

    /**
     * Method to update the account file with the current account information.
     */
    public void updateAccFile() {
        try (BufferedWriter wri = new BufferedWriter(new FileWriter(ACCOUNT))) {
            // Write each account's information to the file
            for (Acconut acc : accs) {
                wri.write(acc.getCardNumber() + "," + acc.getPin() + "," + acc.getAccName() + "," + acc.getBalance() + "," + acc.getMoneyType());
                wri.newLine();  // Move to the next line
            }
        } catch (IOException e) {
            System.out.println("Error updating account file: " + e.getMessage());  // Handle any IOExceptions
        }
    }

    /**
     * Method to save a new account to the account file.
     *
     * @param acc The account to save.
     */
    public void saveAcc(Acconut acc) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ACCOUNT, true))) {
            // Write the account information to the file
            writer.write(acc.getCardNumber() + "," + acc.getPin() + "," + acc.getAccName() + "," + acc.getBalance() + "," + acc.getMoneyType());
            writer.newLine();  // Move to the next line
            System.out.println("Account saved successfully");
        } catch (IOException e) {
            System.out.println("Error writing to account file: " + e.getMessage());  // Handle any IOExceptions
        }
    }

    /**
     * Method to load accounts from the account file. This method is called in
     * the constructor to initialize account data.
     */
    public void loadAcc() {
        try (BufferedReader br = new BufferedReader(new FileReader(ACCOUNT))) {
            String line;  // Variable to hold each line read from the file
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;  // Skip empty lines
                }

                String[] details = line.split(",");  // Split the line into details
                // Check if the details array has the correct number of elements
                if (details.length != 5) {
                    System.out.println("Invalid account line: " + line);  // Log invalid lines
                    continue;  // Skip invalid lines
                }
                // Create a new account from the details and add it to the list
                Acconut acc = new Acconut(details[0], details[1], details[2], Double.parseDouble(details[3]), details[4]);
                accs.add(acc);  // Add account to the list
            }
        } catch (FileNotFoundException e) {
            System.out.println("Account file not found: " + e.getMessage());  // Handle file not found exceptions
        } catch (IOException e) {
            System.out.println("Error reading from account file: " + e.getMessage());  // Handle any IOExceptions
        }
    }

    /**
     * Method to save a transaction record to the transaction file.
     *
     * @param type The type of transaction (e.g., Withdraw, Transfer).
     * @param amount The amount involved in the transaction.
     */
    public void saveTransaction(String type, double amount) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TRANSACTIONS, true))) {
            // Write the transaction details to the file
            writer.write("Transaction Type: " + type + ", Amount: " + amount + ", Account Name: " + currentAcc.getAccName());
            writer.newLine();  // Move to the next line
        } catch (IOException e) {
            System.out.println("Error writing transaction record: " + e.getMessage());  // Handle any IOExceptions
        }
    }

    /**
     * Method to find an account by its card number.
     *
     * @param cardNumber The card number of the account to find.
     * @return The account object if found, otherwise null.
     */
    public Acconut findAccountByCard(String cardNumber) {
        for (Acconut acc : accs) {
            if (acc.getCardNumber().equalsIgnoreCase(cardNumber)) {
                return acc;  // Return the found account
            }
        }
        return null;  // Return null if no account is found
    }
}
