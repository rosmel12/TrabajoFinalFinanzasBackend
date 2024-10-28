package org.example.trabajofinalfinanzasbackend.controller;
import org.example.trabajofinalfinanzasbackend.dtos.OperacionFactoringDto;
import org.example.trabajofinalfinanzasbackend.model.OperacionFactoring;
import org.example.trabajofinalfinanzasbackend.servicesinterfaces.OperacionFactoringService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/quma/operacionfactoring")
@CrossOrigin()
public class OperacionFactoringController {
    @Autowired
    private OperacionFactoringService operacionFactoringService;

    @GetMapping("/usuario/insertar")
    public Integer insertarOperacion() {
        return  operacionFactoringService.insertarOperacion();
    }

    @GetMapping("/usuario/listar")
    public OperacionFactoringDto listarOperacionFactura(@RequestParam Integer idFactura) {
     ModelMapper modelMapper = new ModelMapper();
     OperacionFactoring operacionFactoring=operacionFactoringService.listaroperacionPorFactura(idFactura);
     return modelMapper.map(operacionFactoring, OperacionFactoringDto.class);
    }

    @GetMapping("/usuario/operacionesusuario")
    public List<OperacionFactoringDto> listarOperacionesUsuario(@RequestParam String ruc){
        ModelMapper modelMapper = new ModelMapper();
        List<OperacionFactoring> operacionFactorings=operacionFactoringService.listaroperacionPorCliente(ruc);
        return Arrays.asList(modelMapper.map(operacionFactorings, OperacionFactoringDto[].class));
    }

}
