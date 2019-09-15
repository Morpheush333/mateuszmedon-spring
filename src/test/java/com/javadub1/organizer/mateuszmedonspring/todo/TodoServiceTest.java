package com.javadub1.organizer.mateuszmedonspring.todo;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;


public class TodoServiceTest {

    private InMemoryTodoRepository inMemoryTodoRepository;

    @Before
    public void init() {
        this.inMemoryTodoRepository = new InMemoryTodoRepository(Arrays.asList(
                new Todo(1L,"Hospital","Meeting physiuoterapy 22 Oct", TodoStatus.IN_PROGRES),
                new Todo(2L,"Birthday","7 April", TodoStatus.DONE),
                new Todo(3L,"Appointment work","Angelina's 16 Nov", TodoStatus.NEW),
                new Todo(4L,"Abracadabra","SSSSSS", TodoStatus.IN_PROGRES)
        ));

    }


    @Test(expected = IllegalArgumentException.class)
    public void findByID_ShouldThrowIllegalArgumentExceptionalWhenPassingNull(){
        //given
        Long id = null;

        //when
        inMemoryTodoRepository.findById(id);

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
        inMemoryTodoRepository.findById(id);
    }

    @Test
    public void findByID_ShouldReturnEmptyOptionalForNonExistingId() {
        //given
        Long id = 5L;

        //when
        Optional<Todo> actual = inMemoryTodoRepository.findById(id);

        //then
        Assert.assertFalse("Optional is not empty. User found", actual.isPresent());
    }

    @Test
    public void findByID_ShouldReturnEmptyOptionalWithExpectedUserForGivenId() {
        //given
        Long id = 3L;
        Todo expectedUser = new Todo(3L,"Appointment work","Angelina's 16 Nov", TodoStatus.NEW);

        //when
        Optional<Todo> actual = inMemoryTodoRepository.findById(id);

        //then
        Assert.assertTrue("Optional is empty. User not found", actual.isPresent());
        Assert.assertEquals("Found user is not the correct one", expectedUser, actual.get());
    }

//    ------------------------------------------------------------------------------------------------------

    @Test(expected = IllegalArgumentException.class)
    public void findByStatus_ShouldReturn(){
        //given
        TodoStatus status = TodoStatus.DONE;


        //when


        //then
        inMemoryTodoRepository.findByStatus(status);

    }
}
