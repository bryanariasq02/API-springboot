package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Users;
import com.example.demo.repositories.SaveUserRepository;

@Service
public class UserRegisterService {
    
    private final SaveUserRepository saveUserRepository;

    @Autowired
    public UserRegisterService(SaveUserRepository saveUserRepository) {
        this.saveUserRepository = saveUserRepository;
    }

    public Users createUser(Users user) {
        // Lógica para validar y guardar el usuario
        return saveUserRepository.save(user);
    }
    
}
