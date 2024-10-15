package org.example.trabajofinalfinanzasbackend.controller;

import org.example.trabajofinalfinanzasbackend.dtos.FacturaDto;
import org.example.trabajofinalfinanzasbackend.model.Factura;
import org.example.trabajofinalfinanzasbackend.servicesinterfaces.FacturaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/factura")
@CrossOrigin()
public class FacturaController {
    @Autowired
    private FacturaService facturaService;

    @PostMapping("/insertar")
    public String createFactura(@RequestBody FacturaDto facturaDto) throws Exception {
        try {
            ModelMapper modelMapper = new ModelMapper();
            Factura factura = modelMapper.map(facturaDto, Factura.class);
            return facturaService.insertarFactura(facturaDto, factura);
        } catch(Exception e) {
            throw new Exception("Error al insertar factura");
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Factura>> listar()  {
       /* ModelMapper modelMapper = new ModelMapper();
        List<Factura> facturas = facturaService.listarFacturas();
        return Arrays.asList(modelMapper.map(facturas, FacturaDto[].class));
    */
     return new ResponseEntity<>(facturaService.listarFacturas(), HttpStatus.OK);
    }

}
