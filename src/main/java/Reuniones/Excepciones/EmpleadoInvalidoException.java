package Reuniones.Excepciones;

/**
 * Excepcion lanzada cuando se intenta eliminar un empleado que no pertenece al departamento
 * o cuando se intenta acceder a un empleado mediante una posicion fuera de rango
 */
public class EmpleadoInvalidoException extends RuntimeException{

    /**
     * Constructor de la excepcion
     * @param mensaje mensaje descriptivo con el motivo de la excepcion
     */
    public EmpleadoInvalidoException(String mensaje){
        super(mensaje);
    }
}
