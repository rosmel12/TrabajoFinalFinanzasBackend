package org.example.trabajofinalfinanzasbackend.controller;

import org.example.trabajofinalfinanzasbackend.dtos.ClienteDeudorDto;
import org.example.trabajofinalfinanzasbackend.model.ClienteDeudor;
import org.example.trabajofinalfinanzasbackend.servicesinterfaces.ClienteDeudorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientedeudor")
@CrossOrigin()
public class ClienteDeudorController {
    @Autowired
    private ClienteDeudorService clienteDeudorService;
    @PostMapping("/insertar")
    public String createClienteDeudor(@RequestBody ClienteDeudorDto clienteDeudorDto) throws Exception {
        try {
            ModelMapper modelMapper = new ModelMapper();
            ClienteDeudor cliente = modelMapper.map(clienteDeudorDto, ClienteDeudor.class);
            return clienteDeudorService.insertarClienteDeudor(cliente);
        } catch(Exception e) {
            throw new Exception("Error al insertar cliente");
        }

    }

}
