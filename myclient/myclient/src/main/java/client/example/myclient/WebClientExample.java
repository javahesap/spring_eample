package client.example.myclient;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.ClientResponse;

public class WebClientExample {
    public static void main(String[] args) {
        WebClient webClient = WebClient.create("https://jsonplaceholder.typicode.com");

        // Senkron GET isteği
        String response = webClient.get()
                                    .uri("/posts/1")
                                    .retrieve()
                                    .bodyToMono(String.class)  // JSON'u String'e dönüştür
                                    .block();  // Senkron işleme

        System.out.println(response);
    }
}

