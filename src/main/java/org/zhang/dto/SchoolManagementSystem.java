package org.zhang.dto;

import lombok.Getter;

import java.util.Arrays;

@Getter
/**
 * SchoolManagementSystem class for managing departments, students, teachers, and courses.
 *
 * @author Cihao Zhang
 */
public class SchoolManagementSystem {
    private static final int MAX_DEPARTMENT_NUM = 5;
    private static final int MAX_STUDENT_NUM = 200;
    private static final int MAX_TEACHER_NUM = 20;
    private static final int MAX_COURSE_NUM = 30;

    private Department[] departments;
    private int numDepartments;
    private Student[] students;
    private int numStudents;
    private Teacher[] teachers;
    private int numTeachers;
    private Course[] courses;
    private int numCourses;

    /**
     * A NoArgsConstructor for SchoolManagementSystem. Using departments, students, teachers, and courses as empty arrays.
     */
    public SchoolManagementSystem() {
        this.departments = new Department[MAX_DEPARTMENT_NUM];
        numDepartments = 0;
        this.students = new Student[MAX_STUDENT_NUM];
        numStudents = 0;
        this.teachers = new Teacher[MAX_TEACHER_NUM];
        numTeachers = 0;
        this.courses = new Course[MAX_COURSE_NUM];
        numCourses = 0;
    }

    /**
     * Add a department based on its name.
     *
     * @param name The name of the new department.
     */
    public void addDepartment(String name) {
        if (numDepartments < MAX_DEPARTMENT_NUM) {
            departments[numDepartments] = new Department(name);
            System.out.println("The department " + departments[numDepartments++] + " has been added.");
        } else {
            System.out.println("The maximum number of departments has been reached.");
        }
    }

    /**
     * Add a student based on his name and the name of his department.
     *
     * @param lastName     The last name of the student.
     * @param firstName    The first name of the student.
     * @param departmentId ID of the department of the student.
     */
    public void addStudent(String lastName, String firstName, String departmentId) {
        Department department = findDepartment(departmentId);
        if (numStudents < MAX_STUDENT_NUM) {
            students[numStudents] = new Student(lastName, firstName, department);
            System.out.println("The student " + students[numStudents++] + " has been added.");
        } else {
            System.out.println("The maximum number of students has been reached.");
        }
    }

    /**
     * Add a teacher based on his name and the name of his department.
     *
     * @param lastName     The last name of the teacher.
     * @param firstName    The first name of the teacher.
     * @param departmentId ID of the department of the teacher.
     */
    public void addTeacher(String lastName, String firstName, String departmentId) {
        Department department = findDepartment(departmentId);
        if (numTeachers < MAX_TEACHER_NUM) {
            teachers[numTeachers] = new Teacher(lastName, firstName, department);
            System.out.println("The teacher " + teachers[numTeachers++] + " has been added.");
        } else {
            System.out.println("The maximum number of teachers has been reached.");
        }
    }

    /**
     * Add a course based on its name, its credit, and the name of its department.
     *
     * @param courseName   The name of the course.
     * @param credit       credit given by the course.
     * @param departmentId ID of the department of the course.
     */
    public void addCourse(String courseName, double credit, String departmentId) {
        Department department = findDepartment(departmentId);
        if (department != null) {
            if (numCourses < MAX_COURSE_NUM) {
                courses[numCourses] = new Course(courseName, credit, department);
                System.out.println("The course " + courses[numCourses++] + " has been added.");
            } else {
                System.out.println("The maximum number of courses has been reached.");
            }
        } else {
            System.out.println("The department does not exist.");
        }
    }

    /**
     * Display all departments in a school.
     */
    public void printDepartment() {
        for (Department department : departments) {
            if (department != null) {
                System.out.println(department);
            } else {
                System.out.println("There are " + (numDepartments) + " departments.");
                break;
            }
        }
    }

    /**
     * Display all students in a school.
     * The name of the courses and the name of the department are only displayed if there is any.
     */
    public void printStudents() {
        for (Student student : students) {
            if (student != null) {
                System.out.println(student);
            } else {
                System.out.println("There are " + (numStudents) + " students.");
                break;
            }
        }
    }

    /**
     * Display all teachers in a school.
     * The name of the courses and the name of the department are only displayed if there is any.
     */
    public void printTeachers() {
        for (Teacher teacher : teachers) {
            if (teacher != null) {
                System.out.println(teacher);
            } else {
                System.out.println("There are " + (numTeachers) + " teachers.");
                break;
            }
        }
    }

    /**
     * Display all courses in a school.
     * The name of the teacher, the students, and the department are only displayed if there is any.
     */
    public void printCourses() {
        for (Course course : courses) {
            if (course != null) {
                System.out.println(course);
            } else {
                System.out.println("There are " + (numCourses) + " courses.");
                break;
            }
        }
    }

    /**
     * Search a department in the departments based on a departmentId.
     * If the departmentId does not match with any department, return null.
     *
     * @param departmentId The department's ID.
     * @return The department with corresponding ID, null if nothing is corresponding.
     */
    public Department findDepartment(String departmentId) {
        for (Department department : departments) {
            if (department != null && department.getId().equals(departmentId)) {
                return department;
            }
        }
        return null;
    }

    /**
     * Search a student in the students based on a studentId.
     * If the studentId does not match with any student, return null.
     *
     * @param studentId The student's ID.
     * @return The student with corresponding ID, null if nothing is corresponding.
     */
    public Student findStudent(String studentId) {
        for (Student student : students) {
            if (student != null && student.getId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    /**
     * Search a teacher in the teachers based on a teacherId.
     * If the teacherId does not match with any teacher, return null.
     *
     * @param teacherId The teacher's ID.
     * @return The teacher with corresponding ID, null if nothing is corresponding.
     */
    public Teacher findTeacher(String teacherId) {
        for (Teacher teacher : teachers) {
            if (teacher != null && teacher.getId().equals(teacherId)) {
                return teacher;
            }
        }
        return null;
    }

    /**
     * Search a course in the courses based on a courseId.
     * If the courseId does not match with any course, return null.
     *
     * @param courseId The course's ID.
     * @return The course with corresponding ID, null if nothing is corresponding.
     */
    public Course findCourse(String courseId) {
        for (Course course : courses) {
            if (course != null && course.getId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    /**
     * Assign a teacher to a different course (based on teacherId and courseId).
     * If no corresponding teacher or course is found, a message will be printed.
     *
     * @param teacherId The teacher's ID to assign to the course.
     * @param courseId  The course's ID.
     */
    public void modifyCourseTeacher(String teacherId, String courseId) {
        Teacher teacher = findTeacher(teacherId);
        Course course = findCourse(courseId);

        if (teacher == null || course == null) {
            System.out.println("No corresponding teacher or course found.");
        } else {
            course.setTeacher(teacher);
            System.out.println("Teacher has been assigned to the course successfully.");
        }
    }

    /**
     * Register a student to a course (based on studentId and courseId).
     * If no corresponding student or course is found, a message will be printed.
     * If the student has already registered to a max amount (5) of courses, a message will be printed.
     * If there's already a max amount (5) of student registered to the course, a message will be printed.
     * If the student already registered to the corresponding course, a message will be printed.
     *
     * @param studentId The ID of the student registered to the course.
     * @param courseId  The course's ID.
     */
    public void registerCourse(String studentId, String courseId) {
        Student student = findStudent(studentId);
        Course course = findCourse(courseId);

        if (student == null || course == null) {
            System.out.println("No corresponding student or course found.");
        } else if (student.getCourseNum() >= 5) {
            System.out.println("The student has already registered to the maximum number of courses.");
        } else if (course.getStudentNum() >= 5) {
            System.out.println("The course has reached the maximum number of registered students.");
        } else if (Arrays.asList(student.getCourses()).contains(course)) {
            System.out.println("The student is already registered to the corresponding course.");
        } else {
            student.registerCourse(course);
            course.addStudent(student);
            System.out.println("Student has been registered to the course successfully.");
        }
    }
}
