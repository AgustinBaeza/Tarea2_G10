package Reuniones.Excepciones;

/**
 * Excepcion lanzada cuando ocurre un error al escribir o generar el archivo de texto.
 */
public class EscrituraArchivoException extends RuntimeException {

    /**
     * Constructor de la excepcion
     * @param mensaje mensaje descriptivo con el motivo de la excepcion
     */
    public EscrituraArchivoException(String mensaje) {
        super(mensaje);
    }
}