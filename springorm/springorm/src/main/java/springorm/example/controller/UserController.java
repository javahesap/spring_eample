package springorm.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import springorm.example.model.User;
import springorm.example.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Tüm kullanıcıları getir
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // Yeni kullanıcı ekle (Denemek için ekledik ama veri eklenemeyecek)
    @PostMapping
    public String addUser(@RequestBody User user) {
        // Bu işlem immutable liste nedeniyle başarısız olur.
        try {
            List<User> users = userService.getAllUsers();
            users.add(user); // Bu adımda hata oluşur
            return "Kullanıcı eklendi.";
        } catch (UnsupportedOperationException e) {
            return "Kullanıcı eklenemiyor: Liste değiştirilemez.";
        }
    }
}

