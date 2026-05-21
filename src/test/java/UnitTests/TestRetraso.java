package UnitTests;
import Reuniones.Retraso;
import Reuniones.Empleado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Reuniones.Excepciones.RetrasoInvalidoException;
import java.time.Instant;

/**
 * Clase dedicada a Tests Unitarios sobre clase Retraso
 * Se prueba:
 * - Creacion correcta de objeto Retraso con empleado y hora validos
 * - Excepciones en constructor por argumentos nulos
 * - Getters funcionales
 */
public class TestRetraso {

    private Empleado empleado;
    private Instant horaLlegada;
    private Retraso retraso;

    @BeforeEach
    void setup() {

        empleado = new Empleado("001", "Vera Puente", "Carlos", "cvera2067@udec.cl");
        horaLlegada = Instant.now();
        retraso = new Retraso(empleado, horaLlegada);
    }

    @Test
    @DisplayName("Test Creacion correcta de retraso")
    void retrasoCorrecto() {

        assertEquals(empleado, retraso.getEmpleadoRetraso());
        assertEquals(horaLlegada, retraso.getHoraLlegada());
    }

    @Test
    @DisplayName("Test Retraso con empleado nulo")
    void empleadoNulo() {

        assertThrows(RetrasoInvalidoException.class,() -> {
            new Retraso(null, horaLlegada);
        });
    }

    @Test
    @DisplayName("Test Retraso con hora de llegada nula")
    void horaNula() {

        assertThrows(RetrasoInvalidoException.class,() -> {
            new Retraso(empleado, null);
        });
    }
}