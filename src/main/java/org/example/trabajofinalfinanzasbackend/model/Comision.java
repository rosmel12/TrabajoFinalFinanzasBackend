package org.example.trabajofinalfinanzasbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "comision")
public class Comision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "seguro", nullable = false)
    private double seguro;

    @Column(name = "envio", nullable = false)
    private double envio;

    @Column(name = "retencion", nullable = false)
    private double retencion;

    @Column(name = "moneda", nullable = false, unique = true)
    private String moneda;

    //relacion descuento
    @OneToMany(mappedBy = "comisionDescuento",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Descuento> descuentos;
}
