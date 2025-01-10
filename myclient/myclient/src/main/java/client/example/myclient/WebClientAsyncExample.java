package client.example.myclient;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.ClientResponse;

public class WebClientAsyncExample {
    public static void main(String[] args) {
        WebClient webClient = WebClient.create("https://jsonplaceholder.typicode.com");

        // Asenkron GET isteği
        webClient.get()
                 .uri("/posts/1")
                 .retrieve()
                 .bodyToMono(String.class)
                 .doOnTerminate(() -> System.out.println("Request finished"))
                 .subscribe(response -> {
                     System.out.println("Response: " + response);
                 });
    }
}
