package com.javadub1.organizer.mateuszmedonspring.todo.exceptions;

public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException(Long id) {
        super("Todo with id " + id + " not found");
    }
}
