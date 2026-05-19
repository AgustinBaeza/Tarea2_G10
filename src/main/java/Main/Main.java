package Main;

import Reuniones.*;

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

        //asistencia
        r.agregarAsistente(maria);
        r.agregarAsistente(externo);
        r.agregarAusente(carlos);

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

        TxtReunion txt = new TxtReunion(r);
        txt.generarTxt();
        System.out.println(txt.getNombreArchivo());
    }
}
