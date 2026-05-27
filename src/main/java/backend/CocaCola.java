package backend;

/**
 * clase cocacola que es subclase de Bebida
 */
public class CocaCola extends Bebida {
    /**
     * Se crea una Bebida cocacola son su numero de serie
     * @param serie de la Bebida cocacola
     */
    public CocaCola(int serie) {
        super(serie);
    }

    /**
     * retorna el sabor de la Bebida cocacola
     * @return CocaCola
     */
    @Override
    public String Sabor() {
        return new String("Sabor CocaCola");
    }
}
