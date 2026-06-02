package backend;

/**
 * Moneda de $100, subclase de Moneda
 */
public class Moneda100 extends Moneda{
    /**
     * Crea la Moneda de 100 con su numero de serie
     * @param serie
     */
    public Moneda100(int serie) {
        super(serie);
    }

    @Override
    /**
     * retorna el numero de serie de la moneda
     * @return serie
     */
    public int getSerie() {
        return super.getSerie();
    }
    /**
     * retorna el valor de la moneda
     * @return int 100
     */

    @Override
    public int getValor() {
        return 100;
    }
}

