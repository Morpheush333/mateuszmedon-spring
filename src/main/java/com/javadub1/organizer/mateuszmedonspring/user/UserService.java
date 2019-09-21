package com.javadub1.organizer.mateuszmedonspring.user;


import com.javadub1.organizer.mateuszmedonspring.user.exceptions.InvalidParameterException;
import com.javadub1.organizer.mateuszmedonspring.user.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private JpaUserRepository jpaUserRepository;

    public UserService(JpaUserRepository jpaUserRepository) {
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
            return jpaUserRepository.findByGender(enumGender);
        }catch (IllegalArgumentException e) {
            throw new InvalidParameterException("gender");
        }
    }

    public void saveUser(User user) {
        jpaUserRepository.save(user);
    }
}
