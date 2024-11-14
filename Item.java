package gestionAppAgricola;

public class Item {

private int idItem;
private String nombreProducto;
private String descripcion;
private float precio;
private Usuario id;
private int cantidad;


public  Item(int idItem, String nombreProducto, String descripcion, float precio, Usuario id, int cantidad) {
this.idItem = idItem;
this.nombreProducto = nombreProducto;
this.descripcion = descripcion;
this.precio = precio;
this.cantidad = cantidad;
}

 // Getters y Setters

public void setIdItem (int idItem) {this.idItem = idItem;}

 public int getID() {
    return idItem;
}


public String getNombreProducto() {

    return nombreProducto;
}

public void setNombreProducto(String nombreProducto) {
this.nombreProducto = nombreProducto;
}

public String getDescripcion() {
return descripcion;
}

public void setDescripcion(String descripcion) {
this.descripcion = descripcion;
}

public float getPrecio() {
return precio;
}

public void setPrecio(float precio) {
if (precio >= 0) { 
this.precio = precio;
} else {
System.out.println("El precio no puede ser negativo"); //Para asegurar que el precio siempre sea positivo
}
}

public Usuario getProductor() {
return id;
}

public int getCantidad() {
return cantidad;
}

public void setCantidad(int cantidad) {
if (cantidad >= 0) { 
this.cantidad = cantidad;
} else {
System.out.println("La cantidad no puede ser negativa"); //Para asegurar que la cantidad nunca sea 0 o menor.
}
}

 
@Override
public String toString() {  //Para representar el objeto como texto
        return "Item ID = " + idItem + '\'' +
                "\nNombre del Producto = '" + nombreProducto + '\'' +
                "\nDescripción = '" + descripcion + '\'' +
                "\nPrecio = " + precio + '\'' +
                "\nProductor = " + id.getNombre() + '\'' +
                "\nCantidad = " + cantidad;
    }
}

