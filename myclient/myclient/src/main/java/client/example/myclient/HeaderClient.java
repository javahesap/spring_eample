package client.example.myclient;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class HeaderClient implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(HeaderClient.class, args);
    }

    @Override
    public void run(String... args) {
        RestTemplate restTemplate = new RestTemplate();
     System.out.println("-------------------------------------------------------------------------------------------");
        // Header gönderme
        String serverUrl = "http://localhost:8080/read-header";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Client-Name", "SpringBootClient");
        headers.set("Client-Version", "1.0.1");

        // HttpEntity ile header'ları gönderme
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(serverUrl, HttpMethod.GET, requestEntity, String.class);

        System.out.println("Response from server (read-header): " + response.getBody());

        // Yanıttan header alma
        String sendHeaderUrl = "http://localhost:8080/send-header";
        ResponseEntity<String> sendHeaderResponse = restTemplate.getForEntity(sendHeaderUrl, String.class);

        System.out.println("Response from server (send-header): " + sendHeaderResponse.getBody());
        System.out.println("Server-Name: " + sendHeaderResponse.getHeaders().getFirst("Server-Name"));
        System.out.println("Server-Version: " + sendHeaderResponse.getHeaders().getFirst("Server-Version"));
    }
}
