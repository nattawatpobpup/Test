package com.example.test.repository;

import com.example.test.model.Car;
import com.example.test.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CarRepository extends JpaRepository<Car, Long> {
    Car findById(long id);

}
