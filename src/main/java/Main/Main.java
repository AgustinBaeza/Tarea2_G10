package Main;

import Reuniones.*;
import Reuniones.Excepciones.*;
import java.sql.Date;
import java.time.Duration;
import java.time.Instant;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        //empleados
        Empleado ana    = new Empleado("1", "Diaz",    "Ana",    "ana@empresa.com");
        Empleado juan   = new Empleado("2", "Garcia",  "Juan",   "juan@empresa.com");
        Empleado maria  = new Empleado("3", "Lopez",   "Maria",  "maria@empresa.com");
        Empleado carlos = new Empleado("4", "Perez",   "Carlos", "carlos@empresa.com");

        //departamento
        Departamento java = new Departamento("java");
        java.addEmpleado(juan);
        java.addEmpleado(maria);

        //invitado externo
        InvitadoExterno externo = new InvitadoExterno("Pedro", "Ramirez", "pedro@yopmail.com");

        //crear reunion
        Reunion r = new ReunionVirtual(
                new Date(122,0,3),
                Instant.now(),
                Duration.ofMinutes(15),
                tipoReunion.TECNICA,
                ana,
                "zoom.com/kajfljdalsda"
        );

        //invitaciones
        r.agregarInvitacion(java);
        r.agregarInvitacion(carlos);
        r.agregarInvitacion(externo);

        //iniciar reunion
        r.iniciar();

        //prueba EstadoReunionException: no permite iniciar dos veces la misma reunion
        try {
            r.iniciar();
        } catch (EstadoReunionException e) {
            System.out.println("Prueba EstadoReunionException OK: " + e.getMessage());
        }

        //asistencia
        r.agregarAsistente(maria);
        r.agregarAsistente(externo);
        r.agregarAusente(carlos);

        //prueba ContradiccionException: Maria ya esta como asistente, no puede registrarse como ausente
        try {
            r.agregarAusente(maria);
        } catch (ContradiccionException e) {
            System.out.println("Prueba ContradiccionException OK: " + e.getMessage());
        }

        //prueba ContradiccionException: Carlos ya esta como ausente, no puede registrarse como asistente
        try {
            r.agregarAsistente(carlos);
        } catch (ContradiccionException e) {
            System.out.println("Prueba ContradiccionException OK: " + e.getMessage());
        }

        //prueba EstadoReunionException: no permite finalizar una reunion que no ha iniciado
        Reunion reunionSinIniciar = new ReunionVirtual(
                new Date(122,0,3),
                Instant.now(),
                Duration.ofMinutes(15),
                tipoReunion.TECNICA,
                ana,
                "zoom.com/prueba"
        );

        try {
            reunionSinIniciar.finalizar();
        } catch (EstadoReunionException e) {
            System.out.println("Prueba EstadoReunionException OK: " + e.getMessage());
        }

        //retraso
        Thread.sleep(100);
        Retraso retrasoJuan = new Retraso(juan, Instant.now());
        r.registrarRetraso(retrasoJuan);

        //notas
        Nota n1 = new Nota("Esta buenisima la reunion :)" , maria);
        r.agregarNota(n1);
        Nota n2 = new Nota("Ya me aburri :v" , carlos);
        r.agregarNota(n2);

        //fin reunion
        Thread.sleep(1000);
        r.finalizar();

        //prueba EstadoReunionException: no permite finalizar dos veces la misma reunion
        try {
            r.finalizar();
        } catch (EstadoReunionException e) {
            System.out.println("Prueba EstadoReunionException OK: " + e.getMessage());
        }

        TxtReunion txt = new TxtReunion(r);
        txt.generarTxt();
        System.out.println(txt.getNombreArchivo());
    }
}
