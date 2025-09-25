package com.institute.ccrm.model;

/**
 * Represents a course offered by the institute for students to enroll.
 */
public class Course {
    
    private final String courseCode;
    private String courseName;
    private String instructor;
    private int credits;
    private boolean active;
    
    // Constructor
    public Course(String courseCode, String courseName, String instructor, int credits) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.instructor = instructor;
        this.credits = credits;
        this.active = true;  // course is active by default
    }
    
    // Getters and setters
    
    public String getCourseCode() {
        return courseCode;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public String getInstructor() {
        return instructor;
    }
    
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
    
    public int getCredits() {
        return credits;
    }
    
    public void setCredits(int credits) {
        this.credits = credits;
    }
    
    public boolean isActive() {
        return active;
    }
    
    public void deactivate() {
        this.active = false;
    }
    
    @Override
    public String toString() {
        return "Course{" +
               "courseCode='" + courseCode + '\'' +
               ", courseName='" + courseName + '\'' +
               ", instructor='" + instructor + '\'' +
               ", credits=" + credits +
               ", active=" + active +
               '}';
    }
    
    @Override
    public int hashCode() {
        return courseCode.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Course)) return false;
        Course other = (Course) obj;
        return this.courseCode.equals(other.courseCode);
    }
}
