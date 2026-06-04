package backend;

/**
 * Moneda de $1000, subclase de Moneda
 */
public class Moneda1000 extends Moneda {
    /**
     * Crea la Moneda de 1000 con su numero de serie
     */
    public Moneda1000() {
        super();
    }

    /**
     * Retorna el numero de serie de la Moneda
     * @return serie
     */
    @Override
    public int getSerie() {
        return super.getSerie();
    }
    /**
     * retorna el valor de la moneda
     * @return int 1000
     */
    @Override
    public int getValor() {
        return 1000;
    }
}