package com.javadub1.organizer.mateuszmedonspring.todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    private Long id;
    private String name;
    private String description;
    private TodoStatus status;



}
