package org.example.trabajofinalfinanzasbackend.controller;

import org.example.trabajofinalfinanzasbackend.dtos.ClienteProveedorDto;
import org.example.trabajofinalfinanzasbackend.model.ClienteProveedor;
import org.example.trabajofinalfinanzasbackend.servicesinterfaces.ClienteProveedorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clienteproveedor")
@CrossOrigin()
public class ClienteProveedorController {
    @Autowired
    private ClienteProveedorService clienteProveedorService;

    @PostMapping("/insertar")
    public String createClienteProveeor(@RequestBody ClienteProveedorDto clienteProveedorDto) throws Exception {
        try {
            ModelMapper modelMapper = new ModelMapper();
            ClienteProveedor clienteProveedor  = modelMapper.map(clienteProveedorDto, ClienteProveedor.class);
            return clienteProveedorService.insertarCliente(clienteProveedorDto, clienteProveedor);
        } catch(Exception e) {
            throw new Exception("Error al insertar cliente");
        }

    }

    @GetMapping("/listarcliente")
    public List<ClienteProveedorDto> listarCliente(@RequestParam Integer id){
        ModelMapper modelMapper = new ModelMapper();
        ClienteProveedor clienteProveedor=clienteProveedorService.clientePorUsuario(id);
        return Arrays.asList(modelMapper.map(clienteProveedor, ClienteProveedorDto.class));
    }


    @GetMapping("/listarclientes")
    public List<ClienteProveedorDto> listar()  {
        ModelMapper modelMapper = new ModelMapper();
        List<ClienteProveedor> clienteProveedors=clienteProveedorService.listarClientes();
        return Arrays.asList(modelMapper.map(clienteProveedors, ClienteProveedorDto[].class));
    }
}
