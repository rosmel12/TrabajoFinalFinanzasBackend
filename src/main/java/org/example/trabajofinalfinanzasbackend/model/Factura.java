package org.example.trabajofinalfinanzasbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero", nullable = false)
    private int numero;

    @Column(name = "montoTotal", nullable = false)
    private double montoTotal;

    @Column(name = "montoTotalIgv", nullable = false)
    private double montoTotalIgv;

    @Column(name = "moneda", nullable = false)
    private String moneda;

    @Column(name = "fechaEmision", nullable = false)
    private Date fechaEmision;

    @Column(name = "fechaVencimiento", nullable = false)
    private Date fechaVencimiento;

    //relacion-Cliente_proveedor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="rucClienteProveedor" ,nullable=false)
    private ClienteProveedor proveedorFactura;

    //relacion-Cliente_deudor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="rucClienteDeudor" ,nullable=false)
    private ClienteDeudor deudorFactura;

    //realcion operacion_factoring
    @OneToOne(mappedBy ="facturaOperacion", cascade = CascadeType.ALL)
    private OperacionFactoring operacionFactoring;
}