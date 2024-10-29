package ce181522_l02;

/**
 * L02_Create a Java console program to manage Candidates of a company.
 *
 * Fresher class to store fresher candidate information. This class extends the
 * Candidate class and adds fields for graduation date, rank, and education.
 *
 * @author Nguyen Minh Tam - CE181522
 */
public class Fresher extends Candidate {

    private int gradutionDate;  // Graduation date
    private String graduationRank;  // Graduation rank
    private String education;  // Education background

    /**
     * Constructor for Fresher candidate, initializing all fields.
     *
     * @param candidateID Candidate's ID
     * @param firstName Candidate's first name
     * @param lastName Candidate's last name
     * @param birthDate Candidate's birth year
     * @param address Candidate's address
     * @param phone Candidate's phone number
     * @param email Candidate's email address
     * @param type Candidate type (e.g., fresher)
     * @param graduationDate Candidate's graduation year
     * @param graduationRank Candidate's graduation rank (e.g., Excellent, Good)
     * @param education Candidate's education background (e.g., University name)
     */
    public Fresher(String candidateID, String firstName, String lastName, int birthDate, String address, String phone, String email, int type, int graduationDate, String graduationRank, String education) {
        super(candidateID, firstName, lastName, birthDate, address, phone, email, type);
        this.gradutionDate = gradutionDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    /**
     * Getter for graduationDate.
     *
     * @return the graduation year
     */
    public int getGradutionDate() {
        return gradutionDate;
    }

    /**
     * Setter for graduationDate.
     *
     * @param gradutionDate the graduation year to set
     */
    public void setGradutionDate(int gradutionDate) {
        this.gradutionDate = gradutionDate;
    }

    /**
     * Getter for graduationRank.
     *
     * @return the graduation rank
     */
    public String getGraduationRank() {
        return graduationRank;
    }

    /**
     * Setter for graduationRank.
     *
     * @param graduationRank the graduation rank to set (e.g., Excellent, Good)
     */
    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    /**
     * Getter for education.
     *
     * @return the education background (e.g., University name)
     */
    public String getEducation() {
        return education;
    }

    /**
     * Setter for education.
     *
     * @param education the education background to set
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * Override toString method to display Fresher information.
     *
     * @return a string representation of the Fresher object, including
     * graduation date, rank, and education
     */
    @Override
    public String toString() {
        return "Fresher{" + "gradutionDate=" + gradutionDate + ", graduationRank=" + graduationRank + ", education=" + education + '}';
    }
}
