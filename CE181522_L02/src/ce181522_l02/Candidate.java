package ce181522_l02;

/**
 * L02_Create a Java console program to manage Candidates of a company.
 *
 * Candidate class to store and manage candidate information. It contains fields
 * like candidate ID, first name, last name, etc.
 *
 * @author Nguyen Minh Tam - CE181522
 */
public class Candidate {

    // Fields for the Candidate class to store candidate details.
    private String candidateID;   // Candidate's unique ID
    private String firstName;     // Candidate's first name
    private String lastName;      // Candidate's last name
    private int birthDate;        // Candidate's birth year
    private String address;       // Candidate's address
    private String phone;         // Candidate's phone number
    private String email;         // Candidate's email address
    private int type;             // Candidate type (0: Experience, 1: Fresher, 2: Intern)

    /**
     * Constructor to initialize a Candidate object with the provided details.
     *
     * @param candidateID The unique ID for the candidate.
     * @param firstName The first name of the candidate.
     * @param lastName The last name of the candidate.
     * @param birthDate The birth year of the candidate.
     * @param address The address where the candidate lives.
     * @param phone The candidate's phone number.
     * @param email The candidate's email address.
     * @param type The type of candidate (0 for Experience, 1 for Fresher, 2 for
     * Intern).
     */
    public Candidate(String candidateID, String firstName, String lastName, int birthDate, String address, String phone, String email, int type) {
        this.candidateID = candidateID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.type = type;
    }

    /**
     * Getter method for candidateID.
     *
     * @return The unique ID of the candidate.
     */
    public String getCandidateID() {
        return candidateID;
    }

    /**
     * Setter method for candidateID.
     *
     * @param candidateID The unique ID to set for the candidate.
     */
    public void setCandidateID(String candidateID) {
        this.candidateID = candidateID;
    }

    /**
     * Getter method for firstName.
     *
     * @return The first name of the candidate.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter method for firstName.
     *
     * @param firstName The first name to set for the candidate.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter method for lastName.
     *
     * @return The last name of the candidate.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter method for lastName.
     *
     * @param lastName The last name to set for the candidate.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter method for birthDate.
     *
     * @return The birth year of the candidate.
     */
    public int getBirthDate() {
        return birthDate;
    }

    /**
     * Setter method for birthDate.
     *
     * @param birthDate The birth year to set for the candidate.
     */
    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Getter method for address.
     *
     * @return The address of the candidate.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter method for address.
     *
     * @param address The address to set for the candidate.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Getter method for phone.
     *
     * @return The phone number of the candidate.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Setter method for phone.
     *
     * @param phone The phone number to set for the candidate.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Getter method for email.
     *
     * @return The email address of the candidate.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for email.
     *
     * @param email The email address to set for the candidate.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter method for type.
     *
     * @return The type of the candidate (0 for Experience, 1 for Fresher, 2 for
     * Intern).
     */
    public int getType() {
        return type;
    }

    /**
     * Setter method for type.
     *
     * @param type The type to set for the candidate (0 for Experience, 1 for
     * Fresher, 2 for Intern).
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * Override of the toString method to provide a string representation of the
     * Candidate object.
     *
     * @return A string containing the candidate's details in a readable format.
     */
    @Override
    public String toString() {
        return "Candidate{" + "candidateID=" + candidateID + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", address=" + address + ", phone=" + phone + ", email=" + email + ", type=" + type + '}';
    }
}
