package Reuniones.Excepciones;

/**
 * Excepcion lanzada cuando se intenta realizar una accion
 * no permitida segun el estado actual de la reunion.
 *
 * Por ejemplo, finalizar una reunion que no ha iniciado,
 * iniciar una reunion dos veces o finalizarla dos veces.
 */
public class EstadoReunionException extends RuntimeException {

    /**
     * Constructor de la excepcion.
     * @param mensaje mensaje descriptivo con el motivo de la excepcion
     */
    public EstadoReunionException(String mensaje) {
        super(mensaje);
    }
}
