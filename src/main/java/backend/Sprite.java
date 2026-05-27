package backend;

/**
 * clase Sprite que es subclase de Bebida
 */
public class Sprite extends Bebida {
    /**
     * se crea la Bebida tipo sprite con su numero de serie
     * @param serie de sprite
     */
    public Sprite(int serie) {
        super(serie);
    }

    /**
     * Se retorna el sabor de la Bebida sprite
     * @return Sprite
     */
    @Override
    public String Sabor() {
        return new String("Sabor Sprite");
    }
}
