package UnitTests;
import Reuniones.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/**
 * Clase dedicada a Tests Unitarios sobre la generacion de archivos por TxtReunion.
 * Se prueba:
 * - Creacion correcta del nombre del archivo
 * - Archivo posea toda la informacion esperada
 * - Archivo correctamente guardado como un .txt en el computador
 */
public class TestTxtReunion {

    private Empleado organizador;
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private tipoReunion tipo;
    private ReunionPresencial reunionPresencial;
    private ReunionVirtual reunionVirtual;

    @BeforeEach
    void setup() {

        organizador = new Empleado("505", "Sanhueza", "Martin", "msanhueza2030@udec.cl");
        fecha = new Date();
        horaPrevista = Instant.now();
        duracionPrevista = Duration.ofMinutes(120);
        tipo = tipoReunion.MARKETING;

        reunionPresencial = new ReunionPresencial(fecha, horaPrevista, duracionPrevista, tipo, organizador, "Sala de Conferencias 204");
        reunionVirtual = new ReunionVirtual(fecha, horaPrevista, duracionPrevista, tipo, organizador, "zoom.com/cnf340");
    }

    @Test
    @DisplayName("Test Nombre del archivo correctamente generado")
    void nombreArchivoCorrecto() {

        TxtReunion txt = new TxtReunion(reunionPresencial);
        String nombre = txt.getNombreArchivo();

        assertNotNull(nombre);
        assertTrue(nombre.startsWith("Reunion"));
        assertTrue(nombre.endsWith(".txt"));
    }

    @Test
    @DisplayName("Test Formato de datos para reunion presencial")
    void generarDataPresencialCorrecto() {

        reunionPresencial.iniciar();
        Empleado emp = new Empleado("001", "Sunderland", "Mary", "msunderland2030@udec.cl");
        reunionPresencial.agregarInvitacion(emp);
        reunionPresencial.agregarAsistente(emp);

        Nota nota = new Nota("Nota comun", organizador);
        reunionPresencial.agregarNota(nota);

        TxtReunion txt = new TxtReunion(reunionPresencial);
        String data = txt.generarData();

        assertNotNull(data);
        assertTrue(data.contains("Informe Reunion:"));
        assertTrue(data.contains("Modalidad: Presencial"));
        assertTrue(data.contains("Sala: Sala de Conferencias 204"));
        assertTrue(data.contains("Total asistentes: 1"));
        assertTrue(data.contains("Nota comun"));
        assertTrue(data.contains("Martin"));
    }

    @Test
    @DisplayName("Test Formato de datos para reunion virtual")
    void generarDataVirtualCorrecto() {

        TxtReunion txt = new TxtReunion(reunionVirtual);
        String data = txt.generarData();

        assertNotNull(data);
        assertTrue(data.contains("Modalidad: Virtual"));
        assertTrue(data.contains("Enlace: zoom.com/cnf340"));
        assertTrue(data.contains("Sin asistentes registrados"));
        assertTrue(data.contains("No se registran notas"));
    }

    @Test
    @DisplayName("Test Escritura de archivo .txt en el computador")
    void generarTxtFisicoCorrecto() {

        TxtReunion txt = new TxtReunion(reunionPresencial);

        assertDoesNotThrow(()
                -> txt.generarTxt()
        );
    }
}