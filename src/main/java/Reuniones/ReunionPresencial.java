package Reuniones;

/**
 * Clase que hererada de Reunion
 * Agrega String de sala de la reunion
 */
public class ReunionPresencial  extends Reunion {
    private String sala;

    public ReunionPresencial(int fecha, int horaPrevista, int duracionPrevista, int horaInicio, int horaFin, String sala) {
        super(fecha, horaPrevista, duracionPrevista, horaInicio, horaFin);
        this.sala = sala;
    }

    /**
     * Getter de sala
     *
     * @return sala de la reunion
     */
    public String getSala() {
        return sala;
    }
}
