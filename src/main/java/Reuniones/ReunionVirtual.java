package Reuniones;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/**
 * Clase que hereda de Reunion, corresponde a la sesion virtual en la que se realizara la reunion
 */
public class ReunionVirtual extends Reunion {
    private String enlace;

    /**
     * Constructor de la clase ReunionVirtual
     * @param fecha fecha de la reunion
     * @param horaPrevista hora que deberia iniciar la reunion
     * @param duracionPrevista tiempo que deberia durar la reunion
     * @param tipo tipo de reunion que se va a realizar
     * @param organizador empleado que organiza la reunion
     * @param enlace link de la reunion virtual
     */
    public ReunionVirtual(Date fecha, Instant horaPrevista, Duration duracionPrevista, tipoReunion tipo, Empleado organizador, String enlace) {
        super(fecha, horaPrevista, duracionPrevista, tipo, organizador);
        this.enlace = enlace;
    }

    /**
     * Getter del enlace de la reunion
     * @return link de la reunion virtual en forma de String
     */
    public String getEnlace() {
        return enlace;
    }

    @Override
    public String toString() {
        return "ReunionVirtual{" +
                "enlace='" + enlace + '\'' +
                '}';
    }
}
