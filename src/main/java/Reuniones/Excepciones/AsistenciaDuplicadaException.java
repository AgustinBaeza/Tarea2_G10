package Reuniones.Excepciones;

/**
 * Excepcion lanzada cuando un empleado
 * intenta registrarse dos veces.
 */
public class AsistenciaDuplicadaException extends RuntimeException {

    /**
     * Constructor de la excepcion
     * @param mensaje mensaje descriptivo con el motivo de la excepcion
     */
    public AsistenciaDuplicadaException(String mensaje) {
        super(mensaje);
    }
}
