package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controllers {
    
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/registro")
    public String showRegistroPage() {
        return "registro";
    }
    
    @GetMapping("/productos")
    public String showProductsPage() {
        return "productos";
    }
}
