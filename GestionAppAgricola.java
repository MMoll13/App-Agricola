package gestionAppAgricola;

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
System.out.print("Elige una opción: ");

 int opcion = scanner.nextInt();

switch (opcion) {

case 1 -> {

boolean enAdmiCuenta = true;

while (enAdmiCuenta){ //Entramos al submenu de la cuenta

System.out.println("_______________________________");
System.out.println("MENÚ DE ADMINISTRACIÓN DE CUENTA");
System.out.println("_______________________________");
System.out.println("1 - Modificar información"); //Agregar/eliminar información de la cuenta, tales como correo, numero de telefono o similares.
System.out.println("2 - Salir de la cuenta"); //Pues eso, salir de la cuenta para iniciar sesion en otra, o volver a iniciar sesion
System.out.println("3 -  Eliminar cuenta");//Esta opcion eliminará la cuenta. Se puede ver a futuro para que la información almacenada esté en el sistema por un periodo de tiempo limitado, en caso de que aya sido accidental o de que no haya sido el propio usuario
System.out.print("Elige una opción: ");

int opcionAdmiCuenta = scanner.nextInt();

switch (opcionAdmiCuenta){

boolean opcionAdmiCuenta = true;

case 1 -> {

System.out.println ("Modificar información");

}

case 2 ->{ 
System.out.println ("Saliendo...") //El usuario sale de la aplicación
ejecutando = false;
}

case 3 -> {
System.out.println("¿Está seguro que desea eliminar su cuenta? (S/N)"); //Mensaje preventivo, en caso de que la opción haya sido pulsada por accidente.
scanner.nextLine(); // Limpiar el buffer de entrada
String confirmacion = scanner.nextLine(); //confirmación
if (confirmacion.equalsIgnoreCase("S")) {
System.out.println("Cuenta eliminada.");
enAdmiCuenta = false;
} else {
System.out.println("Operación cancelada.");
}
}
default -> System.out.println("Opción no válida, intenta nuevamente.");
}
}
}

case 2 -> {

boolean enPedidos = true;

while (enPedidos) { // Submenú de Pedidos
System.out.println("_______________________________");
System.out.println("MENÚ DE PEDIDOS");
System.out.println("_______________________________");
System.out.println("1. Hacer Pedido");
System.out.println("2. Mis Pedidos");
System.out.println("3. Cancelar Pedido");
System.out.println("4. Volver al Menú Principal");
System.out.print("Elige una opción: ");
                        
int opcionPedido = scanner.nextInt();

switch (opcionPedido) {
case 1 -> {
                                // Lógica para hacer un pedido
System.out.println("Has seleccionado 'Hacer Pedido'.");
                                // Aquí se puede implementar la lógica para agregar un nuevo pedido
}
case 2 -> {
                                // Lógica para ver los pedidos
System.out.println("Has seleccionado 'Mis Pedidos'.");
                                // Aquí se puede implementar la lógica para listar los pedidos existentes
}
case 3 -> {
                                // Lógica para cancelar un pedido
System.out.println("Has seleccionado 'Cancelar Pedido'.");
                                // Aquí se puede implementar la lógica para cancelar un pedido
}
case 4 -> {
                                // Regresa al menú principal
System.out.println("Regresando al Menú Principal...");
enPedidos = false;
                            }
default -> System.out.println("Opción no válida, intenta nuevamente."); //En caso de entrar una opción inexistente, el sistema mostrará este mensaje.
}
}
}

case 3 -> {

boolean enAdmiParcelas = true;

while (enAdmiParcelas){



}
}
