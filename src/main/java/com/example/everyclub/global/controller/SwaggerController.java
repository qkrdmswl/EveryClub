package com.example.everyclub.global.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerController {

    @GetMapping("/docs")
    public String showSwaggerDocs() {
        return "redirect:/swagger-ui/index.html";
    }
}
