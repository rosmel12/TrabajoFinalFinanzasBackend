package org.example.trabajofinalfinanzasbackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TasaEfectivaDto {
    private Integer id;
    private double tasaInteres;
    private String plazo;
    private Date fechaInicio;
    private Date fechaFin;
}
