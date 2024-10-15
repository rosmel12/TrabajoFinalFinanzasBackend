package org.example.trabajofinalfinanzasbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tceaoperacion")
public class TceaOperacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tcea", nullable = false)
    private double tcea;

    @Column(name = "comentario", nullable = false)
    private String comentario;

    //relacion operacion_Factoring
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idOperacionFactoring" ,nullable=false)
    private OperacionFactoring tceaOperacionFactoring;


}
