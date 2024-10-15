package org.example.trabajofinalfinanzasbackend.servicesinterfaces;


import org.example.trabajofinalfinanzasbackend.model.CarteraTcea;
import org.example.trabajofinalfinanzasbackend.model.Factura;
import org.example.trabajofinalfinanzasbackend.model.TceaOperacion;
import org.example.trabajofinalfinanzasbackend.repositories.CarteraTceaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarteraTceaService {
    @Autowired
    private CarteraTceaRepository carteraTceaRepository;

    public String insertarCarteraTcea(Factura factura) {
        List<Factura> facturas=carteraTceaRepository.factura(factura.getProveedorFactura().getRuc());
        List<TceaOperacion> tceaOperacions=carteraTceaRepository.tcea(factura.getProveedorFactura().getRuc());
        double sumTotal=facturas.stream()
                .mapToDouble(Factura::getMontoTotal)  // Obtener el valor de 'monto' de cada factura
                .sum();
          for(int i =0; i<tceaOperacions.size();i++){
              

          }
        return "no se creo la cartera tcea";
    }

    public List<CarteraTcea> getCarteraTcea(String rucCliente){
     return carteraTceaRepository.findByRuc(rucCliente);
    }
}
