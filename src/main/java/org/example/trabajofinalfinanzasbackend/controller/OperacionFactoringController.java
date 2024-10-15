package org.example.trabajofinalfinanzasbackend.controller;
import org.example.trabajofinalfinanzasbackend.dtos.OperacionFactoringDto;
import org.example.trabajofinalfinanzasbackend.model.OperacionFactoring;
import org.example.trabajofinalfinanzasbackend.servicesinterfaces.OperacionFactoringService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/operacionfactoring")
@CrossOrigin()
public class OperacionFactoringController {
    @Autowired
    private OperacionFactoringService operacionFactoringService;

    @PostMapping("/insertar")
    public String insertarOperacion() throws Exception {
        try {
            return  operacionFactoringService.insertarOperacion();
        } catch(Exception e) {
            throw new Exception("Error al insertar operacion");
        }
    }

}
