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
}
