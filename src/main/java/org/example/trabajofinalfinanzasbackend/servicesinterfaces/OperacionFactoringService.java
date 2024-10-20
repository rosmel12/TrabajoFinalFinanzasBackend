package org.example.trabajofinalfinanzasbackend.servicesinterfaces;

import org.example.trabajofinalfinanzasbackend.model.*;
import org.example.trabajofinalfinanzasbackend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
public class OperacionFactoringService {

@Autowired
private OperacionFactoringRepository operacionFactoringRepository;
@Autowired
private PeriodoRepository periodoRepository;
@Autowired
private TceaOperacionService tceaOperacionService;
@Autowired
private NotificacionClienteService notificacionClienteService;

private int diasFactura=0;
private double tep=0.0;
private double montoDescuento=0.0;

/// ///tablas para la operacion
private Factura factura=null;
private Descuento descuento=null;
private Comision comision=null;
private TasaNominal tasaNominal=null;
private TasaEfectiva tasaEfectiva=null;

///insertar operacion factoring
public String insertarOperacion() {
    if (this.factura!=null && this.descuento!=null) {
        calcularDias();
        if (tasaEfectiva != null) {
            convertirTasaEfectivaEfectiva();
        } else if (tasaNominal != null) {
            convertirTasaNominalEfectiva();
        }
        OperacionFactoring operacionFactoring = new OperacionFactoring();
        operacionFactoring.setFechaOperacion(new Date());
        operacionFactoring.setTasaInteresAplicada(this.tep);
        operacionFactoring.setMontoPago(calcularMontoDescuentoPago());
        operacionFactoring.setMontoDescuento(this.montoDescuento);
        operacionFactoring.setFacturaOperacion(factura);
        operacionFactoring.setDescuentoOperacion(descuento);
        ///creamos la operacion para la factura
        operacionFactoring = operacionFactoringRepository.save(operacionFactoring);
        ///creamos la tcea de la operacion
        tceaOperacionService.IngresarTceaOperacion(this.diasFactura, this.factura.getMontoTotal(), operacionFactoring);
        ///cramos la notificacion de la operacion
        notificacionClienteService.enviarNotificacionCliente(operacionFactoring);
        ///despues de realizado la operacion volvemos null a factura, descuento, comision, tasaNominal, tasaEfectiva para su uso en futuras operaciones
        this.factura=null; this.descuento=null; this.comision=null; this.tasaNominal=null; this.tasaEfectiva=null;
        return "Se ingreso correctamente la operacion";
    }
    else {
        return "no se puedo crear ninguna operacion";
    }
}

///recepcionmos la factura creado al instante
public void recepcionarFactura(Factura factura) {
    this.factura=factura;
}
///recepcionamos el descuento creado al instante
public void recepcionarDescuento(Descuento descuento) {
    this.descuento=descuento;
    this.comision= descuento.getComisionDescuento();
    this.tasaNominal= descuento.getTasaNominalDescuento();
    this.tasaEfectiva= descuento.getTasaEfectivaDescuento();
}

///Calculo de dias Factura
private void calcularDias() {
/// Convertimos las fechas de Date a LocalDate
LocalDate fechaInicio = this.factura.getFechaEmision().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
LocalDate fechaFin = this.factura.getFechaVencimiento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
/// Calculamos la diferencia en días
this.diasFactura =(int) ChronoUnit.DAYS.between(fechaInicio, fechaFin);
}

///Calculo las tasas a TEP
private void convertirTasaEfectivaEfectiva() {
    Periodo periodo = periodoRepository.findByPlazoTasa(tasaEfectiva.getPlazo());
    this.tep= (Math.pow(1 +this.tasaEfectiva.getTasaInteres(), (double) diasFactura / periodo.getPlazoDIas()))-1;
}
private void convertirTasaNominalEfectiva() {
    Periodo periodo = periodoRepository.findByPlazoTasa(tasaNominal.getPlazo());
    Periodo periodoCapitalizable = periodoRepository.findByPlazoTasa(tasaNominal.getCapitalizable());
    ///calcular m y n
    double m = (double) periodo.getPlazoDIas() /periodoCapitalizable.getPlazoDIas();
    double n= (double) this.diasFactura/periodoCapitalizable.getPlazoDIas();
    ///calcular tep
    this.tep=(Math.pow(1+(this.tasaNominal.getTasaInteres()/m),n))-1;
}

///Calculo TEPdescuento
private double calcularTasaDescuento(){ return (this.tep)/(1+this.tep);}

///Realizamos el calculo de la operacion de la factura
private double calcularMontoDescuentoPago() {
double montoDescuentoTasa = this.factura.getMontoTotal() * calcularTasaDescuento();
this.montoDescuento = montoDescuentoTasa + this.comision.getEnvio() + this.comision.getSeguro() + ( this.factura.getMontoTotal() * this.comision.getRetencion() );
return this.factura.getMontoTotal() - this.montoDescuento;
}


///listar operacion por factura
public OperacionFactoring listaroperacionPorFactura(Integer idFactura) {
    return operacionFactoringRepository.operacionFactura(idFactura);
}

///listar operacion por cliente
public List<OperacionFactoring> listaroperacionPorCliente(String ruc) {
    return operacionFactoringRepository.operacionesCliente(ruc);
}

}