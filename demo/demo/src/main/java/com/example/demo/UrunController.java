package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UrunController {

    // Ürünlerin listesini döndüren metod
    @GetMapping("/urunler")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = Arrays.asList(
                new Product(1, "Laptop", 1500.0),
                new Product(2, "Smartphone", 800.0),
                new Product(3, "Tablet", 600.0)
        );
        return ResponseEntity.ok(products); // 200 OK yanıtı ile ürünler döndürülür
    }

    // Belirli bir ürünü ID ile döndüren metod
    @GetMapping("/urun/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
        List<Product> products = Arrays.asList(
                new Product(1, "Laptop", 1500.0),
                new Product(2, "Smartphone", 800.0),
                new Product(3, "Tablet", 600.0)
        );

        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst()
                .map(product -> ResponseEntity.ok(product)) // 200 OK yanıtı
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND) // 404 NOT FOUND yanıtı
                        .body(null));
    }
}
