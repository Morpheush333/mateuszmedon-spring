package com.javadub1.organizer.mateuszmedonspring.user;

import com.javadub1.organizer.mateuszmedonspring.user.entities.Gender;
import com.javadub1.organizer.mateuszmedonspring.user.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JpaUserRepository extends CrudRepository<User, Long> {
    List<User> findByGender(Gender gender);

}
