import java.util.Scanner;
import servicio.ProductoServicio;


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

            switch (opcion) {
                case 1:
                    // Lógica para agregar
                    // valido inputs y creo el producto
                    ProductoServicio.guardar(scanner);
                    break;
                case 2:
                    // Lógica para listar productos
                    break;
                case 3:
                    // Lógica para buscar o actualizar
                    break;
                case 4:
                    // Lógica para eliminar
                    break;
                case 5:
                    // Lógica para crear
                    break;
                case 6:
                    // Lógica para listar pedidos
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }

        } while (opcion != 7);

        scanner.close();
    }
}


