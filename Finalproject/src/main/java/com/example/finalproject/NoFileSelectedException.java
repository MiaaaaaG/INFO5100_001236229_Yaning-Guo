package com.example.finalproject;

// use of inheritance: create a custom exception class "NoFileSelectedException" that extends the built-in "Exception" class
public class NoFileSelectedException extends Exception {
    public NoFileSelectedException(String message) {
        super(message);
    }
}
