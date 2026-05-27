package backend;

/**
 * clase Snickers que es subclase de Dulce
 */
public class Snickers extends Dulce {
    /**
     * crea un Dulce snikcer con su numero de serie
     * @param serie del snikcer
     */
    public Snickers(int serie){
        super(serie);
    }

    /**
     * retorna el sabor del dulce sniker
     * @return snicker
     */
    @Override
    public String Sabor() {
        return "snicker";
    }
}
