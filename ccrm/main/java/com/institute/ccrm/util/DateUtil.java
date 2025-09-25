package com.institute.ccrm.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Utility class for date conversions and formatting.
 */
public class DateUtil {
    
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    /**
     * Parses a date string into LocalDate using "yyyy-MM-dd" format.
     *
     * @param dateStr the date string
     * @return LocalDate object or null if parsing fails
     */
    public static LocalDate parseDate(String dateStr) {
        try {
            return LocalDate.parse(dateStr, DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            System.err.println("Invalid date format. Expected yyyy-MM-dd.");
            return null;
        }
    }
    
    /**
     * Formats a LocalDate to string in "yyyy-MM-dd" format.
     *
     * @param date LocalDate to format
     * @return formatted string or empty if date is null
     */
    public static String formatDate(LocalDate date) {
        return (date != null) ? date.format(DATE_FORMATTER) : "";
    }
}
