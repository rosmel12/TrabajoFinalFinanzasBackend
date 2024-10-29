package org.example.trabajofinalfinanzasbackend.servicesinterfaces;

import org.example.trabajofinalfinanzasbackend.model.NotificacionCliente;
import org.example.trabajofinalfinanzasbackend.model.OperacionFactoring;
import org.example.trabajofinalfinanzasbackend.repositories.NotificacionClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionClienteService {
@Autowired
private NotificacionClienteRepository notificacionClienteRepository;

public void enviarNotificacionCliente(OperacionFactoring operacionFactoring) {
 NotificacionCliente notificacionCliente = new NotificacionCliente();
 notificacionCliente.setMensaje("estimado cliente su operacion fue realizada");
 notificacionCliente.setLeido(false);
 notificacionCliente.setNotificacionOperacionFactoring(operacionFactoring);
 notificacionClienteRepository.save(notificacionCliente);
    }
public String modificarEstadoNotificacionCliente( Integer id) {
  NotificacionCliente notificacionCliente = notificacionClienteRepository.findById(id).get();
  notificacionCliente.setLeido(true);
  notificacionClienteRepository.save(notificacionCliente);
  return "mensaje modificado";
}

public List<NotificacionCliente> listarNotificacionCliente(String ruc) {
    return notificacionClienteRepository.listarNotificacionCliente(ruc);
}

}
