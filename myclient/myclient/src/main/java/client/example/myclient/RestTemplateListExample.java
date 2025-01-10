package client.example.myclient;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RestTemplateListExample {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/products"; // Liste döndüren bir API

        // Listeyi almak için ParameterizedTypeReference kullanıyoruz
        ResponseEntity<List<Product>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {}
        );

        List<Product> productList = response.getBody();

        // Ürünleri yazdırıyoruz
        if (productList != null) {
            for (Product product : productList) {
                System.out.println(product.getId()+"  "+product.getPrice()+"  "+product.getName());
            }
        }
    }
}
