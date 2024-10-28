package gestionAppAgricola;

public class Usuario {

private int id //ID único para identificar a cada usuario, incluso si tienen mismo nombre.
private String nombre; //Datos personales del usuario.
private String apellido;
private int DNI;
private String correo;
private String telefono;
private Parcela ocupacionParcela; // Aqui indica si el usuario tiene ocupación en alguna parcela.

public Usuario(int id, String nombre, String apellido, int DNI, String email, String telefono) {

this,id = id;
this.nombre = nombre;
this.apellido = apellido;
this.DNI = DNI;
this.correo = correo;
this.telefono = telefono;
this.ocupacionParcela = null; // Inicialmente sin ocupación en una parcela
}

//getters y setters

public String getId(){
return id;
}

public String getNombre() {
return nombre;
}

public String getApellido() {
return  apellido;
}

public String get DNI() {
return  DNI;
}

public String getCorreo() {
return correo;
}

public void setCorreo(String correo) {
this.correo = correo;
}

public String getTelefono() {
return telefono;
}

public void setTelefono(String telefono) {
this.telefono = telefono;
}
    
public void mostrarInformacion() {
System.out.println("Nombre: " + nombre);
System.out.println("Apellido " + apellido);
System.out.println("DNI " + DNI);
System.out.println("Correo: " + correo);
System.out.println("Teléfono: " + telefono);
}
}
