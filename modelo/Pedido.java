package modelo;

public class Pedido {
    private Producto producto;
    private int cantidad;

    public Pedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }
}
