package backend;

/**
 * clase abtracta que es subclase de Producto y sirve como base para las diferentes bebidas
 */
public abstract class Bebida extends Producto {
    /**
     * Se crea una Bebida con su numero de serie
     * @param serie de la Bebida
     */
    public Bebida(int serie) {
        super(serie);
    }
}
