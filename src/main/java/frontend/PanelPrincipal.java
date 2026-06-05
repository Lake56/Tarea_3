package frontend;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelPrincipal extends JPanel {
    private PanelComprador comprador;
    private PanelExpendedor expendedor;

    public PanelPrincipal() {
        this.setLayout(new GridLayout(1, 2));

        this.expendedor = new PanelExpendedor(4);
        this.add(expendedor);

        this.comprador = new PanelComprador();
        this.add(comprador);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                if (x >= expendedor.getX() && x <= (expendedor.getX() + expendedor.getWidth()) &&
                        y >= expendedor.getY() && y <= (expendedor.getY() + expendedor.getHeight())) {

                    int xRelExp = x - expendedor.getX();
                    int yRelExp = y - expendedor.getY();

                    expendedor.click(xRelExp, yRelExp);
                }
                else if (x >= comprador.getX() && x <= (comprador.getX() + comprador.getWidth()) &&
                        y >= comprador.getY() && y <= (comprador.getY() + comprador.getHeight())) {

                    int xRelCom = x - comprador.getX();
                    int yRelCom = y - comprador.getY();

                    comprador.click(xRelCom, yRelCom);
                }

                repaint();
            }
        });
    }
}
