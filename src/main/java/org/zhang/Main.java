package org.zhang;

import org.zhang.dto.SchoolManagementSystem;

/**
 * CS Final Project
 *
 * @author Cihao Zhang
 */
public class Main {
    public static void main(String[] args) {
        SchoolManagementSystem schoolManagementSystem = new SchoolManagementSystem();
        schoolManagementSystem.addDepartment("Computer Science");
        schoolManagementSystem.addStudent("Zhang", "Cihao", "D001");
        schoolManagementSystem.addTeacher("Wang", "Yi", "D001");
        schoolManagementSystem.addCourse("Java", 3.0, "D001");
        schoolManagementSystem.printDepartment();
        schoolManagementSystem.printStudents();
        schoolManagementSystem.printCourses();
        schoolManagementSystem.printTeachers();
        schoolManagementSystem.findCourse("C001");
        schoolManagementSystem.findStudent("S001");
        schoolManagementSystem.findDepartment("D001");
        schoolManagementSystem.findTeacher("T001");
        schoolManagementSystem.addDepartment("Mathematics");
        schoolManagementSystem.addCourse("Calculus4", 5.0, "D002");
        schoolManagementSystem.modifyCourseTeacher("T001", "C002");
    }
}
