package Reuniones.Excepciones;

/**
 * Excepcion lanzada cuando existe una contradiccion
 * en el registro de asistencia.
 *
 * Por ejemplo, cuando un invitado ya fue registrado como asistente
 * y luego se intenta registrar como ausente, o viceversa.
 */
public class ContradiccionException extends RuntimeException {

    /**
     * Constructor de la excepcion.
     * @param mensaje mensaje descriptivo con el motivo de la excepcion
     */
    public ContradiccionException(String mensaje) {
        super(mensaje);
    }
}
