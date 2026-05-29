package frontend;

import javax.swing.*;

public class Ventana extends JFrame {
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
