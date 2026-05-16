package Reuniones.Excepciones;

/**
 * Excepcion lanzada cuando un autor esta vacio
 */
public class AutorVacioException extends RuntimeException{

    /**
     * Constructor de la excepcion
     * @param mensaje mensaje descriptivo con el motivo de la excepcion
     */
    public AutorVacioException(String mensaje){
        super(mensaje);
    }
}
