package com.example.demo.controllers;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
// import org.springframework.web.servlet.view.RedirectView;
// import org.springframework.ui.Model;

import com.example.demo.models.Users;
import com.example.demo.services.UserService;
import com.google.common.hash.Hashing;

@Controller
public class LoginController {

    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public RedirectView processLogin(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes redirectAttributes) {
        Users user = userService.findByEmail(email);
        
        if (user == null) {
            redirectAttributes.addFlashAttribute("error", "Usuario no encontrado");
            return new RedirectView("/login");
        }

        String storedPasswordHash = user.getPassword();
        String passwordHash = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();

        if (user != null && passwordHash.equals(storedPasswordHash)) {
            // Usuario válido, redirecciona a la página de inicio
            return new RedirectView("/productos");
        } else {
            // Usuario no válido, muestra un mensaje de error
            redirectAttributes.addFlashAttribute("error", "Credenciales inválidas");
            return new RedirectView("/login");

        }
    }

}
