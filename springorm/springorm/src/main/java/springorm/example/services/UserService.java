package springorm.example.services;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import springorm.example.model.Address;
import springorm.example.model.User;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();

    // Başlangıçta kullanıcıları eklemek için
    @PostConstruct
    public void init() {
        User user1 = new User();
        user1.setId(1);
        user1.setName("John Doe");
        user1.setPassword("password123");

        Address address1 = new Address();
        address1.setId(101);
        address1.setCity("New York");
        address1.setUser(user1);

        Address address2 = new Address();
        address2.setId(102);
        address2.setCity("Los Angeles");
        address2.setUser(user1);

        List<Address> addresses1 = new ArrayList<>();
        addresses1.add(address1);
        addresses1.add(address2);

        user1.setAddresses(addresses1);

        // Kullanıcıyı listeye ekle
        users.add(user1);

        // Listeyi değiştirilemez hale getir
        users = Collections.unmodifiableList(users);
    }

    // Kullanıcıları döndür
    public List<User> getAllUsers() {
        return users;
    }
}

