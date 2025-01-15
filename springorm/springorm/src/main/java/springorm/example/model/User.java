package springorm.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;

// Kullanıcı sınıfı
public class User {
    private int id;
    private String name;

    @JsonIgnore // Parola JSON'a dahil edilmez
    private String password;

    @JsonManagedReference // İlişkinin JSON'da yer almasını sağlayan taraf
    private List<Address> addresses;

    // Getter ve Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public List<Address> getAddresses() { return addresses; }
    public void setAddresses(List<Address> addresses) { this.addresses = addresses; }
}


