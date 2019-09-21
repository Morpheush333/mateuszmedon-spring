package com.javadub1.organizer.mateuszmedonspring.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemoryUserRepository implements UserRepository {

    private List<User> users;
    private RepositoryHelper repositoryHelper;
    private int nextId;

    @Autowired
    public InMemoryUserRepository(RepositoryHelper repositoryHelper) {
        this.users = new ArrayList<>();
        this.repositoryHelper = repositoryHelper;
        this.nextId = 1;
    }

//    constructor protected for tests
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

    @Override
    public List<User> findByGender(Gender gender) {
        return users.stream()
                .filter(user -> gender.equals(user.getGender()))
                .collect(Collectors.toList());
    }

    @Override
    public void save(User user) {
        user.setId((long) nextId++);
        users.add(user);
    }

    @PostConstruct
    public void init() {
        if (this.users.size() == 0) {
            save(new User(1L, "Szymon", "Nowak", Gender.MALE));
            save(new User(2L, "Mateusz", "Medon", Gender.MALE));
            save(new User(3L, "Barbara", "Medon", Gender.FEMALE));
            save(new User(4L, "Piotr", "Kowalik", Gender.LGBT));
        }
    }
}
