package org.example.trabajofinalfinanzasbackend.controller;

import org.example.trabajofinalfinanzasbackend.dtos.TasaEfectivaDto;
import org.example.trabajofinalfinanzasbackend.dtos.TasaNominalDto;
import org.example.trabajofinalfinanzasbackend.model.TasaEfectiva;
import org.example.trabajofinalfinanzasbackend.model.TasaNominal;
import org.example.trabajofinalfinanzasbackend.servicesinterfaces.TasaNominalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasanominal")
@CrossOrigin()
public class TasaNominalController {
    @Autowired
    private TasaNominalService tasaNominalService;

    @PostMapping("/insertar")
    public String createTasaNominal(@RequestBody TasaNominalDto tasaEfectivaDto) throws Exception {
        try {
            ModelMapper modelMapper = new ModelMapper();
           TasaNominal tasaNominal=modelMapper.map(tasaEfectivaDto, TasaNominal.class);
           return tasaNominalService.insertarTasaNominal(tasaNominal);
        } catch(Exception e) {
            throw new Exception("Error al insertar tasa nominal");
        }
    }
}
