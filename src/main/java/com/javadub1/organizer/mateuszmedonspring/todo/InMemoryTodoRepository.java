package com.javadub1.organizer.mateuszmedonspring.todo;

import jdk.nashorn.internal.ir.Optimistic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemoryTodoRepository implements TodoRepository {

    private List<Todo> todoList;

    InMemoryTodoRepository(List<Todo> todoList) {
        this.todoList = todoList;
    }
    @Autowired
    public InMemoryTodoRepository() {
    }

    @Override
    public List<Todo> findAll() {
        return new ArrayList<>();
    }

    @Override
    public Optional<Todo> findById(Long id) {
        if(id == null || id <= 0){
            throw new IllegalArgumentException();
        }
        return todoList.stream()
                .filter(todo -> id.equals(todo.getId()))
                .findAny();
    }

    @Override
    public List<Todo> findByStatus(TodoStatus status) {
        if(status == null){
            throw new IllegalArgumentException();
        }
        return todoList.stream()
                .filter(todo -> status.equals(todo.getStatus()))
                .collect(Collectors.toList());
    }

    @PostConstruct
    public void init() {
        this.todoList.add(new Todo(1L,"Hospital","Meeting physiuoterapy 22 Oct", TodoStatus.IN_PROGRES));
        this.todoList.add(new Todo(2L,"Birthday","7 April", TodoStatus.DONE));
        this.todoList.add(new Todo(3L,"Appointment work","Angelina's 16 Nov", TodoStatus.NEW));
        this.todoList.add(new Todo(4L,"Abracadabra","SSSSSS", TodoStatus.IN_PROGRES));
    }
}
