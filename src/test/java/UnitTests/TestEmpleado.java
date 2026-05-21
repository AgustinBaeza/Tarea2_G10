package UnitTests;
import Reuniones.Empleado;
import Reuniones.Invitable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Reuniones.Excepciones.InvitadoInvalidoException;

/**
 * Clase dedicada a Tests Unitarios sobre clase Empleado
 * Se prueba:
 * - Creacion correcta de objeto Empleado
 * - Excepciones al inicializar atributos como objetos nulos o cadenas vacias
 * - Implementacion de Invitable en interfaz
 */
public class TestEmpleado {

    private Empleado empleado;

    @BeforeEach
    void setup() {
        empleado = new Empleado("67", "Diddy Gonzalez", "Cristobal", "cdiddy@udec.cl");
    }

    @Test
    @DisplayName("Test Creacion correcta de empleado")
    void empleadoCorrecto() {

        assertEquals("67", empleado.getId());
        assertEquals("Diddy Gonzalez", empleado.getApellidos());
        assertEquals("Cristobal", empleado.getNombre());
        assertEquals("cdiddy@udec.cl", empleado.getCorreo());
    }

    @Test
    @DisplayName("Test Empleado ID nulo")
    void idEmpleadoNulo() {

        assertThrows(InvitadoInvalidoException.class,() -> {
            new Empleado(null, "Diddy Gonzalez", "Cristobal", "cdiddy@udec.cl");
        });
    }

    @Test
    @DisplayName("Test Empleado ID con cadena vacia")
    void idEmpleadoVacio() {

        assertThrows(InvitadoInvalidoException.class,() -> {
            new Empleado("  ", "Diddy Gonzalez", "Cristobal", "cdiddy@udec.cl");
        });
    }

    @Test
    @DisplayName("Test Empleado apellidos nulo")
    void empleadoApellidoNulo() {

        assertThrows(InvitadoInvalidoException.class,() -> {
            new Empleado("67", null, "Cristobal", "cdiddy@udec.cl");
        });

    }

    @Test
    @DisplayName("Test Empleado apellidos vacio")
    void empleadoApellidosVacio() {

        assertThrows(InvitadoInvalidoException.class,() -> {
            new Empleado("67", "  ", "Cristobal", "cdiddy@udec.cl");
        });
    }

    @Test
    @DisplayName("Test Empleado nombre nulo")
    void empleadoNombreNulo() {

        assertThrows(InvitadoInvalidoException.class,() -> {
            new Empleado("67","Diddy Gonzalez", null, "cdiddy@udec.cl");
        });
    }

    @Test
    @DisplayName("Test Empleado nombre vacio")
    void empleadoNombreVacio() {

        assertThrows(InvitadoInvalidoException.class,() -> {
            new Empleado("67","Diddy Gonzalez", " ", "cdiddy@udec.cl");
        });
    }

    @Test
    @DisplayName("Test Empleado correo nulo")
    void empleadoCorreoNulo() {

        assertThrows(InvitadoInvalidoException.class,() -> {
            new Empleado("67", "Diddy Gonzalez", "Cristobal", null);
        });
    }

    @Test
    @DisplayName("Test Empleado correo vacio")
    void empleadoCorreoVacio() {
        assertThrows(InvitadoInvalidoException.class,() -> {
            new Empleado("67", "Diddy Gonzalez", "Cristobal", "  ");
        });
    }

    @Test
    @DisplayName("Test Clase Empleado implementa interfaz Invitable")
    void empleadoImplementaInvitable() {
        assertInstanceOf(Invitable.class, empleado);
    }
}
