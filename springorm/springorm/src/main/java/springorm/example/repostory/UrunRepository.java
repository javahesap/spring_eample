package springorm.example.repostory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import springorm.example.model.Category;
import springorm.example.model.Urun;

public interface  UrunRepository extends  CrudRepository<Urun,UUID> {

	@Query("select s from Urun s")
	List<Urun> findUrun();
	
	@Query("SELECT u FROM Urun u WHERE u.name LIKE 'Ürün 5%'")
    List<Urun> findUrunStartingWithFive();
	
	@Query("SELECT u FROM Urun u WHERE u.name LIKE :namePrefix%")
	List<Urun> findUrunByNamePrefix(@Param("namePrefix") String namePrefix);
	
	@Query("SELECT AVG(u.price) FROM Urun u")
	Double findAveragePrice();

	@Query("SELECT AVG(u.price) FROM Urun u WHERE u.category = :category")
	Double findAveragePriceByCategory(@Param("category") Category category);
	



	
	
	
}
