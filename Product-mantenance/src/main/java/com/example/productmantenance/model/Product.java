package com.example.productmantenance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity(name="product")
public class Product {
    @Id
    private String code;
    private String description;
    private double price;

    public Product() {
        code="";
        description="";
        price=0;
    }
}
