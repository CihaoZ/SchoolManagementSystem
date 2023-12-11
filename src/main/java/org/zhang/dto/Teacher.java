package org.zhang.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Teacher of the School
 *
 * @author Cihao Zhang
 */
@Getter
@Setter
public class Teacher {
    private static int nextId = 1;
    private String lastName;
    private String firstName;
    private String id;
    private Department department;

    /**
     * Constructor for Teacher with lastName, firstName and department, with incrementing id.
     *
     * @param lastName   lastName of the teacher
     * @param firstName  firstName of the teacher
     * @param department department of the teacher
     */
    public Teacher(String lastName, String firstName, Department department) {
        this.id = String.format("T%03d", nextId++);
        this.lastName = lastName;
        this.firstName = firstName;
        this.department = department;
    }

    /**
     * Returns a string representation of the teacher.
     *
     * @return returns a string representation of the teacher.
     */
    @Override
    public String toString() {
        return "Teacher{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id='" + id + '\'' +
                ", department=" + department +
                '}';
    }
}
