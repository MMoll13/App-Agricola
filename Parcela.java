package gestionAppAgricola;

import java.util.ArrayList;
import java.util.List;

public class Parcela { //Definimos la clase
private String nombreParcela;
private double area;
private String tipoCultivo;
 private List<Usuario> trabajadores;

public Parcela (String nombreParcela, double area, String tipoCultivo) { //Definimos el constructor
this.nombreParcela = nombreParcela; //Datos de la parcela
this.area = area;
this.tipoCultivo = tipoCultivo;
this.trabajadores = new ArrayList<>(); // Inicializamos la lista de trabajadores
}


public void agregarTrabajador(Usuario trabajador) { //Método para añadir un trabajador a la lista
trabajadores.add(trabajador);
}

public String getDetalles() {// Método para obtener detalles de la parcela
StringBuilder detalles = new StringBuilder();
detalles.append("Nombre de la Parcela: ").append(nombreParcela)
.append(", Área: ").append(area)
.append(", Cultivo: ").append(tipoCultivo)
.append("\nTrabajadores:\n");

if (trabajadores.isEmpty()) {// Verificamos si la lista de trabajadores está vacía
detalles.append("No hay trabajadores asignados a esta parcela.\n");
} else {
for (Usuario trabajador : trabajadores) {// Añadir los trabajadores a los detalles
detalles.append(trabajador.toString()).append("\n");
}
}
return detalles.toString();
}
