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

    /**
     * Getter del contenido de la nota
     * @return contenido de la nota como String
     */
    public String getContenido() {
        return contenido;
    }

    /**
     * Setter del contenido de la nota
     * @param contenido String que detalla lo que se busca escribir en la nota
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    /**
     * Getter de la fecha junto a la hora en que fue realizada la nota
     * @return objeto Instant con la fecha y la hora en que se realizo la nota
     */
    public Instant getFechaHora() {
        return fechaHora;
    }

    /**
     * Getter del autor de la nota
     * @return autor de la nota como objeto Empleado
     */
    public Empleado getAutor() {
        return autor;
    }

    /**
     * Setter del autor de la nota
     * @param autor objeto Empleado correspondiente a quien hizo la nota
     */
    public void setAutor(Empleado autor) {
        this.autor = autor;
    }

    /**
     * toString que devuelve los detalles sobre la nota
     * @return contenido de la nota, hora en que se realizo y el autor de esta como objeto String
     */
    @Override
    public String toString() {
        return "Nota{contenido = "+ contenido + ", fechaHora = " + fechaHora + ", autor = " + autor + "}";
    }
}
