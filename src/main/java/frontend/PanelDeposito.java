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

}
