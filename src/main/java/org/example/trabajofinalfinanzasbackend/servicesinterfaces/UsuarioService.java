package org.example.trabajofinalfinanzasbackend.servicesinterfaces;

import org.example.trabajofinalfinanzasbackend.model.Usuario;
import org.example.trabajofinalfinanzasbackend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Integer agregarUsuario(Usuario usuario) {
        Usuario usuarioComprobar=usuarioRepository.findUsuarioByUsername(usuario.getUsername());
        if(usuarioComprobar==null){
            String pass=usuario.getPassword();
            usuario.setPassword(pass);
           usuario=usuarioRepository.save(usuario);
           return usuario.getId();
        }
       return null;
    }
    public Usuario buscarUsuario(String username) {
        return usuarioRepository.findUsuarioByUsername(username);
    }

}
