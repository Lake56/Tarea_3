package frontend;

import javax.swing.*;
import java.awt.*;

public class Moneda {
    private int valor;
    private String serie;
    private int x;
    private int y;

    private Image imagen;

    public Moneda(int valor, String serie) {
        this.valor = valor;
        this.serie = serie;

        cargarImagen();
    }

    public void cargarImagen() {
        String ruta = "";

        if (valor == 100) {
            ruta = "/moneda100.png";
        } else if (valor == 500) {
            ruta = "/moneda500.png";
        } else if (valor == 1000) {
            ruta = "/moneda1000.png";
        }

        try {
            java.net.URL url = getClass().getResource(ruta);

            if(url != null) {
                ImageIcon icon = new ImageIcon(url);
                this.imagen = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);            }
            else {
                System.out.print("Java no ha encontrado el archivo " + ruta);
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public void paintComponent(Graphics g) {
        if(imagen != null) {
            g.drawImage(imagen, x, y, null);
        }
        else {
            g.setColor(Color.YELLOW);
            g.fillOval(x, y, 40, 40);
            g.setColor(Color.BLACK);
            g.drawOval(x, y, 40, 40);
        }

        g.setColor(Color.BLACK);
        g.drawString(serie, x + 5, y + 55);
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
