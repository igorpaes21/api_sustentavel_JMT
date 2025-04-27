package br.com.senai.api_sutentavel.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SecurityController {

    @GetMapping("/public")
    public String publico() {
        return "Público acessado.";
    }

    @GetMapping("/user")
    public String user() {
        return "User acessado.";
    }

   @GetMapping("/admin")
    public String admin() {
        return "Admin acessado.";
    }
}
