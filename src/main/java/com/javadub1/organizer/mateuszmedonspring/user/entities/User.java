package com.javadub1.organizer.mateuszmedonspring.user.entities;

import com.javadub1.organizer.mateuszmedonspring.user.entities.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Gender gender;

    @ManyToMany
    private List<Address> address;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
