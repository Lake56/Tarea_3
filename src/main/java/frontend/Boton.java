package frontend;

import java.awt.*;

public class Boton {
    private int x;
    private int y;
    private int ancho;
    private int alto;
    private String texto;
    private Color color;

    public Boton(int x, int y, int ancho, int alto, String texto, Color color) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.texto = texto;
        this.color = color;
    }

    public void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, ancho, alto);

        g.setColor(Color.BLACK);
        g.drawRect(x, y,  ancho, alto);

        g.setColor(Color.WHITE);
        g.drawString(texto, x + 30, y + (alto / 2) + 5);
    }

    public boolean contiene(int ejeX, int ejeY) {
        if(ejeX >= x && ejeX <= (x + ancho) && ejeY >= y && ejeY <= (y + alto)) {
            return true;
        }
        else {
            return false;
        }
    }
}
