package frontend;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelPrincipal extends JPanel {
    private PanelComprador comprador;

    public PanelPrincipal() {
        this.comprador = new PanelComprador(450, 20, 300, 530);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                comprador.click(e.getX(), e.getY());

                repaint();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(comprador != null) {
            comprador.paintComponent(g);
        }
    }
}
