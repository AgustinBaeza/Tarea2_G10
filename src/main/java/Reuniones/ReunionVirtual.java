package Reuniones;

/**
 * Clase que hereda de Reunion, corresponde a la sesion virtual en la que se realizara la reunion
 */
public class ReunionVirtual extends Reunion{
    private String enlace;

    /**
     * Constructor de la clase ReunionVirtual
     * @param fecha fecha de la reunion
     * @param horaPrevista hora prevista de inicio
     * @param duracionPrevista duracion prevista de la reunion
     * @param horaInicio hora real de inicio
     * @param horaFin hora real de finalizacion
     * @param enlace link de la reunion
     */
    public ReunionVirtual(int fecha, int horaPrevista, int duracionPrevista, int horaInicio, int horaFin, String enlace) {
        super(fecha, horaPrevista, duracionPrevista, horaInicio, horaFin);
        this.enlace = enlace;
    }

    /**
     * Getter del enlace de la reunion
     * @return link de la reunion virtual en forma de String
     */
    public String getEnlace() {
        return enlace;
    }
}
