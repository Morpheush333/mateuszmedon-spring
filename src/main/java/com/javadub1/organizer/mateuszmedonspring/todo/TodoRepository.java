package com.javadub1.organizer.mateuszmedonspring.todo;

import com.javadub1.organizer.mateuszmedonspring.todo.entities.Todo;
import com.javadub1.organizer.mateuszmedonspring.todo.entities.TodoStatus;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface TodoRepository extends CrudRepository<Todo, Long> {
    List<Todo> findByStatus(TodoStatus status);

}
