package com.javadub1.organizer.mateuszmedonspring.todo;

import com.javadub1.organizer.mateuszmedonspring.todo.entities.Todo;
import com.javadub1.organizer.mateuszmedonspring.todo.entities.TodoStatus;
import com.javadub1.organizer.mateuszmedonspring.todo.exceptions.TodoNotFoundException;
import com.javadub1.organizer.mateuszmedonspring.user.entities.Gender;
import com.javadub1.organizer.mateuszmedonspring.user.entities.User;
import com.javadub1.organizer.mateuszmedonspring.user.exceptions.InvalidParameterException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo findById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException(id + "is invalid");
        }
        return todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
    }

    public Iterable<Todo> findAll() {
        return todoRepository.findAll();
    }

    public List<Todo> findByStatus(String gender) {
        try {
            TodoStatus enumGender = TodoStatus.valueOf(gender);
            return todoRepository.findByStatus(enumGender);
        } catch (IllegalArgumentException e) {
            throw new InvalidParameterException("gender");
        }
    }


        public void saveTodo (Todo todo){
            todoRepository.save(todo);
        }


    }

