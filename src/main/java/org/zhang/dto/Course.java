package org.zhang.dto;

import java.util.Arrays;

/**
 * Course of school
 *
 * @author Cihao Zhang
 */
public class Course {
    private static final int MAX_STUDENT_NUM = 5;
    private static int nextId = 1;

    private String id;
    private String courseName;
    private double credit;
    private Department department;
    private Teacher teacher;
    private Student[] students;
    private int studentNum;

    /**
     * Constructor of Course with name, credit, and department, with incremented id.
     *
     * @param courseName Name of course
     * @param credit     Credit of course
     * @param department Department of course
     */
    public Course(String courseName, double credit, Department department) {
        this.id = String.format("C%03d", nextId++);
        this.courseName = courseName;
        this.credit = credit;
        this.department = department;
    }

    /**
     * Returns a string representation of the course.
     *
     * @return a string representation of the course.
     */
    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credit=" + credit +
                ", department=" + department +
                ", teacher=" + teacher +
                ", students=" + Arrays.toString(students) +
                ", studentNum=" + studentNum +
                '}';
    }
}
