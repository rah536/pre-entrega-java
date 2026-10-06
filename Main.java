import java.util.Scanner;
import servicio.ProductoServicio;
import exception.ProductoNoEncontradoException;
import exception.StockInsuficienteException;

public class Main {
    public static void main(String[] args) {

        //Menu
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("*****************************");
            System.out.println("SISTEMA DE GESTIÓN - TECHLAB ");
            System.out.println("_____________________________");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Listar Productos");
            System.out.println("3. Buscar o Actualizar Producto");
            System.out.println("4. Eliminar Producto");
            System.out.println("5. Crear Pedido");
            System.out.println("6. Listar Pedidos");
            System.out.println("7. Salir");
            System.out.println("'''''''''''''''''''''''''''''");
            System.out.print("Elija una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); //Limpia el buffer del enter luego de elegir una opción

            try {
                switch (opcion) {
                    case 1:
                        ProductoServicio.guardar(scanner);
                        break;
                    case 2:
                        ProductoServicio.mostrarProductos(scanner);
                        break;
                    case 3:
                        ProductoServicio.mostrarProducto(scanner);
                        break;
                    case 4:
                        // Actualizar un producto
                        ProductoServicio.actualizarProducto(scanner);
                        break;
                    case 5:
                        // Eliminar un producto
                        break;
                    case 6:
                        // Lógica para crear pedidos
                        break;
                    case 7:
                        // Lógica para listar pedidos
                        break;
                    case 8:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Por favor, elija una opción válida.");
                }

            } catch (ProductoNoEncontradoException | StockInsuficienteException e) {
                // capturamos las excepciones personalizadas
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                // Validador de datos genericos invalidos
                // (nombre,precio negativo,etc...)
                System.out.println(e.getMessage());
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Tipo de dato inválido. Por favor, ingrese un número.");
                scanner.nextLine();
            }

        } while (opcion != 7);

        scanner.close();
    }
}


