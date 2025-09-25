package com.institute.ccrm.service;

import com.institute.ccrm.model.Course;
import com.institute.ccrm.model.Enrollment;
import com.institute.ccrm.model.Student;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Service class to manage enrollments of students in courses.
 */
public class EnrollmentService {
    
    private final Map<String, Enrollment> enrollmentMap;
    
    public EnrollmentService() {
        this.enrollmentMap = new HashMap<>();
    }
    
    /**
     * Enrolls a student in a course.
     *
     * @return true if successfully enrolled, false if enrollment exists or inactive student/course.
     */
    public boolean enrollStudent(String enrollmentId, Student student, Course course, LocalDate enrollmentDate) {
        if (student == null || !student.isActive() || course == null || !course.isActive()) {
            return false;
        }
        // Check if already enrolled
        for (Enrollment en : enrollmentMap.values()) {
            if (en.getStudent().equals(student) && en.getCourse().equals(course) && en.isActive()) {
                return false; // Already enrolled
            }
        }
        Enrollment enrollment = new Enrollment(enrollmentId, student, course, enrollmentDate);
        enrollmentMap.put(enrollmentId, enrollment);
        return true;
    }
    
    /**
     * Unenrolls a student from a course by deactivating enrollment.
     */
    public boolean unenrollStudent(String enrollmentId) {
        Enrollment enrollment = enrollmentMap.get(enrollmentId);
        if (enrollment != null && enrollment.isActive()) {
            enrollment.deactivate();
            return true;
        }
        return false;
    }
    
    /**
     * Lists active enrollments.
     */
    public List<Enrollment> listActiveEnrollments() {
        return enrollmentMap.values()
                .stream()
                .filter(Enrollment::isActive)
                .collect(Collectors.toList());
    }
    
    /**
     * Lists enrollments by a specific student.
     */
    public List<Enrollment> listEnrollmentsByStudent(String studentId) {
        return enrollmentMap.values()
                .stream()
                .filter(en -> en.isActive() && en.getStudent().getId().equals(studentId))
                .collect(Collectors.toList());
    }
    
    /**
     * Lists enrollments for a course.
     */
    public List<Enrollment> listEnrollmentsByCourse(String courseCode) {
        return enrollmentMap.values()
                .stream()
                .filter(en -> en.isActive() && en.getCourse().getCourseCode().equals(courseCode))
                .collect(Collectors.toList());
    }
}
