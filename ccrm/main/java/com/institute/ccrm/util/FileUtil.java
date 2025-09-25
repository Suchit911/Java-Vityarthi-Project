package com.institute.ccrm.util;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class for file operations such as backup and archive.
 */
public class FileUtil {
    
    private static final DateTimeFormatter TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    
    /**
     * Creates a timestamped backup folder within the specified base directory.
     * 
     * @param baseDir the base directory for backup
     * @return Path of the created backup folder
     * @throws IOException if an I/O error occurs
     */
    public static Path createBackupFolder(String baseDir) throws IOException {
        String timestamp = LocalDateTime.now().format(TIMESTAMP_FORMATTER);
        Path backupDir = Paths.get(baseDir, "backup_" + timestamp);
        if (!Files.exists(backupDir)) {
            Files.createDirectories(backupDir);
        }
        return backupDir;
    }
    
    /**
     * Recursively copies contents of source directory to target directory.
     *
     * @param sourceDir  source directory path
     * @param targetDir  target directory path
     * @throws IOException in case of I/O errors
     */
    public static void copyDirectoryRecursive(Path sourceDir, Path targetDir) throws IOException {
        if (!Files.exists(sourceDir) || !Files.isDirectory(sourceDir)) {
            throw new IllegalArgumentException("Source must be an existing directory");
        }
        
        Files.walk(sourceDir)
             .forEach(source -> {
                 try {
                     Path destination = targetDir.resolve(sourceDir.relativize(source));
                     if (Files.isDirectory(source)) {
                         if (!Files.exists(destination)) {
                             Files.createDirectories(destination);
                         }
                     } else {
                         Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
                     }
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             });
    }
}
