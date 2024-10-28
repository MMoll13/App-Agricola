package gestionAppAgricola;

public class Aplicacion {
private Usuario usuario;
private Convocatoria convocatoria;
private String estado; // "Pendiente", "Aceptada", "Rechazada"

public Aplicacion(Usuario usuario, Convocatoria convocatoria) {
this.usuario = usuario;
this.convocatoria = convocatoria;
this.estado = "Pendiente"; // Inicialmente la aplicación está pendiente
 }

public Usuario getUsuario() {
return usuario;
}

public Convocatoria getConvocatoria() {
return convocatoria;
}

public String getEstado() {
return estado;
}

public void aceptar() {
estado = "Aceptada";
}

public void rechazar() {
estado = "Rechazada";
}
}

