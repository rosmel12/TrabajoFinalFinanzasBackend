package org.example.trabajofinalfinanzasbackend.controller;

import org.example.trabajofinalfinanzasbackend.dtos.CarteraTceaDto;
import org.example.trabajofinalfinanzasbackend.model.CarteraTcea;
import org.example.trabajofinalfinanzasbackend.servicesinterfaces.CarteraTceaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carteratcea")
@CrossOrigin()
public class CarteraTceaController {
    @Autowired
    private CarteraTceaService carteraTceaService;

    @PostMapping("/insertar")
    public String createCarteraTcea(@RequestBody CarteraTceaDto carteraTceaDto) throws Exception {
        try {
            ModelMapper modelMapper = new ModelMapper();
            CarteraTcea carteraTcea=modelMapper.map(carteraTceaDto, CarteraTcea.class);
            return carteraTceaService.insertarCarteraTcea(carteraTceaDto,carteraTcea);
        } catch(Exception e) {
            throw new Exception("Error al insertar cartera tcea");
        }

    }
}
