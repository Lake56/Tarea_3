package frontend;

import javax.swing.JPanel;
import java.awt.Graphics;

public class PanelPrincipal extends JPanel {
    private PanelComprador comprador;

    public PanelPrincipal() {
        this.comprador = new PanelComprador(450, 50, 300, 500);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(comprador != null) {
            comprador.paintComponent(g);
        }
    }
}
