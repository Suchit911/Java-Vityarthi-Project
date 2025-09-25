package com.institute.ccrm.model;

import java.util.Objects;

/**
 * Represents a grade awarded to a student for a course.
 */
public class Grade {
    
    private final Enrollment enrollment;
    private double marksObtained;
    private String gradeLetter;
    
    // Constructor
    public Grade(Enrollment enrollment, double marksObtained, String gradeLetter) {
        this.enrollment = enrollment;
        this.marksObtained = marksObtained;
        this.gradeLetter = gradeLetter;
    }
    
    // Getters and setters
    
    public Enrollment getEnrollment() {
        return enrollment;
    }
    
    public double getMarksObtained() {
        return marksObtained;
    }
    
    public void setMarksObtained(double marksObtained) {
        this.marksObtained = marksObtained;
    }
    
    public String getGradeLetter() {
        return gradeLetter;
    }
    
    public void setGradeLetter(String gradeLetter) {
        this.gradeLetter = gradeLetter;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(enrollment);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Grade)) return false;
        Grade other = (Grade) obj;
        return Objects.equals(this.enrollment, other.enrollment);
    }
    
    @Override
    public String toString() {
        return "Grade{" +
               "enrollment=" + enrollment +
               ", marksObtained=" + marksObtained +
               ", gradeLetter='" + gradeLetter + '\'' +
               '}';
    }
}
