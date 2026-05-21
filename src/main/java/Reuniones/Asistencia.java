package Reuniones;

import Reuniones.Excepciones.RegistroDuplicadoException;

import java.util.ArrayList;

/**
 * Clase que administra la asistencia de una reunion.
 */
public class Asistencia {

    private ArrayList<Invitable> asistentes;
    private ArrayList<Invitable> ausentes;
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
    * @param invitado invitado asistente
     * @throws RegistroDuplicadoException
     * si el invitado ya fue registrado como asistente
     */
    public void agregarAsistente(Invitable invitado) {
        if (asistentes.contains(invitado)) {
            throw new RegistroDuplicadoException("El invitado ya fue registrado como asistente.");
        }

        asistentes.add(invitado);
    }
    /**
     * Agrega un invitado ausente.
     * @param invitado invitado ausente
     * @throws RegistroDuplicadoException
     * si el invitado ya fue registrado como ausente
     */
    public void agregarAusente(Invitable invitado) {
        if (ausentes.contains(invitado)) {
            throw new RegistroDuplicadoException("El invitado ya fue registrado como ausente.");
        }

        ausentes.add(invitado);
    }
    /**
     * Registra un retraso.
     * @param retraso retraso registrado
     */
    public void registrarRetraso(Retraso retraso) {
        retrasos.add(retraso);
    }

    public ArrayList<Invitable> getAsistentes() {
        return asistentes;
    }

    public ArrayList<Invitable> getAusentes() {
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