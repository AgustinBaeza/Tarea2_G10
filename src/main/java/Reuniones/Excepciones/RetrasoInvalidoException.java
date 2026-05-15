package Reuniones.Excepciones;

/**
 * Excepcion lanzada cuando un retraso es invalido.
 */
public class RetrasoInvalidoException extends RuntimeException {

    public RetrasoInvalidoException(String mensaje) {
        super(mensaje);
    }
}
