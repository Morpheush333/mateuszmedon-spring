package com.javadub1.organizer.mateuszmedonspring.todo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo findById(Long id) {
        if(id == null || id <=0){
            throw new IllegalArgumentException(id + "is invalid");
        }
        return todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
    }

    public List<Todo> findAll(){
        return todoRepository.findAll();
    }

    public List<Todo> findByStatus(TodoStatus status) {
        return todoRepository.findByStatus(status);
    }
}
