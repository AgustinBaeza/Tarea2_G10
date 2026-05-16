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
     * @param empleado empleado retrasado
     * @param horaLlegada hora de llegada
     * @throws RetrasoInvalidoException si la hora es null
     */
    public Retraso(Empleado empleado, Instant horaLlegada) {
        if (empleado == null) {
            throw new RetrasoInvalidoException("El empleado no puede ser null");
        }
        if (horaLlegada == null) {
            throw new RetrasoInvalidoException("La hora de llegada no puede ser null");
        }
        this.empleado = empleado;
        this.horaLlegada = horaLlegada;
    }

    /**
     * Getter del empleado del que se registro un retraso
     * @return empleado retrasado como objeto Empleado
     */
    public Empleado getEmpleadoRetraso() {
        return empleado;
    }

    /**
     * Getter de la hora de llegada del empleado
     * @return hora de llegada registrada como objeto Instant
     */
    public Instant getHoraLlegada() {
        return horaLlegada;
    }

    /**
     * toString que devuelve el detalle del retraso registrado como String
     * @return detalle del empleado retrasado junto a su hora de llegada
     */
    @Override
    public String toString() {
        return "Retraso{empleado = " + empleado + ", horaLlegada = "+ horaLlegada +"}";
    }
}
