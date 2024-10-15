package org.example.trabajofinalfinanzasbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {
    private int id;
    private String dni;
    private String nombre;
    private String apellido;
    private String email;
    private String usuario;
    private String contrasena;
    private String rol;
}
