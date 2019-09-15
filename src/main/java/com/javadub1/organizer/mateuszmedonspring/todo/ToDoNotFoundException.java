package com.javadub1.organizer.mateuszmedonspring.todo;

public class ToDoNotFoundException extends RuntimeException {
    public ToDoNotFoundException(Long id) {
        super("Todo with id " + id + " not found");
    }
}
