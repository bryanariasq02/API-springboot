package com.example.demo.controllers;

import com.google.common.hash.Hashing;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.models.Users;
import com.example.demo.repositories.SaveUserRepository;

@RestController
@RequestMapping("/registro")
public class RegisterController {
    
    private final SaveUserRepository saveUserRepository;

    @Autowired
    public RegisterController(SaveUserRepository saveUserRepository){
        this.saveUserRepository = saveUserRepository;
    }

    @PostMapping()
    public RedirectView createUser(@RequestParam("email") String email, @RequestParam("password") String password){
        Users user = new Users();
        user.setEmail(email);
        // Hashear la contraseña

        user.setPassword(Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString());

        

        saveUserRepository.save(user);

        return new RedirectView("productos");
    } 
    
}
