package springorm.example;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

 public interface ProductRepository extends JpaRepository<Product, UUID> {
	
	
	
	
}
