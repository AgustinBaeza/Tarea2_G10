package Reuniones;
import Reuniones.Excepciones.InvitacionInvalidaException;

import java.time.Instant;

/**
 * Clase que representa la invitacion de una entidad a la reunion
 * Esta clase registra el momento exacto en el que se realizo la invitacion y a que entidad fue dirigida
 * El invitado puede ser cualquier destinatario que implemente la interfaz Invitable
 */
public class Invitacion {

    private Invitable invitado;
    private Instant hora;

    /**
     * Constructor de la clase Invitacion
     * Almacena la hora actual como instante en que se realizo la invitacion y llama a .invitar() para efectuar la invitacion
     * @param invitado cualquier entidad que tenga el rasgo de ser invitable a la reunion
     * @throws InvitacionInvalidaException puede lanzar esta excepcion si el invitado es nulo
     */
    public Invitacion(Invitable invitado){
        if (invitado == null){
            throw new InvitacionInvalidaException("La entidad invitada no puede ser nula");
        }

        this.invitado = invitado;
        this.hora = Instant.now();
        invitado.invitar();
    }

    /**
     * Getter del invitado
     * @return la entidad invitada en el constructor
     */
    public Invitable getInvitado(){
        return invitado;
    }

    /**
     * Getter de la hora
     * @return hora a la que fue invitada la entidad
     */
    public Instant getHora(){
        return hora;
    }

    /**
     * toString que retorna una representacion de la invitacion en texto
     * @return String con el detalle de la entidad invitada y la hora a la que se realizo su invitacion
     */
    @Override
    public String toString(){
        return "Invitacion{invitado = "+invitado+", hora = "+hora+"}";
    }
}
