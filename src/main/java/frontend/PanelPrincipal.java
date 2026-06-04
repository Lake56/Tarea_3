package frontend;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelPrincipal extends JPanel {
    private PanelComprador comprador;
    private PanelExpendedor exp;

    public PanelPrincipal() {
        this.exp = new PanelExpendedor(10, 10, 545, 660, 4);
        this.comprador = new PanelComprador(570, 20, 300, 630);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                exp.click(e.getX(), e.getY());
                comprador.click(e.getX(), e.getY());

                repaint();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        exp.paintComponent(g);
        if(comprador != null) {
            comprador.paintComponent(g);
        }
    }
}
