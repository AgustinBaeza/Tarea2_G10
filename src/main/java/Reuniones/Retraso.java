package Reuniones;

import Reuniones.Excepciones.RetrasoInvalidoException;
import java.time.LocalTime;

/**
 * Clase que representa el retraso de un empleado.
 */
public class Retraso {

    private Empleado empleado;
    private LocalTime horaLlegada;

    /**
     * Constructor de la clase Retraso.
     *
     * @param empleado empleado retrasado
     * @param horaLlegada hora de llegada
     * @throws RetrasoInvalidoException
     * si la hora es null
     */
    public Retraso(Empleado empleado, LocalTime horaLlegada) {
        if (horaLlegada == null) {
            throw new RetrasoInvalidoException(
                    "La hora de llegada no puede ser null."
            );
        }
        this.empleado = empleado;
        this.horaLlegada = horaLlegada;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public LocalTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    @Override
    public String toString() {
        return "Retraso{" +
                "empleado=" + empleado +
                ", horaLlegada=" + horaLlegada +
                '}';
    }
}
