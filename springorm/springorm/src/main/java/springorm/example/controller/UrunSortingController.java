package springorm.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springorm.example.model.Urun;
import springorm.example.repostory.UrunRepository;
import springorm.example.repostory.UrunsortingRepository;

import java.util.List;

@RestController
public class UrunSortingController {

	@Autowired
	private UrunsortingRepository urunsortingRepository;

	// Sayfalama ve sıralama ile ürünleri listeleme
	@GetMapping("/urunlersort")
	public String getUrunlerWithPaginationAndSorting(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "name") String sortBy) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending()); // Sayfa numarası, sayfa boyutu ve
																						// sıralama
		Page<Urun> pageResult = urunsortingRepository.findAll(pageable); // Sayfalama ve sıralama işlemi

		int totalPages = pageResult.getTotalPages(); // Toplam sayfa sayısı
		long totalElements = pageResult.getTotalElements(); // Toplam eleman sayısı
		int currentPage = pageResult.getNumber(); // Mevcut sayfa
		List<Urun> urunler = pageResult.getContent(); // Sayfadaki ürünler
        
		StringBuilder builder = new StringBuilder();
		builder.append("Toplam Sayfa Sayısı: ").append(totalPages).append("\n");
		builder.append("Toplam Ürün Sayısı: ").append(totalElements).append("\n");
		builder.append("Mevcut Sayfa: ").append(currentPage).append("\n");

		for (Urun urun : urunler) {
			builder.append(urun.getName()).append("\n");
		}

		return builder.toString();
	}

	// Kategorisi ve fiyatı ile sayfalama yaparak ürünleri listeleme
	@GetMapping("/urunler/filtre")
	public List<Urun> getFilteredUrunlerWithPagination(@RequestParam String category, @RequestParam double minPrice,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size,
			@RequestParam(defaultValue = "name") String sortBy) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending()); // Sayfa numarası, sayfa boyutu ve
																						// sıralama
		Page<Urun> pageResult = urunsortingRepository.findByCategoryAndPriceGreaterThan(category, minPrice, pageable);

		return pageResult.getContent(); // Sayfa verilerini döndürür
	}
}
