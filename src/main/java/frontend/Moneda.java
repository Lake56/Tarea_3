package frontend;

import javax.swing.*;
import java.awt.*;

public class Moneda{
    /**
     * Se representa de forma grafica una moneda
     * cargando una imagen con su valor
     * y numero de serie correspondiente
     */
    private int valor;
    private String serie;
    private int x;
    private int y;

    private Image imagen;

    /**
     * Contruye la moneda grafica con su valor y serie
     * @param valor de la moneda
     * @param serie de la moneda
     */
    public Moneda(int valor, String serie) {
        this.valor = valor;
        this.serie = serie;

        cargarImagen();
    }

    /**
     * Carga la imagen de la moneda con
     * su correspondiente valor
     * Verifica que la imagen exista
     * en caso de que no exista se ocupa una representacion grafica alternativa
     */
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

    /**
     * Dibuja la Moneda en la ventana
     * En caso de que no exista se dibuja una representacion
     * @param g contexto grafico del dibujo
     */
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

    /**
     * Actualiza la coordenada x de la moneda
     * @param x nueva posicion
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Actualiza la coordenada y de la moneda
     * @param y nueva posicion
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Obtiene el valor de la moneda
     * @return valor de la moneda
     */
    public int getValor() {
        return valor;
    }
}
