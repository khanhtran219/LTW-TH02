package com.example.productmantenance;

import com.example.productmantenance.model.Product;
import com.example.productmantenance.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class Dbinit implements CommandLineRunner {
    private ProductRepository productRepository;

    public Dbinit(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.productRepository.deleteAll();
        Product product1 = new Product("khanh","86 (the band) - True Life Songs and Pictures",14.95);
        Product product2 = new Product("pf01","Paddlefoot - The first CD",12.95);
        Product product3 = new Product("pf02","Paddlefoot - The Paddlefoot - The first CDsecond CD",14.95);
        Product product4 = new Product("jr01","Joe Rut - Genuine Wood Grained Finish",14.95);
        List<Product> products = Arrays.asList(product1, product2, product3);
        productRepository.saveAll(products);
    // hello
    }
}
