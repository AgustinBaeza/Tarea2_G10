package Reuniones;

public abstract class Reunion {

    private int fecha;
    private int horaPrevista;
    private int duracionPrevista;
    private int horaInicio;
    private int horaFin;
    private Asistencia asistencia;

    public Reunion(int fecha, int horaPrevista, int duracionPrevista, int horaInicio, int horaFin){
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.asistencia = new Asistencia();
    }

    public void obtenerAsistencia(){
        asistencia.getAsistentes();
    }

    public void obtenerAusencias(){

    }

    public void obtenerRetrasos(){

    }

    public void obtenerTotalAsistencia(){
        asistencia.totalAsistentes();
    }

    public void calcularTiempoReal(){

    }

    public void iniciar(){

    }

    public void finalizar(){

    }

}
