package Reuniones;

import Reuniones.Excepciones.RegistroDuplicadoException;
import java.util.ArrayList;

/**
 * Clase que administra la asistencia de una reunion.
 */
public class Asistencia {

    private ArrayList<Empleado> asistentes;
    private ArrayList<Empleado> ausentes;
    private ArrayList<Retraso> retrasos;

    /**
     * Constructor de la clase Asistencia.
     */
    public Asistencia() {
        asistentes = new ArrayList<>();
        ausentes = new ArrayList<>();
        retrasos = new ArrayList<>();
    }
    /**
    * Agrega un asistente.
    * @param empleado empleado asistente
     * @throws RegistroDuplicadoException
     * si el empleado ya fue registrado como asistente
     */
    public void agregarAsistente(Empleado empleado) {

        if (asistentes.contains(empleado)) {
            throw new RegistroDuplicadoException("El empleado ya fue registrado como asistente.");
        }

        asistentes.add(empleado);
    }
    /**
     * Agrega un empleado ausente.
     * @param empleado empleado ausente
     * @throws RegistroDuplicadoException
     * si el empleado ya fue registrado como ausente
     */
    public void agregarAusente(Empleado empleado) {

        if (ausentes.contains(empleado)) {
            throw new RegistroDuplicadoException("El empleado ya fue registrado como ausente.");
        }

        ausentes.add(empleado);
    }
    /**
     * Registra un retraso.
     * @param retraso retraso registrado
     */
    public void registrarRetraso(Retraso retraso) {
        retrasos.add(retraso);
    }

    public ArrayList<Empleado> getAsistentes() {
        return asistentes;
    }

    public ArrayList<Empleado> getAusentes() {
        return ausentes;
    }

    public ArrayList<Retraso> getRetrasos() {
        return retrasos;
    }

    /**
     * Obtiene el total de asistentes.
     * @return cantidad de asistentes
     */
    public int totalAsistentes() {
        return asistentes.size();
    }

    /**
     * Calcula el porcentaje de asistencia.
     * @param totalInvitados total de invitados
     * @return porcentaje de asistencia
     */
    public double calcularPorcentajeAsistencia(int totalInvitados) {

        if (totalInvitados == 0) {
            return 0;
        }

        return ((double) asistentes.size() / totalInvitados) * 100;
    }

    /**
     * toString que devuelve los detalles del registro de asistencia en texto
     * @return String con los asistentes, ausentes y retrasos
     */
    @Override
    public String toString() {
        return "Asistencia{asistentes = " +asistentes +", ausentes = " + ausentes +", retrasos = " + retrasos +"}";
    }
}