package springorm.example.repostory;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import springorm.example.model.Urun;

public interface  UrunRepository extends  CrudRepository<Urun,UUID> {

	@Query("select s from Urun s")
	List<Urun> findUrun();
	
}
