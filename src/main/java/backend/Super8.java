package backend;

/**
 * clase super 8 que es subclase de Dulce
 */
public class Super8 extends Dulce {
    /**
     * Crea un dulce de clase super8 con su serie
     * @param serie del super 8
     */
    public Super8(int serie){
        super(serie);
    }

    /**
     * retorna el sabor del dulce super8
     * @return super8
     */
    @Override
    public String Sabor() {
        return "super8";
    }
}
