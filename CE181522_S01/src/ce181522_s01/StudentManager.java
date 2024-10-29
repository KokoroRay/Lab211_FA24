package ce181522_s01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * StudentManager class to handle student operations such as adding, saving,
 * loading, looking up, and displaying students.
 *
 * Author: Nguyen Minh Tam - CE181522
 */
public class StudentManager {

    private List<Student> studentList = new ArrayList<>(); // List of students

    // Constructor to initialize student list from file
    public StudentManager() {
        loadFromFileStudent(); // Load students from file when the manager is created
    }

    /**
     * Method to add a new student to the list
     *
     * This method gets input for a new student including a unique student code,
     * student name, date of birth, and learning score. The new student is added
     * to the list, which is sorted afterward. The updated list is then saved to
     * the file.
     */
    public void addStudent() {
        // Get a unique student code
        String studentCode = CheckInputValue.getStudentCode("Enter student code: ", "SV\\d{3}", studentList);
        String studentName = CheckInputValue.getStringName("Enter student name: ", "^[A-Za-z ]+$");
        String dob = CheckInputValue.getDateOfBirth("Enter date of birth (DD-MMM-YYYY): ", "\\d{2}-[A-Za-z]{3}-\\d{4}");
        double score = CheckInputValue.getDouble("Enter learning score: ");

        // Add student to the list
        Student newStudent = new Student(studentCode, studentName, dob, score);
        studentList.add(newStudent);
        Collections.sort(studentList); // Sort student list after adding
        saveToFileStudent(); // Save to file
    }

    /**
     * Method to save the student list to a file
     *
     * This method writes the current student list to a file called
     * "Student.txt". Each student's data is written in a single line separated
     * by the "#" character.
     */
    public void saveToFileStudent() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Student.txt"))) {
            for (Student student : studentList) {
                writer.write(student.getStudentCode() + "#" + student.getStudentName() + "#" + student.getStudenDateOfBirth() + "#" + student.getLearningPoint());
                writer.newLine(); // New line after each student
            }
        } catch (IOException e) {
            System.out.println("Error saving data to file");
        }
    }

    /**
     * Method to load students from the file
     *
     * This method reads student data from the file "Student.txt". Each line in
     * the file represents a student, with their attributes separated by "#". It
     * populates the student list and sorts it afterward.
     */
    public void loadFromFileStudent() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Student.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("#");
                if (parts.length == 4) {
                    String code = parts[0];
                    String name = parts[1];
                    String dob = parts[2];
                    double score = Double.parseDouble(parts[3]);
                    studentList.add(new Student(code, name, dob, score));
                }
            }
            Collections.sort(studentList); // Sort the list after loading
        } catch (IOException e) {
            System.out.println("Error loading data from file");
        }
    }

    /**
     * Method to search for a student by the first name
     *
     * @param name The first name to search for
     *
     * This method looks for a student by their first name. It iterates through
     * the student list and compares the first name of each student with the
     * provided name. If a match is found, it prints the student's details.
     */
    public void lookUpStudent(String name) {
        boolean found = false;
        for (Student student : studentList) {
            // Check if the first name of the student matches the input
            String firstName = student.getStudentName().split(" ")[0]; // Get the first name
            if (firstName.equalsIgnoreCase(name)) {
                System.out.println(student); // Print the student object if found
                found = true;
            }
        }
        if (!found) {
            System.out.println("Student with the given name not found.");
        }
    }

    /**
     * Method to display the student list
     *
     * This method prints the details of all students in the list. If the list
     * is empty, it shows a message that no students are available.
     */
    public void displayStudentList() {
        if (studentList.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : studentList) {
                System.out.println(student);
                System.out.println("---------------------------");
            }
        }
    }

    /**
     * Main method for user interaction with the menu
     *
     * This method runs the menu-driven interface for user interaction. Users
     * can choose to add students, search for students, display the student
     * list, or exit the program.
     */
    public void project() {
        int choice;

        do {
            System.out.println("1. Enter student list");
            System.out.println("2. Look up student");
            System.out.println("3. Display student list");
            System.out.println("4. Exit");

            choice = CheckInputValue.getInteger("Please choose (1–4): ");

            switch (choice) {
                case 1:
                    addStudent(); // Add a new student
                    break;
                case 2:
                    String searchName = CheckInputValue.getStringName("Enter first name to search: ", "^[a-zA-Z]+$");
                    lookUpStudent(searchName); // Search for a student
                    break;
                case 3:
                    System.out.println("Student list:");
                    System.out.println("----------------------------");
                    displayStudentList(); // Display the list of students
                    break;
                case 4:
                    System.out.println("Exiting the program");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }

        } while (choice != 4); // Repeat until user chooses to exit
    }
}
