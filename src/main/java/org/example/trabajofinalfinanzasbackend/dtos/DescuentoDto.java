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
public class DescuentoDto {
    private Integer id;
    private Date fecha;
    private Integer idComision;
    private Integer idTasaNominal;
    private Integer idTasaEfectiva;
}
