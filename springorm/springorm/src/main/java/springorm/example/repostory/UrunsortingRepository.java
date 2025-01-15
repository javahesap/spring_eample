package springorm.example.repostory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import springorm.example.model.Urun;
import java.util.UUID;

public interface UrunsortingRepository extends PagingAndSortingRepository<Urun, UUID> {

    // Sayfalama ve sıralama ile tüm ürünleri listeleme
    Page<Urun> findAll(Pageable pageable);

    // Kategorisi ve fiyatı ile sayfalama ve sıralama
    Page<Urun> findByCategoryAndPriceGreaterThan(String category, Double minPrice, Pageable pageable);
}
