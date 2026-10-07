package servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utilidad.Validador;
import modelo.Producto;

public class ProductoServicio {
    private static List<Producto> listaProductos = new ArrayList<>();

    private static int contadorId = 1;

    public static Producto validarProducto(Scanner scanner){

        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese la cantidad de stock del producto: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        Validador.validarNombre(nombre);
        Validador.validarPrecio(precio);
        Validador.validarStock(stock);

        Producto prod = new Producto(nombre, precio, stock);
        
        return prod;
    }

    public static Void guardar (Scanner scanner){
        
        Producto prod = new Producto();
        prod = validarProducto(scanner);

        prod.setId(contadorId);
        contadorId++;

        listaProductos.add(prod);
        operacionRealizadaconExito(scanner, 0);

        return null;
    }

    public static List<Producto> listarTodos(){
        return listaProductos;
    }

    public static Void operacionRealizadaconExito(Scanner scanner, int a){
        
        if (a == 0){
            System.out.println("*****************************");
            System.out.println("Producto agregado con éxito !");
            System.out.println("*****************************");
            System.out.println(" ");
            System.out.println("Apretar Enter para continuar...");
            scanner.nextLine();
        }
        else if (a == 1){
            System.out.println("*****************************");
            System.out.println("Producto actualizado con éxito !");
            System.out.println("*****************************");
            System.out.println(" ");
            System.out.println("Apretar Enter para continuar...");
            scanner.nextLine();
        }
        else if (a == 2){
            System.out.println("*****************************");
            System.out.println("Producto eliminado con éxito !");
            System.out.println("*****************************");
            System.out.println(" ");
            System.out.println("Apretar Enter para continuar...");
            scanner.nextLine();
        }

        return null;
    }

    public static Void mostrarProductos(Scanner scanner){
        System.out.println("********************");
        System.out.println("Lista de Productos:");
        System.out.println("____________________");

        if (listaProductos.isEmpty()) {
            System.out.println("Aún no hay productos registrados.");
        } else {
            // se obtiene formato mediante toString()
            listaProductos.forEach(producto -> System.out.println(producto));        
        }

        System.out.println("____________________");
        System.out.println("Apretar Enter para continuar...");
        scanner.nextLine();

        return null;
    }

    public static Void mostrarProducto(Scanner scanner){
        
        Producto producto = buscarProductoPorId(scanner);
        if (producto == null) {
            System.out.println("No se encontró el producto con el ID proporcionado.");
        } else {
            System.out.println("********************");
            System.out.println("Producto encontrado:");
            System.out.println("____________________");
            // se obtiene formato mediante toString()
            System.out.println(producto);
        }

        System.out.println("____________________");
        System.out.println("Apretar Enter para continuar...");
        scanner.nextLine();

        return null;
    }

    public static Producto buscarProductoPorId(Scanner scanner) {
        System.out.print("Ingrese el ID del producto: ");
        int id = scanner.nextInt();
        Validador.validarId(id);
        scanner.nextLine();

        for (Producto producto : listaProductos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null; // Retorna null si no se encuentra el producto
    }

    public static Void actualizarProducto(Scanner scanner) {
        Producto producto = buscarProductoPorId(scanner);

        if (producto == null) {
            System.out.println("No se encontró el producto con el ID proporcionado.");
            System.out.println("Apretar Enter para continuar...");
            scanner.nextLine();
            return null;
        }
        Producto prod = new Producto();
        prod = validarProducto(scanner);//trae un producto con los datos validados
        //seteo de los valores actualizados en el producto existente
        producto.setNombre(prod.getNombre());
        producto.setPrecio(prod.getPrecio());
        producto.setStock(prod.getStock());

        operacionRealizadaconExito(scanner, 1);
        return null;
    }

    public static Void eliminarProducto(Scanner scanner){
        Producto producto = buscarProductoPorId(scanner);
        
        if (producto == null) {
            System.out.println("No se encontró el producto con el ID proporcionado.");
            System.out.println("Apretar Enter para continuar...");
            scanner.nextLine();
            return null;
        }

        listaProductos.remove(producto);
        operacionRealizadaconExito(scanner, 2);
        return null;
    }
}
