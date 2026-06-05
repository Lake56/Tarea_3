package frontend;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelComprador extends JPanel {
    final private int x = 0;
    final private int y = 0;

    private int estado = 0;

    private Boton botonCoca;
    private Boton botonSprite;
    private Boton botonFanta;
    private Boton botonSnickers;
    private Boton botonSuper8;

    private Boton botonMoneda100;
    private Boton botonMoneda500;
    private Boton botonMoneda1000;

    private Boton botonRePro;
    private Boton botonReVue;

    private ArrayList<Moneda> monedas;
    private ArrayList<Producto> inventario;

    private PanelExpendedor expendedor;
    private Moneda moneda;


    public PanelComprador(PanelExpendedor expendedor) {
        this.expendedor = expendedor;

        this.estado = 0;

        this.botonCoca = new Boton(x + 20, y + 40, 120, 35, "Coca Cola", Color.RED);
        this.botonSprite = new Boton(x + 160, y + 40, 120, 35, "Sprite", Color.GREEN);
        this.botonFanta = new Boton(x + 20, y + 90, 120, 35, "Fanta", Color.ORANGE);
        this.botonSnickers = new Boton(x + 160, y + 90, 120, 35, "Snickers", Color.BLUE);
        this.botonSuper8 = new Boton(x + 90, y + 140, 120, 35, "Super8", Color.BLACK);

        this.botonMoneda100 = new Boton(x + 40, y + 225, 100, 35, "100 Pesos", Color.GRAY);
        this.botonMoneda500 = new Boton(x + 160, y + 225, 100, 35, "500 Pesos", Color.GRAY);
        this.botonMoneda1000 = new Boton(x + 100, y + 270, 100, 35, "1000 Pesos", Color.GRAY);

        this.botonRePro = new Boton(x + 20, y + 575, 120, 35, "Recoger Producto", Color.GRAY);
        this.botonReVue = new Boton(x + 160, y + 575, 120, 35, "Recoger Vuelto", Color.GRAY);

        this.monedas = new ArrayList<>();
        this.inventario = new ArrayList<>();

        monedas.add(new Moneda(100, "M-001"));
        monedas.add(new Moneda(100, "M-002"));
        monedas.add(new Moneda(500, "M-003"));
        monedas.add(new Moneda(1000, "M-°004"));
        monedas.add(new Moneda(500, "M-005"));

        inventario.add(new Producto("Coca Cola", "P-001"));
        inventario.add(new Producto("Sprite", "P-002"));
        inventario.add(new Producto("Fanta", "P-003"));
        inventario.add(new Producto("Snickers", "P-004"));
        inventario.add(new Producto("Super8", "P-005"));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int ancho = this.getWidth();
        int alto = this.getHeight();

        g.setColor(new Color(190, 190, 190));
        g.fillRect(0, 0, ancho, alto);

        g.setColor(new Color(0, 102, 204)); // Azul para que resalte
        g.setFont(new Font("Arial", Font.BOLD, 13));

        String textoEstado = "";

        if (estado == 0) {
            textoEstado = "ESTADO: Por favor, ingrese una moneda";
        } else if (estado == 1) {
            textoEstado = "ESTADO: Elija un producto";
        } else if (estado == 2) {
            textoEstado = "ESTADO: Retire su producto";
        } else if (estado == 3) {
            textoEstado = "ESTADO: Retire su vuelto";
        }

        g.drawString(textoEstado, x + 15, y + 15);

        Font fuenteBoton = new Font("Arial", Font.BOLD , 12);
        Font fuenteTitulos = new Font("Arial", Font.BOLD, 18);
        Font fuenteSeries = new Font("Arial", Font.PLAIN, 8);

        g.setColor(Color.BLACK);
        g.setFont(fuenteTitulos);
        g.drawString("Productos", x + 100, y + 35);

        g.setFont(fuenteBoton);
        botonCoca.paintComponent(g);
        botonSprite.paintComponent(g);
        botonFanta.paintComponent(g);
        botonSnickers.paintComponent(g);
        botonSuper8.paintComponent(g);

        g.setColor(Color.BLACK);
        g.setFont(fuenteTitulos);
        g.drawString("Monedas", x + 110, y + 206);

        g.setFont(fuenteBoton);
        botonMoneda100.paintComponent(g);
        botonMoneda500.paintComponent(g);
        botonMoneda1000.paintComponent(g);

        g.setColor(Color.BLACK);
        g.setFont(fuenteTitulos);
        g.drawString("Monedero", x + 110, y + 335);

        g.setColor(new Color(175, 175, 175));
        g.fillRect(x + 20, y + 350, ancho - 40, 75);

        g.setFont(fuenteSeries);

        int monedaInicialX = x + 30;
        int monedaInicialY = y + 360;

        int limiteMonedas = Math.min(monedas.size(), 6);

        for (int i = 0; i < limiteMonedas; i++) {
            Moneda m = monedas.get(i);

            m.setX(monedaInicialX);
            m.setY(monedaInicialY);

            m.paintComponent(g);

            monedaInicialX += 45;

            if (monedaInicialX > (x + 20 + 260 - 40)) {
                monedaInicialX = x + 30;
                monedaInicialY += 45;
            }
        }

        g.setColor(Color.BLACK);
        g.setFont(fuenteTitulos);
        g.drawString("Inventario", x + 110, y + 460);

        g.setColor(new Color(175, 175, 175));
        g.fillRect(x + 20, y + 480, 260, 75);

        g.setColor(Color.BLACK);
        g.setFont(fuenteTitulos);
        g.drawString("Inventario", x + 110, y + 460);

        g.setColor(new Color(175, 175, 175));
        g.fillRect(x + 20, y + 480, 260, 75);

        int prodInicialX = x + 30;
        int prodInicialY = y + 490;

        int limiteProductos = Math.min(inventario.size(), 4);

        for (int i = 0; i < limiteProductos; i++) {
            Producto p = inventario.get(i);

            p.setX(prodInicialX);
            p.setY(prodInicialY);
            p.paintComponent(g);

            prodInicialX += 55;

            if (prodInicialX > (x + 20 + 260 - 45)) {
                prodInicialX = x + 30;
                prodInicialY += 65;
            }
        }

        g.setFont(fuenteBoton);
        botonRePro.paintComponent(g);
        botonReVue.paintComponent(g);
    }

    public void click(int ejeX, int ejeY) {
        if (estado == 0) {
            if (botonMoneda100.contiene(ejeX, ejeY)) {
                insertarMoneda(100);
            }
            else if (botonMoneda500.contiene(ejeX, ejeY)) {
                insertarMoneda(500);
            }
            else if (botonMoneda1000.contiene(ejeX, ejeY)) {
                insertarMoneda(1000);
            }
        }

        else if (estado == 1) {
            boolean compraExitosa = false;

            if (botonCoca.contiene(ejeX, ejeY)) {
                compraExitosa = expendedor.comprar("Coca Cola", moneda, 500);
            }
            else if (botonSprite.contiene(ejeX, ejeY)) {
                compraExitosa = expendedor.comprar("Sprite", moneda, 500);
            }
            else if (botonFanta.contiene(ejeX, ejeY)) {
                compraExitosa = expendedor.comprar("Fanta", moneda, 500);
            }
            else if (botonSnickers.contiene(ejeX, ejeY)) {
                compraExitosa = expendedor.comprar("Snickers", moneda, 600);
            }
            else if (botonSuper8.contiene(ejeX, ejeY)) {
                compraExitosa = expendedor.comprar("Super8", moneda, 300);
            }

            if (botonCoca.contiene(ejeX, ejeY) || botonSprite.contiene(ejeX, ejeY) ||
                    botonFanta.contiene(ejeX, ejeY) || botonSnickers.contiene(ejeX, ejeY) ||
                    botonSuper8.contiene(ejeX, ejeY)) {

                moneda = null;

                if (compraExitosa) {
                    estado = 2;
                    System.out.println("Retire su producto");
                } else {
                    estado = 3;
                    System.out.println("Rechazado. Retire su vuelto");
                }
            }
        }

        else if (estado == 2) {
            if (botonRePro.contiene(ejeX, ejeY)) {
                Producto p = expendedor.getProductoUnico();

                if (p != null) {
                    inventario.add(p);
                    System.out.println("Producto guardado en el inventario.");
                }

                estado = 3;
            }
        }
        else if (estado == 3) {
            if (botonReVue.contiene(ejeX, ejeY)) {

                Moneda m = expendedor.getVuelto();

                while (m != null) {
                    monedas.add(m);
                    m = expendedor.getVuelto();
                }

                System.out.println("Vuelto recogido por completo.");

                estado = 0;
            }
        }
    }

    private void insertarMoneda(int valor) {
        Moneda seleccionada = null;

        for(Moneda m : monedas) {
            if(m.getValor() == valor) {
                    seleccionada = m;
                    break;
            }
        }

        if(seleccionada != null) {
            monedas.remove(seleccionada);
            moneda = seleccionada;
            estado = 1;

            System.out.println("Moneda de " + valor + " lista para pagar. Seleccione producto.");
        } else {
            System.out.println("No tienes monedas de $" + valor + " disponibles.");
        }
    }
}
