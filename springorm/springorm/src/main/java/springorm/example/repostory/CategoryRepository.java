package springorm.example.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import springorm.example.model.Category;
import springorm.example.model.Urun;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
	
	@Query("SELECT c FROM Category c WHERE c.name = :name")
    Optional<Category> findByName(String name);
}