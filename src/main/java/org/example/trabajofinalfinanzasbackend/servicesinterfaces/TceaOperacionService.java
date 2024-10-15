package org.example.trabajofinalfinanzasbackend.servicesinterfaces;

import org.example.trabajofinalfinanzasbackend.dtos.TceaOperacionDto;
import org.example.trabajofinalfinanzasbackend.model.OperacionFactoring;
import org.example.trabajofinalfinanzasbackend.model.TasaNominal;
import org.example.trabajofinalfinanzasbackend.model.TceaOperacion;
import org.example.trabajofinalfinanzasbackend.repositories.TceaOperacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TceaOperacionService {
    @Autowired
    private TceaOperacionRepository tceaOperacionRepository;

    public String IngresarTceaOperacion(int DiasOperacion,double MontoTotal, OperacionFactoring operacionFactoring) {
        TceaOperacion tceaOperacion = new TceaOperacion();
        tceaOperacion.setTcea(calcularTceaOperacion(DiasOperacion,operacionFactoring.getMontoPago(),MontoTotal));
        tceaOperacion.setComentario("tcea correcto");
        tceaOperacion.setTceaOperacionFactoring(operacionFactoring);
        tceaOperacionRepository.save(tceaOperacion);
        return "la tcea se agrego correctmente";
    }
    private double calcularTceaOperacion(int DiasOperacion, double MontoOperacionPagado,double MontoTotal) {
        double tceaOperacion = (Math.pow(MontoTotal/MontoOperacionPagado, (double) 360/DiasOperacion))-1;
        return tceaOperacion;
    }

    public List<TceaOperacion> listarTceaOperacionUsuario(String ruc) {
       return tceaOperacionRepository.findAllByRucClienteProveedor(ruc);
    }
}