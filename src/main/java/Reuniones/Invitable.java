package Reuniones;

/**
 * Interfaz que representa a las entidades que pueden ser invitadas a una reunion
 * Las clases que implementen esta interfaz podran recibir y manejar invitaciones
 */
public interface Invitable {

    /**
     * Metodo que envia invitacion a la entidad especifica
     */
    void invitar();
}
