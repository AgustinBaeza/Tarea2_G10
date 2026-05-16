package Reuniones.Excepciones;

/**
 * Excepcion lanzada cuando los datos de un departamento son invalidos, que ocurre cuando el nombre del departamento es nulo o esta vacio,
 */
public class DepartamentoInvalidoException extends RuntimeException {

    /**
     * Constructor de la excepcion
     * @param mensaje mensaje descriptivo con el motivo de la excepcion
     */
    public DepartamentoInvalidoException(String mensaje) {
        super(mensaje);
    }
}