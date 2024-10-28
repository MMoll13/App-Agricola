package gestionAppAgricola;

import gestionAppAgricola.Convocatoria;
import gestionAppAgricola.Parcela;
import gestionAppAgricola.Item;
import gestionAppAgricola.Usuario;
import gestionAppAgricola.Pedido;
import gestionAppAgricola.Aplicacion;

import java.util.Scanner;

public class GestionAppAgricola { //Definimos la clase principal
public static void main (String [] args) {
Scanner scanner = new Scanner(System.in);

AppAgricola app = new AppAgricola ("ProDeA");
boolean ejecutar = true;

while (ejecutar) { //Menu principal. Aqui se verán las principales opciones, las cuales permiten modificar/agregar inforamcioń de la cuenta, tambien salir  o eliminarla, hacer pedidos (o ver/cancelar/rechazar/aceptar), etc... Comentaré para que no haya confusion
System.out.println("_______________________________");
System.out.println("MENU PRINCIPAL - ProDeA");
System.out.println("_______________________________");
System.out.println("1 - Administrar Cuenta");
System.out.println("2 - Pedidos");
System.out.println("3 - Administrar Parcelas");
System.out.println("4 - Convocatoria");
System.out.println("5 - Items");
System.out.print("Elige una opción: ");

 int opcion = scanner.nextInt();

switch (opcion) {

case 1 -> {

boolean enAdmiCuenta = true;

while (enAdmiCuenta){ //Submenu de la cuenta

System.out.println("_______________________________");
System.out.println("MENÚ DE ADMINISTRACIÓN DE CUENTA");
System.out.println("_______________________________");
System.out.println("1 - Modificar información"); //Agregar/eliminar información de la cuenta, tales como correo o numero de telefono.
System.out.println("2 - Salir de la cuenta"); //Pues eso, salir de la cuenta para iniciar sesion en otra, o volver a iniciar sesion
System.out.println("3 -  Eliminar cuenta");//Esta opcion eliminará la cuenta. Se puede ver a futuro para que la información almacenada esté en el sistema por un periodo de tiempo limitado, en caso de que aya sido accidental o de que no haya sido el propio usuario
System.out.println("4 - Volver al Menú Principal");//Se vuelve una opción atras
System.out.print("Elige una opción: ");

int opcionAdmiCuenta = scanner.nextInt();

switch (opcionAdmiCuenta){

case 1 -> {
System.out.println("Modificar información de la cuenta:");
        
System.out.print("Ingrese su nuevo correo: ");
String nuevoCorreo = scanner.nextLine();
usuario.setCorreo(nuevoCorreo);

System.out.print("Ingrese su nuevo número de teléfono: ");
String nuevoTelefono = scanner.nextLine();
usuario.setTelefono(nuevoTelefono);

System.out.println("Información actualizada con éxito."); // Confirmación de la modificación
System.out.println("Nuevo Correo: " + nuevoCorreo);
System.out.println("Nuevo Número de Teléfono: " + nuevoTelefono);
}
}


case 2 ->{ 
System.out.println ("Saliendo..."); //El usuario sale de la aplicación.
ejecutando = false;
}

case 3 -> {
System.out.println("¿Está seguro que desea eliminar su cuenta? (S/N)"); //Mensaje preventivo, en caso de que la opción haya sido pulsada por accidente.
scanner.nextLine(); // Limpiar el buffer de entrada.
String confirmacion = scanner.nextLine(); //confirmaciónen caso de pulsar S.
if (confirmacion.equalsIgnoreCase("S")) {
System.out.println("Cuenta eliminada."); //ver a futuro como conservar los datos por un tiempo limitado, en caso de que la cuenta haya sido borrada por un tercero no autorizado.
enAdmiCuenta = false;
} else {
System.out.println("Operación cancelada."); //en caso de pulsar N.
}
}

case 4 -> {
System.out.println("Regresando al Menú Principal...");
enAdmiCuenta = false;
}
default -> System.out.println("Opción no válida, intenta nuevamente."); //En caso de entrar una opción inexistente, el sistema mostrará este mensaje.
}
}
}

case 2 -> {

boolean enPedidos = true;

while (enPedidos) { // Submenú de Pedidos
System.out.println("_______________________________");
System.out.println("MENÚ DE PEDIDOS");
System.out.println("_______________________________");
System.out.println("1 - Hacer Pedido"); //Con esta opción, el usuario podrá realizar un pedido a un productor, y esperar a que este acepte/rechaze su petición
System.out.println("2 - Mis Pedidos");//Si el usuario ya hizo pedidos, estos quedan almacenados a la espera de confirmación, o si ya fueron aceptados/rechazados, se visualiza su estado.
System.out.println("3 - Cancelar Pedido");//Solo el usuario que realizo el pedido puede cancelarlo si está a la espera.
System.out.println("4 - Volver al Menú Principal");//Se vuelve una opción atras
System.out.print("Elige una opción: ");
                        
int opcionPedido = scanner.nextInt();

switch (opcionPedido) {
case 1 -> {
 scanner.nextLine(); // Consumir la línea en blanco
System.out.print("Ingrese el nombre del producto: ");
String Item = scanner.nextLine();
System.out.print("Ingrese la cantidad: ");
int cantidad = scanner.nextInt();

boolean pedidoExitoso = pedido.hacerPedido(producto, cantidad);
if (pedidoExitoso) {
System.out.println("Pedido realizado con éxito.");
} else {
System.out.println("Error al realizar el pedido. Verifique el inventario.");
}
}
case 2 -> {
System.out.println("Mis Pedidos:");
pedido.verPedidos();
}

case 3 -> {

System.out.print("Ingrese el ID del pedido a cancelar: ");

int idPedido = scanner.nextInt();
                                
boolean cancelado = pedidoManager.cancelarPedido(idPedido);
if (cancelado) {
System.out.println("Pedido cancelado exitosamente.");
} else {
System.out.println("No se encontró un pedido con ese ID.");
}
}

case 4 -> {
System.out.println("Regresando al Menú Principal...");
enPedidos = false;
}
default -> System.out.println("Opción no válida, intenta nuevamente."); //En caso de entrar una opción inexistente, el sistema mostrará este mensaje.
}
}
}

case 3 -> {

boolean enAdmiParcela = true;

while (enAdmiParcela){  //Submenú de parcelas

System.out.println("_______________________________");
System.out.println("MENÚ DE PARCELAS");
System.out.println("_______________________________");
System.out.println("1 - Agregar parcela"); //El usuario agrega parcelas con la información correpondiente de ellas (Tamaño, ubicación, cultivos en ella y cantidad de trabajadores, si los hay).
System.out.println("2 - Ver Parcelas");//La informacioń previamente dicha, se pude modificar.
System.out.println("3 - Eliminar parcela");//En caso de que una parcela se venda o por cualquier otro motivo, el usuario la elimina de la información de su cuenta.
System.out.println("4 - Volver al Menú Principal");//Se vuelve una opción atras
System.out.print("Elige una opción: ");

int opcionParcela = scanner.netxInt();

switch (opcionParcela){

case 1 ->{ 
System.out.println("Agregar nueva parcela:");

System.out.print("Nombre de la parcela: ");
String nombre = scanner.nextLine();

System.out.print("Área de la parcela (en hectáreas): ");
double area = scanner.nextDouble();
scanner.nextLine(); // Limpiar el buffer

System.out.print("Tipo de cultivo: ");
String tipoCultivo = scanner.nextLine();

Parcela nuevaParcela = new Parcela(nombre, area, tipoCultivo); //Crear y agregar la parcela a la lista
parcela.add(nuevaParcela);
System.out.println("Parcela agregada con éxito.");
}

case 2 ->{
if (parcela.isEmpty()) {
System.out.println("No hay parcelas registradas.");
} else {
System.out.println("Lista de Parcelas:");
for (Parcela parcela : parcela) {
System.out.println(parcela.getDetalles());
}
}
}


case 3 ->{
if (parcela.isEmpty()) {
System.out.println("No hay parcelas para eliminar."); //Si el usuario no registra parcelas, este mensaje se mostrará.
return;
}

System.out.println("Ingrese el nombre de la parcela a eliminar:"); //Selecciona parcela a eliminar.
String nombreParcela = scanner.nextLine();

boolean encontrada = false;
for (Parcela parcela : parcelas) {
if (parcela.getNombreParcela().equalsIgnoreCase(nombreParcela)) {
parcelas.remove(parcela);
System.out.println("Parcela eliminada con éxito."); //Se elimina la parcela.
encontrada = true;
break;
}
}

if (!encontrada) {
System.out.println("Parcela no encontrada."); //Si la parcela no existe, se mostrará este mensaje.
}

case 4 -> {
System.out.println("Regresando al Menú Principal...");
enAdmiParcela = false;
}
default -> System.out.println("Opción no válida, intenta nuevamente."); //En caso de entrar una opción inexistente, el sistema mostrará este mensaje.
}
}
}

case 4 -> {

boolean enAdmiConvo = true;

while (enAdmiConvo){//Submenú de Convocatorias

System.out.println("_______________________________");
System.out.println("MENÚ DE CONVOCATORIAS");
System.out.println("_______________________________");
System.out.println("1 - Aplicar a convocatoria"); //El usuario puede buscar las convocatorias activas y aplicar para cualquiera de estas.
System.out.println("2 - Administrar Convocatoria"); //El usuario puede crear una convocatoria o cancelar la aplicación que mandó a una estas
System.out.println("3 - Mis aplicaciones"); //El usuario puede visualizar el estado de sus aplicaciones a convocatorias, siendo estas: Aceptadas, En espera y Rechazada.
System.out.println("4 - Volver al Menú Principal");//Se vuelve una opción atras
System.out.print("Elige una opción: ");

int opcionConvo = scanner.nextInt();

switch (opcionConvo) {

case 1 ->{ 
Usuario usuario = new Usuario();
Aplicacion aplicacion = new Aplicacion(usuario, convocatoria);
convocatoria.nuevaAplicacion(aplicacion);
System.out.println("Aplicación realizada por " + usuario.getNombre() + usuario.getApellido());
}

case 2 ->{

}

case 3 ->{
aplicacion.getEstado();
}

case 4 -> {
System.out.println("Regresando al Menú Principal...");
enAdmiConvo= false;
}
default -> System.out.println("Opción no válida, intenta nuevamente."); //En caso de entrar una opción inexistente, el sistema mostrará este mensaje.
}
}
}

case 5 ->{
boolean enItem = true;

while (enItem){
System.out.println("_______________________________");
System.out.println("MENU DE ITEMS");
System.out.println("_______________________________");
System.out.println("1 - Agregar item"); //Se agrega un item para poner en venta
System.out.println("2 - Modificar item"); //Se modifica un item existente
System.out.println("3 - Eliminar item"); //Se elimina un item
System.out.println("4 - Volver al Menú Principal");//Se vuelve una opción atras
System.out.print("Elige una opción: ");

int opcionItem = scanner.nextInt();

switch (opcionItem){

case 1 -> {
System.out.println("Ingrese datos del producto a agregar: ");
    
System.out.print("Nombre del producto: ");
String nombreProducto = scanner.nextLine(); 

System.out.print("Descripción: ");
String descripcion = scanner.nextLine(); 

System.out.print("Precio: ");
float precio = scanner.nextFloat(); 

System.out.print("Cantidad: ");
int cantidad = scanner.nextInt();
scanner.nextLine();

if (precio <= 0) { 
 System.out.println("El precio no puede ser 0 o negativo."); //Comprobar que la cantidad sea correcta
return; 
}

if (cantidad <= 0) { 
System.out.println("La cantidad no puede ser 0 o negativa."); //Comprobar que la cantidad sea correcta
return; 
}

Item nuevoItem = new Item(nombreProducto, descripcion, precio, cantidad); //Crear y agregar la parcela a la lista
item.add(nuevoItem);
System.out.println("Item agregado con éxito.");

}

case 2 -> {
if (items.isEmpty()) { // Verificar si la lista de items está (o no) vacía
System.out.println("No hay items para modificar.");
break; // Salir del case si no hay items
}

System.out.println("Seleccione el ID del producto que desea modificar:"); //Se elige el producto a modificar
for (Item item : items) {
System.out.println("ID: " + item.getID() + ", Nombre: " + item.getNombreProducto());
}

int idModificar = scanner.nextInt();
scanner.nextLine(); // Limpiar el buffer de entrada


Item itemAModificar = null; //Buscar el item por ID
for (Item item : items) {
if (item.getID() == idModificar) {
itemAModificar = item;
break;
}
}

if (itemAModificar == null) {
System.out.println("Item no encontrado.");
break;  //Salir si no se encuentra el item
}

   
System.out.println("Datos actuales del producto:"); //Mostrar datos actuales
System.out.println(itemAModificar); 

System.out.print("Ingrese nuevo nombre del producto (dejar vacío para no modificar): "); // Solicitar nueva información
String nuevoNombre = scanner.nextLine();
if (!nuevoNombre.isEmpty()) {
itemAModificar.setNombreProducto(nuevoNombre);
}

System.out.print("Ingrese nueva descripción (dejar vacío para no modificar): ");
String nuevaDescripcion = scanner.nextLine();
if (!nuevaDescripcion.isEmpty()) {
itemAModificar.setDescripcion(nuevaDescripcion);
}

System.out.print("Ingrese nuevo precio (dejar en 0 para no modificar): ");
float nuevoPrecio = scanner.nextFloat();
if (nuevoPrecio > 0) {
itemAModificar.setPrecio(nuevoPrecio);
}

System.out.print("Ingrese nueva cantidad (dejar en 0 para no modificar): ");
int nuevaCantidad = scanner.nextInt();
if (nuevaCantidad > 0) {
itemAModificar.setCantidad(nuevaCantidad);
}

System.out.println("Item modificado con éxito."); //Mensaje que muestra que la informacion del producto fue modificada con exito
}


}

case 3 -> {
if (items.isEmpty()) {  //Verificar si la lista de items está (o no) vacía
System.out.println("No hay items para eliminar.");
break;  //Salir del case si no hay items
}

System.out.println("Seleccione el ID del producto que desea eliminar:");
for (Item item : items) {
System.out.println("ID: " + item.getID() + ", Nombre: " + item.getNombreProducto());
}

int idEliminar = scanner.nextInt();
scanner.nextLine();  //Limpiar el buffer de entrada

Item itemAEliminar = null;  //Buscar el item por ID
for (Item item : items) {
if (item.getID() == idEliminar) {
itemAEliminar = item;
break;
}
}

if (itemAEliminar == null) {
System.out.println("Item no encontrado.");
break; //Salir si no se encuentra el item
}


System.out.println("Está a punto de eliminar el siguiente producto:"); //Confirmación antes de eliminar
System.out.println(itemAEliminar); //Muestra los detalles del item a eliminar
System.out.print("¿Está seguro que desea eliminarlo? (S/N): ");
String confirmacion = scanner.nextLine();

if (confirmacion.equalsIgnoreCase("S")) {
items.remove(itemAEliminar); // Eliminar el item de la lista
System.out.println("Item eliminado con éxito.");
} else {
System.out.println("Operación cancelada. El item no fue eliminado.");
}

}

case 4 -> {
System.out.println("Regresando al Menú Principal...");
enAdmiConvo= false;
}
default -> System.out.println("Opción no válida, intenta nuevamente."); //En caso de entrar una opción inexistente, el sistema mostrará este mensaje.
}
}
}

scanner.close();
}
