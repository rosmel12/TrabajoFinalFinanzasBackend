package org.example.trabajofinalfinanzasbackend.controller;

import org.example.trabajofinalfinanzasbackend.dtos.DescuentoDto;
import org.example.trabajofinalfinanzasbackend.model.Descuento;
import org.example.trabajofinalfinanzasbackend.servicesinterfaces.DescuentoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/descuento")
@CrossOrigin()
public class DescuentoController {
    @Autowired
    private DescuentoService descuentoService;

    @PostMapping("/insertar")
    public String createDescuento(@RequestBody DescuentoDto descuentoDto) throws Exception {
        try {
            ModelMapper modelMapper = new ModelMapper();
            Descuento descuento = modelMapper.map(descuentoDto, Descuento.class);
            return descuentoService.insertDescuento(descuentoDto,descuento);
        } catch(Exception e) {
            throw new Exception("Error al insertar descuento");
        }

    }

    @GetMapping("/listardescuento")
    public List<DescuentoDto> listarDescuento(){
        ModelMapper modelMapper = new ModelMapper();
        List<Descuento> descuentos = descuentoService.listarDescuentos();
        return Arrays.asList(modelMapper.map(descuentos, DescuentoDto[].class));
    }
}
