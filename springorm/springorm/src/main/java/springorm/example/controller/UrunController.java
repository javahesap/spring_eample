package springorm.example.controller;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springorm.example.model.Category;
import springorm.example.model.Urun;
import springorm.example.repostory.CategoryRepository;
import springorm.example.repostory.UrunRepository;

@RestController
@RequestMapping("/urunler")
public class UrunController {

	private UrunRepository urunrepository;
	private UrunRepository urunRepositorysoting;
    private final CategoryRepository categoryRepository;

	public UrunController(UrunRepository urunrepository, CategoryRepository categoryRepository) {

		this.urunrepository = urunrepository;
		this.categoryRepository=categoryRepository;
	}

	@GetMapping
	public String list() {

		StringBuilder builder = new StringBuilder();
		for (Urun urun : urunrepository.findUrun()) {
			builder.append(urun.getName()).append("\n")
			.append(urun.getCategory().getId()).append("\n");


		}
		return builder.toString();
	}

	@GetMapping("/like")
	public String listUrunStartingWithFive() {
		StringBuilder builder = new StringBuilder();

		// "Ürün 5" ile başlayanları alıyoruz
		for (Urun urun : urunrepository.findUrunStartingWithFive()) {
			builder.append(urun.getName()).append("\n");
		}

		return builder.toString();
	}
	//http://localhost:8080/urunler/urunler/4
	@GetMapping("/urunler/{prefix}")
	public String listUrunByPrefix(@PathVariable String prefix) {
	    StringBuilder builder = new StringBuilder();
	    
	    // "prefix" parametresine göre sorgu çalıştırılıyor
	    for (Urun urun : urunrepository.findUrunByNamePrefix("Ürün " + prefix)) {
	        builder.append(urun.getName()).append("\n");
	    }
	    
	    return builder.toString();
	}
	
	
	@GetMapping("/ortalama-fiyat")
	public String getAveragePrice() {
	    Double averagePrice = urunrepository.findAveragePrice();
	    return "Ortalama Fiyat: " + (averagePrice != null ? averagePrice : "Hesaplanamadı");
	}
	
	
	@GetMapping("/urunler/ortalama-fiyat/{categoryName}")
	public String getAveragePriceByCategory(@PathVariable String categoryName) {
	    // Find the category by name
	    Optional<Category> categoryOpt = categoryRepository.findByName(categoryName);

	    if (categoryOpt.isEmpty()) {
	        return "Kategori bulunamadı.";
	    }

	    Category category = categoryOpt.get();
	    Double averagePrice = urunrepository.findAveragePriceByCategory(category);
	    return "Kategori: " + categoryName + " için Ortalama Fiyat: " + 
	           (averagePrice != null ? averagePrice : "Hesaplanamadı");
	}
	
	
	
	

	


}
