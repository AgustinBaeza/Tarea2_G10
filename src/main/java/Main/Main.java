package Main;

import Reuniones.Asistencia;
import Reuniones.Empleado;
import Reuniones.Nota;
import Reuniones.Retraso;

import java.time.Instant;

public class Main {

    public static void main(String[] args) {

        // Crear empleados
        Empleado empleado1 = new Empleado(
                "1",
                "Flores",
                "Alan",
                "alan@correo.com"
        );

        Empleado empleado2 = new Empleado(
                "2",
                "Flores",
                "Alex",
                "Alex@correo.com"
        );

        // Crear asistencia
        Asistencia asistencia = new Asistencia();

        // Agregar asistentes
        asistencia.agregarAsistente(empleado1);
        asistencia.agregarAsistente(empleado2);

        // Registrar retraso
        Retraso retraso = new Retraso(empleado2,Instant.now());

        asistencia.registrarRetraso(retraso);

        // Crear nota
        Nota nota = new Nota(
                "Se aprobó el presupuesto.",
                empleado1
        );

        // Mostrar información
        System.out.println("** ASISTENCIA **");
        System.out.println(asistencia);

        System.out.println();

        System.out.println("** NOTA **");
        System.out.println(nota);

        System.out.println();

        System.out.println("** TOTAL ASISTENTES **");
        System.out.println(
                asistencia.totalAsistentes()
        );

        System.out.println();

        System.out.println("** PORCENTAJE **");
        System.out.println(
                asistencia.calcularPorcentajeAsistencia(3)
        );
        System.out.println(":)");
    }
}
