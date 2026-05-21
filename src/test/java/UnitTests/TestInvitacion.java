package UnitTests;
import Reuniones.Invitacion;
import Reuniones.Empleado;
import Reuniones.InvitadoExterno;
import Reuniones.Departamento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Reuniones.Excepciones.InvitacionInvalidaException;
import Reuniones.Excepciones.DepartamentoVacioException;
import java.time.Instant;

/**
 * Clase dedicada a Tests Unitarios sobre clase Invitacion
 * Se prueba:
 * - Creación correcta de objeto Invitacion con distintos tipos de Invitables (Empleado, InvitadoExterno, Departamento)
 * - Excepción al inicializar con un invitado nulo
 * - Comportamiento de la invitacion ante un Departamento vacio
 * - Registro correcto del instante de tiempo de la invitación
 */
public class TestInvitacion {

    private Empleado empleado;
    private InvitadoExterno externo;
    private Departamento deptoGente;
    private Departamento deptoVacio;

    @BeforeEach
    void setup() {

        empleado = new Empleado("777", "Puente", "Rene", "rpuente2030@udec.cl");
        externo = new InvitadoExterno("Angel", "Sensacion Cabrales", "asensacion@gmail.com");

        deptoGente = new Departamento("Informatica");
        deptoGente.addEmpleado(empleado);

        deptoVacio = new Departamento("Comerciales");
    }

    @Test
    @DisplayName("Test Creacion correcta de invitacion con Empleado")
    void invitacionEmpleado() {

        Invitacion inv = new Invitacion(empleado);
        assertEquals(empleado, inv.getInvitado());
    }

    @Test
    @DisplayName("Test Creacion correcta de invitacion con Invitado Externo")
    void invitacionExterno() {

        Invitacion inv = new Invitacion(externo);
        assertEquals(externo, inv.getInvitado());
    }

    @Test
    @DisplayName("Test Creacion correcta de invitacion con Departamento con empleados")
    void invitacionDepartamentoValido() {

        Invitacion inv = new Invitacion(deptoGente);
        assertEquals(deptoGente, inv.getInvitado());
    }

    @Test
    @DisplayName("Test Crear invitacion con Departamento vacio lanza excepcion")
    void invitacionDepartamentoVacio() {

        assertThrows(DepartamentoVacioException.class,() -> {
            new Invitacion(deptoVacio);
        });
    }

    @Test
    @DisplayName("Test Invitacion con invitado nulo lanza excepcion")
    void invitadoNulo() {

        assertThrows(InvitacionInvalidaException.class,() -> {
            new Invitacion(null);
        });
    }

    @Test
    @DisplayName("Test Registro correcto de la hora de la invitacion")
    void verificarHoraInvitacion() {

        Invitacion inv = new Invitacion(empleado);
        Instant hora = Instant.now();

        assertNotNull(inv.getHora());
        assertTrue(inv.getHora().isBefore(hora.plusSeconds(1))); // prueba de tiempo con margen de 1 segundo
    }
}