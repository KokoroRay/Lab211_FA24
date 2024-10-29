package ce181522_v08;

/**
 * Grading logic class Manages the grading process for midterm, final, homework,
 * and overall score.
 *
 * @author: Nguyen Minh Tam - CE181522
 */
public class GradeStudent {

    CheckInputValue IO = new CheckInputValue(); // Handles input validation
    private double midtermWeightedScore; // Stores weighted score for midterm
    private double finalWeightedScore;   // Stores weighted score for final exam
    private double homeworkWeightedScore; // Stores weighted score for homework
    private int totalWeight = 0;  // Stores the cumulative weight of all components

    /**
     * Method to introduce the grading program. Provides an introduction message
     * when the program starts.
     */
    public void begin() {
        System.out.println("This program reads exam/homework scores and reports your overall course grade.");
    }

    /**
     * Method to process midterm score input and calculate the weighted score.
     * It handles midterm weight, score, and score shifting if applicable.
     */
    public void midTerm() {
        System.out.println("Midterm: ");

        // Get the weight for the midterm (0 to 100)
        int weight = IO.getIntInput("Weight (0 - 100)? ", 0, 100);
        totalWeight += weight;

        // Get the score earned in the midterm
        int scoreEarned = IO.getIntInput("Score earned? ", 0, 100);

        // Check if score shifting is applied (1 for yes, 2 for no)
        int shift = IO.getIntInput("Were scores shifted (1=yes, 2=no)? ", 1, 2);
        int shiftAmount = 0;

        if (shift == 1) {
            // Get the shift amount, ensuring it doesn't make the total points exceed 100
            shiftAmount = IO.getIntInput("Shift amount? ", 0, 100);
        }

        // Calculate the total points after applying the shift, capped at 100
        int totalPoints = Math.min(scoreEarned + shiftAmount, 100);

        // Calculate the midterm's weighted score
        midtermWeightedScore = (totalPoints / 100.0) * weight;

        // Display the calculated total points and weighted score
        System.out.printf("Total points = %d/100\n", totalPoints);
        System.out.printf("Weighted score = %.1f/%d\n", midtermWeightedScore, weight);
    }

    /**
     * Method to process the final exam score and calculate the weighted score.
     * Similar to midterm, handles final exam weight, score, and optional score
     * shifting.
     */
    public void finalTerm() {
        System.out.println("Final:");

        // Get the weight for the final exam (0 to 100)
        int weight = IO.getIntInput("Weight (0 - 100)? ", 0, 100);
        totalWeight += weight;

        // Get the score earned in the final exam
        int scoreEarned = IO.getIntInput("Score earned? ", 0, 100);

        // Check if score shifting is applied (1 for yes, 2 for no)
        int shift = IO.getIntInput("Were scores shifted (1=yes, 2=no)? ", 1, 2);
        int shiftAmount = 0;

        if (shift == 1) {
            // Get the shift amount, ensuring it doesn't make the total points exceed 100
            shiftAmount = IO.getIntInput("Shift amount? ", 0, 100);
        }

        // Calculate the total points after applying the shift, capped at 100
        int totalPoints = Math.min(scoreEarned + shiftAmount, 100);

        // Calculate the final exam's weighted score
        finalWeightedScore = (totalPoints / 100.0) * weight;

        // Display the calculated total points and weighted score
        System.out.printf("Total points = %d/100\n", totalPoints);
        System.out.printf("Weighted score = %.1f/%d\n", finalWeightedScore, weight);
    }

    /**
     * Method to process homework score input and calculate the final weighted
     * score. It handles homework assignments, section attendance, and
     * calculates the total score.
     */
    public void homework() {
        int weight;

        do {
            // Get the weight for homework, ensuring total weight sums to 100
            weight = IO.getIntInput("Weight (0 - 100)? ", 0, 100);
            totalWeight += weight;

            // Ensure the cumulative weight doesn't exceed 100
            if (totalWeight != 100) {
                System.out.println("The weights of the three test scores must total exactly 100.");
                totalWeight -= weight;
            }
        } while (totalWeight != 100);

        // Get the number of homework assignments
        int numAssignments = IO.getIntInput("Number of assignments? ", 1, 100);

        int totalScore = 0, totalMax = 0;

        // Loop to collect scores and max points for each assignment
        for (int i = 1; i <= numAssignments; i++) {
            int score = IO.getIntInput("Assignment " + i + " score? ", 0, 100);
            int max = IO.getIntInput("Assignment " + i + " max? ", score, 100);
            totalScore += score;
            totalMax += max;
        }

        // Cap total scores at 150 points
        totalScore = Math.min(totalScore, 150);
        totalMax = Math.min(totalMax, 150);

        // Get the number of sections attended and calculate section points
        int sectionsAttended = IO.getIntInput("How many sections did you attend? ", 0, 6);
        int sectionPoints = Math.min(sectionsAttended * 5, 30);

        // Add section points to the total score and max points
        totalScore += sectionPoints;
        totalMax += 30;

        // Calculate the weighted homework score
        homeworkWeightedScore = (totalScore / (double) totalMax) * weight;

        // Display the total points and weighted homework score
        System.out.printf("Total points = %d/%d\n", totalScore, totalMax);
        System.out.printf("Weighted score = %.1f/%d\n", homeworkWeightedScore, weight);
    }

    /**
     * Method to generate and display the overall report. Combines the weighted
     * scores from midterm, final, and homework to calculate the overall
     * percentage.
     */
    public void report() {
        // Calculate the overall percentage
        double overallPercentage = midtermWeightedScore + finalWeightedScore + homeworkWeightedScore;

        // Display the overall percentage
        System.out.printf("Overall percentage = %.1f\n", overallPercentage);

        double grade;

        // Determine grade based on the overall percentage
        if (overallPercentage >= 85) {
            grade = 3.0;  // Highest grade
        } else if (overallPercentage >= 75) {
            grade = 2.0;
        } else if (overallPercentage >= 60) {
            grade = 0.7;
        } else {
            grade = 0.0;  // Failing grade
        }

        // Display the grade
        System.out.printf("Your grade will be at least: %.1f\n", grade);
    }
}
