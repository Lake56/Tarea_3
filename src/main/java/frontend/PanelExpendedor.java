package frontend;

import java.awt.*;
import java.util.ArrayList;

public class PanelExpendedor {

    private int x;
    private int y;
    private int ancho;
    private int alto;

    private PanelDeposito depCoca;
    private PanelDeposito depSprite;
    private PanelDeposito depFanta;
    private PanelDeposito depSnickers;
    private PanelDeposito depSuper8;
    private PanelDeposito depProductoComprado;

    private PanelDeposito depVuelto;
    private ArrayList<Moneda> monedasVuelto;

    private int numProductos;
    private static int contadorSerie = 1;

    public PanelExpendedor(int x, int y, int ancho, int alto, int numProductos) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.numProductos = numProductos;
        this.monedasVuelto = new ArrayList<>();

        int depAncho = 80;
        int depAlto = alto-120;
        int margen = 15;
        int brecha = 10;

        depCoca = new PanelDeposito(x+ margen,y + 35, depAncho, depAlto, "Coca Cola");
        depSprite = new PanelDeposito(x+ margen +(depAncho + brecha),y + 35, depAncho, depAlto, "Sprite");
        depFanta = new PanelDeposito(x+ margen +(depAncho + brecha) * 2, y + 35, depAncho, depAlto, "Fanta");
        depSnickers = new PanelDeposito(x+ margen +(depAncho + brecha) * 3, y + 35, depAncho, depAlto, "Snickers");
        depSuper8 = new PanelDeposito(x+ margen +(depAncho + brecha) * 4, y + 35, depAncho, depAlto, "Super8");

        depProductoComprado = new PanelDeposito(x+ margen,y + alto -80, 100, 75, "Producto");
        depVuelto = new PanelDeposito(x+ margen +115, y + alto -80, 100, 75, "Vuelto");

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

        int cambio = moneda.getValor()-precio;
        int serieM = 1;
        while (cambio >= 100) {
            monedasVuelto.add(new Moneda(100, "s:"+serieM++));
            cambio-=100;
        }
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
    public void paintComponent(Graphics g) {
        g.setColor(new Color(91, 131, 212));
        g.fillRect(x, y, ancho, alto);
        g.setColor(Color.WHITE);
        g.drawRect(x, y, ancho, alto);
        g.setFont(new Font("Arial", Font.BOLD, 17));
        g.drawString("Expendedor", x + 10, y + 22);

        depCoca.paintComponent(g);
        depSprite.paintComponent(g);
        depFanta.paintComponent(g);
        depSnickers.paintComponent(g);
        depSuper8.paintComponent(g);
        depProductoComprado.paintComponent(g);
        depVuelto.paintComponent(g);

        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font("Arial", Font.PLAIN, 11));

        if (!monedasVuelto.isEmpty()) {
            int mx = depVuelto.getX() + 5;
            int my = depVuelto.getY() + 20;
            for (int i = 0; i < Math.min(monedasVuelto.size(), 3); i++) {
                Moneda m = monedasVuelto.get(i);
                m.setX(mx);
                m.setY(my);
                m.paintComponent(g);
                mx += 42;
            }
        }
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getAncho() {
        return ancho;
    }
    public int getAlto() {
        return alto;
    }
}
