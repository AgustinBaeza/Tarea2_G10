package Reuniones;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Clase encargada de generar un archivo de texto con la informacion de una reunion.
 *
 * El archivo contiene:
 * - Datos generales de la reunion
 * - Horarios
 * - Modalidad
 * - Asistentes
 * - Ausencias
 * - Retrasos
 * - Estadisticas
 * - Notas
 */
public class TxtReunion {
    private Reunion reunion;
    private static int numReuniones = 1;

    /**
     * Constructor de la clase
     * @param reunion reunion de la cual se generara el informe
     */
    public TxtReunion(Reunion reunion){
        this.reunion = reunion;
        numReuniones += 1;
    }
    /** Nombre del archivo generado*/
    private String nombreReunion = "Reunion" + numReuniones +".txt";

    /**
     * Genera un archivo txt y escribe en el la informacion de la reunion
     */
    public void generarTxt(){
        try{
            FileWriter writer = new FileWriter(nombreReunion);
            writer.write(generarData());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Genera un String con toda la informacion de la reunion
     * @return informacion completa de la reunion
     */
    public String generarData(){
        StringBuilder sb = new StringBuilder();


        sb.append("Informe Reunion: \n\n");

        sb.append("Fecha: \n-").append(reunion.getFecha()).append("\n");

        String HoraPrevista = "null";
        if ( reunion.getHoraPrevista() != null){
            HoraPrevista = reunion.getHoraPrevista().toString();
        }

        //Datos Previstos
        sb.append("Hora prevista: \n-").append( HoraPrevista ).append("\n");
        sb.append("Duracion prevista: \n-").append(reunion.getDuracionPrevista().toMinutes()).append("minutos\n\n");

        //Tipo reunion
        sb.append("Tipo de reunion: \n-").append(reunion.getTipo()).append("\n");

        //Organizador
        sb.append("Organizador: \n-").append(reunion.getOrganizador()).append("\n\n");

        //Horas Inicio/Fin
        String HoraInicio = "null";
        if ( reunion.getHoraInicio() != null){
            HoraInicio = reunion.getHoraInicio().toString();
        }
        sb.append("Hora Inicio: ").append(HoraInicio).append("\n");

        String HoraFin = "null";
        if ( reunion.getHoraFin() != null){
            HoraFin = reunion.getHoraFin().toString();
        }
        sb.append("Hora Fin: ").append(HoraFin).append("\n");

        if (reunion.getHoraFin() != null && reunion.getHoraInicio() != null){
            sb.append("Duracion real: ").append(reunion.calcularTiempoReal()).append(" minutos\n\n");
        }

        //Sala o enlace
        if (reunion instanceof ReunionPresencial){
            sb.append("Modalidad: Presencial\n");
            sb.append("Sala: ").append(((ReunionPresencial) reunion).getSala()).append("\n\n");
        } else if (reunion instanceof ReunionVirtual){
            sb.append("Modalidad: Virtual\n");
            sb.append("Enlace: ").append(((ReunionVirtual) reunion).getEnlace()).append("\n\n");
        }

        //Asistentes
        sb.append("Asistentes: \n");
        List<Invitable> asistentes = reunion.obtenerAsistencia();
        if (asistentes.isEmpty()){
            sb.append("Sin asistentes registrados\n\n");
        }
        else {
            for (Invitable a : asistentes) {
                sb.append(" -").append(a).append("\n");
            }
            sb.append("\n");
        }

        //Ausentes
        sb.append("Ausentes: \n");
        List<Invitable> ausentes = reunion.obtenerAusencias();
        if (ausentes.isEmpty()){
            sb.append("Sin ausentes\n\n");
        }
        else {
            for (Invitable a : ausentes) {
                sb.append("-").append(a).append("\n");
            }
            sb.append("\n");
        }

        //Retrasos
        sb.append("Retrasos: \n");
        List<Retraso> retrasos = reunion.obtenerRetrasos();
        if (retrasos.isEmpty()){
            sb.append("Sin retrasos\n\n");
        }
        else {
            for (Retraso r : retrasos) {
                sb.append("-").append(r).append("\n");
            }
            sb.append("\n");
        }

        //Estadisticas
        sb.append("Total asistentes: ").append(reunion.obtenerTotalAsistencia()).append("\n");
        sb.append("Porcentaje de asistencia: ").append(reunion.obtenerPorcentajeAsistencia()).append("\n\n");

        //Notas
        List<Nota> notas = reunion.getNotas();

        sb.append("Notas: \n");
        if (notas.isEmpty()){
            sb.append("No se registran notas\n\n");
        }
        else{
            for (Nota nota : notas){
                sb.append(nota.getAutor()).append(": ");
                sb.append(nota.getContenido()).append("\n");
            }
        }

        return sb.toString();
    }

    /**
     * Getter del nombre del archivo generado
     * @return nombre del archivo txt
     */
    public String getNombreArchivo() {
        return nombreReunion;
    }
}