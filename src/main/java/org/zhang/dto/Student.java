package org.zhang.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Student for school.
 *
 * @author Cihao Zhang
 */
@Getter
@Setter
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
        this.courses = new Course[MAX_COURSE_NUM];
        this.courseNum = 0;
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
                ", department=" + departmentString(department) +
                ", courses=" + courseString(courses) +
                ", courseNum=" + courseNum +
                '}';
    }

    /**
     * Register a course. Checks for whether the course has been registered. and whether
     * the student has reached the maximum number of courses.
     * @param course course
     */
    public void registerCourseStudent(Course course) {
        if (courseNum < MAX_COURSE_NUM) {
            for (int i = 0; i < courseNum; i++) {
                if (course == courses[i]) {
                    System.out.println("Already registered.");
                }
            }
            courses[courseNum++] = course;
        } else {
            System.out.println("Student has already reached maximum number of courses.");
        }
    }

    /**
     * Returns a string representation of the courses. If there is no course, return empty string.
     * @param courses array of courses
     * @return string representation of the courses
     */
    private String courseString(Course[] courses) {
        String courseString = "";
        for (Course course : courses) {
            if (course != null) {
                courseString += course.getCourseName() + " ";
            }
        }
        return courseString;
    }

    /**
     * Returns a string representation of the department. If there is no department, return empty string.
     * @param department object of department
     * @return string representation of the department
     */
    private String departmentString(Department department) {
        if (department != null) {
            return department.getDepartmentName();
        }
        return "";
    }
}
