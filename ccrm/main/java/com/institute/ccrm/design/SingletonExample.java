package com.institute.ccrm.design;

/**
 * Example demonstrating the Singleton design pattern.
 */
public class SingletonExample {
    
    private static SingletonExample instance;
    
    // Private constructor to prevent instantiation
    private SingletonExample() {
        // Initialization code here
    }
    
    /**
     * Returns the single instance of this class, creating it if necessary.
     */
    public static synchronized SingletonExample getInstance() {
        if (instance == null) {
            instance = new SingletonExample();
        }
        return instance;
    }
    
    /**
     * Example business method.
     */
    public void doSomething() {
        System.out.println("Singleton instance is working.");
    }
}
