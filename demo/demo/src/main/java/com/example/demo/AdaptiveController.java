package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdaptiveController {

    // Query parametresi kullanarak değer dönen bir metot
    @GetMapping("/deger")
    public String getSquerei(@RequestParam(name = "number", required = false) String number) {
        return "Gelen değer: " + number;
    }

    // Path variable kullanarak bir sayının karesini dönen metot
    @GetMapping("/square/{deger}")
    public double getSquere(@PathVariable(name = "deger") double number) {
        return number * number;
    }
}
