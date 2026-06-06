package frontend;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Representa de forma grafica el deposito de productos
 * Permite almacenar, retirar y visualizar los productos dentro
 * del expendedor.
 */
public class PanelDeposito extends JPanel {
    private String nombre;
    private ArrayList<Producto> productos;

    /**
     * Se crea un deposito con su nombre
     * @param nombre del deposito
     */
    public PanelDeposito(String nombre) {
        this.nombre = nombre;
        this.productos = new ArrayList<>();
    }

    /**
     * Se añaden los productos al deposito
     * y acutaliza su posicion
     * @param p producto a agregar
     */
    public void addProducto(Producto p) {
        productos.add(p);
        reposicionar();
        repaint();
    }

    /**
     * Retira el primero producto del deposito
     * @return producto o null si el deposito esta vacio
     */
    public Producto getProducto() {
        if (productos.isEmpty()) {
            return null;
        }

        Producto p = productos.remove(0);
        reposicionar();
        return p;
    }

    /**
     * Verifica que el deposito tiene productos
     * @return true si el deposito esta vacio
     * false si el deposito tiene productos
     */
    public boolean estaVacio() {
        return productos.isEmpty();
    }

    /**
     * Recalula las posiciones del producto respecto al eje y
     */
    public void reposicionar() {
        int offsetY = 20;

        for (Producto p : productos) {
            p.setY(offsetY);
            offsetY += 100;
        }
    }

    /**
     * Dibuja el deposito y sus productos
     * @param g contexto grafico del dibujo
     */
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
