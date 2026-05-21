package UnitTests;
import Reuniones.InvitadoExterno;
import Reuniones.Invitable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Reuniones.Excepciones.InvitadoInvalidoException;

/**
 * Clase dedicada a Tests Unitarios sobre clase InvitadoExterno
 * Se prueba:
 * - Creacion correcta de objeto InvitadoExterno
 * - Excepciones al inicializar atributos como objetos nulos o cadenas vacias
 * - Implementacion de interfaz Invitable
 */
public class TestInvitadoExterno {

    private InvitadoExterno invitado;

    @BeforeEach
    void setup() {
        invitado = new InvitadoExterno("Rene", "Puente Run", "rpuente2030@gmail.com");
    }

    @Test
    @DisplayName("Test Creacion correcta de invitado externo")
    void invitadoCorrecto() {

        assertEquals("Rene", invitado.getNombre());
        assertEquals("Puente Run", invitado.getApellidos());
        assertEquals("rpuente2030@gmail.com", invitado.getCorreo());
    }

    @Test
    @DisplayName("Test Invitado Externo nombre nulo")
    void nombreInvitadoNulo() {

        assertThrows(InvitadoInvalidoException.class,() -> {
            new InvitadoExterno(null, "Puente Run", "rpuente2030@gmail.com");
        });
    }

    @Test
    @DisplayName("Test Invitado Externo nombre con cadena vacia")
    void nombreInvitadoVacio() {

        assertThrows(InvitadoInvalidoException.class,() -> {
            new InvitadoExterno("  ", "Puente Run", "rpuente2030@gmail.com");
        });
    }

    @Test
    @DisplayName("Test Invitado Externo apellidos nulo")
    void apellidoInvitadoNulo() {

        assertThrows(InvitadoInvalidoException.class,() -> {
            new InvitadoExterno("Rene", null, "rpuente2030@gmail.com");
        });
    }

    @Test
    @DisplayName("Test Invitado Externo apellidos vacio")
    void apellidoInvitadoVacio() {

        assertThrows(InvitadoInvalidoException.class,() -> {
            new InvitadoExterno("Rene", "   ", "rpuente2030@gmail.com");
        });
    }

    @Test
    @DisplayName("Test Invitado Externo correo nulo")
    void correoInvitadoNulo() {

        assertThrows(InvitadoInvalidoException.class,() -> {
            new InvitadoExterno("Rene", "Puente Run", null);
        });
    }

    @Test
    @DisplayName("Test Invitado Externo correo vacio")
    void correoInvitadoVacio() {

        assertThrows(InvitadoInvalidoException.class,() -> {
            new InvitadoExterno("Rene", "Puente Run", " ");
        });
    }

    @Test
    @DisplayName("Test Clase InvitadoExterno implementa interfaz Invitable")
    void invitadoImplementaInvitable() {

        assertInstanceOf(Invitable.class, invitado);
    }
}

