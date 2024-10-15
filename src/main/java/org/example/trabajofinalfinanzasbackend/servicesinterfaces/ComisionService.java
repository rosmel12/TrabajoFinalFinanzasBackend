package org.example.trabajofinalfinanzasbackend.servicesinterfaces;

import org.example.trabajofinalfinanzasbackend.model.Comision;
import org.example.trabajofinalfinanzasbackend.repositories.ComisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComisionService {
@Autowired
    private ComisionRepository comisionRepository;

public String insertComision(Comision comision) {
     comisionRepository.save(comision);
    return " se agrego la comision";
}

public List<Comision> listarComisiones() {
    return comisionRepository.findAll();
}
}
