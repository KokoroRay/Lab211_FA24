package ce181522_l02;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * L02_Create a Java console program to manage Candidates of a company.
 *
 * The ManagerCandidate class is responsible for managing a list of candidates.
 * It provides functionalities such as creating candidates (of different types:
 * Experience, Fresher, Internship), displaying the names of candidates, and
 * searching for candidates based on name and type.
 *
 * @author Nguyen Minh Tam
 */
public class ManagerCandidate {

    // List to store Candidate objects (Experience, Fresher, Internship)
    private ArrayList<Candidate> list = new ArrayList<>();
    private ArrayList<Candidate> searchResults = new ArrayList<>();

    // Instance of CheckInputValue class, used for input validation and user input handling
    CheckInputValue IO = new CheckInputValue();
    private int currentYear = LocalDate.now().getYear();

    /**
     * Creates a new candidate based on the specified type.
     *
     * Depending on the type (Experience, Fresher, Internship), this method will
     * prompt the user to enter relevant information and create the
     * corresponding candidate object.
     *
     * @param type The type of candidate to create. The value can be: 0 -
     * Experience candidate 1 - Fresher candidate 2 - Internship candidate
     */
    public void createCandidate(int type) {
        // Gathering common personal information for all types of candidates
        String firstName = IO.regexString("Enter First Name: ", "Just be contain alphabetic and spaces!", "[A-Za-z\\s]+");
        String lastName = IO.regexString("Enter Last Name: ", "Just be contain alphabetic and spaces!", "[A-Za-z\\s]+");

        // Get the current year to validate birth year
        // Birth year must be between 1900 and the current year
        int birthDate = IO.getInteger("Enter Birth Date: ", "Must be 1900 ->" + currentYear, 1900, currentYear);

        // Prompt for address, phone, and email
        String address = IO.getString("Enter Address: ", "Can not be empty!");
        String phone = IO.regexString("Enter Phone: ", "Must be number with minimum 10 characters ", "\\d{10,}");
        String email = IO.regexString("Enter email: ", "Must be in format <account name>@<domain>", "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");

        // Switch based on candidate type (Experience, Fresher, Internship)
        switch (type) {
            case 0: // Create Experience candidate
                // Generate a unique ID for the Experience candidate, starting with "E"
                String ID = "E" + (list.size() + 1);

                // Prompt for years of experience (valid range: 1 to 100)
                int expInYear = IO.getInteger("Enter Years of Experience: ", "Must be >= 1 and <= 100", 1, 100);

                // Prompt for professional skills
                String proSkill = IO.getString("Enter Professional Skill: ", "Can not be empty!");

                // Create an Experience candidate object and add it to the list
                Candidate exp = new Experience(ID, firstName, lastName, birthDate, address, phone, email, type);
                list.add(exp);
                System.out.println("Experience candidate information has been added! Success.");
                break;

            case 1: // Create Fresher candidate
                // Generate a unique ID for the Fresher candidate, starting with "F"
                ID = "F" + (list.size() + 1);

                // Prompt for graduation date (valid range: 1900 to current year)
                int graduationDate = IO.getInteger("Enter Graduation Date: ", "Must be 1900 -> " + currentYear, 1900, currentYear);

                // Prompt for graduation rank with a choice from predefined options (1 to 4)
                int choiceRank = IO.getInteger("Choose Rank:\n"
                        + "1. Excellence\n"
                        + "2. Good\n"
                        + "3. Fair\n"
                        + "4. Poor\n"
                        + "Enter Your Choice: ", "Must be 1->4", 1, 4);

                // Determine the graduation rank based on user's choice
                String graduationRank = null;
                switch (choiceRank) {
                    case 1:
                        graduationRank = "Excellence";
                        break;
                    case 2:
                        graduationRank = "Good";
                        break;
                    case 3:
                        graduationRank = "Fair";
                        break;
                    case 4:
                        graduationRank = "Poor";
                        break;
                }

                // Prompt for education
                String education = IO.getString("Enter Education: ", "Can not be empty!");

                // Create a Fresher candidate object and add it to the list
                Candidate fresher = new Fresher(ID, firstName, lastName, birthDate, address, phone, email, type, graduationDate, graduationRank, education);
                list.add(fresher);
                System.out.println("Fresher candidate information has been added! Success.");
                break;

            case 2: // Create Internship candidate
                // Generate a unique ID for the Internship candidate, starting with "I"
                ID = "I" + (list.size() + 1);

                // Prompt for internship details: major, semester, university name
                String majors = IO.getString("Enter Majors: ", "Can not be empty!");
                String semester = IO.getString("Enter Semester: ", "Can not be empty!");
                String universityName = IO.getString("Enter University: ", "Can not be empty!");

                // Create an Internship candidate object and add it to the list
                Candidate intern = new Intern(ID, firstName, lastName, birthDate, address, phone, email, type, majors, semester, universityName);
                list.add(intern);
                System.out.println("Intern candidate information has been added! Success.");
                break;
        }
    }

    /**
     * Displays the names of all candidates, categorized by type (Experience,
     * Fresher, Intern).
     *
     * If the candidate list is empty, it will notify the user. Otherwise, it
     * will group the candidates by their type and display their full names
     * (first name + last name).
     */
    public void displayAllNameCandidate() {
        // Check if the candidate list is empty
        if (list.isEmpty()) {
            // Inform the user if there are no candidates and exit the method
            System.out.println("Candidate list is empty!");
            return;
        }

        // Display the header indicating that the list of candidates will be shown
        System.out.println("List of candidates");

        // Display the Experience candidates
        System.out.println("============== EXPERIENCE CANDIDATE ==============");
        for (Candidate candidate : list) {
            // Check if the current candidate is an Experience type
            if (candidate instanceof Experience) {
                // Display the candidate's full name (first name + last name)
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }

        // Display the Fresher candidates
        System.out.println("============== FRESHER CANDIDATE ==============");
        for (Candidate candidate : list) {
            // Check if the current candidate is a Fresher type
            if (candidate instanceof Fresher) {
                // Display the candidate's full name
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }

        // Display the Intern candidates
        System.out.println("============== INTERN CANDIDATE ==============");
        for (Candidate candidate : list) {
            // Check if the current candidate is an Intern type
            if (candidate instanceof Intern) {
                // Display the candidate's full name
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
    }

    /**
     * Searches for candidates based on a provided name (first or last) and type
     * (Experience, Fresher, or Intern).
     *
     * It will display all candidates that match the input name and type. If no
     * candidates match, it will notify the user.
     */
    public void search() {
        // Clear previous search results to ensure the new search starts fresh
        searchResults.clear();

        // Prompt the user to input the candidate's name (first name or last name) to search for
        // The IO.getString method ensures the user enters a non-empty string
        String key = IO.getString("Input Candidate name (First name or Last name): ", "Can not be empty");

        // Prompt the user to input the type of candidate they want to search for
        // Type options: 0 for Experience, 1 for Fresher, and 2 for Internship
        // The IO.getInteger method ensures the input is within the valid range of 0 to 2
        int type = IO.getInteger("Input type of candidate (0->2): ", "Must be from 0 -> 2", 0, 2);

        // Loop through all candidates in the list to check for matches
        for (Candidate c : list) {
            // Combine the candidate's first and last name to create their full name
            String fullName = c.getFirstName() + " " + c.getLastName();

            // Check if the full name contains the search key (case-insensitive)
            // and if the candidate's type matches the specified type
            if (fullName.toLowerCase().contains(key.toLowerCase()) && c.getType() == type) {
                // If both the name and type match, add the candidate to the search results list
                searchResults.add(c);
            }
        }

        // After the loop, check if no candidates were found
        if (searchResults.isEmpty()) {
            // Notify the user that no candidates matching the search criteria were found
            System.out.println("First name or last name not found: " + key + " just entered in the system");
        }
    }

    /**
     * Modifies the information of an existing candidate based on user input. It
     * prompts the user for the candidate's name, type, phone number, and other
     * details, validating the input as necessary.
     */
    public void modifyCandidate() {
        // Prompt the user to input the candidate's first or last name for modification
        String key = IO.getString("Input Candidate name (First name or Last name): ", "Can not be empty");

        // Prompt the user to specify the type of candidate (0: Experience, 1: Fresher, 2: Internship)
        int type = IO.getInteger("Enter Type of candidate to modify: ", "Can not be empty", 0, 2);

        // Prompt the user to input the candidate's phone number, ensuring it contains only digits and has at least 10 characters
        String phone = IO.regexString("Enter Phone of candidate to modify: ", "Must be number with minimum 10 characters", "\\d{10,}");

        // Call a method to find the candidate based on the provided name, type, and phone number
        Candidate candidateToModify = findCandidateById(key, type, phone);

        // Check if a candidate was found; if not, notify the user and exit the method
        if (candidateToModify == null) {
            System.out.println("Candidate not found"); // Inform the user that the candidate could not be found
            return; // Exit the method since the candidate doesn't exist
        }
        boolean check = false;
        while (check != true) {
            System.out.println("1. First Name");
            System.out.println("2. Last Name");
            System.out.println("3. Birth Date");
            System.out.println("4. Address");
            System.out.println("5. Phone");
            System.out.println("6. email");
            System.out.println("7. Exit");
            int choice = IO.getInteger("Enter Your Choice: ", "Must be", 1, 7); // Validates user input to ensure it's a number between 1 and 7.

            switch (choice) {
                case 1:
                    // Prompt the user to enter a new first name for the candidate
                    // Validate to ensure the new first name contains only alphabetic characters and spaces
                    candidateToModify.setFirstName(IO.regexString("Enter new First Name: ", "Just contain alphabetic characters and spaces!", "[A-Za-z\\s]+"));
                    break;
                case 2:

                    // Prompt the user to enter a new last name for the candidate
                    // Validate to ensure the new last name contains only alphabetic characters and spaces
                    candidateToModify.setLastName(IO.regexString("Enter new Last Name: ", "Just contain alphabetic characters and spaces!", "[A-Za-z\\s]+"));
                    break;
                case 3:

                    // Prompt the user to enter a new birth date for the candidate
                    // Validate to ensure the input is a valid integer between 1900 and the current year
                    candidateToModify.setBirthDate(IO.getInteger("Enter new Birth Date: ", "Must be 1900 ->" + currentYear, 1900, currentYear));
                    break;
                case 4:
                    // Prompt the user to enter a new address for the candidate
                    // Validate to ensure the address is not empty
                    candidateToModify.setAddress(IO.getString("Enter new Address: ", "Can not be empty"));
                    break;
                case 5:

                    // Prompt the user to enter a new phone number for the candidate
                    // Validate to ensure it is at least 10 digits long and contains only numbers
                    candidateToModify.setPhone(IO.regexString("Enter Phone: ", "Must be number with minimum 10 characters", "\\d{10,}"));
                    break;
                case 6:
                    // Prompt the user to enter a new email for the candidate
                    // Validate to ensure it follows a standard email format
                    candidateToModify.setEmail(IO.regexString("Enter email: ", "Must be in format <account name>@<domain>", "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"));
                    break;
                case 7:
                    check = true;
                    // Notify the user that the candidate information was successfully updated
                    System.out.println("Successful candidate information update");
                    break;
            }
        }

    }

    /**
     * Deletes a candidate from the list based on user input. The method prompts
     * the user for the candidate's name, type, and phone number, validates the
     * input, and removes the candidate if found.
     */
    public void deleteCandidate() {
        // Prompt the user to input the candidate's name (first or last) for identification
        String key = IO.getString("Input Candidate name (First name or Last name): ", "Can not be empty");

        // Prompt the user to specify the type of candidate (0: Experience, 1: Fresher, 2: Internship)
        int type = IO.getInteger("Enter Type of candidate to modify: ", "Can not be empty", 0, 2);

        // Prompt the user to input the candidate's phone number
        // Ensure the input is a valid number with at least 10 digits
        String phone = IO.regexString("Enter Phone of candidate to modify: ", "Must be number with minimum 10 characters", "\\d{10,}");

        // Search for the candidate in the list by the provided name, type, and phone number
        Candidate candidateToModify = findCandidateById(key, type, phone);

        // Check if the candidate was found; if not, notify the user and exit the method
        if (candidateToModify == null) {
            System.out.println("Candidate not found"); // Inform the user if no candidate matches the search criteria
            return; // Exit the method since the candidate does not exist
        }

        // Remove the found candidate from the list
        list.remove(candidateToModify); // Remove the candidate from the list

        // Notify the user that the candidate has been successfully deleted
        System.out.println("Candidate has been deleted successfully!"); // Confirm successful deletion
    }

    /**
     * Displays the search results in a formatted table.
     *
     * If there are no search results, it notifies the user. Otherwise, it shows
     * the candidates' full names, birthdates, addresses, phones, emails, and
     * types.
     */
    public void displaySearch() {
        // Check if the search results list is empty
        if (searchResults.isEmpty()) {
            // Inform the user if no candidates were found and exit the method
            System.out.println("Empty storage system");
            return;
        }

        // Display the header for the table of search results
        System.out.println("The candidate(s) found:");
        System.out.println("+---+--------------------+---------+---------------+------------+--------------------+----+");
        System.out.println("|No.|Fullname            |Birthdate|Address        |Phone       |Email               |Type|");
        System.out.println("+---+--------------------+---------+---------------+------------+--------------------+----+");

        // Initialize a counter to number the candidates in the table
        int stt = 1;

        // Loop through each candidate in the search results
        for (Candidate c : searchResults) {
            // Combine the first and last name to form the full name
            String fullName = c.getFirstName() + " " + c.getLastName();

            // Print the candidate's details in a formatted row, with appropriate spacing for each field
            System.out.printf("|%-3d|%-20s|%9d|%-15s|%-12s|%-20s|%4d|\n",
                    stt++, // Row number
                    fullName, // Candidate's full name
                    c.getBirthDate(), // Birth date of the candidate
                    c.getAddress(), // Candidate's address
                    c.getPhone(), // Candidate's phone number
                    c.getEmail(), // Candidate's email
                    c.getType());               // Candidate's type (e.g., 0 for Experience, 1 for Fresher, 2 for Intern)
        }

        // Display the footer of the table
        System.out.println("+---+--------------------+---------+---------------+------------+--------------------+----+");
    }

    /**
     * Searches for a candidate in the list based on the provided name, type,
     * and phone number.
     *
     * @param key The name (first or last) of the candidate to search for.
     * @param type The type of candidate (0: Experience, 1: Fresher, 2:
     * Internship).
     * @param phone The phone number of the candidate to search for.
     * @return The matching Candidate object if found, or null if no match is
     * found.
     */
    private Candidate findCandidateById(String key, int type, String phone) {
        // Iterate through the list of candidates to find a match
        for (Candidate c : list) {
            // Combine the first and last names to form the full name
            String fullName = c.getFirstName() + " " + c.getLastName();

            // Check if the full name contains the search key (case insensitive), 
            // the candidate's type matches the provided type, 
            // and the phone number matches (case insensitive)
            if (fullName.toLowerCase().contains(key.toLowerCase())
                    && c.getType() == type
                    && c.getPhone().equalsIgnoreCase(phone)) {
                // Return the found candidate
                return c;
            }
        }

        // Return null if no matching candidate is found
        return null;
    }

}
