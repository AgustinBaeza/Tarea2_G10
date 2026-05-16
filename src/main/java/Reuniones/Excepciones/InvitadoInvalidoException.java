package Reuniones.Excepciones;

/**
 * Excepcion lanzada cuando los datos de un invitado son invalidos.
 * Esto ocurre cuando el nombre, apellidos o el correo electronico de un invitado estan vacios o son nulos
 */
public class InvitadoInvalidoException extends RuntimeException {

    /**
     * Constructor de la excepción
     * @param mensaje mensaje descriptivo con el motivo de la excepción
     */
    public InvitadoInvalidoException(String mensaje){
        super(mensaje);
    }

}