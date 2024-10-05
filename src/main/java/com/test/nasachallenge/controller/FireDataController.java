package com.test.nasachallenge.controller;

import com.test.nasachallenge.attribute.FireData;
import com.test.nasachallenge.service.FireDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/map")
public class FireDataController {

    @Autowired
    private FireDataService fireDataService;

    @GetMapping
    public List<FireData> getFireData() {
        return fireDataService.getFireData(); // Devuelve la lista de objetos FireData
    }
}
