package ce181522_s01;

/**
 * Class representing a student and implementing Comparable for sorting.
 *
 * Author: Nguyen Minh Tam - CE181522
 */
// This class represents a student and implements Comparable for sorting
public class Student implements Comparable<Student> {

    private String studentCode;
    private String studentName;
    private String studenDateOfBirth;
    private Double learningPoint;

    /**
     * Constructor to initialize the student attributes
     *
     * @param studentCode the student's unique code
     * @param studentName the student's full name
     * @param studenDateOfBirth the student's date of birth
     * @param learningPoint the student's learning score
     */
    public Student(String studentCode, String studentName, String studenDateOfBirth, Double learningPoint) {
        this.studentCode = studentCode;
        this.studentName = studentName;
        this.studenDateOfBirth = studenDateOfBirth;
        this.learningPoint = learningPoint;
    }

    /**
     * Getter method for student code
     *
     * @return student's code
     */
    public String getStudentCode() {
        return studentCode;
    }

    /**
     * Getter method for student name
     *
     * @return student's full name
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Getter method for student's date of birth
     *
     * @return student's date of birth
     */
    public String getStudenDateOfBirth() {
        return studenDateOfBirth;
    } 

    /**
     * Getter method for student's learning score
     *
     * @return student's learning score
     */
    public Double getLearningPoint() {
        return learningPoint;
    }

    /**
     * toString method to return a string representation of the student object
     *
     * @return formatted string containing student's details
     */
    @Override
    public String toString() {
        return "Student code: " + studentCode + "\nStudent name: " + studentName
                + "\nDate of birth: " + studenDateOfBirth + "\nLearning point: " + learningPoint;
    }

    /**
     * compareTo method to compare students by their name for sorting
     *
     * @param other another student to compare with
     * @return result of name comparison
     */
    @Override
    public int compareTo(Student other) {
        return other.learningPoint.compareTo(this.learningPoint); // Compare students by name
    }
}
