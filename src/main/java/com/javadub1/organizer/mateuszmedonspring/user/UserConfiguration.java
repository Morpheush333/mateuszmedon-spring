package com.javadub1.organizer.mateuszmedonspring.user;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class UserConfiguration {

    @Bean
    public UserRepository preInitializedInMemoryUserRepository() {
        return new InMemoryUserRepository(Arrays.asList(
                new User(1L,"Mariusz", "Golonko", Gender.LGBT)
        ));
    }
}
