package springorm.example.controller;

import java.util.Iterator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springorm.example.model.Urun;
import springorm.example.repostory.UrunRepository;

@RestController
@RequestMapping("/urunler")
public class UrunController {
	
	private  UrunRepository urunrepository;

	public UrunController(UrunRepository urunrepository) {

		this.urunrepository = urunrepository;
	}
    @GetMapping
	public String list() {
		
		StringBuilder builder =new  StringBuilder();
		for (Urun urun : urunrepository.findUrun()) {
	      builder.append(urun.getId()).append("\n");
			
		}
		return builder.toString();
	}

}
