package Reuniones;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/**
 * Clase que hereda de Reunion, corresponde a la sala fisica en la que se realizara la reunion
 */
public class ReunionPresencial  extends Reunion {
    private String sala;

    /**
     * Constructor de la clase ReunionPresencial
     * @param fecha fecha de la reunion
     * @param horaPrevista hora que deberia iniciar la reunion
     * @param duracionPrevista tiempo que deberia durar la reunion
     * @param tipo tipo de reunion que se va a realizar
     * @param organizador empleado que organiza la reunion
     * @param sala lugar en que se dara la reunion
     */
    public ReunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista, tipoReunion tipo, Empleado organizador, String sala) {
        super(fecha, horaPrevista, duracionPrevista, tipo, organizador);
        this.sala = sala;
    }

    /**
     * Getter de sala fisica donde se hara la reunion
     * @return sala de la reunion en forma de String
     */
    public String getSala() {
        return sala;
    }

    @Override

    @Override
    public String toString() {
        return "ReunionPresencial{" +
                "sala='" + sala + '\'' +
                '}';
    }
}
