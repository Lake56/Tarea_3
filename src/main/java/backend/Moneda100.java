package backend;

/**
 * Moneda de $100, subclase de Moneda
 */
public class Moneda100 extends Moneda {
    public Moneda100(int serie) {
        super(serie);
    }

    @Override
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

