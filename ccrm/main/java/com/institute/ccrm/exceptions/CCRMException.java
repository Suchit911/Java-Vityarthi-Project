package com.institute.ccrm.exceptions;

/**
 * Custom exception class for Campus Course Records Manager-related exceptions.
 */
public class CCRMException extends Exception {
    
    public CCRMException() {
        super();
    }
    
    public CCRMException(String message) {
        super(message);
    }
    
    public CCRMException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public CCRMException(Throwable cause) {
        super(cause);
    }
}
