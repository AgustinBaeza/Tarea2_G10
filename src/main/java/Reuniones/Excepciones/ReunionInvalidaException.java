package Reuniones.Excepciones;

/**
 * Excepcion lanzada cuando se intentan ingresar fechas o tipo de reuniones nulas al constructor de la clase Reunion
 */
public class ReunionInvalidaException extends RuntimeException{

    /**
     * Constructor de la excepción
     * @param mensaje mensaje descriptivo con el motivo de la excepción
     */
    public ReunionInvalidaException(String mensaje){
        super(mensaje);
    }
}
