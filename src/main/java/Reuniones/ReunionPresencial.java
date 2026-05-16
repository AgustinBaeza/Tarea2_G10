package Reuniones;

import java.time.Instant;

/**
 * Clase que hereda de Reunion, corresponde a la sala fisica en la que se realizara la reunion
 */
public class ReunionPresencial  extends Reunion {
    private String sala;

    /**
     * Constructor de la clase ReunionPresencial
     * @param fecha fecha de la reunion
     * @param horaPrevista hora prevista de inicio
     * @param duracionPrevista duracion prevista de la reunion
     * @param horaInicio hora real de inicio de reunion
     * @param horaFin hora de finalizacion de reunion
     * @param sala sala fisica donde se realizara la reunion
     */
    public ReunionPresencial(Instant fecha, Instant horaPrevista, Instant duracionPrevista, Instant horaInicio, Instant horaFin, String sala) {
        super(fecha, horaPrevista, duracionPrevista, horaInicio, horaFin);
        this.sala = sala;
    }

    /**
     * Getter de sala fisica donde se hara la reunion
     * @return sala de la reunion en forma de String
     */
    public String getSala() {
        return sala;
    }
}
