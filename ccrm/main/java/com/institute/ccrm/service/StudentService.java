package com.institute.ccrm.service;

import com.institute.ccrm.model.Student;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service class to manage student-related operations.
 */
public class StudentService {
    
    private final Map<String, Student> studentMap;

    public StudentService() {
        this.studentMap = new HashMap<>();
    }
    
    /**
     * Adds a new student to the system.
     */
    public boolean addStudent(String id, String firstName, String lastName, LocalDate dob, String department) {
        if (studentMap.containsKey(id)) {
            return false;  // Student with same ID exists
        }
        Student student = new Student(id, firstName, lastName, dob, department);
        studentMap.put(id, student);
        return true;
    }
    
    /**
     * Gets a student by ID.
     */
    public Student getStudentById(String id) {
        return studentMap.get(id);
    }
    
    /**
     * Updates student details.
     */
    public boolean updateStudent(String id, String newFirstName, String newLastName, LocalDate newDob, String newDepartment) {
        Student student = studentMap.get(id);
        if (student == null || !student.isActive()) {
            return false;
        }
        if (newFirstName != null && !newFirstName.isEmpty()) student.setFirstName(newFirstName);
        if (newLastName != null && !newLastName.isEmpty()) student.setLastName(newLastName);
        if (newDob != null) student.setDateOfBirth(newDob);
        if (newDepartment != null && !newDepartment.isEmpty()) student.setDepartment(newDepartment);
        return true;
    }
    
    /**
     * Deactivates a student.
     */
    public boolean deactivateStudent(String id) {
        Student student = studentMap.get(id);
        if (student != null && student.isActive()) {
            student.deactivate();
            return true;
        }
        return false;
    }
    
    /**
     * Lists all active students.
     */
    public List<Student> listActiveStudents() {
        return studentMap.values()
                .stream()
                .filter(Student::isActive)
                .sorted(Comparator.comparing(Student::getLastName).thenComparing(Student::getFirstName))
                .collect(Collectors.toList());
    }
}
