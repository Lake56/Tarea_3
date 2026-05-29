package frontend;

import java.awt.*;
import java.util.ArrayList;

public class PanelComprador {
    private int x;
    private int y;
    private int ancho;
    private int alto;

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

    /*
    Todo:
    * Terminar visual del inventario
    * Secuencia de estados ciclicos
    * Terminar metodo click con la logica
     */

    public PanelComprador(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;

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

    public void paintComponent(Graphics g) {
        g.setColor(new Color(190, 190, 190));
        g.fillRect(x, y, ancho, alto);

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
        g.fillRect(x + 20, y + 350, 260, 75); // Fondo gris del monedero

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
                System.out.println("Moneda de 100 ingresada.");
                estado = 1;
            }
            else if (botonMoneda500.contiene(ejeX, ejeY)) {
                System.out.println("Moneda de 500 ingresada.");
                estado = 1;
            }
            else if (botonMoneda1000.contiene(ejeX, ejeY)) {
                System.out.println("Moneda de 1000 ingresada.");
                estado = 1;
            }
            else {
                System.out.println("Primero debes ingresar una moneda.");
            }
        }

        else if (estado == 1) {
            if (botonCoca.contiene(ejeX, ejeY)) {
                System.out.println("Coca Cola seleccionada. Procesando...");
                // Llamar metodo comprarProducto()
                estado = 2;
            }
            else if (botonSprite.contiene(ejeX, ejeY)) {
                System.out.println("Sprite seleccionada. Procesando...");
                // Llamar metodo comprarProducto()

                estado = 2;
            }
            else if (botonFanta.contiene(ejeX, ejeY)) {
                System.out.println("Fanta seleccionada. Procesando...");
                // Llamar metodo comprarProducto()
                estado = 2;
            }
            else if (botonSnickers.contiene(ejeX, ejeY)) {
                System.out.println("Snickers seleccionados. Procesando...");
                // Llamar metodo comprarProducto()
                estado = 2;
            }
            else if (botonSuper8.contiene(ejeX, ejeY)) {
                System.out.println("Super8 seleccionado. Procesando...");
                // Llamar metodo comprarProducto()
                estado = 2;
            }
            else {
                System.out.println("Selecciona un producto.");
            }
        }
        else if (estado == 2) {
            if (botonRePro.contiene(ejeX, ejeY)) {
                System.out.println("Recogiendo producto del depósito...");

                // Agregar producto visual a lista de producto

                estado = 3;
            }
            else if (botonReVue.contiene(ejeX, ejeY)) {
                System.out.println("ACCIÓN INVÁLIDA: Saca tu bebida primero.");
            }
            else {
                System.out.println("Debes recoger tu compra para continuar.");
            }
        }

        else if (estado == 3) {
            if (botonReVue.contiene(ejeX, ejeY)) {
                System.out.println("Recogiendo vuelto del depósito...");

                // Agregar las monedas de monedero después

                estado = 0;
            }
            else if (botonRePro.contiene(ejeX, ejeY)) {
                System.out.println("Ya sacaste tu bebida, saca tu vuelto.");
            }
            else {
                System.out.println("Debes recoger tu vuelto para finalizar.");
            }
        }
    }
}
