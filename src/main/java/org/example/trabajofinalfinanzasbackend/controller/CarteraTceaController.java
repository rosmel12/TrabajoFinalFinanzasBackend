package org.example.trabajofinalfinanzasbackend.controller;

import org.example.trabajofinalfinanzasbackend.servicesinterfaces.CarteraTceaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carteratcea")
@CrossOrigin()
public class CarteraTceaController {
    @Autowired
    private CarteraTceaService carteraTceaService;

    @PostMapping("/insertar")
    public String createCarteraTcea() throws Exception {
        try {
            return "";
        } catch(Exception e) {
            throw new Exception("Error al insertar cartera tcea");
        }

    }
}
