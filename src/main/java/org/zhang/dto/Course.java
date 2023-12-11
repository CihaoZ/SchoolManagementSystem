package org.zhang.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

/**
 * Course of school
 *
 * @author Cihao Zhang
 */
@Getter
@Setter
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
        this.students = new Student[MAX_STUDENT_NUM];
        this.studentNum = 0;
        this.teacher = null;
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
                ", department=" + departmentString(department) +
                ", teacher=" + stringTeacher(teacher) +
                ", students=" + stringStudent(students) +
                ", studentNum=" + studentNum +
                '}';
    }

    /**
     * Add a student to the course while checking if the course is full. If the course is full, print out a message.
     * @param student the student to be added
     */
    public void addStudent(Student student) {
        if (studentNum < MAX_STUDENT_NUM) {
            students[studentNum++] = student;
        } else {
            System.out.println("The course is full.");
        }
    }

    /**
     * Set the teacher of the course
     * @param teacher the teacher of the course
     */
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    /**
     * Turn the teacher of the course into a string
     * @param teacher the teacher
     * @return the string
     */
    public String stringTeacher(Teacher teacher) {
        String strOut = "";
        if (teacher != null) {
            strOut += teacher.getFirstName() + " " + teacher.getLastName() + "\n";
        }
        return strOut;
    }

    /**
     * Turn the students of the course into a string
     * @param students Array of students
     * @return the string
     */
    public String stringStudent(Student[] students) {
        String strOut = "";
        for (Student student : students) {
            if (student != null) {
                strOut += student.getFirstName() + " " + student.getLastName() + "\n";
            }
        }
        return strOut;
    }

    /**
     * Turn the department of the course into a string or an empty string if the department is null
     * @param department the department
     * @return the string
     */
    private String departmentString(Department department) {
        if (department != null) {
            return department.getDepartmentName();
        }
        return "";
    }
}
