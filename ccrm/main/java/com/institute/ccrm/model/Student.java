package com.institute.ccrm.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Represents a student in the Campus Course Records Manager system.
 * Contains student details and status.
 */
public class Student {
    
    private final String id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String department;
    private boolean active;
    
    private static final DateTimeFormatter DOB_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    // Constructor
    public Student(String id, String firstName, String lastName, LocalDate dateOfBirth, String department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.active = true;  // New students are active by default
    }
    
    // Getters and setters
    
    public String getId() {
        return id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public boolean isActive() {
        return active;
    }
    
    public void deactivate() {
        this.active = false;
    }
    
    // Utility methods
    
    /**
     * Returns formatted DOB string.
     */
    public String getFormattedDOB() {
        return dateOfBirth.format(DOB_FORMATTER);
    }
    
    /**
     * Returns full name of the student.
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }
    
    @Override
    public String toString() {
        return "Student{" +
               "id='" + id + '\'' +
               ", name='" + getFullName() + '\'' +
               ", dob=" + getFormattedDOB() +
               ", department='" + department + '\'' +
               ", active=" + active +
               '}';
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student other = (Student) obj;
        return Objects.equals(this.id, other.id);
    }
}
