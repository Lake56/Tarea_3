package backend;

/**
 * excepcion lanzada cuando no hay productos en el deposito o no existe
 *
 */
public class NoHayProductoException extends Exception {
    /**
     * crea la excepción con un mensaje.
     * @param errormessage del error
     */
    public NoHayProductoException(String errormessage) {
        super(errormessage);
    }
}
