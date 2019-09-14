package com.javadub1.organizer.mateuszmedonspring.user;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FileBasedUserRepository implements UserRepository {

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>();
    }
}
