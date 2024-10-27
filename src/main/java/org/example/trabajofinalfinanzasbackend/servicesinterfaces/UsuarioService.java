package org.example.trabajofinalfinanzasbackend.servicesinterfaces;

import org.example.trabajofinalfinanzasbackend.model.Usuario;
import org.example.trabajofinalfinanzasbackend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Integer agregarUsuario(Usuario usuario) {
        Usuario usuarioComprobar=usuarioRepository.findUsuarioByUsername(usuario.getUsername());
        if(usuarioComprobar==null){
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(usuario.getPassword());
            usuario.setPassword(encodedPassword);
           usuarioRepository.save(usuario);
           return usuario.getId();
        }
       return null;
    }
    public Usuario buscarUsuario(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }


}
