package Reuniones;

import java.util.ArrayList;

/**
 * Clase que representa la lista de asistentes
 * Busca registrar a todos los asistentes de la reunion
 */
public class Asistencia {
    private ArrayList<String> asistentes = new ArrayList<>();

    /**
     * Constructor de la clase
     */
    public Asistencia() {
    }

    /**
     * Agrega un asistente a la reunion
     * @param asistente toString del empleado
     */
    public void agregarAsistente(String asistente){
        asistentes.add(asistente);
    }

    /**
     * Quita un asistente a la reunion
     *
     * @param asistente toString del empleado
     */
    public void eliminarAsistente(String asistente){
        asistentes.remove(asistente);
    }

    /**
     * Devuelve la lista con los asistentes presentes
     *
     * @return ArrayList con todos los asistentes
     */
    public ArrayList<String> getAsistentes() {
        return asistentes;
    }

    /**
     * Devuelve el total de presentes en la reunion
     *
     * @return el numero total de asistentes
     */
    public int totalAsistentes(){
        return asistentes.size();
    }

}