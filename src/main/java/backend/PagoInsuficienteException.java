package backend;

/**
 * excepcion lanzada cuando el valor de la moneda es menor al precio
 */
public class PagoInsuficienteException extends Exception {
    /**
     * crea la excepción con un mensaje.
     * @param errormessage del error
     */
    public PagoInsuficienteException(String errormessage) {
        super(errormessage);
    }
}
