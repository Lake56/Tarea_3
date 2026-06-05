package frontend;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.MouseEvent;

public class PanelExpendedor extends JPanel {
    private PanelDeposito depCoca;
    private PanelDeposito depSprite;
    private PanelDeposito depFanta;
    private PanelDeposito depSnickers;
    private PanelDeposito depSuper8;
    private PanelDeposito depProductoComprado;

    private PanelDeposito depVuelto;
    private ArrayList<Moneda> monedasVuelto;
    private ArrayList<Moneda> ganancias;

    private int numProductos;
    private static int contadorSerie = 1;

    public PanelExpendedor(int numProductos) {
        this.numProductos = numProductos;
        this.monedasVuelto = new ArrayList<>();

        this.ganancias = new ArrayList<>();

        this.setBackground(new Color(91, 131, 212));
        this.setLayout(new BorderLayout(10, 10));
        this.setBorder(BorderFactory.createEmptyBorder(35, 15, 15, 15));

        JPanel panelSuperior = new JPanel(new GridLayout(1, 5, 10, 0));
        panelSuperior.setOpaque(false);

        depCoca = new PanelDeposito("Coca Cola");
        depSprite = new PanelDeposito("Sprite");
        depFanta = new PanelDeposito("Fanta");
        depSnickers = new PanelDeposito("Snickers");
        depSuper8 = new PanelDeposito("Super8");

        panelSuperior.add(depCoca);
        panelSuperior.add(depSprite);
        panelSuperior.add(depFanta);
        panelSuperior.add(depSnickers);
        panelSuperior.add(depSuper8);

        JPanel panelInferior = new JPanel(new GridLayout(1, 2, 50, 0));
        panelInferior.setOpaque(false);
        panelInferior.setPreferredSize(new Dimension(0, 120)); // Forzamos una altura de 120px

        depProductoComprado = new PanelDeposito("Producto");
        depVuelto = new PanelDeposito("Vuelto");

        panelInferior.add(depProductoComprado);
        panelInferior.add(depVuelto);

        this.add(panelSuperior, BorderLayout.CENTER);
        this.add(panelInferior, BorderLayout.SOUTH);

        inicializarProductos();
    }

    //carga con stock los depositos
    private void inicializarProductos() {
        for (int i = 0; i < numProductos; i++) {
            depCoca.addProducto(new Producto("Coca Cola", "n:" + contadorSerie++));
            depSprite.addProducto(new Producto("Sprite", "n:" + contadorSerie++));
            depFanta.addProducto(new Producto("Fanta", "n:" + contadorSerie++));
            depSnickers.addProducto(new Producto("Snickers", "n:" + contadorSerie++));
            depSuper8.addProducto(new Producto("Super8", "n:" + contadorSerie++));
        }
    }
    public void click(int ejeX, int ejeY) {
        rellenarVacios();
        repaint();
    }
    private void rellenarVacios() {
        if (depCoca.estaVacio()) {
            for (int i =0; i <numProductos; i++)
                depCoca.addProducto(new Producto("Coca Cola", "n:" + contadorSerie++));
        }
        else if (depSprite.estaVacio()) {
            for (int i =0; i <numProductos; i++)
                depSprite.addProducto(new Producto("Sprite", "n:" + contadorSerie++));
        }
        else if (depFanta.estaVacio()) {
            for (int i =0; i <numProductos; i++)
                depFanta.addProducto(new Producto("Fanta", "n:" + contadorSerie++));
        }
        else if (depSnickers.estaVacio()) {
            for (int i =0; i <numProductos; i++)
                depSnickers.addProducto(new Producto("Snickers", "n:" + contadorSerie++));
        }
        else if (depSuper8.estaVacio()) {
            for (int i =0; i <numProductos; i++)
                depSuper8.addProducto(new Producto("Super8", "n:" + contadorSerie++));
        }
    }
    //getter de depositos
    public PanelDeposito getDeposito(String nombreProducto) {
        return switch (nombreProducto) {
            case "Coca Cola" -> depCoca;
            case "Sprite" -> depSprite;
            case "Fanta" -> depFanta;
            case "Snickers" -> depSnickers;
            case "Super8" -> depSuper8;
            default -> null;
        };
    }

    //comprar producto
    public boolean comprar(String nombreProducto, Moneda moneda, int precio) {
        if (moneda==null) {
            return false;
        }

        if (moneda.getValor()< precio) {
            monedasVuelto.add(moneda);
            return false;
        }

        PanelDeposito dep = getDeposito(nombreProducto);
        if (dep==null || dep.estaVacio()) {
            monedasVuelto.add(moneda);
            return false;
        }

        Producto p = dep.getProducto();
        depProductoComprado.addProducto(p);

        ganancias.add(moneda);

        int cambio = moneda.getValor()-precio;
        int serieM = 1;

        while(cambio >= 500) {
            monedasVuelto.add(new Moneda(500, "V500-" + serieM++));
            cambio -= 500;
        }

        while (cambio >= 100) {
            monedasVuelto.add(new Moneda(100, "V100-" + serieM++));
            cambio -= 100;
        }

        repaint();

        return true;
    }

    public Producto getProductoUnico() {
        return depProductoComprado.getProducto();
    }

    public Moneda getVuelto() {
        if (monedasVuelto.isEmpty()) return null;
        return monedasVuelto.remove(0);
    }

    //pintado
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Java pinta el fondo azul

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        g.setColor(Color.WHITE);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1); // Borde general

        g.setFont(new Font("Arial", Font.BOLD, 17));
        g.drawString("Expendedor", 10, 22); // Título
    }

    @Override
    protected void paintChildren(Graphics g) {
        super.paintChildren(g);

        if(!monedasVuelto.isEmpty()) {
            Point posVuelto = SwingUtilities.convertPoint(depVuelto, 0, 0, this);

            int x = posVuelto.x + 5;
            int y = posVuelto.y + 20;

            for(int i = 0; i < Math.min(monedasVuelto.size(), 3); i++) {
                Moneda m = monedasVuelto.get(i);

                m.setX(x);
                m.setY(y);

                m.paintComponent(g);

                x += 42;
            }
        }
    }
}
