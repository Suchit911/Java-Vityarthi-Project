package com.institute.ccrm.service;

import com.institute.ccrm.model.Grade;
import com.institute.ccrm.model.Student;
import com.institute.ccrm.model.Transcript;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class to manage transcript-related functionalities.
 */
public class TranscriptService {
    
    private final List<Transcript> transcripts;
    
    public TranscriptService() {
        this.transcripts = new ArrayList<>();
    }
    
    /**
     * Creates and stores a new transcript for a student with given grades.
     */
    public Transcript createTranscript(Student student, List<Grade> grades) {
        Transcript transcript = new Transcript(student, grades);
        transcripts.add(transcript);
        return transcript;
    }
    
    /**
     * Retrieves transcript(s) of a particular student.
     */
    public List<Transcript> getTranscriptsByStudent(String studentId) {
        return transcripts.stream()
                .filter(t -> t.getStudent().getId().equals(studentId))
                .collect(Collectors.toList());
    }
    
    // Additional helper methods can be added for updating, deleting or printing transcripts
}
