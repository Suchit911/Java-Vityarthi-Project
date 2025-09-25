package com.institute.ccrm.service;

import com.institute.ccrm.model.Enrollment;
import com.institute.ccrm.model.Grade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service class to handle grade records.
 */
public class GradeService {

    private final Map<Enrollment, Grade> gradeRecords;

    public GradeService() {
        this.gradeRecords = new HashMap<>();
    }

    /**
     * Records or updates a grade for an enrollment.
     */
    public void recordGrade(Enrollment enrollment, double marksObtained, String gradeLetter) {
        if (enrollment == null) {
            throw new IllegalArgumentException("Enrollment cannot be null");
        }
        Grade grade = new Grade(enrollment, marksObtained, gradeLetter);
        gradeRecords.put(enrollment, grade);
    }

    /**
     * Fetches a grade by enrollment.
     */
    public Grade getGrade(Enrollment enrollment) {
        return gradeRecords.get(enrollment);
    }

    /**
     * Removes a grade record.
     */
    public boolean removeGrade(Enrollment enrollment) {
        if (gradeRecords.containsKey(enrollment)) {
            gradeRecords.remove(enrollment);
            return true;
        }
        return false;
    }

    /**
     * Fetches all grades recorded for a given student ID.
     */
    public List<Grade> getAllGradesForStudent(String studentId) {
        return gradeRecords.values()
                .stream()
                .filter(grade -> grade.getEnrollment().getStudent().getId().equals(studentId))
                .collect(Collectors.toList());
    }
}
