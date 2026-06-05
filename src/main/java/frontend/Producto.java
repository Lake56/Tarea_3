package frontend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Producto {
    private String sabor;
    private String serie;
    private int x;
    private int y;

    private int ancho;
    private int alto;

    private Image imagen;

    public Producto(String sabor, String serie) {
        this.sabor = sabor;
        this.serie = serie;

        if(sabor.equals("Super8")) {
            this.ancho = 75;
            this.alto = 45;
        }
        else if (sabor.equals("Snickers")) {
            this.ancho = 75;
            this.alto = 65;
        }
        else if(sabor.equals("Sprite")) {
            this.ancho = 130;
            this.alto = 80;
        }
        else {
            this.ancho = 75;
            this.alto = 75;
        }

        cargarImagen();
    }

    private void cargarImagen() {
        String ruta = "";

        if (sabor.equals("Coca Cola")) {
            ruta = "/cocacola.png";
        } else if (sabor.equals("Sprite")) {
            ruta = "/sprite.png";
        } else if (sabor.equals("Fanta")) {
            ruta = "/fanta.png";
        } else if (sabor.equals("Snickers")) {
            ruta = "/snickers.png";
        } else if (sabor.equals("Super8")) {
            ruta = "/super8.png";
        }

        try {
            java.net.URL url = getClass().getResource(ruta);

            if (url != null) {
                ImageIcon icon = new ImageIcon(url);

                this.imagen = icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
            } else {
                System.out.print("Java no ha encontrado el archivo " + ruta);
            }
        } catch (Exception e) {
            System.out.println("Error  " + e.getMessage());
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAncho() {
        return this.ancho;
    }

    public void paintComponent(Graphics g) {
        if (imagen != null) {
            g.drawImage(imagen, x, y, null);
        } else {
            if (sabor.equals("Coca Cola")) {
                g.setColor(Color.RED);
            }
            else if (sabor.equals("Sprite")) {
                g.setColor(Color.GREEN);
            }
            else if (sabor.equals("Fanta")) {
                g.setColor(Color.ORANGE);
            }
            else if (sabor.equals("Snickers")) {
                g.setColor(new Color(139, 69, 19));
            }
            else {
                g.setColor(Color.DARK_GRAY);
            }

            g.fillRect(x, y, 45, 55);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, 45, 55);
        }

        g.setColor(Color.WHITE);
        g.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 10));

        g.setColor(Color.BLACK);
        g.drawString(serie, x + 2, y + 71);
        g.setColor(Color.WHITE);
        g.drawString(serie, x + 3, y + 70);
    }
}