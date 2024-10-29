package ce181522_l02;

/**
 * L02_Create a Java console program to manage Candidates of a company.
 *
 * The Experience class stores experience-related information about a candidate.
 * This class extends the Candidate class and includes fields for years of
 * experience and professional skills.
 *
 * @author Nguyen Minh Tam - CE181522
 */
public class Experience extends Candidate {

    private int expInYear;  // Years of experience
    private String proSkill;  // Professional skill

    /**
     * Constructor for Experience candidate, initializing all fields.
     *
     * @param candidateID Candidate's ID
     * @param firstName Candidate's first name
     * @param lastName Candidate's last name
     * @param birthDate Candidate's birth year
     * @param address Candidate's address
     * @param phone Candidate's phone number
     * @param email Candidate's email address
     * @param type Candidate type (e.g., experience)
     */
    public Experience(String candidateID, String firstName, String lastName, int birthDate, String address, String phone, String email, int type) {
        super(candidateID, firstName, lastName, birthDate, address, phone, email, type);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    /**
     * Getter for expInYear.
     *
     * @return the number of years of experience
     */
    public int getExpInYear() {
        return expInYear;
    }

    /**
     * Setter for expInYear.
     *
     * @param expInYear the number of years of experience to set
     */
    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    /**
     * Getter for proSkill.
     *
     * @return the professional skill as a String
     */
    public String getProSkill() {
        return proSkill;
    }

    /**
     * Setter for proSkill.
     *
     * @param proSkill the professional skill to set
     */
    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    /**
     * Override toString method to display experience information.
     *
     * @return a string representation of the Experience object, including years
     * of experience and professional skill
     */
    @Override
    public String toString() {
        return "Experience{" + "expInYear=" + expInYear + ", proSkill=" + proSkill + '}';
    }
}
