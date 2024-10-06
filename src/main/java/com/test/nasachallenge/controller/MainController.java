package com.test.nasachallenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String home() {
        // Carga la página principal (index.html)
        return "index";
    }

    @GetMapping("/mapa")
    public String mapa() {
        // Carga la página del mapa (map.html)
        return "map";
    }

    @GetMapping("/animales")
    public String animales(){
        return "animals";
    }

    @GetMapping("/afectado")
    public String afectado(){
        return "affected";
    }
}
