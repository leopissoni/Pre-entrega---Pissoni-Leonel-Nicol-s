
import java.util.Scanner;

public class Main {
        private static Scanner scan = new Scanner(System.in);
        private static int idAuto = 1;
        private static ArrayList<Producto> inventario = new ArrayList<Producto>();
        private static ArrayList<Pedido> historial = new ArrayList<Pedido>();

    public static void main(String[] args) {
        int op = 0;

        while (op != 7) {
            System.out.println("\n SISTEMA DE GESTIÓN DE PRODUCTOS Y PEDIDOS ");
            System.out.println("1) Agregar producto");
            System.out.println("2) Listar productos");
            System.out.println("3) Buscar/Actualizar producto");
            System.out.println("4) Eliminar producto");
            System.out.println("5) Crear un pedido");
            System.out.println("6) Listar pedidos");
            System.out.println("7) Salir");
            System.out.print("\nElija una opción para continuar: ");

            op = scan.nextInt();
            scan.nextLine(); 

            if (op == 1) {
                System.out.print("Nombre: ");
                String n = scan.nextLine();
                System.out.print("Precio: ");
                double p = scan.nextDouble();
                scan.nextLine(); 
                System.out.print("Stock: ");
                int s = scan.nextInt();
                scan.nextLine(); 

                if (p >= 0 && s >= 0) {
                    Producto nuevo = new Producto(idAuto, n, p, s);
                    inventario.add(nuevo);
                    idAuto = idAuto + 1;
                    System.out.println("Guardado");
                } else {
                    System.out.println("Error");
                }
            } else if (op == 2) {
                System.out.println("\n LISTA ");
                for (int i = 0; i < inventario.size(); i = i + 1) {
                    System.out.println(inventario.get(i).toString());
                }

            } else if (op == 3) {
                System.out.print(" Ingrese ID a buscar: ");
                int idB = scan.nextInt();
                scan.nextLine(); 
                
                Producto buscado = buscarProducto(idB);

                if (buscado != null) {
                    System.out.println("Encontrado: " + buscado);
                    System.out.print("¿Queres modificarlo? (si/no): ");
                    if (scan.nextLine().equalsIgnoreCase("si")) {
                        System.out.print("Nuevo Precio: ");
                        buscado.setPre(scan.nextDouble());
                        scan.nextLine(); 
                        System.out.print("Stock Actualizado: ");
                        buscado.setSt(scan.nextInt());
                        scan.nextLine(); 
                        System.out.println("Actualizado");
                    }
                } else {
                    System.out.println("ID no encontrado");
                }

            } else if (op == 4) {
                System.out.print("el ID a borrar: ");
                int idEliminar = scan.nextInt();
                scan.nextLine(); 

                Producto aux = buscarProducto(idEliminar);
                if (aux != null) {
                    inventario.remove(aux); 
                    System.out.println("Eliminado");
                } else {
                    System.out.println("No se encontró");
                }

            } else if (op == 5) {
                Pedido nuevoPedido = new Pedido();
                String control;

                do {
                    System.out.print("ID del producto a comprar: ");
                    int idP = scan.nextInt();
                    scan.nextLine(); 
                    
                    Producto prod = buscarProducto(idP);

                    if (prod != null) {
                        System.out.print("Cantidad: ");
                        int cant = scan.nextInt();
                        scan.nextLine(); 

                        if (cant <= prod.getSt() && cant > 0) {
                            prod.setSt(prod.getSt() - cant); 
                            
                            for (int k = 0; k < cant; k = k + 1) {
                                nuevoPedido.cargar(prod);
                            }
                            System.out.println("Agregado");
                        } else {
                            System.out.println("Error de stock");
                        }
                    } else {
                        System.out.println("Este Producto no existe");
                    }

                    System.out.print("¿Queres agregar más productos? (si/no): ");
                    control = scan.nextLine();

                } while (control.equalsIgnoreCase("si"));

                historial.add(nuevoPedido);
                nuevoPedido.mostrarTicket();

            } else if (op == 6) {
                System.out.println("\n HISTORIAL ");
                for (int i = 0; i < historial.size(); i = i + 1) {
                    historial.get(i).mostrarTicket();
                }

            } else if (op == 7) {
                System.out.println("Saliendo");
            }
        }
    }
    private static Producto buscarProducto(int id) {
        for (int i = 0; i < inventario.size(); i = i + 1) {
            Producto p = inventario.get(i);
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}