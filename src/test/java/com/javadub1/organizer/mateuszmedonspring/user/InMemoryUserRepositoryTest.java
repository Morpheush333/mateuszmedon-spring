package com.javadub1.organizer.mateuszmedonspring.user;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.Assert.*;

public class InMemoryUserReposytoryTest {
    private InMemoryUserReposytory inMemoryUserReposytory;

    @Before
    public void init() {
        this.inMemoryUserReposytory = new InMemoryUserReposytory(Arrays.asList(
                new User(1L,"Szymon","Nowak", Gender.MALE),
                new User(2L,"Lord","Voldemort", Gender.MALE),
                new User(3L,"Wife Bilbo", "Baggins'a", Gender.FEMALE)
        ));
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByID_ShouldThrowIllegalArgumentExceptionalWhenPassingNull(){
        //given
        Long id = null;

        //when
        // definition in annotation test

        //then
        inMemoryUserReposytory.findById(id);

    }

    @Test(expected = IllegalArgumentException.class)
    public void findByID_ShouldThrowIllegalArgumentExceptionalWhenPassingNegativeValue(){
        //given
        Long id = -1L;

        //when
        // definition in annotation test

        //then
        inMemoryUserReposytory.findById(id);
    }

    @Test
    public void findByID_ShouldReturnEmptyOptionalForNonExistingId() {
        //given
        Long id = 5L;

        //when
        Optional<User> actual = inMemoryUserReposytory.findById(id);

        //then
        Assert.assertFalse("Optional is not empty. User found", actual.isPresent());
    }

    @Test
    public void findByID_ShouldReturnEmptyOptionalWithExpectedUserForGivenId() {
        //given
        Long id = 3L;
        User expectedUser = new User(3L,"Wife Bilbo", "Baggins'a", Gender.FEMALE);

        //when
        Optional<User> actual = inMemoryUserReposytory.findById(id);

        //then
        Assert.assertTrue("Optional is empty. User not found", actual.isPresent());
        Assert.assertEquals("Found user is notr the correct one", expectedUser, actual.get());


    }

}