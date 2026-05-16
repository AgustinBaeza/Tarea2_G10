package Reuniones.Excepciones;


/**
 * Excepcion que se lanza cuando el departamento al que se quiere invitar no posee empleados
 */
public class DepartamentoVacioException extends RuntimeException{

    /**
     * Constructor de la excepcion
     * @param mensaje mensaje descriptivo con el motivo de la excepcion
     */
    public DepartamentoVacioException(String mensaje){
        super(mensaje);
    }
}
