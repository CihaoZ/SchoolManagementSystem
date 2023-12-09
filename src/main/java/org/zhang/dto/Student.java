package org.zhang.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * Student for school.
 *
 * @author Cihao Zhang
 */
public class Student {
    private static final int MAX_COURSE_NUM = 5;
    private static int nextId = 1;

    private String id;
    private String lastName;
    private String firstName;
    private Department department;
    private Course[] courses;
    private int courseNum;

    /**
     * Constructor of Student with last name, first name and department. With incremented ID.
     *
     * @param lastName   last name of student
     * @param firstName  first name of student
     * @param department department of student
     */
    public Student(String lastName, String firstName, Department department) {
        this.id = String.format("S%03d", nextId++);
        this.lastName = lastName;
        this.firstName = firstName;
        this.department = department;
    }

    /**
     * Returns a string representation of the student.
     *
     * @return the string representation of the student.
     */
    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", department=" + department +
                ", courses=" + courseString(courses) +
                ", courseNum=" + courseNum +
                '}';
    }

    public void registerCourse(Course course) {
        if (courseNum < MAX_COURSE_NUM) {
            courses[courseNum++] = course;
        }
    }

    private String courseString(Course[] courses) {
        String courseString = "";
        for (Course course : courses) {
            if (course != null) {
                courseString += course.getCourseName() + " ";
            }
        }
        return courseString;
    }
}
