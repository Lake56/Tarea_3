package backend;

/**
 * se define la clase abstracta Producto
 * que servira como base de variables y metodos para las demas sub clases de esta
 */
public abstract class Producto {
    private int serie;
    /**
     * Se crea un producto su numero de serie
     * @param serie del producto
     */
    public Producto(int serie) {
        this.serie = serie;
    }

    /**
     * se obtiene el numero de serie
     * @return numero de serie
     */
    public int getSerie(){
        return this.serie;
    }

    /**
     * Metodo que sirve como base para que cada Producto retorne su propio sabor
     * @return sabor del producto escogido
     */
    public abstract String Sabor();
}
