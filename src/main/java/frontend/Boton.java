package frontend;

import java.awt.*;

public class Boton{
    /**
     * Se crea un boton que sera dibujado en la interfaz
     * detectando el click
     */
    private int x;
    private int y;
    private int ancho;
    private int alto;
    private String texto;
    private Color color;

    /**
     * Se crea el boton con su posicion, ancho, alto, color y el texto que contendra
     * @param x coordenada x
     * @param y coordenada y
     * @param ancho del boton
     * @param alto del boton
     * @param texto a mostrar
     * @param color del boton
     */
    public Boton(int x, int y, int ancho, int alto, String texto, Color color) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.texto = texto;
        this.color = color;
    }

    /**
     * Se dibuja el boton en la interfaz y se pide su contexto grafico
     * @param g contexto grafico
     */
    public void paintComponent(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, ancho, alto);

        g.setColor(Color.BLACK);
        g.drawRect(x, y,  ancho, alto);

        g.setColor(Color.WHITE);

        FontMetrics metrics = g.getFontMetrics();

        int anchoTexto = metrics.stringWidth(texto);
        int altoTexto = metrics.getAscent();

        int centroX = this.x + (this.ancho - anchoTexto) / 2;
        int centroY = this.y + (this.alto + altoTexto) / 2;

        g.drawString(texto, centroX, centroY);
    }

    /**
     * Comprueba que el boton este dentro de los limites
     * @param ejeX
     * @param ejeY
     * @return true si las coordenadas estan dentro de los limites,
     * caso contario retorna false si las coordenadas estan fuera de los limites
     */
    public boolean contiene(int ejeX, int ejeY) {
        if(ejeX >= x && ejeX <= (x + ancho) && ejeY >= y && ejeY <= (y + alto)) {
            return true;
        }
        else {
            return false;
        }
    }
}
