package com.institute.ccrm.app;

import com.institute.ccrm.model.*;
import com.institute.ccrm.service.*;
import com.institute.ccrm.util.DateUtil;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class CCRMApp {
    
    private final StudentService studentService = new StudentService();
    private final CourseService courseService = new CourseService();
    private final EnrollmentService enrollmentService = new EnrollmentService();
    private final GradeService gradeService = new GradeService();
    private final TranscriptService transcriptService = new TranscriptService();
    
    private final Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        CCRMApp app = new CCRMApp();
        app.run();
    }
    
    private void run() {
        boolean exit = false;
        while (!exit) {
            printMainMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> manageStudentsMenu();
                case "2" -> manageCoursesMenu();
                case "3" -> manageEnrollmentsMenu();
                case "4" -> recordGrades();
                case "5" -> printTranscripts();
                case "0" -> exit = true;
                default -> System.out.println("Invalid choice, try again.");
            }
        }
        System.out.println("Exiting Campus Course Records Manager. Goodbye!");
    }
    
    private void printMainMenu() {
        System.out.println("\n*** Campus Course Records Manager ***");
        System.out.println("1. Manage Students");
        System.out.println("2. Manage Courses");
        System.out.println("3. Manage Enrollments");
        System.out.println("4. Record Grades");
        System.out.println("5. Print Transcripts");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    // Student submenu
    private void manageStudentsMenu() {
        System.out.println("\n-- Manage Students --");
        System.out.println("1. Add Student");
        System.out.println("2. List Students");
        System.out.println("0. Back");
        System.out.print("Enter choice: ");
        String choice = scanner.nextLine().trim();
        switch (choice) {
            case "1" -> addStudent();
            case "2" -> listStudents();
            case "0" -> {}
            default -> System.out.println("Invalid choice");
        }
    }

    private void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine().trim();
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine().trim();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine().trim();
        System.out.print("Enter Date of Birth (yyyy-MM-dd): ");
        LocalDate dob = DateUtil.parseDate(scanner.nextLine().trim());
        System.out.print("Enter Department: ");
        String dept = scanner.nextLine().trim();

        boolean success = studentService.addStudent(id, firstName, lastName, dob, dept);
        if (success)
            System.out.println("Student added successfully.");
        else
            System.out.println("Student with ID already exists.");
    }

    private void listStudents() {
        List<Student> students = studentService.listActiveStudents();
        if (students.isEmpty()) {
            System.out.println("No active students found.");
        } else {
            students.forEach(System.out::println);
        }
    }

    // Course submenu
    private void manageCoursesMenu() {
        System.out.println("\n-- Manage Courses --");
        System.out.println("1. Add Course");
        System.out.println("2. List Courses");
        System.out.println("0. Back");
        System.out.print("Enter choice: ");
        String choice = scanner.nextLine().trim();
        switch (choice) {
            case "1" -> addCourse();
            case "2" -> listCourses();
            case "0" -> {}
            default -> System.out.println("Invalid choice");
        }
    }

    private void addCourse() {
        System.out.print("Enter Course Code: ");
        String code = scanner.nextLine().trim();
        System.out.print("Enter Course Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter Instructor: ");
        String inst = scanner.nextLine().trim();
        System.out.print("Enter Credits: ");
        int credits;
        try {
            credits = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid number for credits.");
            return;
        }

        boolean success = courseService.addCourse(code, name, inst, credits);
        if (success)
            System.out.println("Course added successfully.");
        else
            System.out.println("Course with this code already exists.");
    }

    private void listCourses() {
        List<Course> courses = courseService.listActiveCourses();
        if (courses.isEmpty()) {
            System.out.println("No active courses found.");
        } else {
            courses.forEach(System.out::println);
        }
    }

    // Enrollment submenu
    private void manageEnrollmentsMenu() {
        System.out.println("\n-- Manage Enrollments --");
        System.out.println("1. Enroll Student");
        System.out.println("2. List Enrollments");
        System.out.println("0. Back");
        System.out.print("Enter choice: ");
        String choice = scanner.nextLine().trim();
        switch (choice) {
            case "1" -> addEnrollment();
            case "2" -> listEnrollments();
            case "0" -> {}
            default -> System.out.println("Invalid choice");
        }
    }

    private void addEnrollment() {
        System.out.print("Enter Enrollment ID: ");
        String eid = scanner.nextLine().trim();
        System.out.print("Enter Student ID: ");
        String sid = scanner.nextLine().trim();
        System.out.print("Enter Course Code: ");
        String ccode = scanner.nextLine().trim();
        System.out.print("Enter Enrollment Date (yyyy-MM-dd): ");
        LocalDate edate = DateUtil.parseDate(scanner.nextLine().trim());

        Student student = studentService.getStudentById(sid);
        Course course = courseService.getCourseByCode(ccode);

        if (student == null || !student.isActive()) {
            System.out.println("Student not found or inactive.");
            return;
        }
        if (course == null || !course.isActive()) {
            System.out.println("Course not found or inactive.");
            return;
        }
        boolean success = enrollmentService.enrollStudent(eid, student, course, edate);
        if (success)
            System.out.println("Enrollment successful.");
        else
            System.out.println("Enrollment failed. Possibly already enrolled or invalid data.");
    }

    private void listEnrollments() {
        List<Enrollment> enrollments = enrollmentService.listActiveEnrollments();
        if (enrollments.isEmpty()) {
            System.out.println("No active enrollments found.");
        } else {
            enrollments.forEach(System.out::println);
        }
    }

    // Grade recording, transcript printing already provided and can be used

    private void recordGrades() {
        System.out.println("\n-- Record Grade for an Enrollment --");
        System.out.print("Enter Enrollment ID: ");
        String enrollmentId = scanner.nextLine().trim();

        Enrollment enrollment = enrollmentService.listActiveEnrollments().stream()
                .filter(e -> e.getEnrollmentId().equals(enrollmentId))
                .findFirst()
                .orElse(null);

        if (enrollment == null) {
            System.out.println("Enrollment not found or inactive.");
            return;
        }

        System.out.print("Enter marks obtained: ");
        double marks;
        try {
            marks = Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid marks input.");
            return;
        }

        System.out.print("Enter grade letter (e.g., A, B+, C): ");
        String gradeLetter = scanner.nextLine().trim();

        gradeService.recordGrade(enrollment, marks, gradeLetter);
        System.out.println("Grade recorded successfully.");
    }

    private void printTranscripts() {
        System.out.println("\n-- Print Transcript --");
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine().trim();

        Student student = studentService.getStudentById(studentId);

        if (student == null || !student.isActive()) {
            System.out.println("Student not found or inactive.");
            return;
        }

        List<Grade> grades = gradeService.getAllGradesForStudent(studentId);

        if (grades.isEmpty()) {
            System.out.println("No grades recorded for this student.");
            return;
        }

        Transcript transcript = transcriptService.createTranscript(student, grades);
        transcript.printTranscript();
    }
}
