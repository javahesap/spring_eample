package client.example.myclient;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ClientcookieApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ClientcookieApplication.class, args);
    }

    @Override
    public void run(String... args) {
        RestTemplate restTemplate = new RestTemplate();

        // 1. Çerez oluşturma isteği
        String setCookieUrl = "http://localhost:8080/set-cookie";
        ResponseEntity<String> setResponse = restTemplate.getForEntity(setCookieUrl, String.class);
        System.out.println("Response from /set-cookie: " + setResponse.getBody());

        // 2. Çerez okuma isteği
        String getCookieUrl = "http://localhost:8080/get-cookie";
        ResponseEntity<String> getResponse = restTemplate.getForEntity(getCookieUrl, String.class);
        System.out.println("Response from /get-cookie: " + getResponse.getBody());
    }
}


