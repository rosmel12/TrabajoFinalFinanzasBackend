package org.example.trabajofinalfinanzasbackend.repositories;

import org.example.trabajofinalfinanzasbackend.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {
@Query(value = "select fc.*\n" +
        "from factura fc\n" +
        "where fc.ruc_cliente_proveedor=:ruc",nativeQuery = true)
 List<Factura> listarFacturasClienteRuc(@Param("ruc") String ruc);
}
