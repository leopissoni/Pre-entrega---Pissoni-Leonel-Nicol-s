public class Pedido {
    private int cont = 1;
    private int idPed;
    private double total;

    private ArrayList<Producto> lista;

    public Pedido() {
        this.idPed = cont;
        cont = cont + 1;
        this.lista = new ArrayList<Producto>();
        this.total = 0;
    }

    public void cargar(Producto p) {
        lista.add(p);
        this.total = this.total + p.getPre();
    }

    public void mostrarTicket() {
        System.out.println("\n TICKET NRO: " + idPed);
        if (lista.isEmpty()) {
            System.out.println("El pedido está vacío");
        } else {
            for (int i = 0; i < lista.size(); i = i + 1) {
                Producto prod = lista.get(i);
                System.out.println("- " + prod.getNom() + " ($" + prod.getPre() + ")");
            }
        }
        System.out.println(" TOTAL PEDIDO: $" + total);
        
    }
}