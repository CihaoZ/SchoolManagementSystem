package org.zhang;

import org.zhang.dto.SchoolManagementSystem;

/**
 * CS Final Project
 *
 * @author Cihao Zhang
 */
public class Main {
    public static void main(String[] args) {
        //Start the SchoolManagementSystem
        SchoolManagementSystem schoolManagementSystem = new SchoolManagementSystem();
        // Start the program
        schoolManagementSystem.start();

        // Alternative version of start() (Please comment out the first version to try.)
        /**
        // Add some departments
        schoolManagementSystem.addDepartment("Computer Science");
        schoolManagementSystem.addDepartment("Mathematics");
        schoolManagementSystem.addDepartment("Physics");
        schoolManagementSystem.addDepartment("Chemistry");
        schoolManagementSystem.addDepartment("Biology");
        schoolManagementSystem.addDepartment("English"); // Should fail

        // print out the departments
        schoolManagementSystem.printDepartment();

        // Find the department
        schoolManagementSystem.findDepartment("D001");

        // Add some students
        for (int i = 0; i < 201; i++) {
            schoolManagementSystem.addStudent("Zhang", "Cihao", "D001"); //201st student should fail
        }

        // print out the students
        schoolManagementSystem.printStudents();

        // Add some teachers
        for (int i = 0; i < 21; i++) {
            schoolManagementSystem.addTeacher("Yi", "Wang", "D001"); //21st teacher should fail
        }

        // display the teachers
        schoolManagementSystem.printTeachers();

        // Add some courses
        for (int i = 0; i < 31; i++) {
            schoolManagementSystem.addCourse("CST101", 3, "D001");
        }

        // Display the courses
        schoolManagementSystem.printCourses();

        // Modify the Teacher's course
        schoolManagementSystem.modifyCourseTeacher("T001", "D001"); // should succeed

        schoolManagementSystem.modifyCourseTeacher("T001", "C031"); // should fail because course not found

        schoolManagementSystem.modifyCourseTeacher("T021", "C001"); // should fail because teacher not found

        // Register a course for a student
        schoolManagementSystem.registerCourse("S001", "C001"); // should succeed
        schoolManagementSystem.registerCourse("S201", "C001"); // should fail because student not found
        schoolManagementSystem.registerCourse("S001", "C031"); // should fail because course not found
        schoolManagementSystem.registerCourse("S00", "C001"); // should fail because student already registered (bonus)

        // Fills the registerCourseStudent in students
        schoolManagementSystem.registerCourse("S002", "C001");
        schoolManagementSystem.registerCourse("S003", "C001");
        schoolManagementSystem.registerCourse("S004", "C001");
        schoolManagementSystem.registerCourse("S005", "C001");
        schoolManagementSystem.registerCourse("S006", "C001"); // should fail because cap

        // Fills the registerCourse in classes
        schoolManagementSystem.registerCourse("S001", "C002");
        schoolManagementSystem.registerCourse("S001", "C003");
        schoolManagementSystem.registerCourse("S001", "C004");
        schoolManagementSystem.registerCourse("S001", "C005");
        schoolManagementSystem.registerCourse("S001", "C006"); // should fail because cap
        */
    }
}
