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
public class FacturaDto {
    private Integer id;
    private int numero;
    private double montoTotal;
    private double montoTotalIgv;
    private String moneda;
    private Date fechaEmision;
    private Date fechaVencimiento;
    private String rucClienteProveedor;
    private String rucClienteDeudor;
}
