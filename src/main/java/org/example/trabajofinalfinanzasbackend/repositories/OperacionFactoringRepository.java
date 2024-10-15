package org.example.trabajofinalfinanzasbackend.repositories;

import jakarta.persistence.Id;
import org.example.trabajofinalfinanzasbackend.model.OperacionFactoring;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperacionFactoringRepository extends JpaRepository<OperacionFactoring, Integer> {
}
