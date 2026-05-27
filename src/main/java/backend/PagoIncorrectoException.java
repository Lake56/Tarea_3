package backend;

/**
 * excepcion lanzada cuando intenta comprar sin moneda
 */
public class PagoIncorrectoException extends Exception {
    /**
     * crea la excepción con un mensaje.
     * @param errormessage del error
     */
    public PagoIncorrectoException(String errormessage) {
        super(errormessage);
    }
}
