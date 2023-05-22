package com.example.demo.repositories;

import com.example.demo.models.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaveUserRepository extends JpaRepository<Users, Long> {
    
}
