package com.javadub1.organizer.mateuszmedonspring.user;

import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class InMemoryUserReposytory implements UserReposytory {

    private List<User> users;

    public InMemoryUserReposytory() {
        this.users = new ArrayList<>();
    }

    InMemoryUserReposytory(List<User> users) {
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

    private void init() {
        this.users.add(new User(1L, "Szymon", "Nowak", Gender.MALE));
        this.users.add(new User(2L, "Mateusz", "Medon", Gender.MALE));
        this.users.add(new User(3L, "Barbara", "Medon", Gender.FEMALE));
        this.users.add(new User(4L, "Piotr", "Kowalik", Gender.LGBT));
    }
}
