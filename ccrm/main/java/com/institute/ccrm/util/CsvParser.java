package com.institute.ccrm.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for parsing CSV files with simple comma-separated values.
 */
public class CsvParser {
    
    /**
     * Reads CSV file and returns list of string arrays representing each row.
     *
     * @param csvFilePath path to the CSV file
     * @return List of String arrays where each array is a row split by comma
     * @throws IOException if reading file fails
     */
    public static List<String[]> parseCsvFile(Path csvFilePath) throws IOException {
        List<String[]> records = new ArrayList<>();
        
        try (BufferedReader reader = Files.newBufferedReader(csvFilePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Basic CSV parsing by splitting on commas; more complex CSV cases may require better parsing
                String[] tokens = line.split(",");
                records.add(tokens);
            }
        }
        
        return records;
    }
}
