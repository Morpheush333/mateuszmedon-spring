package com.javadub1.organizer.mateuszmedonspring.todo;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


public class TodoServiceTest {

    private TodoService todoService;

    @Before
    public void init() {

        this.todoService = new TodoService(new InMemoryTodoRepository(Arrays.asList(
                new Todo(1L,"Hospital","Meeting physiuoterapy 22 Oct", TodoStatus.IN_PROGRES),
                new Todo(2L,"Birthday","7 April", TodoStatus.DONE),
                new Todo(3L,"Appointment work","Angelina's 16 Nov", TodoStatus.NEW),
                new Todo(4L,"Abracadabra","SSSSSS", TodoStatus.IN_PROGRES)

        )));

    }


    @Test(expected = IllegalArgumentException.class)
    public void findByID_ShouldThrowIllegalArgumentExceptionalWhenPassingNull(){
        //given
        Long id = null;

        //when
        todoService.findById(id);

//        then
//        exception it thrown

    }

    @Test(expected = IllegalArgumentException.class)
    public void findByID_ShouldThrowIllegalArgumentExceptionalWhenPassingNegativeValue(){
        //given
        Long id = -1L;

        //when
        // definition in annotation test

        //then
        todoService.findById(id);
    }

    @Test(expected = TodoNotFoundException.class)
    public void findByID_ShouldReturnEmptyOptionalForNonExistingId() {
        //given
        Long id = 5L;

        //when
        Todo actual = todoService.findById(id);

    }

    @Test
    public void findByID_ShouldReturnEmptyOptionalWithExpectedUserForGivenId() {
        //given
        Long id = 3L;
        Todo expectedUser = new Todo(3L,"Appointment work","Angelina's 16 Nov", TodoStatus.NEW);

        //when
        Todo actual = todoService.findById(id);

        //then
        Assert.assertEquals("Found user is not the correct one", expectedUser, actual);
    }

//    ------------------------------------------------------------------------------------------------------

    @Test
    public void findByStatus_ShouldReturnListOfTodoForGivenStatus(){
        //given
        TodoStatus status = TodoStatus.NEW;
        Todo expected =  new Todo(3L,"Appointment work","Angelina's 16 Nov", TodoStatus.NEW);


        //when
        List<Todo> actual = todoService.findByStatus(status);

        //then
        Assert.assertEquals("List should have exactly one todo", 1,actual.size());
        Assert.assertEquals("Todo should be equal the expected one", expected, actual.get(0));

    }
}
