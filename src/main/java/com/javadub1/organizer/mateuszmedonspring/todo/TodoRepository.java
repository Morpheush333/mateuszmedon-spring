package com.javadub1.organizer.mateuszmedonspring.todo;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {

    List<Todo> findAll();
    Optional<Todo> findById(Long id);
    List<Todo>findByStatus(TodoStatus status);
}
