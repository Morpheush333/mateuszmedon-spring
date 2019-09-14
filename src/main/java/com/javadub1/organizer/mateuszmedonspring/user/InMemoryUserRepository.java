package com.javadub1.organizer.mateuszmedonspring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryUserRepository implements UserRepository {

    private List<User> users;
    private RepositoryHelper repositoryHelper;

    @Autowired
    public InMemoryUserRepository(RepositoryHelper repositoryHelper) {
        this.users = new ArrayList<>();
        this.repositoryHelper = repositoryHelper;
    }

    InMemoryUserRepository(List<User> users) {
        this.users = users;
    }

    @Override
    public Optional<User> findById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException();
        }

        return users.stream()
                .filter(user -> id.equals(user.getId()))
                .findFirst();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @PostConstruct
    public void init() {
        this.users.add(new User(1L, "Szymon", "Nowak", Gender.MALE));
        this.users.add(new User(2L, "Mateusz", "Medon", Gender.MALE));
        this.users.add(new User(3L, "Barbara", "Medon", Gender.FEMALE));
        this.users.add(new User(4L, "Piotr", "Kowalik", Gender.LGBT));
    }
}
