package com.example.demo;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HeaderController {
/*
    // Header alma örneği
    @GetMapping("/read-header")
    public ResponseEntity<String> readHeader(@RequestHeader("Client-Name") String clientName,
                                             @RequestHeader(value = "Client-Version", defaultValue = "1.0") String clientVersion) {
        return ResponseEntity.ok("Received headers -> Client-Name: " + clientName + ", Client-Version: " + clientVersion);
    }

    // Header ekleme örneği
    @GetMapping("/send-header")
    public ResponseEntity<String> sendHeader() {
        return ResponseEntity.ok()
                .header("Server-Name", "SpringBootServer")
                .header("Server-Version", "2.5.0")
                .body("Headers added to the response!");
    }
    
    */
}

