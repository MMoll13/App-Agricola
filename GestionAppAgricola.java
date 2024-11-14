package gestionAppAgricola;

import java.awt.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class gestionAppAgricola {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean ejecutar = true;
        while (ejecutar) {

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

                    while (enAdmiCuenta) { //Submenu de la cuenta

                        System.out.println("_______________________________");
                        System.out.println("MENÚ DE ADMINISTRACIÓN DE CUENTA");
                        System.out.println("_______________________________");
                        System.out.println("1 - Modificar información"); //Agregar/eliminar información de la cuenta, tales como correo o numero de telefono.
                        System.out.println("2 - Salir de la cuenta"); //Pues eso, salir de la cuenta para iniciar sesion en otra, o volver a iniciar sesion
                        System.out.println("3 -  Eliminar cuenta");//Esta opcion eliminará la cuenta. Se puede ver a futuro para que la información almacenada esté en el sistema por un periodo de tiempo limitado, en caso de que aya sido accidental o de que no haya sido el propio usuario
                        System.out.println("4 - Volver al Menú Principal");//Se vuelve una opción atras
                        System.out.print("Elige una opción: ");

                        int opcionAdmiCuenta = scanner.nextInt();

                        switch (opcionAdmiCuenta) {

                            case 1 -> {
                                System.out.println("_______________________________");
                                System.out.println("MENU DE ADMINISTRACIÓN DE CUENTA");
                                System.out.println("_______________________________");
                                System.out.println("1 - Modificar información");
                                System.out.println("2 - Salir de la cuenta");
                                System.out.println("3 - Eliminar cuenta");
                                System.out.println("4 - Volver al Menú Principal");
                                System.out.println("Elige una opcion:");

                                int opcionAdmi = scanner.nextInt();

                                switch (opcionAdmi) {
                                    case 1 -> {
                                        System.out.println("Modificación de Información de cuenta");
                                        System.out.println("Ingrese su nuevo correo:");
                                        String nuevoCorreo = scanner.nextLine();
                                        Usuario.setCorreo(nuevoCorreo);

                                        System.out.println("Ingrese su nuevo número de telefono:");
                                        String nuevoTelefono = scanner.nextLine();
                                        Usuario.setTelefono(nuevoTelefono);

                                        System.out.println("Informacion actualizada con exito");
                                        System.out.println("Nuevo Correo: " + nuevoCorreo);
                                        System.out.println("Nuevo número de telefono: " + nuevoTelefono);
                                    }
                                    case 2 -> {
                                        System.out.println("Saliendo...");
                                        enAdmiCuenta = false;
                                    }
                                    case 3 -> {
                                        System.out.println("¿Estás seguro que desea eliminar su cuenta?");
                                        scanner.nextLine();
                                        String confirmacion = scanner.nextLine();
                                        if (confirmacion.equalsIgnoreCase("S")) {
                                            System.out.println("Cuenta eliminada");
                                            ejecutar = false;
                                        } else {
                                            System.out.println("Operación cancelada");
                                        }
                                    }
                                    case 4 -> {
                                        System.out.println("Regresando al menú principal");
                                        enAdmiCuenta = false;
                                    }

                                    default -> System.out.println("Opción no valida");
                                }


                            }
                        }
                    }

                }
                case 2 -> {
                    boolean enPedidos = true;

                    while (true) { // Submenú de Pedidos
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
                                scanner.nextLine();
                                System.out.println("Ingrese nombre del producto: ");
                                String item = scanner.nextLine();
                                System.out.println("Ingrese cantidad: ");
                                int cantidad = scanner.nextInt();

                                boolean pedidoExitoso = true;

                                if (pedidoExitoso) {
                                    System.out.println("Pedido realizado con exito");
                                } else {
                                    System.out.println("Error al realizar el pedido. Verifique inventario.");
                                }
                            }
                            case 2 -> {
                                System.out.println("Mis Pedidos:");
                            }
                            case 3 -> {
                            }
                            case 4 -> {
                                System.out.println("Regresando al menú principal...");
                                enPedidos = false;
                            }

                            default -> System.out.println("Opción no valida");
                        }
                    }
                }
                case 3 -> {

                    boolean enAdmiParcela = true;

                    while (enAdmiParcela) {  //Submenú de parcelas

                        System.out.println("_______________________________");
                        System.out.println("MENÚ DE PARCELAS");
                        System.out.println("_______________________________");
                        System.out.println("1 - Agregar parcela"); //El usuario agrega parcelas con la información correpondiente de ellas (Tamaño, ubicación, cultivos en ella y cantidad de trabajadores, si los hay).
                        System.out.println("2 - Ver Parcelas");//La informacioń previamente dicha, se pude modificar.
                        System.out.println("3 - Eliminar parcela");//En caso de que una parcela se venda o por cualquier otro motivo, el usuario la elimina de la información de su cuenta.
                        System.out.println("4 - Volver al Menú Principal");//Se vuelve una opción atras
                        System.out.print("Elige una opción: ");
                    }
                    int opcionParcela = Integer.parseInt(scanner.nextLine());

                    switch (opcionParcela) {

                        case 1 -> {
                            System.out.println("Agregar nueva parcela:");

                            System.out.print("Nombre de la parcela: ");
                            String nombre = scanner.nextLine();

                            System.out.print("Área de la parcela (en hectáreas): ");
                            double area = scanner.nextDouble();
                            scanner.nextLine(); // Limpiar el buffer

                            System.out.print("Tipo de cultivo: ");
                            String tipoCultivo = scanner.nextLine();

                            Parcela nuevaParcela = new Parcela(nombre, area, tipoCultivo); //Crear y agregar la parcela a la lista
                            Parcela.add(nuevaParcela);
                            System.out.println("Parcela agregada con éxito.");
                        }
                        case 2 -> {
                            if (Parcela.isEmpty()) {
                                System.out.println("No hay parcelas registradas.");
                            } else {
                                System.out.println("Lista de Parcelas:");
                                for (Parcela parcela : parcela) {
                                    System.out.println(parcela.getDetalles());
                                }
                            }
                        }


                        case 3 -> {
                            if (parcela.isEmpty()) {
                                System.out.println("No hay parcelas para eliminar."); //Si el usuario no registra parcelas, este mensaje se mostrará.
                                return;
                            }

                            System.out.println("Ingrese el nombre de la parcela a eliminar:"); //Selecciona parcela a eliminar.
                            String nombreParcela = scanner.nextLine();

                            boolean encontrada = false;
                            for (Parcela parcela : parcela) {
                                if (parcela.getNombreParcela().equalsIgnoreCase(nombreParcela)) {
                                    parcela.remove(parcela);
                                    System.out.println("Parcela eliminada con éxito."); //Se elimina la parcela.
                                    encontrada = true;
                                    break;
                                }
                            }

                            if (!encontrada) {
                                System.out.println("Parcela no encontrada."); //Si la parcela no existe, se mostrará este mensaje.
                            }
                        }

                        case 4 -> {
                            System.out.println("Regresando al Menú Principal...");
                            enAdmiParcela = false;

                        }
                        default ->
                                System.out.println("Opción no válida, intenta nuevamente."); //En caso de entrar una opción inexistente, el sistema mostrará este mensaje.
                    }

                }
                case 4 -> {

                    boolean enAdmiConvo = true;

                    while (enAdmiConvo) { // Submenú de Convocatorias

                        System.out.println("_______________________________");
                        System.out.println("MENÚ DE CONVOCATORIAS");
                        System.out.println("_______________________________");
                        System.out.println("1 - Aplicar a convocatoria"); // El usuario puede buscar las convocatorias activas y aplicar para cualquiera de estas.
                        System.out.println("2 - Administrar Convocatoria"); // El usuario puede crear una convocatoria o cancelar la aplicación que mandó a una de estas.
                        System.out.println("3 - Mis aplicaciones"); // El usuario puede visualizar el estado de sus aplicaciones a convocatorias, siendo estas: Aceptadas, En espera y Rechazada.
                        System.out.println("4 - Volver al Menú Principal"); // Se vuelve una opción atrás
                        System.out.print("Elige una opción: ");

                        int opcionConvo = scanner.nextInt();

                        switch (opcionConvo) {

                            case 1 -> {
                                Usuario usuario = new Usuario();
                                Aplicacion aplicacion = new Aplicacion(usuario, convocatoria);
                                convocatoria.nuevaAplicacion(aplicacion);
                                System.out.println("Aplicación realizada por " + usuario.getNombre() + " " + usuario.getApellido());
                                break;
                            }

                            case 2 -> {
                            }

                            case 3 -> {
                                // Llama al metodo para mostrar el estado de la aplicación
                                Aplicacion.getEstado();
                                break;
                            }

                            case 4 -> {
                                System.out.println("Regresando al Menú Principal...");
                                enAdmiConvo = false;
                                break;
                            }
                            default ->
                                    System.out.println("Opción no válida, intenta nuevamente."); // En caso de entrar una opción inexistente, el sistema mostrará este mensaje.
                        }
                    }
                }
                case 5 -> {
                    boolean enItem = true;

                    while (enItem) {
                        System.out.println("_______________________________");
                        System.out.println("MENU DE ITEMS");
                        System.out.println("_______________________________");
                        System.out.println("1 - Agregar item"); //Se agrega un item para poner en venta
                        System.out.println("2 - Modificar item"); //Se modifica un item existente
                        System.out.println("3 - Eliminar item"); //Se elimina un item
                        System.out.println("4 - Volver al Menú Principal");//Se vuelve una opción atras
                        System.out.print("Elige una opción: ");

                        int opcionItem = scanner.nextInt();

                        switch (opcionItem) {

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
                                    System.out.println("El precio no puede ser 0 o negativo."); // Comprobar que la cantidad sea correcta
                                    return;
                                }

                                if (cantidad <= 0) {
                                    System.out.println("La cantidad no puede ser 0 o negativa."); // Comprobar que la cantidad sea correcta
                                    return;
                                }

                                Item nuevoItem = new Item(nombreProducto, descripcion, precio, cantidad);
                                item.add(nuevoItem);
                                System.out.println("Item agregado con éxito.");
                            }


                            case 2 -> {
                                if (item.isEmpty()) { // Verificar si la lista de items está (o no) vacía
                                    System.out.println("No hay items para modificar.");
                                    break; // Salir del case si no hay items
                                }

                                System.out.println("Seleccione el ID del producto que desea modificar:"); //Se elige el producto a modificar
                                for (Item item : Item) {
                                    System.out.println("ID: " + item.getID() + ", Nombre: " + item.getNombreProducto());
                                }

                                int idModificar = scanner.nextInt();
                                scanner.nextLine(); // Limpiar el buffer de entrada


                                Item itemAModificar = null; //Buscar el item por ID
                                for (Item item : item) {
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
                                    break;
                                }

                                System.out.print("Ingrese nueva descripción (dejar vacío para no modificar): ");
                                String nuevaDescripcion = scanner.nextLine();
                                if (!nuevaDescripcion.isEmpty()) {
                                    itemAModificar.setDescripcion(nuevaDescripcion);
                                    break;
                                }

                                System.out.print("Ingrese nuevo precio (dejar en 0 para no modificar): ");
                                float nuevoPrecio = scanner.nextFloat();
                                if (nuevoPrecio > 0) {
                                    itemAModificar.setPrecio(nuevoPrecio);
                                    break;
                                }

                                System.out.print("Ingrese nueva cantidad (dejar en 0 para no modificar): ");
                                int nuevaCantidad = scanner.nextInt();
                                if (nuevaCantidad > 0) {
                                    itemAModificar.setCantidad(nuevaCantidad);
                                    break;
                                }

                                System.out.println("Item modificado con éxito."); //Mensaje que muestra que la informacion del producto fue modificada con exito
                            }
                            case 3 -> {
                                if (item.isEmpty()) {  //Verificar si la lista de items está (o no) vacía
                                    System.out.println("No hay items para eliminar.");
                                    break;  //Salir del case si no hay items
                                }

                                System.out.println("Seleccione el ID del producto que desea eliminar:");
                                for (Item item : itemAEliminar) {
                                    System.out.println("ID: " + item.getID() + ", Nombre: " + item.getNombreProducto());
                                }

                                int idEliminar = scanner.nextInt();
                                scanner.nextLine();  //Limpiar el buffer de entrada

                                Item itemAEliminar = null;  //Buscar el item por ID
                                for (Item item : itemAEliminar) {
                                    if (item.getID() == idEliminar) {
                                        itemAEliminar = item;
                                        break;
                                    }
                                }

                                if (itemAEliminar == null) {
                                    System.out.println("Item no encontrado.");
                                    break; // Salir si no se encuentra el item
                                }

                                // Confirmación antes de eliminar
                                System.out.println("Está a punto de eliminar el siguiente producto:");
                                System.out.println(itemAEliminar); // Muestra los detalles del item a eliminar
                                System.out.print("¿Está seguro que desea eliminarlo? (S/N): ");
                                String confirmacion = scanner.nextLine();

                                if (confirmacion.equalsIgnoreCase("S")) {
                                    item.remove(itemAEliminar); // Eliminar el item de la lista
                                    System.out.println("Item eliminado con éxito.");
                                } else {
                                    System.out.println("Operación cancelada. El item no fue eliminado.");
                                }
                            }
                            case 4 -> {
                                System.out.println("Regresando al Menú Principal...");
                                enItem = false;
                            }
                            default -> System.out.println("Opción no válida, intenta nuevamente.");
                        } //En caso de entrar una opción inexistente, el sistema mostrará este mensaje.
                    }
                }
            }
            break;


        } scanner.close(); }

    }
