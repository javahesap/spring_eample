package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

    // Ürünlerin listesini döndüren metod
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return Arrays.asList(
                new Product(1, "Laptop", 1500.0),
                new Product(2, "Smartphone", 800.0),
                new Product(3, "Tablet", 600.0)
        );
    }

    // Belirli bir ürünü ID ile döndüren metod
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable long id) {
        return new Product(id, "Sample Product", 100.0); // Burada örnek ürün döndürüyoruz
    }
}
