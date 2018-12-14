package com.ibrahim.tiket.controller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ibrahim.tiket.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
