package backend;

/**
 * Moneda de $500, subclase de Moneda
 */
public class Moneda500 extends Moneda {
    public Moneda500(int serie) {
        super(serie);
    }

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