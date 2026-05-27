package backend;

/**
 * Moneda de $1000, subclase de Moneda
 */
class Moneda1000 extends Moneda {
    public Moneda1000() {
        super();
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