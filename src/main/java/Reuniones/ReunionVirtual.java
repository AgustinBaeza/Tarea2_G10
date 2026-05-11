package Reuniones;

/**
 * Clase que hererada de Reunion
 * Agrega String de enlace hacia la reunion
 */
public class ReunionVirtual extends Reunion{
    private String enlace;

    public ReunionVirtual(int fecha, int horaPrevista, int duracionPrevista, int horaInicio, int horaFin, String enlace) {
        super(fecha, horaPrevista, duracionPrevista, horaInicio, horaFin);
        this.enlace = enlace;
    }

    /**
     * Getter del enlace
     * @return enlace de la reunion
     */
    public String getEnlace() {
        return enlace;
    }
}
