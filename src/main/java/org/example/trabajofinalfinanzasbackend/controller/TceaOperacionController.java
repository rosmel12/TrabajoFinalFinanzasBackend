package org.example.trabajofinalfinanzasbackend.controller;

import org.example.trabajofinalfinanzasbackend.dtos.TceaOperacionDto;
import org.example.trabajofinalfinanzasbackend.model.TceaOperacion;
import org.example.trabajofinalfinanzasbackend.servicesinterfaces.TceaOperacionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/tceaoperacion")
@CrossOrigin()
public class TceaOperacionController {
    @Autowired
    private TceaOperacionService tceaOperacionService;

    @GetMapping("/listartceausuario")
    public List<TceaOperacionDto> listarTceaOperacion(@RequestParam String ruc) {
        ModelMapper modelMapper = new ModelMapper();
        List<TceaOperacion> tceaOperacions=tceaOperacionService.listarTceaOperacionUsuario(ruc);
        return Arrays.asList(modelMapper.map(tceaOperacions, TceaOperacionDto[].class));
    }
}