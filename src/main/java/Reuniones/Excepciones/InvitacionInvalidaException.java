package Reuniones.Excepciones;

/**
 * Excepcion lanzada cuando se intenta crear una invitacion invalida, que ocurre cuando el invitado ingresado es null
 */
public class InvitacionInvalidaException extends RuntimeException {

    /**
     * Constructor de la excepcion
     * @param mensaje mensaje descriptivo con el motivo de la excepcion
     */
    public InvitacionInvalidaException(String mensaje){
        super(mensaje);
    }
}
