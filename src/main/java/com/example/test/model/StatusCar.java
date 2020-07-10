package com.example.test.model;

import lombok.*;

import javax.persistence.*;
@Data
@Entity
@Getter @Setter
public class StatusCar {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gender_seq")
    private Long id;
    private String status;


}
