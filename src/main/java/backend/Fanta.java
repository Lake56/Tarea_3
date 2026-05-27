package backend;

/**
 * clase fanta que es subclase de Bebida
 */
public class Fanta extends Bebida {
    /**
     * Se crea una Bebida tipo fanta con su numero de serie
     * @param serie de la Bebida fanta
     */
    public Fanta(int serie) {
        super(serie);
    }

    /**
     * retorna el sabor de la Bebida Fanta
     * @return fanta
     */
    @Override
    public String Sabor() {
        return new String("Sabor Fanta");
    }
}
