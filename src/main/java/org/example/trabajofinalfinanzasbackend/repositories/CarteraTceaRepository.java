package org.example.trabajofinalfinanzasbackend.repositories;

import org.example.trabajofinalfinanzasbackend.model.CarteraTcea;
import org.example.trabajofinalfinanzasbackend.model.Factura;
import org.example.trabajofinalfinanzasbackend.model.TceaOperacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarteraTceaRepository extends JpaRepository<CarteraTcea, Integer> {
    @Query(value = "select fc.* \n" +
            "from factura fc\n" +
            "join operacionfactoring ofc on ofc.id_factura=fc.id\n" +
            "join tceaoperacion tcea on tcea.id_operacion_factoring=ofc.id\n" +
            "where fc.ruc_cliente_proveedor=:ruc",nativeQuery = true )
    List<Factura> factura (@Param("ruc")String ruc);


    @Query(value = "select tcea.* \n" +
            "from factura fc\n" +
            "join operacionfactoring ofc on ofc.id_factura=fc.id\n" +
            "join tceaoperacion tcea on tcea.id_operacion_factoring=ofc.id\n" +
            "where fc.ruc_cliente_proveedor=:ruc",nativeQuery = true )
    List<TceaOperacion> tcea (@Param("ruc")String ruc);

    @Query(value = "select *\n" +
            "from carteratcea ct\n" +
            "where ct.ruc_cliente=:ruc",nativeQuery = true)
    List<CarteraTcea> findByRuc(@Param("ruc")String ruc);
}
