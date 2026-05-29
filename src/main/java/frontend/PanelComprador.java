package frontend;

import java.awt.*;

public class PanelComprador {
    private int x;
    private int y;
    private int ancho;
    private int alto;

    public PanelComprador(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }

    public void paintComponent(Graphics g) {
        g.setColor(new Color(190, 190, 190));
        g.fillRect(x, y, ancho, alto);
    }
}
