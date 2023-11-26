package org.zhang.dto;

import java.util.Arrays;

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


    public Course(String courseName, double credit, Department department) {
        this.id = String.format("C%03d", nextId++);
        this.courseName = courseName;
        this.credit = credit;
        this.department = department;
    }

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
