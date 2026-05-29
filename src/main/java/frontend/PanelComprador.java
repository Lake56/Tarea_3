package frontend;

import java.awt.*;

public class PanelComprador {
    private int x;
    private int y;
    private int ancho;
    private int alto;

    private Boton botonCoca;
    private Boton botonSprite;
    private Boton botonFanta;
    private Boton botonSnickers;
    private Boton botonSuper8;

    private Boton botonMoneda100;
    private Boton botonMoneda500;
    private Boton botonMoneda1000;

    public PanelComprador(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;

        this.botonCoca = new Boton(x + 20, y + 20, 120, 35, "Coca Cola", Color.RED);
        this.botonSprite = new Boton(x + 160, y + 20, 120, 35, "Sprite", Color.GREEN);
        this.botonFanta = new Boton(x + 20, y + 70, 120, 35, "Fanta", Color.ORANGE);
        this.botonSnickers = new Boton(x + 160, y + 70, 120, 35, "Snickers", Color.BLUE);
        this.botonSuper8 = new Boton(x + 90, y + 120, 120, 35, "Super8", Color.BLACK);

        this.botonMoneda100 = new Boton(x + 50, y + 200, 200, 35, "100 Pesos", Color.GRAY);
        this.botonMoneda500 = new Boton(x + 50, y + 250, 200, 35, "500 Pesos", Color.GRAY);
        this.botonMoneda1000 = new Boton(x + 50, y + 300, 200, 35, "1000 Pesos", Color.GRAY);

    }

    public void paintComponent(Graphics g) {
        g.setColor(new Color(190, 190, 190));
        g.fillRect(x, y, ancho, alto);

        botonCoca.paintComponent(g);
        botonSprite.paintComponent(g);
        botonFanta.paintComponent(g);
        botonSnickers.paintComponent(g);
        botonSuper8.paintComponent(g);

        botonMoneda100.paintComponent(g);
        botonMoneda500.paintComponent(g);
        botonMoneda1000.paintComponent(g);
    }

    public void click(int ejeX, int ejeY) {
        if(botonCoca.contiene(ejeX, ejeY)) {
            System.out.println("Cocacola");
        }
    }
}
