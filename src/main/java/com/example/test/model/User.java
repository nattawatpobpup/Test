package com.example.test.model;
import lombok.*;

import javax.persistence.*;
@Data
@Entity
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_seq")
    private Long id;
    private String name;
    private int age;
    private String passport;
    @ManyToOne
    private Gender gender;
}
