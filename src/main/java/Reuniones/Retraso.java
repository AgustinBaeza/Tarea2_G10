package Reuniones;

import Reuniones.Excepciones.RetrasoInvalidoException;
import java.time.Instant;

/**
 * Clase que representa el retraso de un empleado.
 */
public class Retraso {

    private Empleado empleado;
    private Instant horaLlegada;

    /**
     * Constructor de la clase Retraso.
     *
     * @param empleado empleado retrasado
     * @param horaLlegada hora de llegada
     * @throws RetrasoInvalidoException si la hora es null
     */
    public Retraso(Empleado empleado, Instant horaLlegada) {
        if (empleado == null) {
            throw new RetrasoInvalidoException(
                    "El empleado no puede ser null."
            );
        }
        if (horaLlegada == null) {
            throw new RetrasoInvalidoException("La hora de llegada no puede ser null.");
        }
        this.empleado = empleado;
        this.horaLlegada = horaLlegada;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public Instant getHoraLlegada() {
        return horaLlegada;
    }

    @Override
    public String toString() {
        return "Retraso{empleado = " + empleado + ", horaLlegada = "+ horaLlegada +"}";
    }
}
