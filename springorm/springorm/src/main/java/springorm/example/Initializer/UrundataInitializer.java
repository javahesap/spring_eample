package springorm.example.Initializer;
import org.springframework.boot.CommandLineRunner;
import springorm.example.model.Category;
import springorm.example.model.Urun;
import springorm.example.repostory.CategoryRepository;
import springorm.example.repostory.UrunRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.StreamSupport;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UrundataInitializer {

    @Bean
    public CommandLineRunner initDatabase(CategoryRepository categoryRepository, UrunRepository urunRepository) {
        return args -> {
            // Kategoriler oluşturuluyor
            List<Category> categories = List.of(
                new Category(UUID.randomUUID(), "Elektronik"),
                new Category(UUID.randomUUID(), "Kitap"),
                new Category(UUID.randomUUID(), "Giyim"),
                new Category(UUID.randomUUID(), "Ev & Yaşam")
            );

            // Kategorileri veritabanına kaydet (Her durumda eklenebilir)
            categoryRepository.saveAll(categories);

            // Ürünler veritabanında var mı diye kontrol et
            List<Urun> urunlercontrol = StreamSupport.stream(urunRepository.findAll().spliterator(), false).toList();

            // Eğer ürünler veritabanında yoksa, yeni ürünler eklenir
            if (urunlercontrol.isEmpty()) {
                // Ürünler oluşturuluyor
                List<Urun> urunler = new ArrayList<>();
                for (int i = 0; i < 100; i++) {
                    Urun urun = new Urun();
                    urun.setId(UUID.randomUUID());
                    urun.setName("Ürün " + (i + 1));
                    urun.setPrice(Math.random() * 100);
                    urun.setCategory(categories.get(i % categories.size())); // Kategoriler rastgele atanıyor
                    urunler.add(urun);
                }

                // Ürünleri veritabanına kaydet
                urunRepository.saveAll(urunler);
            }
        };
    }
}


