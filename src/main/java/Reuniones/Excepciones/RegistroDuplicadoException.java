package Reuniones.Excepciones;

/**
 * Excepcion lanzada cuando un empleado
 * intenta registrarse dos veces.
 */
public class RegistroDuplicadoException extends RuntimeException {

    /**
     * Constructor de la excepcion
     * @param mensaje mensaje descriptivo con el motivo de la excepcion
     */
    public RegistroDuplicadoException(String mensaje) {
        super(mensaje);
    }
}
