package frontend;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelDeposito extends JPanel {
    private String nombre;
    private ArrayList<Producto> productos;

    public PanelDeposito(String nombre) {
        this.nombre = nombre;
        this.productos = new ArrayList<>();
    }

    public void addProducto(Producto p) {
        productos.add(p);
        reposicionar();
        repaint();
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
        int offsetY = 20;

        for (Producto p : productos) {
            p.setY(offsetY);
            offsetY += 100;
        }
    }

    //dibuja los depositos de los productos
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int ancho = this.getWidth();
        int alto = this.getHeight();

        g.setColor(Color.GRAY);
        g.fillRect(0, 0, ancho, alto);

        g.setColor(Color.DARK_GRAY);
        g.drawRect(0, 0, ancho - 1, alto - 1);

        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 10));
        g.drawString(nombre, 5, 12);

        for (Producto p : productos) {
            p.setX((ancho - p.getAncho()) / 2);

            p.paintComponent(g);
        }
    }
}
