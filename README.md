# Campus Course Records Manager (CCRM)

## Description
A Java console application for managing campus academic records including students, courses, enrollments, grades, and transcripts. Implements object-oriented design, file import/export, and advanced Java features.

## Features
- Add, update, list, and deactivate students and courses
- Enroll and unenroll students in courses with validation
- Record grades and compute GPA on transcripts
- Modular design with services and models
- File operations using Java NIO (import/export, backup)
- Custom exceptions and robust error handling
- CLI menu-driven interface for ease of use

## Project Structure

ccrm/                        # Root source folder for Java code
 ├── main/                   # Main application and entry point
 │    └── java/
 │        └── com/
 │            └── institute/
 │                └── ccrm/
 │                    ├── app/
 │                    │    └── CCRMApp.java           # Main class for CLI app launch
 │                    ├── model/                       # Domain models
 │                    │    ├── Student.java
 │                    │    ├── Course.java
 │                    │    ├── Enrollment.java
 │                    │    ├── Grade.java
 │                    │    └── Transcript.java
 │                    ├── service/                     # Business logic & operations
 │                    │    ├── StudentService.java
 │                    │    ├── CourseService.java
 │                    │    ├── EnrollmentService.java
 │                    │    └── TranscriptService.java
 │                    ├── util/                        # Utility classes like CSV/File IO, validation
 │                    │    ├── FileUtil.java
 │                    │    ├── CsvParser.java
 │                    │    └── DateUtil.java
 │                    ├── exceptions/                  # Custom exception classes
 │                    │    └── CCRMException.java
 │                    ├── design/                      # Patterns like Singleton, Builder
 │                    │    ├── SingletonExample.java
 │                    │    └── BuilderExample.java
 │                    └── constants/                   # Constants and Enums
 │                         ├── GradeScale.java
 │                         └── Status.java



## Prerequisites
- Java Development Kit (JDK) 11 or higher installed

## Running the Project

1. Navigate to the project Java source root folder:
cd path\to\project\ccrm\main\java

text

2. Compile all Java source files:
Get-ChildItem -Path .\com\institute\ccrm -Recurse -Filter *.java | ForEach-Object { javac $_.FullName }

text

3. Run the main CLI application:
java com.institute.ccrm.app.CCRMApp
