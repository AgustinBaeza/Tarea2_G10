package UnitTests;
import Reuniones.Asistencia;
import Reuniones.Invitable;
import Reuniones.Empleado;
import Reuniones.InvitadoExterno;
import Reuniones.Retraso;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Reuniones.Excepciones.RegistroDuplicadoException;
import java.time.Instant;

/**
 * Clase dedicada a Tests Unitarios sobre clase Asistencia
 * Se prueba:
 * - Creacion correcta del objeto Asistencia y sus colecciones iniciales
 * - Registro de asistentes y control de duplicados
 * - Registro de ausentes y control de duplicados
 * - Registro de retrasos de empleados
 * - Calculo del porcentaje de asistencia y manejo de division por cero
 */
public class TestAsistencia {

    private Asistencia asistencia;
    private Invitable empleado;
    private Invitable externo;
    private Retraso retraso;

    @BeforeEach
    void setup() {

        asistencia = new Asistencia();
        empleado = new Empleado("010", "Sancho", "Pancho", "psancho2025@udec.cl");
        externo = new InvitadoExterno("Sandro", "Gomez", "sgomez@gmail.com");
        retraso = new Retraso((Empleado) empleado, Instant.now());
    }

    @Test
    @DisplayName("Test Creacion correcta de asistencia")
    void asistenciaCorrecta() {

        assertNotNull(asistencia.getAsistentes());
        assertNotNull(asistencia.getAusentes());
        assertNotNull(asistencia.getRetrasos());
        assertEquals(0, asistencia.totalAsistentes());
    }

    @Test
    @DisplayName("Test Agregar asistente incrementa el total y almacena el objeto")
    void agregarAsistenteCorrecto() {

        asistencia.agregarAsistente(empleado);
        asistencia.agregarAsistente(externo);
        assertEquals(2, asistencia.totalAsistentes());
        assertTrue(asistencia.getAsistentes().contains(empleado));
        assertTrue(asistencia.getAsistentes().contains(externo));
    }

    @Test
    @DisplayName("Test Agregar asistente duplicado lanza excepcion")
    void asistenteDuplicado() {

        asistencia.agregarAsistente(empleado);
        assertThrows(RegistroDuplicadoException.class,() -> {
            asistencia.agregarAsistente(empleado);
        });
    }

    @Test
    @DisplayName("Test Agregar ausente de forma correcta")
    void agregarAusenteCorrecto() {

        asistencia.agregarAusente(empleado);
        assertEquals(1, asistencia.getAusentes().size());
        assertTrue(asistencia.getAusentes().contains(empleado));
    }

    @Test
    @DisplayName("Test Agregar ausente duplicado lanza excepcion")
    void ausenteDuplicado() {

        asistencia.agregarAusente(externo);
        assertThrows(RegistroDuplicadoException.class,() -> {
            asistencia.agregarAusente(externo);
        });
    }

    @Test
    @DisplayName("Test Registrar un retraso correctamente")
    void registrarRetrasoCorrecto() {

        asistencia.registrarRetraso(retraso);
        assertEquals(1, asistencia.getRetrasos().size());
        assertEquals(retraso, asistencia.getRetrasos().get(0));
    }

    @Test
    @DisplayName("Test Calcular porcentaje de asistencia con cero invitados")
    void porcentajeCeroInvitados() {

        double porcentaje = asistencia.calcularPorcentajeAsistencia(0);
        assertEquals(0.0, porcentaje);
    }

    @Test
    @DisplayName("Test Calcular porcentaje de asistencia con valores validos")
    void porcentajeValoresValidos() {

        asistencia.agregarAsistente(empleado);
        double porcentaje = asistencia.calcularPorcentajeAsistencia(4); // 1 de 4 representa el 25.0%
        assertEquals(25.0, porcentaje);
    }
}