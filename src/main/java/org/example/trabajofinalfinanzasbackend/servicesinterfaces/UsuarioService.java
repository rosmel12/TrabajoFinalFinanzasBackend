package org.example.trabajofinalfinanzasbackend.servicesinterfaces;

import org.example.trabajofinalfinanzasbackend.model.Usuario;
import org.example.trabajofinalfinanzasbackend.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public String agregarUsuario(Usuario usuario) {
        Usuario usuarioComprobar=usuarioRepository.findUsuarioByUsername(usuario.getUsername());
        if(usuarioComprobar==null){
            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(usuario.getPassword());
            usuario.setPassword(encodedPassword);
           usuarioRepository.save(usuario);
           return "Usuario agregado exitosamente";
        }
       return "usuario existente";
    }
    public Usuario buscarUsuario(String usuario) {
        return usuarioRepository.findUsuarioByUsername(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }
}
