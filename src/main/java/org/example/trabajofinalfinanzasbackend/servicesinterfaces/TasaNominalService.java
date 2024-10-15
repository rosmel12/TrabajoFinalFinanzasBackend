package org.example.trabajofinalfinanzasbackend.servicesinterfaces;

import org.example.trabajofinalfinanzasbackend.model.TasaNominal;
import org.example.trabajofinalfinanzasbackend.repositories.TasaNominalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasaNominalService {
@Autowired
private TasaNominalRepository TasaNominalRepository;

public String insertarTasaNominal(TasaNominal TasaNominal) {
    TasaNominalRepository.save(TasaNominal);
    return "creado correctamente";
}

public List<TasaNominal> listarTasaNominal() {
    return TasaNominalRepository.findAll();
}
}
