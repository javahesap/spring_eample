package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
public class CookieController {

    // Çerez oluşturma
    @GetMapping("/set-cookie")
    public ResponseEntity<String> setCookie(HttpServletResponse response) {
        try {
            Cookie cookie = new Cookie("user-token", "12345");
            cookie.setHttpOnly(true);  // XSS koruması
            cookie.setSecure(true);   // HTTPS kullanıyorsanız true
            cookie.setPath("/");      // Tüm URL'ler için geçerli
            cookie.setMaxAge(3600);   // 1 saatlik süre (3600 saniye)
            response.addCookie(cookie);

            // SameSite özelliğini ekleyin
            response.addHeader("Set-Cookie", "user-token=12345; HttpOnly; Secure; SameSite=Lax");

            return ResponseEntity.ok("Cookie has been set successfully!");
        } catch (Exception e) {
     
            return ResponseEntity.status(500).body("Error while setting cookie.");
        }
    }

    // Çerez okuma
    @GetMapping("/get-cookie")
    public ResponseEntity<String> getCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("user-token".equals(cookie.getName())) {
                    return ResponseEntity.ok("User Token: " + cookie.getValue());
                }
            }
        }
        return ResponseEntity.ok("No cookie found!");
    }
}
