package org.zhang.dto;

import java.util.Arrays;

public class Student {
    private static final int MAX_COURSE_NUM = 5;
    private static int nextId = 1;

    private String id;
    private String lastName;
    private String firstName;
    private Department department;
    private Course[] courses;
    private int courseNum;

    public Student(String lastName, String firstName, Department department) {
        this.id = String.format("S%03d", nextId++);
        this.lastName = lastName;
        this.firstName = firstName;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", department=" + department +
                ", courses=" + Arrays.toString(courses) +
                ", courseNum=" + courseNum +
                '}';
    }
}
