package org.example.trabajofinalfinanzasbackend.servicesinterfaces;

import org.example.trabajofinalfinanzasbackend.dtos.DescuentoDto;
import org.example.trabajofinalfinanzasbackend.model.Comision;
import org.example.trabajofinalfinanzasbackend.model.Descuento;
import org.example.trabajofinalfinanzasbackend.model.TasaEfectiva;
import org.example.trabajofinalfinanzasbackend.model.TasaNominal;
import org.example.trabajofinalfinanzasbackend.repositories.ComisionRepository;
import org.example.trabajofinalfinanzasbackend.repositories.DescuentoRepository;
import org.example.trabajofinalfinanzasbackend.repositories.TasaEfectivaRepository;
import org.example.trabajofinalfinanzasbackend.repositories.TasaNominalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescuentoService {

    @Autowired
    private DescuentoRepository descuentoRepository;
    @Autowired
    private ComisionRepository comisionRepository;
    @Autowired
    private TasaNominalRepository tasaNominalRepository;
    @Autowired
    private TasaEfectivaRepository tasaEfectivaRepository;
    @Autowired
    private OperacionFactoringService operacionFactoringService;
    public String insertDescuento(DescuentoDto descuentoDto, Descuento descuento) {
        Comision comision =comisionRepository.findById(descuentoDto.getIdComision()).orElse(null) ;
        TasaNominal tasaNominal=tasaNominalRepository.findById(descuentoDto.getIdTasaNominal()).orElse(null) ;
        TasaEfectiva tasaEfectiva=tasaEfectivaRepository.findById(descuentoDto.getIdTasaEfectiva()).orElse(null);

        //verificar comision
        if(comision !=null){
           descuento.setComisionDescuento(comision);
       }else{
           return "no se agrego comision";
       }
       //verificar una tasa
       if(tasaNominal!=null && tasaEfectiva==null) {
            descuento.setTasaNominalDescuento(tasaNominal);
            descuento.setTasaEfectivaDescuento(null);
           descuento= descuentoRepository.save(descuento);
           operacionFactoringService.recepcionarDescuento(descuento);
           return "descuento agregado con tasa nominal";
       }else if(  tasaEfectiva !=null && tasaNominal==null) {
            descuento.setTasaEfectivaDescuento(tasaEfectiva);
            descuento.setTasaNominalDescuento(null);
           descuento= descuentoRepository.save(descuento);
           operacionFactoringService.recepcionarDescuento(descuento);
           return "descuento agregado con tasa efectiva";
       }
        return "no se agrego descuento";
    }

    public List<Descuento> listarDescuentos() {
        return descuentoRepository.findAll();
    }

}
