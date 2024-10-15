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
public class OperacionFactoringDto {
    private Integer id;
    private Date fechaOperacion;
    private double tasaInteresAplicada;
    private double montoDescuento;
    private double montoPago;
    private Integer idFactura;
    private Integer idDescuento;
}
