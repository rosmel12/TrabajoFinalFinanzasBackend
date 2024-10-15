package org.example.trabajofinalfinanzasbackend.servicesinterfaces;

import org.example.trabajofinalfinanzasbackend.model.Usuario;
import org.example.trabajofinalfinanzasbackend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public String agregarUsuario(Usuario usuario) {
        Usuario usuarioComprobar=usuarioRepository.findUsuarioByUsuario(usuario.getUsuario());
        if(usuarioComprobar==null){
            String pass=usuario.getContrasena();
            usuario.setContrasena(pass);
           usuarioRepository.save(usuario);
           return "Usuario agregado exitosamente";
        }
       return "usuario existente";
    }
    public Usuario buscarUsuario(String usuario) {
        return usuarioRepository.findUsuarioByUsuario(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
}