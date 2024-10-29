package ce181522_l02;

/**
 * L02_Create a Java console program to manage Candidates of a company.
 *
 * Intern class to store intern candidate information. This class extends the
 * Candidate class and adds fields for major, semester, and university name.
 *
 * @author Nguyen Minh Tam - CE181522
 */
public class Intern extends Candidate {

    private String majors; // Candidate's major
    private String semester; // Candidate's current semester
    private String universityName; // Candidate's university name

    /**
     * Constructor for Intern candidate, initializing all fields.
     *
     * @param candidateID Candidate's ID
     * @param firstName Candidate's first name
     * @param lastName Candidate's last name
     * @param birthDate Candidate's birth year
     * @param address Candidate's address
     * @param phone Candidate's phone number
     * @param email Candidate's email address
     * @param type Candidate type (e.g., intern)
     * @param majors Candidate's major
     * @param semester Candidate's current semester
     * @param universityName Candidate's university name
     */
    public Intern(String candidateID, String firstName, String lastName, int birthDate, String address, String phone, String email, int type, String majors, String semester, String universityName) {
        super(candidateID, firstName, lastName, birthDate, address, phone, email, type);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    /**
     * Getter for majors.
     *
     * @return the candidate's major
     */
    public String getMajors() {
        return majors;
    }

    /**
     * Setter for majors.
     *
     * @param majors the candidate's major to set
     */
    public void setMajors(String majors) {
        this.majors = majors;
    }

    /**
     * Getter for semester.
     *
     * @return the candidate's current semester
     */
    public String getSemester() {
        return semester;
    }

    /**
     * Setter for semester.
     *
     * @param semester the candidate's current semester to set
     */
    public void setSemester(String semester) {
        this.semester = semester;
    }

    /**
     * Getter for universityName.
     *
     * @return the candidate's university name
     */
    public String getUniversityName() {
        return universityName;
    }

    /**
     * Setter for universityName.
     *
     * @param universityName the candidate's university name to set
     */
    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    /**
     * Override toString method to display Intern information.
     *
     * @return a string representation of the Intern object, including major,
     * semester, and university name
     */
    @Override
    public String toString() {
        return "Intern{" + "majors=" + majors + ", semester=" + semester + ", universityName=" + universityName + '}';
    }

}
