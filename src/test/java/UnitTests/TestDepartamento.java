package UnitTests;
import Reuniones.Departamento;
import Reuniones.Empleado;
import Reuniones.Invitable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Reuniones.Excepciones.DepartamentoInvalidoException;
import Reuniones.Excepciones.DepartamentoVacioException;
import Reuniones.Excepciones.EmpleadoInvalidoException;

/**
 * Clase dedicada a Tests Unitarios sobre clase Departamento
 * Se prueba:
 * - Creacion correcta de objeto Departamento
 * - Excepciones en constructor por argumentos invalidos
 * - Manipulación de empleados (añadir, remover, obtener) y sus limites
 * - Comportamiento del metodo invitar y sus excepciones de estado
 * - Implementacion de la interfaz Invitable
 */
public class TestDepartamento {

    private Departamento depto;
    private Departamento depto2;
    private Empleado empleado;
    private Empleado empleado2;

    @BeforeEach
    void setup() {

        depto = new Departamento("Marketing");
        empleado = new Empleado("333", "Palma", "Diego", "dpalma@udec.cl");
        depto2 = new Departamento("RRHH");
        empleado2 = new Empleado("001","Cofre","Cristobal","ccofre@udec.cl");
    }

    @Test
    @DisplayName("Test Creacion correcta de departamento")
    void departamentoCorrecto() {

        assertEquals("Marketing", depto.getNombre());
        assertNotNull(depto.getDepartamento());
        assertEquals(0, depto.obtenerCantidadEmpleados());
    }

    @Test
    @DisplayName("Test Departamento nombre nulo")
    void nombreDepartamentoNulo() {

        assertThrows(DepartamentoInvalidoException.class,() -> {
            new Departamento(null);
        });
    }

    @Test
    @DisplayName("Test Departamento nombre vacio")
    void nombreDepartamentoVacio() {

        assertThrows(DepartamentoInvalidoException.class,() -> {
            new Departamento("   ");
        });
    }

    @Test
    @DisplayName("Test Agregar empleado incrementa el contador")
    void agregarEmpleado() {

        depto.addEmpleado(empleado);
        assertEquals(1, depto.obtenerCantidadEmpleados());
        assertEquals(empleado, depto.getEmpleadoDepartamento(0));
    }

    @Test
    @DisplayName("Test Eliminar empleado existente correctamente")
    void eliminarEmpleadoExistente() {

        depto.addEmpleado(empleado);
        depto.removeEmpleado(empleado);
        assertEquals(0, depto.obtenerCantidadEmpleados());
    }

    @Test
    @DisplayName("Test Eliminar empleado que no pertenece al departamento")
    void eliminarEmpleadoInexistente() {

        Empleado inexistente = new Empleado("444", "Palma", "Felipe", "fpalma@udec.cl");
        assertThrows(EmpleadoInvalidoException.class,() -> {
            depto.removeEmpleado(inexistente);
        });

    }

    @Test
    @DisplayName("Test Obtener empleado en posicion valida")
    void obtenerEmpleadoValido() {

        depto.addEmpleado(empleado);
        Empleado extraido = depto.getEmpleadoDepartamento(0);
        assertEquals(empleado, extraido);
    }

    @Test
    @DisplayName("Test Obtener empleado fuera de rango")
    void obtenerEmpleadoFueraRango() {

        assertThrows(EmpleadoInvalidoException.class,()-> {
            depto.getEmpleadoDepartamento(2);
        });
        assertThrows(EmpleadoInvalidoException.class,() -> {
            depto.getEmpleadoDepartamento(-1);
        });
    }

    @Test
    @DisplayName("Test Obtener empleado con indice fuera de rango")
    void obtenerEmpleadoIndiceFueraRango() {

        depto.addEmpleado(empleado);
        assertThrows(EmpleadoInvalidoException.class,() -> {
            depto.getEmpleadoDepartamento(1);
        });
    }

    @Test
    @DisplayName("Test Intentar invitar a un departamento vacio lanza excepcion")
    void invitarDepartamentoVacio() {

        assertThrows(DepartamentoVacioException.class,() -> {
            depto.invitar();
        });
    }

    @Test
    @DisplayName("Test Invitar departamento con empleados funciona correctamente")
    void invitarDepartamentoEmpleados() {

        depto.addEmpleado(empleado);
        depto2.addEmpleado(empleado2);
        assertDoesNotThrow(() -> {
            depto.invitar();
            depto2.invitar();
        });
    }

    @Test
    @DisplayName("Test Clase Departamento implementa interfaz Invitable")
    void departamentoImplementaInvitable() {

        assertInstanceOf(Invitable.class, depto);
    }
}