package backend;

/**
 * Moneda de $500, subclase de Moneda
 */
class Moneda500 extends Moneda {
    public Moneda500() {
        super();
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