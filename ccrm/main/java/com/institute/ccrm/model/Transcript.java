package com.institute.ccrm.model;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents a student's academic transcript.
 */
public class Transcript {
    
    private final Student student;
    private final List<Grade> grades;
    
    // Constructor
    public Transcript(Student student, List<Grade> grades) {
        this.student = student;
        this.grades = grades;
    }
    
    public Student getStudent() {
        return student;
    }
    
    public List<Grade> getGrades() {
        return grades;
    }
    
    /**
     * Calculates GPA based on marks and credits.
     * Assumes grade letters or marks are convertible to GPA scale.
     */
    public double calculateGPA() {
        double totalPoints = 0.0;
        int totalCredits = 0;
        
        for (Grade grade : grades) {
            int credits = grade.getEnrollment().getCourse().getCredits();
            double gradePoint = mapGradeToPoint(grade.getGradeLetter());
            totalPoints += gradePoint * credits;
            totalCredits += credits;
        }
        
        return (totalCredits > 0) ? (totalPoints / totalCredits) : 0.0;
    }
    
    // Map grade letters to grade points (Example scale)
    private double mapGradeToPoint(String gradeLetter) {
        switch (gradeLetter.toUpperCase()) {
            case "A+": return 4.0;
            case "A":  return 4.0;
            case "A-": return 3.7;
            case "B+": return 3.3;
            case "B":  return 3.0;
            case "B-": return 2.7;
            case "C+": return 2.3;
            case "C":  return 2.0;
            case "C-": return 1.7;
            case "D+": return 1.3;
            case "D":  return 1.0;
            case "F":  return 0.0;
            default:   return 0.0;
        }
    }
    
    /**
     * Prints transcript details in a formatted manner.
     */
    public void printTranscript() {
        System.out.println("Transcript for student: " + student.getFullName());
        System.out.println("Student ID: " + student.getId());
        System.out.println("-------------------------------------------");
        System.out.printf("%-10s %-30s %-7s %-5s\n", "Course", "Course Name", "Grade", "Credits");
        
        for (Grade grade : grades) {
            Course course = grade.getEnrollment().getCourse();
            System.out.printf("%-10s %-30s %-7s %-5d\n", 
                              course.getCourseCode(), course.getCourseName(), 
                              grade.getGradeLetter(), course.getCredits());
        }
        
        System.out.println("-------------------------------------------");
        System.out.printf("GPA: %.2f\n", calculateGPA());
    }
}
