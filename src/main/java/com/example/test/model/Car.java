package com.example.test.model;

import lombok.*;

import javax.persistence.*;
@Data
@Entity
@Getter @Setter
public class Car {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="car_seq")
    private Long id;
    private String carName;
    private String carId;
    @ManyToOne
    private StatusCar statusCar;
}
