package com.ibrahim.tiket.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibrahim.tiket.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
