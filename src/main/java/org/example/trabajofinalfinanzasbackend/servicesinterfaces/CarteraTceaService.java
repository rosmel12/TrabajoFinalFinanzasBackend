package org.example.trabajofinalfinanzasbackend.servicesinterfaces;

import org.example.trabajofinalfinanzasbackend.dtos.CarteraTceaDto;
import org.example.trabajofinalfinanzasbackend.model.CarteraTcea;
import org.example.trabajofinalfinanzasbackend.model.ClienteProveedor;
import org.example.trabajofinalfinanzasbackend.repositories.CarteraTceaRepository;
import org.example.trabajofinalfinanzasbackend.repositories.ClienteProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarteraTceaService {
    @Autowired
    private CarteraTceaRepository carteraTceaRepository;
    @Autowired
    private ClienteProveedorRepository proveedorRepository;
    public String insertarCarteraTcea(CarteraTceaDto carteraTceaDto, CarteraTcea carteraTcea) {
        ClienteProveedor proveedor=proveedorRepository.findById(carteraTceaDto.getRucCliente()).orElse(null);
        if(proveedor!=null){
            carteraTcea.setProveedorCartera(proveedor);
            carteraTceaRepository.save(carteraTcea);
            return "se creo la cartera tcea";
        }
        return "no se creo la cartera tcea";
    }
}
