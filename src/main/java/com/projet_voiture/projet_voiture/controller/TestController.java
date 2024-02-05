package com.projet_voiture.projet_voiture.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    @PreAuthorize("hasRole('ADMIN')")
    public String hello() {
        return "Hello";
    }
}
