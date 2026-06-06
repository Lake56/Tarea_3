package frontend;

import javax.swing.*;

/**
 * Ventana principal de la aplicacion
 * inicializa el panel principal para las interacciones
 * entre el comprador y el expendedor
 */

public class Ventana extends JFrame {
    /**
     * Crea la ventana principal y panel principal
     * Configura su tamaño y posicion
     */
    public Ventana(){
        super("Maquina Expendedora");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(900,  700);

        this.setLocationRelativeTo(null);

        PanelPrincipal panel = new PanelPrincipal();
        this.add(panel);

        this.setVisible(true);
    }
}
