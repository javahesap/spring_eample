package springorm.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

//Adres sınıfı
public class Address {
 private int id;
 private String city;

 @JsonBackReference // Döngüyü önlemek için JSON'da yer almayacak taraf
 private User user;

 // Getter ve Setter
 public int getId() { return id; }
 public void setId(int id) { this.id = id; }

 public String getCity() { return city; }
 public void setCity(String city) { this.city = city; }

 public User getUser() { return user; }
 public void setUser(User user) { this.user = user; }
}