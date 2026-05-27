package backend;

/**
 * Moneda de $100, subclase de Moneda
 */
public class Moneda100 extends Moneda {
    public Moneda100() {
        super();
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

