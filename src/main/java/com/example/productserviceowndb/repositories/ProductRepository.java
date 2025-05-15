package com.example.productserviceowndb.repositories;

import com.example.productserviceowndb.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findFirstByName(String name);

}
