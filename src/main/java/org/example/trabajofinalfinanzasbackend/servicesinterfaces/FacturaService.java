package org.example.trabajofinalfinanzasbackend.servicesinterfaces;

import org.example.trabajofinalfinanzasbackend.dtos.FacturaDto;
import org.example.trabajofinalfinanzasbackend.model.ClienteDeudor;
import org.example.trabajofinalfinanzasbackend.model.ClienteProveedor;
import org.example.trabajofinalfinanzasbackend.model.Factura;
import org.example.trabajofinalfinanzasbackend.repositories.ClienteDeudorRepository;
import org.example.trabajofinalfinanzasbackend.repositories.ClienteProveedorRepository;
import org.example.trabajofinalfinanzasbackend.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaService {
    @Autowired
    private FacturaRepository facturaRepository;
    @Autowired
    private ClienteDeudorRepository deudorRepository;
    @Autowired
    private ClienteProveedorRepository proveedorRepository;
    @Autowired
    private OperacionFactoringService operacionFactoringService;

    public String insertarFactura(FacturaDto facturaDto, Factura factura) {
        ClienteProveedor clienteProveedor = proveedorRepository.findById(facturaDto.getRucClienteProveedor()).orElse(null);
        ClienteDeudor clienteDeudor = deudorRepository.findById(facturaDto.getRucClienteDeudor()).orElse(null);
        if (clienteDeudor != null && clienteProveedor != null) {
            factura.setDeudorFactura(clienteDeudor);
            factura.setProveedorFactura(clienteProveedor);
            factura =facturaRepository.save(factura);
            operacionFactoringService.recepcionarFactura(factura);
            return "Factura agregada con exito";
        }
        return "no creo la factura";
    }

    public List<Factura> listarFacturas() {
        return facturaRepository.findAll();
    }
}
