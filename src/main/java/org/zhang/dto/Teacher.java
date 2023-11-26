package org.zhang.dto;

public class Teacher {
    private static int nextId = 1;
    private String lastName;
    private String firstName;
    private String id;
    private Department department;

    public Teacher(String lastName, String firstName, Department department) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.department = department;
        this.id = String.format("T%03d", nextId++);
    }

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
