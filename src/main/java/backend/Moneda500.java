package backend;

/**
 * Moneda de $500, subclase de Moneda
 */
public class Moneda500 extends Moneda {
    /**
     * Se crea la Moneda de 500 con su numero de serie
     */
    public Moneda500() {
        super();
    }

    /**
     * Retorna el numero de serie de la Moneda
     * @return serie
     * */
    @Override
    public int getSerie() {
        return super.getSerie();
    }

    /**
     * retorna el valor de la moneda
     * @return int 500
     */
    @Override
    public int getValor() {
        return 500;
    }
}