package utils;

/**
 * Excepción personalizada utilizada cuando un RUT no cumple
 * con las validaciones definidas por el sistema.
 */
public class RutInvalidoException extends Exception {

    /**
     * Constructor de la excepción.
     *
     * @param mensaje Mensaje descriptivo del error.
     */
    public RutInvalidoException(String mensaje) {
        super(mensaje);
    }

}