package Reuniones.Excepciones;

/**
 * Excepcion lanzada cuando un empleado
 * intenta registrarse dos veces.
 */
public class AsistenciaDuplicadaException extends RuntimeException {

    public AsistenciaDuplicadaException(String mensaje) {
        super(mensaje);
    }
}
