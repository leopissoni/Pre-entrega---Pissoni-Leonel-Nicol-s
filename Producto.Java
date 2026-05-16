public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.id = id;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }
    public int getId() {
        return id;
    }
    public double getPrecio() {
        return precio;
    }
    public int getStock() {
        return stock;
    }

    public String toString() {
        return " ID: " + id + " Nombre: " + nombre + " Precio: $" + precio + " Stock: " + stock;
    }

}

    