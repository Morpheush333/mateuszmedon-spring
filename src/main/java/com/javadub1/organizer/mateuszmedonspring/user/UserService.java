package com.javadub1.organizer.mateuszmedonspring.user;


import com.javadub1.organizer.mateuszmedonspring.user.exceptions.InvalidParameterException;
import com.javadub1.organizer.mateuszmedonspring.user.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;
    private JpaUserRepository jpaUserRepository;

    public UserService(@Qualifier("inMemoryUserRepository") UserRepository userRepository,JpaUserRepository jpaUserRepository) {
        this.userRepository = userRepository;
        this.jpaUserRepository = jpaUserRepository;
    }

    public User findById(Long id) {
        return jpaUserRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public Iterable<User> findAll() {
        return jpaUserRepository.findAll();
    }

    public List<User> findByGender(String gender){
        try {
            Gender enumGender = Gender.valueOf(gender);
            return userRepository.findByGender(enumGender);
        }catch (IllegalArgumentException e) {
            throw new InvalidParameterException("gender");
        }
    }

    public void saveUser(User user) {
        jpaUserRepository.save(user);
    }
}
