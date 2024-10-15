package org.example.trabajofinalfinanzasbackend.repositories;

import org.example.trabajofinalfinanzasbackend.model.ClienteProveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteProveedorRepository extends JpaRepository<ClienteProveedor, String> {
    @Query(value = "select cp.*\n" +
            "from  clienteproveedor cp\n" +
            "where cp.id_usuario=:id",nativeQuery = true)
    ClienteProveedor clienteUsuario(@Param("id") Integer id) ;

}
