package Reuniones;

import Reuniones.Excepciones.AutorVacioException;
import Reuniones.Excepciones.NotaVaciaException;
import java.time.Instant;

/**
 * Clase que representa una nota escrita durante una reunion.
 */
public class Nota {

    private String contenido;
    private Instant fechaHora;
    private Empleado autor;

    /**
     * Constructor de la clase Nota.
     *
     * @param contenido contenido de la nota
     * @param autor empleado que escribe la nota
     * @throws NotaVaciaException si el contenido está vacío
     */
    public Nota(String contenido, Empleado autor) {

        if (contenido == null || contenido.isBlank()) {
            throw new NotaVaciaException("La nota no puede estar vacía.");
        }
        if (autor == null){
            throw new AutorVacioException("El autor debe ser valido.");
        }
        this.contenido = contenido;
        this.autor = autor;
        this.fechaHora = Instant.now();
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Instant getFechaHora() {
        return fechaHora;
    }

    public Empleado getAutor() {
        return autor;
    }

    public void setAutor(Empleado autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Nota{contenido = "+ contenido + ", fechaHora = " + fechaHora + ", autor = " + autor + "}";
    }
}
