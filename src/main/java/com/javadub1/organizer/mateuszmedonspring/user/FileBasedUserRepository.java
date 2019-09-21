package com.javadub1.organizer.mateuszmedonspring.user;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Profile("!prod")
@Repository
public class FileBasedUserRepository implements UserRepository {

    private RepositoryHelper repositoryHelper;

    public FileBasedUserRepository(RepositoryHelper repositoryHelper) {
        this.repositoryHelper = repositoryHelper;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>();
    }

    @Override
    public List<User> findByGender(Gender gender) {
        return null;
    }

    @Override
    public void save(User user) {

    }
}
