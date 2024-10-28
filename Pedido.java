package  gestionAppAgricola

import java.util.Date;

public class Pedido {

private int idPedido;
private Item item;
private Date fechaPedido;
private String tipo; 
private int cantidad;
private float importe;
private Usuario usuario; 

    // Constructor
public Pedido(int idPedido, Item item, Date fechaPedido, String tipo, int cantidad, float importe, Usuario usuario) {
this.idPedido = idPedido;
this.item = item;
this.fechaPedido = fechaPedido;
this.tipo = tipo;
this.cantidad = cantidad;
this.importe = importe;
this.usuario = usuario;
}

    // Getters y Setters
public int getIdPedido() {
return idPedido;
}

public Item getItem() {
return item;
}

public void setItem(Item item) {
this.item = item;
}

public Date getFechaPedido() {
return fechaPedido;
}

public void setFechaPedido(Date fechaPedido) {
this.fechaPedido = fechaPedido;
}

public String getTipo() {
return tipo;
}

public void setTipo(String tipo) {
this.tipo = tipo;
}

public int getCantidad() {
return cantidad;
}

public void setCantidad(int cantidad) {
this.cantidad = cantidad;
}

public float getImporte() {
return importe;
}

public void setImporte(float importe) {
this.importe = importe;
}

public Usuario getUsuario() {
return usuario;
}

public void setUsuario(Usuario usuario) {
this.usuario = usuario;
}

public void calcularImporte() { //Método para calcular el importe total basado en la cantidad y el precio del item
if (item != null) {
this.importe = item.getPrecio() * cantidad;
}
}

    // Método toString para imprimir información del pedido
    @Override
    public String toString() {
        return "Pedido ID: " + idPedido +
                "\nItem: " + item.getNombre() +
                "\nFecha del Pedido: " + fechaPedido +
                "\nTipo: " + tipo +
                "\nCantidad: " + cantidad +
                "\nImporte Total: " + importe +
                "\nUsuario: " + usuario.getNombre();
    }
}

