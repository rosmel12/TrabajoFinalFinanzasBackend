package org.example.trabajofinalfinanzasbackend.controller;

import org.example.trabajofinalfinanzasbackend.dtos.UsuarioDto;
import org.example.trabajofinalfinanzasbackend.model.Usuario;
import org.example.trabajofinalfinanzasbackend.servicesinterfaces.UsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin()
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/InsertarUsuario")
    public String createUsuario(@RequestBody UsuarioDto usuario) throws Exception {
        try {
            ModelMapper modelMapper = new ModelMapper();
            Usuario user = modelMapper.map(usuario, Usuario.class);
            return usuarioService.agregarUsuario(user);
        } catch(Exception e) {
            throw new Exception("Error al insertar usuario");
        }
    }
    @GetMapping("/listar")
    public List<UsuarioDto>listar()  {
            ModelMapper modelMapper = new ModelMapper();
            List<Usuario> usuarios = usuarioService.listarUsuarios();
            return Arrays.asList(modelMapper.map(usuarios, UsuarioDto[].class));
    }
}
