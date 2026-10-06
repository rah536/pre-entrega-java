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

        return null;
    }

    public static List<Producto> listarTodos(){
        return listaProductos;
    }

    public static Void mensajeProductoAgregadoExitoso(){
        System.out.println("*****************************");
        System.out.println("Producto agregado con éxito !");
        System.out.println("*****************************");
        System.out.println(" ");
        System.out.println("Apretar Enter para continuar...");
        return null;
    }

}
