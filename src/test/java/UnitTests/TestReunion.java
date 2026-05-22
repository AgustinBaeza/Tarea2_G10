package UnitTests;
import Reuniones.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Reuniones.Excepciones.ReunionInvalidaException;
import Reuniones.Excepciones.EstadoReunionException;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

/**
 * Clase dedicada a Tests Unitarios sobre la jerarquia de la clase Reunion
 * Se prueba:
 * - Creacion correcta de subclases ReunionPresencial y ReunionVirtual
 * - Validacion de argumentos nulos en constructores
 * - Correcto funcionamiento de Getters
 * - Flujo correcto de inicializacion y finalizacion de una reunion
 * - Control sobre dobles inicializaciones y finalizaciones
 * - Funcionamiento correcto de metodos dedicados a registros, notas y calculo de estadisticas sobre la reunion
 */
public class TestReunion {

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
    @DisplayName("Test Creacion correcta de reunion presencial con su sala")
    void reunionPresencialCorrecta() {

        assertNotNull(reunionPresencial);
        assertEquals("Sala de Conferencias 204", reunionPresencial.getSala());
        assertEquals(organizador, reunionPresencial.getOrganizador());
        assertEquals(duracionPrevista, reunionPresencial.getDuracionPrevista());
    }

    @Test
    @DisplayName("Test Creacion correcta de reunion virtual con su enlace")
    void reunionVirtualCorrecta() {

        assertNotNull(reunionVirtual);
        assertEquals("zoom.com/cnf340", reunionVirtual.getEnlace());
        assertEquals(fecha, reunionVirtual.getFecha());
        assertEquals(tipo, reunionVirtual.getTipo());
    }

    @Test
    @DisplayName("Test Reunion virtual con duracion prevista nula")
    void duracionPrevistaNula() {

        assertThrows(ReunionInvalidaException.class,() -> {
            new ReunionVirtual(fecha, horaPrevista, null, tipo, organizador, "zoom.com/cnf340");
        });
    }

    @Test
    @DisplayName("Test Reunion presencial con tipo nulo")
    void tipoNuloConstructor() {

        assertThrows(ReunionInvalidaException.class,() -> {
            new ReunionPresencial(fecha, horaPrevista, duracionPrevista, null, organizador, "Sala Auditorio");
        });
    }

    @Test
    @DisplayName("Test Reunion presencial con fecha nula")
    void fechaNulaConstructor() {

        assertThrows(ReunionInvalidaException.class,() -> {
            new ReunionPresencial(null, horaPrevista, duracionPrevista, tipo, organizador, "Sala de Conferencias 204");
        });
    }

    @Test
    @DisplayName("Test Getter de la hora prevista de la reunion")
    void horaPrevistaCorrecta() {

        assertEquals(horaPrevista, reunionPresencial.getHoraPrevista());
    }

    @Test
    @DisplayName("Test Getter de la lista de invitaciones")
    void invitacionesCorrecto() {

        Empleado emp = new Empleado("001", "Sunderland", "Mary", "msunderland2030@udec.cl");
        reunionPresencial.agregarInvitacion(emp);

        assertNotNull(reunionPresencial.getInvitaciones());
        assertEquals(1, reunionPresencial.getInvitaciones().size());
        assertEquals(emp, reunionPresencial.getInvitaciones().get(0).getInvitado());
    }

    @Test
    @DisplayName("Test Getter asistencias")
    void verificarObtenerAsistencia() {

        Empleado emp = new Empleado("777", "Teto", "Kasane", "kteto2030@udec.cl");
        reunionPresencial.agregarAsistente(emp);

        assertNotNull(reunionPresencial.obtenerAsistencia());
        assertEquals(1, reunionPresencial.obtenerAsistencia().size());
        assertTrue(reunionPresencial.obtenerAsistencia().contains(emp));
    }

    @Test
    @DisplayName("Test Getter ausencias")
    void obtenerAusenciasCorrecto() {

        Empleado emp = new Empleado("020", "Aros Quinan", "Victor", "varos@udec.cl");
        reunionPresencial.agregarAusente(emp);

        assertNotNull(reunionPresencial.obtenerAusencias());
        assertEquals(1, reunionPresencial.obtenerAusencias().size());
        assertTrue(reunionPresencial.obtenerAusencias().contains(emp));
    }

    @Test
    @DisplayName("Test Getter retrasos")
    void obtenerRetrasosCorrecto() {

        Empleado emp = new Empleado("333", "Torres", "Luis", "ltorres@udec.cl");
        Retraso ret = new Retraso(emp, Instant.now());
        reunionPresencial.registrarRetraso(ret);

        assertNotNull(reunionPresencial.obtenerRetrasos());
        assertEquals(1, reunionPresencial.obtenerRetrasos().size());
        assertTrue(reunionPresencial.obtenerRetrasos().contains(ret));
    }

    @Test
    @DisplayName("Test Getter Total de Asistencias")
    void obtenerTotalAsistenciaCorrecto() {

        Empleado emp1 = new Empleado("033", "York", "Ton", "tyork@udec.cl");
        Empleado emp2 = new Empleado("044", "Gomez", "Hector", "hgomez@udec.cl");

        assertEquals(0, reunionVirtual.obtenerTotalAsistencia());
        reunionVirtual.agregarAsistente(emp1);
        reunionVirtual.agregarAsistente(emp2);
        assertEquals(2, reunionVirtual.obtenerTotalAsistencia());
    }

    @Test
    @DisplayName("Test Getter total de invitados")
    void calculoTotalInvitados() {

        Empleado emp1 = new Empleado("003", "Cifuentes", "Tomas", "tcifuentes2030@udec.cl");
        InvitadoExterno ext1 = new InvitadoExterno("Daniela","Inostroza","dinostroza@gmail.com");
        Departamento depto = new Departamento("RRHH");
        depto.addEmpleado(emp1);

        reunionPresencial.agregarInvitacion(emp1);
        reunionPresencial.agregarInvitacion(ext1);
        reunionPresencial.agregarInvitacion(depto);

        assertEquals(3, reunionPresencial.getTotalInvitados());
    }

    @Test
    @DisplayName("Test Flujo correcto iniciar y finalizar una reunion virtual")
    void flujoReunionVirtual() {

        assertNull(reunionVirtual.getHoraInicio());
        assertNull(reunionVirtual.getHoraFin());

        reunionVirtual.iniciar();
        assertNotNull(reunionVirtual.getHoraInicio());

        reunionVirtual.finalizar();
        assertNotNull(reunionVirtual.getHoraFin());
        assertNotNull(reunionVirtual.getHoraInicio());
    }

    @Test
    @DisplayName("Test Flujo correcto iniciar y finalizar una reunion presencial")
    void flujoReunionPresencial() {

        assertNull(reunionPresencial.getHoraInicio());
        assertNull(reunionPresencial.getHoraFin());

        reunionPresencial.iniciar();
        assertNotNull(reunionPresencial.getHoraInicio());

        reunionPresencial.finalizar();
        assertNotNull(reunionPresencial.getHoraFin());
        assertNotNull(reunionPresencial.getHoraInicio());
    }

    @Test
    @DisplayName("Test Iniciar una reunion ya iniciada")
    void dobleInicializacionReunion() {

        reunionPresencial.iniciar();
        assertThrows(EstadoReunionException.class,() -> {
            reunionPresencial.iniciar();
        });
    }

    @Test
    @DisplayName("Test Finalizar una reunion que no ha empezado")
    void finalizarNoIniciada() {

        assertThrows(EstadoReunionException.class,() -> {
            reunionPresencial.finalizar();
        });
    }

    @Test
    @DisplayName("Test Iniciar una reunion ya finalizada")
    void iniciarFinalizada() {

        reunionVirtual.iniciar();
        reunionVirtual.finalizar();
        assertThrows(EstadoReunionException.class,() -> {
            reunionVirtual.iniciar();
        });
    }

    @Test
    @DisplayName("Test Finalizar una reunion ya finalizada")
    void dobleFinalizacion() {

        reunionVirtual.iniciar();
        reunionVirtual.finalizar();
        assertThrows(EstadoReunionException.class,() -> {
            reunionVirtual.finalizar();
        });
    }

    @Test
    @DisplayName("Test Calculo tiempo real con reunion sin comenzar y sin finalizar")
    void tiempoReunionIncompleta() {

        assertEquals(0.0f, reunionPresencial.calcularTiempoReal());
        reunionPresencial.iniciar();
        assertEquals(0.0f, reunionPresencial.calcularTiempoReal());
    }

    @Test
    @DisplayName("Test Agregar notas correctamente a la reunion")
    void agregarNotasReunion() {

        Nota nota = new Nota("Nota sumamente importante", organizador);
        reunionPresencial.agregarNota(nota);

        assertEquals(1, reunionPresencial.getNotas().size());
        assertEquals(nota, reunionPresencial.getNotas().get(0));
    }

    @Test
    @DisplayName("Test metodos Invitaciones, Asistencias, Ausencias y Retrasos correctos")
    void metodosRegistros() {

        Empleado empl_presente = new Empleado("001", "Ikari", "Shinji", "sikari2015@udec.cl");
        Empleado empl_presente2 = new Empleado("002", "Bloodborne", "John", "jbloodborne2015@udec.cl");
        Empleado empl_ausente = new Empleado("003","Sunderland","James","jsunderland1999@udec.cl");
        Empleado empl_atrasado = new Empleado("004", "Snake","Venom","keptyouwaitinghuh@diamonddogs.com");
        Retraso retr = new Retraso(empl_atrasado, Instant.now());

        reunionVirtual.agregarInvitacion(empl_presente);
        reunionVirtual.agregarInvitacion(empl_presente2);
        reunionVirtual.agregarInvitacion(empl_ausente);
        reunionVirtual.agregarInvitacion(empl_atrasado);

        reunionVirtual.agregarAsistente(empl_presente);
        reunionVirtual.agregarAsistente(empl_presente2);
        reunionVirtual.agregarAusente(empl_ausente);
        reunionVirtual.agregarAsistente(empl_atrasado);
        reunionVirtual.registrarRetraso(retr);

        assertTrue(reunionVirtual.obtenerAsistencia().contains(empl_presente));
        assertTrue(reunionVirtual.obtenerAsistencia().contains(empl_presente2));
        assertTrue(reunionVirtual.obtenerAsistencia().contains(empl_atrasado));
        assertTrue(reunionVirtual.obtenerAusencias().contains(empl_ausente));
        assertTrue(reunionVirtual.obtenerRetrasos().contains(retr));

        assertEquals(3, reunionVirtual.obtenerTotalAsistencia());
        assertEquals(75.0, reunionVirtual.obtenerPorcentajeAsistencia());
    }
}