package org.zhang.dto;

import lombok.Getter;

import java.util.Scanner;


/**
 * SchoolManagementSystem class for managing departments, students, teachers, and courses.
 *
 * @author Cihao Zhang
 */
@Getter
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
        this.numDepartments = 0;
        this.students = new Student[MAX_STUDENT_NUM];
        this.numStudents = 0;
        this.teachers = new Teacher[MAX_TEACHER_NUM];
        this.numTeachers = 0;
        this.courses = new Course[MAX_COURSE_NUM];
        this.numCourses = 0;
    }

    /**
     * Start the SchoolManagementSystem program.
     */
    public void start() {
        // Initialize the scanner
        Scanner scanner = new Scanner(System.in);

        //Start the program and let the user choose what they want to do
        while (true) {
            // Print welcome message and help message
            System.out.println("Welcome to the School Management System Console!\n");
            System.out.println("The maximum number of departments is " + MAX_DEPARTMENT_NUM + ".");
            System.out.println("The maximum number of students is " + MAX_STUDENT_NUM + ".");
            System.out.println("The maximum number of teachers is " + MAX_TEACHER_NUM + ".");
            System.out.println("The maximum number of courses is " + MAX_COURSE_NUM + ".");

            // Ask the user what they want to do
            System.out.println("What would you like to do today? Please press 'q' to quit. Please press 'h' for help. " +
                    "The following inputs are Case Sensitive.");
            String input = scanner.next();

            // Quit the program
            if (input.equals("q")) {
                return;
            }

            // Help page
            if (input.equals("h")) {
                System.out.println("Welcome to the help page 1/2, press '2' for help page 2/2.");
                System.out.println("addDepartment - Add a department based on its name.");
                System.out.println("addStudent - Add a student based on his first and last name and the " +
                        "Id of his department.");
                System.out.println("addTeacher - Add a teacher based on his first and last name and the " +
                        "Id of his department.");
                System.out.println("addCourse - Add a course based on its name, credit, and the Id of its department.");
                System.out.println("printDepartments - Display all departments.");

                String input2 = scanner.next();
                while (!input2.equals("e")) {
                    if (input2.equals("2")) {
                        System.out.println("Welcome to the help page 2/2, press 'e' to exit.");
                        System.out.println("printStudents - Display all students.");
                        System.out.println("printTeachers - Display all teachers.");
                        System.out.println("printCourses - Display all courses.");
                        System.out.println("q - Quit the program.");
                        System.out.println("registerCourse - Register a course for a student. Using studentId and " +
                                "courseId.");
                        System.out.println("modifyCourseTeacher - Modify the teacher of a course. Using teacherId and " +
                                "courseId.");

                        String input3 = scanner.next();

                        if (input3.equals("e")) {
                            break;
                        }
                    }
                }
            }

            // Does an action based on the input
            switch (input) {
                // Add a department based on its name
                case "addDepartment":
                    System.out.println("Please enter the name of the new department in one word.");
                    String name = scanner.next();
                    addDepartment(name);
                    break;
                // Add a student based on his name and the name of his department, the user can choose whether
                // to give individual values or use default values
                case "addStudent":
                    System.out.println("How many students do you want to add?");
                    int numStudents = scanner.nextInt();
                    System.out.println("Would you like to give individual values or use default values? I/D");
                    String input2 = scanner.next();
                    if (input2.equals("I")) {
                        for (int i = 0; i < numStudents; i++) {
                            System.out.println("Please enter the last name of the student.");
                            String lastNameS = scanner.next();
                            System.out.println("Please enter the first name of the student.");
                            String firstNameS = scanner.next();
                            System.out.println("Please enter the ID of the department of the student.");
                            String departmentIdS = scanner.next();
                            addStudent(lastNameS, firstNameS, departmentIdS);
                        }
                    } else if (input2.equals("D")) {
                        System.out.println("Which department would you like to use?");
                        String departmentIdS = scanner.next();
                        for (int i = 0; i < numStudents; i++) {
                            addStudent("Training", "Dummy" + i + 1 , departmentIdS);
                        }
                    } else {
                        System.out.println("Invalid input. Please try again.");
                        continue;
                    }
                    break;
                // Add a teacher based on his name and the name of his department the user can choose whether
                // they want individual values or use default values
                case "addTeacher":
                    System.out.println("How many teachers do you want to add?");
                    int numTeachers = scanner.nextInt();
                    System.out.println("Would you like to give individual values or use default values? I/D");
                    String input3 = scanner.next();
                    if (input3.equals("I")) {
                        for (int i = 0; i < numTeachers; i++) {
                            System.out.println("Please enter the last name of the teacher.");
                            String lastNameT = scanner.next();

                            System.out.println("Please enter the first name of the teacher.");
                            String firstNameT = scanner.next();

                            System.out.println("Please enter the ID of the department of the teacher.");
                            String departmentIdT = scanner.next();
                            addTeacher(lastNameT, firstNameT, departmentIdT);
                        }

                    } else if (input3.equals("D")) {
                        System.out.println("Which department would you like to use?");
                        String departmentIdT = scanner.next();
                        for (int i = 0; i < numTeachers; i++) {
                            addTeacher("Training", "Dummy" + i , departmentIdT);
                        }

                    } else {
                        System.out.println("Invalid input. Please try again.");
                        continue;
                    }
                    break;
                // Add a course based on its name, credit, and the Id of its department
                // the user can choose whether they want individual values or use default values
                case "addCourse":
                    System.out.println("How many courses do you want to add?");
                    int numCourses = scanner.nextInt();
                    System.out.println("Would you like to give individual values or use default values? I/D");
                    String input4 = scanner.next();

                    if (input4.equals("I")) {
                        for (int i = 0; i < numCourses; i++) {
                            System.out.println("Please enter the name of the course in one word.");
                            String nameC = scanner.next();
                            System.out.println("Please enter the credit of the course.");
                            double creditC = scanner.nextDouble();
                            System.out.println("Please enter the ID of the department of the course.");
                            String departmentIdC = scanner.next();
                            addCourse(nameC, creditC, departmentIdC);
                        }
                    } else if (input4.equals("D")) {
                        System.out.println("Which department would you like to use?");
                        String departmentIdC = scanner.next();
                        for (int i = 0; i < numCourses; i++) {
                            addCourse("DummyCourse" + i, 3.0, departmentIdC);
                        }
                    } else {
                        System.out.println("Invalid input. Please try again.");
                        continue;
                    }
                    break;
                // Print out all the departments
                case "printDepartments":
                    printDepartment();
                    break;
                // Print out all the students
                case "printStudents":
                    printStudents();
                    break;
                // Print out all the teachers
                case "printTeachers":
                    printTeachers();
                    break;
                // Print out all the courses
                case "printCourses":
                    printCourses();
                    break;
                // Find the student based on his department ID
                case "findStudent":
                    System.out.println("Please enter the ID of the student.");
                    String studentId2 = scanner.next();
                    findStudent(studentId2);
                    break;
                // Find the teacher based on his department ID
                case "findTeacher":
                    System.out.println("Please enter the ID of the teacher.");
                    String teacherId2 = scanner.next();
                    findTeacher(teacherId2);
                    break;
                // Find the course based on its department ID
                case "findCourse":
                    System.out.println("Please enter the ID of the course.");
                    String courseId2 = scanner.next();
                    findCourse(courseId2);
                    break;
                // Find the department based on its ID
                case "findDepartment":
                    System.out.println("Please enter the ID of the department.");
                    String departmentId2 = scanner.next();
                    findDepartment(departmentId2);
                    break;
                // Register a course for a student based on his ID and the ID of the course
                case "registerCourse":
                    System.out.println("Please enter the ID of the student.");
                    String studentId = scanner.next();
                    System.out.println("Please enter the ID of the course.");
                    String courseId = scanner.next();
                    registerCourse(studentId, courseId);
                    break;
                // Assign a teacher to a different course (based on teacherId and courseId)
                case "modifyCourseTeacher":
                    System.out.println("Please enter the ID of the course.");
                    String courseId3 = scanner.next();
                    System.out.println("Please enter the ID of the teacher.");
                    String teacherId = scanner.next();
                    modifyCourseTeacher(teacherId, courseId3);
                    break;
                // Invalid input
                default:
                    System.out.println("Invalid input. Please refer to 'h' for help.");
            }
        }
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
                System.out.println("Department found");
                return department;
            }
        }
        System.out.println("Department not found");
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
                System.out.println("Student found");
                return student;
            }
        }
        System.out.println("Student not found");
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
                System.out.println("Teacher found");
                return teacher;
            }
        }
        System.out.println("Teacher not found");
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
                System.out.println("Course found");
                return course;
            }
        }
        System.out.println("Course not found");
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

        if (teacher == null) {
            System.out.println("No corresponding Teacher found with " + teacherId + "Course " + courseId + " " +
                    "not updated.");
        } else if (course == null) {
            System.out.println("No corresponding course found with " + courseId + " Teacher " + teacherId + " " +
                    "not updated.");
        } else {
            course.setTeacher(teacher);
            System.out.println(course + "Teacher info updated successfully.");
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
            System.out.println("The student " + studentId + " has already registered to the maximum number of courses.");
        } else if (course.getStudentNum() >= 5) {
            System.out.println("The course " + courseId + " has reached the maximum number of registered students.");
        } else if (isRegisteredForCourse(student, course)) {
            System.out.println("The student " + studentId + " has already registered to the course" + courseId + "." +
                    " Registration failed.");
        } else {
            student.registerCourseStudent(course);
            course.addStudent(student);
            System.out.println("Student " + studentId + " has been registered to the course " + courseId + " successfully.");
            System.out.println("Latest Student info: " + student);
            System.out.println("Latest Course info: " + course);
        }
    }

    /**
     * Check if the student is registered for the course
     *
     * @param course the course
     * @return true if the student is registered for the course
     */
    public boolean isRegisteredForCourse(Student student, Course course) {
        for (Course c : student.getCourses()) {
            if (c == course) {
                return true;
            }
        }
        return false;
    }
}
