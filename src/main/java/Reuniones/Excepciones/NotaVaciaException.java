package Reuniones.Excepciones;

/**
 * Excepcion lanzada cuando una nota esta vacia.
 */
public class NotaVaciaException extends RuntimeException {

    public NotaVaciaException(String mensaje) {
        super(mensaje);
    }
}
