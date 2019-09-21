package com.javadub1.organizer.mateuszmedonspring.user.exceptions;

public class InvalidParameterException extends RuntimeException {
    public InvalidParameterException(String parameter) {
        super("Invalid value of parameter: " + parameter);
    }
}
