package gestionAppAgricola;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Convocatoria {
private String tipoTrabajo;
private LocalDate fechaLimite;
private Usuario creador;
private String lugar;
private double pago;
private List<Aplicacion> aplicaciones;  // Lista de aplicaciones para esta convocatoria

public Convocatoria(String tipoTrabajo, LocalDate fechaLimiteAplicacion, Usuario creador, String lugar, double pago) {//Definimos el constructor
this.tipoTrabajo = tipoTrabajo;
this.fechaLimiteAplicacion = fechaLimiteAplicacion;
this.creador = creador;
this.lugar = lugar;
this.pago = pago;
this.aplicaciones = new ArrayList<>();
}


public void aplicar(Usuario usuario, String mensajeAplicacion) {// Método para aplicar a la convocatoria
if (LocalDate.now().isAfter(fechaLimiteAplicacion)) {
System.out.println("La convocatoria ha expirado. No se pueden recibir más aplicaciones.");
 } else {
Aplicacion nuevaAplicacion = new Aplicacion(usuario, mensajeAplicacion);
aplicaciones.add(nuevaAplicacion);
System.out.println("Aplicación enviada correctamente.");
}
}

    // Método para mostrar los detalles de la convocatoria
public void mostrarDetalles() {
System.out.println("Convocatoria de Trabajo");
System.out.println("Tipo de trabajo: " + tipoTrabajo);
System.out.println("Fecha límite para aplicar: " + fechaLimiteAplicacion);
System.out.println("Creador: " + creador.getNombre());
System.out.println("Lugar: " + lugar);
System.out.println("Pago: $" + pago);
System.out.println("Número de aplicaciones recibidas: " + aplicaciones.size());
}

