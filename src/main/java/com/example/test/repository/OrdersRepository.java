package com.example.test.repository;

import com.example.test.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    Orders findById(long id);
}
