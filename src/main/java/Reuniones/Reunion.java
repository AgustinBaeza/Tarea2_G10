package Reuniones;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase abstracta que representa una reunion
 *
 * Una reunion almacena informacion relacionada con:
 * - Fecha y horarios
 * - Duracion
 * - Tipo de reunion
 * - Organizador
 * - Invitaciones
 * - Asistencia
 * - Retrasos
 * - Notas
 *
 * Esta clase sirve como base para reuniones
 * presenciales y virtuales
 */
public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    private Asistencia asistencia;
    private tipoReunion tipo;
    private Empleado organizador;
    private ArrayList<Nota> notas;
    private ArrayList<Invitacion> invitaciones;

    /**
     * Constructor de la reunion
     *
     * @param fecha fecha de la reunion
     * @param horaPrevista hora en que deberia empezar la reunion
     * @param duracionPrevista duracion que deberia tener la reunion
     * @param tipo tipo de reunion
     * @param organizador empleado que organiza la reunion
     */
    public Reunion(Date fecha, Instant horaPrevista, Duration duracionPrevista, tipoReunion tipo, Empleado organizador){
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.asistencia = new Asistencia();
        this.tipo = tipo;
        this.organizador = organizador;
        this.notas = new ArrayList<>();
        this.invitaciones = new ArrayList<>();
    }

    /**
     * Agrega una invitacion para un empleado
     *
     * @param invitado empleado o departamento invitado
     */
    public void agregarInvitacion(Invitable invitado){
        invitaciones.add(new Invitacion(invitado));
    }

    /**
     * Calcula el total de invitados a la reunion,
     * si el invitado corresponde a un departamento se cuentan todos los empleados
     *
     * @return cantidad total de invitados
     */
    public int getTotalInvitados(){
        int total = 0;

        for( Invitacion inv : invitaciones) {
            if (inv.getInvitado() instanceof Departamento){
                total += ((Departamento) inv.getInvitado()).obtenerCantidadEmpleados();
            }
            else{
                total++;
            }
        }
        return total;
    }

    /**
     * Registra un asistente a la reunion
     *
     * @param invitado asistente registrado
     */
    public void agregarAsistente(Invitable invitado){
        asistencia.agregarAsistente(invitado);
    }

    /**
     * Registra un invitado ausente
     *
     * @param invitado invitado ausente
     */
    public void agregarAusente(Invitable invitado){
        asistencia.agregarAusente(invitado);
    }

    /**
     * Registra un retraso de asistencia
     *
     * @param retraso retraso registrado
     */
    public void registrarRetraso(Retraso retraso){
        asistencia.registrarRetraso(retraso);
    }

    /**
     * Obtiene la lista de asistentes
     *
     * @return lista de asistentes
     */
    public List<Invitable> obtenerAsistencia(){
        return asistencia.getAsistentes();
    }

    /**
     * Obtiene la lista de ausentes
     *
     * @return lista de ausentes
     */
    public List<Invitable> obtenerAusencias(){
        return asistencia.getAusentes();
    }

    /**
     * Obtiene la lista de retrasos registrados
     *
     * @return lista de retrasos
     */
    public List<Retraso> obtenerRetrasos(){
        return asistencia.getRetrasos();
    }

    /**
     * Obtiene el total de asistentes
     *
     * @return cantidad total de asistentes
     */
    public int obtenerTotalAsistencia() {
        return asistencia.totalAsistentes();
    }

    /**
     * Calcula el porcentaje de asistencia de la reunion
     *
     * @return porcentaje de asistencia
     */
    public double obtenerPorcentajeAsistencia(){
        return asistencia.calcularPorcentajeAsistencia(getTotalInvitados());
    }

    /**
     * Calcula la duracion real de la reunion en minutos
     *
     * @return duracion real de la reunion
     */
    public float calcularTiempoReal(){
        if(horaInicio == null || horaFin == null){
            return 0;
        }
        return Duration.between(horaInicio, horaFin).toMinutes();
    }

    /**
     * Registra la hora actual como inicio de la reunion
     */
    public void iniciar(){
        horaInicio = Instant.now();
    }

    /**
     * Registra la hora actual como final de la reunion
     */
    public void finalizar(){
        horaFin = Instant.now();
    }

    /**
     * Agrega una nota a la reunion
     *
     * @param nota nota registrada
     */
    public void agregarNota(Nota nota){
        notas.add(nota);
    }

    /**
     * Getter de la fecha de la reunion
     *
     * @return fecha de la reunion
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Getter de la hora prevista de inicio
     *
     * @return hora prevista
     */
    public Instant getHoraPrevista() {
        return horaPrevista;
    }

    /**
     * Getter de la duracion prevista
     *
     * @return duracion prevista
     */
    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }

    /**
     * Getter de la hora real de inicio
     *
     * @return hora de inicio
     */
    public Instant getHoraInicio() {
        return horaInicio;
    }

    /**
     * Getter de la hora real del final
     *
     * @return hora de finalizacion
     */
    public Instant getHoraFin() {
        return horaFin;
    }

    /**
     * Getter del el tipo de reunion
     *
     * @return tipo de reunion
     */

    public tipoReunion getTipo() {
        return tipo;
    }

    /**
     * Getter de el organizador de la reunion
     *
     * @return organizador
     */
    public Empleado getOrganizador() {
        return organizador;
    }

    /**
     * Getter de las invitaciones registradas
     *
     * @return lista de invitaciones
     */
    public ArrayList<Invitacion> getInvitaciones() {
        return invitaciones;
    }

    /**
     * Getter de las notas registradas
     *
     * @return lista de notas
     */
    public ArrayList<Nota> getNotas() {
        return notas;
    }

    /**
     * Representacion en String de la reunion
     *
     * @return informacion de la reunion
     */
    @Override
    public String toString() {
        return "fecha: "+ fecha.toString() +
                ", horaPrevista, " + horaPrevista +
                ", horaInicio: " + horaInicio +
                ", horaFin: " + horaFin +
                ", tipo: " + tipo +
                ", organizador: "+ organizador;
    }
}
