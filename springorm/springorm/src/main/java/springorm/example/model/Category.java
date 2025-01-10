package springorm.example.model;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.UUID;





@Entity
public class Category {

    @Id
    private UUID id;
    private String name;

    @OneToMany(mappedBy = "category") // Urun entity'sinde category alanı olmalı
    private List<Urun> Uruns;

    // Varsayılan yapıcı (Hibernate için gerekli)
    public Category() {
    }

    // Parametreli yapıcı
    public Category(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter ve Setter'lar
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Urun> getUruns() {
        return Uruns;
    }

    public void setUruns(List<Urun> Uruns) {
        this.Uruns = Uruns;
    }
}

