package ce181522_l02; // Declares the package of the program, typically used to organize related classes and interfaces.

/**
 * L02_Create a Java console program to manage Candidates of a company.
 *
 * Main class to run the Candidate Management program. The program manages the
 * candidates in a company, allowing the user to create and search for
 * candidates.
 *
 * @author Nguyen Minh Tam - CE181522
 */
public class CE181522_L02 { // Declares the main class of the program, where the core logic is controlled.

    /**
     * Main method to execute the program.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) { // Main method, the entry point of the program.
        // Create an instance of the Manager class to handle candidate management.
        //Manager HR = new Manager(); // This line is commented out, replaced by the line below.

        ManagerCandidate HR = new ManagerCandidate(); // Creates an instance of the ManagerCandidate class to manage candidates.
        CheckInputValue IO = new CheckInputValue(); // Creates an instance of CheckInputValue to handle and validate user inputs.

        // Start the candidate management system.
        //HR.star(); // This line is commented out, skipping the start of the system via the star() method.
        do {
            // Display the main menu options
            System.out.println("CANDIDATE MANAGEMENT SYSTEM"); // Displays the title of the Candidate Management System.
            System.out.println("1. Experience"); // Option for creating an "Experience" candidate.
            System.out.println("2. Fresher"); // Option for creating a "Fresher" candidate.
            System.out.println("3. Internship"); // Option for creating an "Internship" candidate.
            System.out.println("4. Searching"); // Option for searching candidates.
            System.out.println("5. Modify"); // Option for modifying candidate details.
            System.out.println("6. Delete"); // Option for deleting a candidate.
            System.out.println("7. Exit"); // Option for exiting the program.

            // Get the user's choice, ensuring it's between 1 and 7
            int choice = IO.getInteger("Enter Your Choice[1..7]: ", "Must be 1 -> 7", 1, 7); // Validates user input to ensure it's a number between 1 and 7.

            // Handle the user's choice using a switch statement
            switch (choice) {
                case 1: // Create Experience candidate
                    do {
                        System.out.println("=============CREATE EXPERIENCE============="); // Displays a header for creating an "Experience" candidate.
                        HR.createCandidate(0); // Calls method to create a candidatse of type "Experience".
                    } while (IO.getConfirm("Do you want to order now (Y/N): ")); // Confirms if the user wants to continue creating more candidates.
                    break;

                case 2: // Create Fresher candidate
                    do {
                        System.out.println("=============CREATE FRESHER============="); // Displays a header for creating a "Fresher" candidate.
                        HR.createCandidate(1); // Calls method to create a candidate of type "Fresher".
                    } while (IO.getConfirm("Do you want to order now (Y/N): ")); // Confirms if the user wants to continue creating more candidates.
                    break;

                case 3: // Create Internship candidate
                    do {
                        System.out.println("=============CREATE INTERNSHIP============="); // Displays a header for creating an "Internship" candidate.
                        HR.createCandidate(2); // Calls method to create a candidate of type "Internship".
                    } while (IO.getConfirm("Do you want to order now (Y/N)")); // Confirms if the user wants to continue creating more candidates.
                    break;

                case 4: // Search for candidates
                    HR.displayAllNameCandidate(); // Displays the names of all candidates.
                    HR.search(); // Calls the search method to look for specific candidates.
                    HR.displaySearch(); // Displays the search results.
                    break;
                case 5: // Modify candidate information
                    HR.modifyCandidate(); // Calls the method to modify the candidate's details.
                    break;
                case 6: // Delete candidate
                    HR.deleteCandidate(); // Calls the method to delete a candidate.
                    break;
                case 7: // Exit the application
                    System.exit(0); // Exits the program.
                    break;
            }

        } while (true); // Keeps looping until the user chooses to exit.
    }
}
