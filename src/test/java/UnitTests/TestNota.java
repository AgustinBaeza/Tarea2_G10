package UnitTests;
import Reuniones.Nota;
import Reuniones.Empleado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Reuniones.Excepciones.NotaVaciaException;
import Reuniones.Excepciones.AutorVacioException;
import java.time.Instant;

/**
 * Clase dedicada a Tests Unitarios sobre clase Nota
 * Se prueba:
 * - Creacion correcta de objeto Nota con contenido y autor validos
 * - Excepciones en constructor por contenido vacio o autor nulo
 * - Modificacion de contenido mediante setter y sus respectivas excepciones
 * - Registro correcto del instante de tiempo de la nota
 */
public class TestNota {

    private Empleado autorNota;
    private Nota nota;

    @BeforeEach
    void setup() {

        autorNota = new Empleado("067", "Vera", "Carlos", "cvera2067@udec.cl");
        nota = new Nota("Nota de prueba 1", autorNota);
    }

    @Test
    @DisplayName("Test Creacion correcta de nota")
    void notaCorrecta() {

        assertEquals("Nota de prueba 1", nota.getContenido());
        assertEquals(autorNota, nota.getAutor());
    }

    @Test
    @DisplayName("Test Nota con contenido nulo")
    void notaNula() {

        assertThrows(NotaVaciaException.class,() -> {
            new Nota(null, autorNota);
        });
    }

    @Test
    @DisplayName("Test Nota con texto vacio")
    void notaVacia() {

        assertThrows(NotaVaciaException.class,() -> {
            new Nota("  ", autorNota);
        });
    }

    @Test
    @DisplayName("Test Nota con autor nulo")
    void autorNuloConstructor() {

        assertThrows(AutorVacioException.class,() -> {
            new Nota("Apunte 1", null);
        });
    }

    @Test
    @DisplayName("Test Modificar contenido de nota correctamente")
    void modificarContenidoCorrecto() {

        nota.setContenido("Correccion nota de prueba 1");
        assertEquals("Correccion nota de prueba 1", nota.getContenido());
    }

    @Test
    @DisplayName("Test Modificar contenido con nulo")
    void modificarContenidoNulo() {

        assertThrows(NotaVaciaException.class,() -> {
            nota.setContenido(null);
        });
    }

    @Test
    @DisplayName("Test Modificar contenido con cadena vacia")
    void modificarContenidoVacio() {

        assertThrows(NotaVaciaException.class,() -> {
            nota.setContenido("  ");
        });
    }

    @Test
    @DisplayName("Test Registro correcto de la hora de la nota")
    void verificarHoraNota() {

        Nota nuevaNota = new Nota("Apunte importante", autorNota);
        Instant hora = Instant.now();

        assertNotNull(nuevaNota.getFechaHora());
        assertTrue(nuevaNota.getFechaHora().isBefore(hora.plusSeconds(1))); // prueba de tiempo con margen de 1 segundo
    }
}