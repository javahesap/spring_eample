package springorm.example.Initializer;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import springorm.example.model.Product;
import springorm.example.repostory.ProductRepository;

@Component
public class ProductInitializer {

    private final ProductRepository repository;

    public ProductInitializer(ProductRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void populateProducts() {
        for (int i = 1; i <= 100; i++) {
            Product product = new Product("Product " + i, Math.round(Math.random() * 1000) / 10.0);
            repository.save(product);
        }
        System.out.println("100 products have been initialized in the database!");
    }
}