package springorm.example.repostory;

import org.springframework.data.jpa.repository.JpaRepository;
import springorm.example.model.Category;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}