package org.example.trabajofinalfinanzasbackend.servicesinterfaces;

import org.example.trabajofinalfinanzasbackend.model.TasaEfectiva;
import org.example.trabajofinalfinanzasbackend.repositories.TasaEfectivaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TasaEfectivaService {
    @Autowired
    private TasaEfectivaRepository tasaEfectivaRepository;

    public String insertarTasaEfectiva(TasaEfectiva tasaEfectiva) {
         tasaEfectivaRepository.save(tasaEfectiva);
         return "creado correctamente";
    }

    public List<TasaEfectiva> listarTasaEfectivas() {
        return tasaEfectivaRepository.findAll();
    }
}
