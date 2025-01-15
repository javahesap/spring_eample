package springorm.example.controller;


import org.springframework.web.bind.annotation.*;
import springorm.example.model.Category;
import springorm.example.model.Urun;
import springorm.example.repostory.CategoryRepository;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        category.setId(UUID.randomUUID());  // UUID'yi elle ayarlayabilirsiniz
        return categoryRepository.save(category);
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable UUID id) {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }
    
    @GetMapping("/{id}/products")
    public List<Urun> getProductsByCategory(@PathVariable UUID id) {
        Category category = categoryRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Category not found"));
        return category.getUruns(); // Kategoriye bağlı ürünlerin listesi
    }

    
}
