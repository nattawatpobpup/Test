package com.example.test.repository;

import com.example.test.model.StatusCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StatusCarRepository extends JpaRepository<StatusCar, Long> {
    StatusCar findById(long id);
}
