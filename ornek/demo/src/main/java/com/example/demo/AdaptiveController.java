package com.example.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class AdaptiveController {


    @GetMapping("/square{deger}")
    public double getSquere(@PathVariable(name="deger") double number){
        return number*number;
    }

}
