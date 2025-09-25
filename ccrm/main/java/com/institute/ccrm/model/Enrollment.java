package com.institute.ccrm.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Represents enrollment of a student in a particular course.
 */
public class Enrollment {
    
    private final String enrollmentId;
    private final Student student;
    private final Course course;
    private LocalDate enrollmentDate;
    private boolean active;
    
    // Constructor
    public Enrollment(String enrollmentId, Student student, Course course, LocalDate enrollmentDate) {
        this.enrollmentId = enrollmentId;
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
        this.active = true;
    }
    
    // Getters & setters
    
    public String getEnrollmentId() {
        return enrollmentId;
    }
    
    public Student getStudent() {
        return student;
    }
    
    public Course getCourse() {
        return course;
    }
    
    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }
    
    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
    
    public boolean isActive() {
        return active;
    }
    
    public void deactivate() {
        this.active = false;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(enrollmentId);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Enrollment)) return false;
        Enrollment other = (Enrollment) obj;
        return Objects.equals(enrollmentId, other.enrollmentId);
    }
    
    @Override
    public String toString() {
        return "Enrollment{" +
               "enrollmentId='" + enrollmentId + '\'' +
               ", student=" + student.getFullName() +
               ", course=" + course.getCourseCode() +
               ", enrollmentDate=" + enrollmentDate +
               ", active=" + active +
               '}';
    }
}
