package com.example.productmantenance.repository;

import com.example.productmantenance.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product,String> {
    Product findByCode(String code);
}
