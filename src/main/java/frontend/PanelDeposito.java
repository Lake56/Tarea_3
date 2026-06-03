package frontend;

import java.awt.*;
import java.util.ArrayList;

public class PanelDeposito {

    private int x;
    private int y;
    private int ancho;
    private int alto;
    private String nombre;
    private ArrayList<Producto> productos;

    public PanelDeposito(int x, int y, int ancho, int alto, String nombre) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.nombre = nombre;
        this.productos = new ArrayList<>();
    }

    public void addProducto(Producto p) {
        productos.add(p);
        reposicionar();
    }

    //obtener producto
    public Producto getProducto() {
        if (productos.isEmpty()) {
            return null;
        }
        Producto p = productos.remove(0);
        reposicionar();
        return p;
    }

    //verifica si esta vacio o no
    public boolean estaVacio() {
        return productos.isEmpty();
    }

    //reposicionar los productos
    public void reposicionar() {
        int offsetY = y + 20;
        for(int i=0; i < productos.size(); i++) {
            Producto p = productos.get(i);
            p.setX(x + (ancho-45)/2); //centrarlo
            p.setY(offsetY);
            offsetY += 62;
        }
    }
}
