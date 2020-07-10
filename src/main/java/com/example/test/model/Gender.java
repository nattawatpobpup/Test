package com.example.test.model;

import lombok.*;

import javax.persistence.*;
@Data
@Entity
@Getter @Setter
public class Gender {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gen_seq")
    private Long id;
    private String gender;
}
