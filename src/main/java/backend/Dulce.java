package backend;

/**
 * se crea la clase abstracta Dulce como subclase de Producto
 * esta sirve como base para los diferentes dulces
 */
public abstract class Dulce extends Producto {
    /**
     * Se crea un dulce con su numero de serie
     * @param serie del producto
     */
    public Dulce(int serie){
        super(serie);
    }
}
