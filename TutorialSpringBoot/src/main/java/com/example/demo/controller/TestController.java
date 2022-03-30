package com.example.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    @Operation(summary = "Just a test for check that everything works")
    public String test(){
        return "Tutto ok, l'app funziona!";
    }
}
