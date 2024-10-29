package ce181522_v08;

/**
 * Title: This title reflects the core functionality of the program, which reads
 * student scores from midterms, finals, and homework, and calculates the
 * overall grade. It highlights the purpose of the system as a tool for grading
 * and reporting.
 *
 * Main class for running the grading program
 *
 * @author: Nguyen Minh Tam - CE181522
 */
public class CE181522_V08 {

    /**
     * Main method Entry point for the program. It creates a GradeStudent object
     * and initiates the grading process.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Creates an instance of GradeStudent
        GradeStudent student = new GradeStudent();

        // Calls methods to simulate grading phases
        student.begin();    // Introduction to the program
        student.midTerm();  // Process the midterm grading
        student.finalTerm(); // Process the final exam grading
        student.homework(); // Process the homework grading
        student.report();   // Generate and display the overall report
    }
}
