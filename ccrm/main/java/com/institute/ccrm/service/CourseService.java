package com.institute.ccrm.service;

import com.institute.ccrm.model.Course;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Service class to manage course-related operations.
 */
public class CourseService {

    private final Map<String, Course> courseMap;

    public CourseService() {
        this.courseMap = new HashMap<>();
    }

    /**
     * Adds a new course.
     */
    public boolean addCourse(String courseCode, String courseName, String instructor, int credits) {
        if (courseMap.containsKey(courseCode)) {
            return false; // course existing
        }
        Course course = new Course(courseCode, courseName, instructor, credits);
        courseMap.put(courseCode, course);
        return true;
    }

    /**
     * Gets a course by course code.
     */
    public Course getCourseByCode(String courseCode) {
        return courseMap.get(courseCode);
    }

    /**
     * Updates course details.
     */
    public boolean updateCourse(String courseCode, String newName, String newInstructor, Integer newCredits) {
        Course course = courseMap.get(courseCode);
        if (course == null || !course.isActive()) {
            return false;
        }
        if (newName != null && !newName.isEmpty()) {
            course.setCourseName(newName);
        }
        if (newInstructor != null && !newInstructor.isEmpty()) {
            course.setInstructor(newInstructor);
        }
        if (newCredits != null && newCredits > 0) {
            course.setCredits(newCredits);
        }
        return true;
    }

    /**
     * Deactivates a course.
     */
    public boolean deactivateCourse(String courseCode) {
        Course course = courseMap.get(courseCode);
        if (course != null && course.isActive()) {
            course.deactivate();
            return true;
        }
        return false;
    }

    /**
     * Lists all active courses.
     */
    public List<Course> listActiveCourses() {
        return courseMap.values()
                .stream()
                .filter(Course::isActive)
                .sorted(Comparator.comparing(Course::getCourseCode))
                .collect(Collectors.toList());
    }
}
