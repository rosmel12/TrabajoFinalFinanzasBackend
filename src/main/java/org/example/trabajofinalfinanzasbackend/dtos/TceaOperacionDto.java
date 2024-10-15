package org.example.trabajofinalfinanzasbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TceaOperacionDto {
    private Integer id;
    private double tcea;
    private String comentario;
    private Integer idOperacionFactoring;
}
