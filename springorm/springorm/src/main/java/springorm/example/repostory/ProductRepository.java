package springorm.example.repostory;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import springorm.example.model.Product;

 public interface ProductRepository extends JpaRepository<Product, UUID> {
	
	
	
	
}
