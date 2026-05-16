package Reuniones.Excepciones;

/**
 * Excepcion lanzada cuando un retraso es invalido.
 */
public class RetrasoInvalidoException extends RuntimeException {

    /**
     * Constructor de la excepcion
     * @param mensaje mensaje descriptivo con el motivo de la excepcion
     */
    public RetrasoInvalidoException(String mensaje) {
        super(mensaje);
    }
}
