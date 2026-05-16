package Reuniones;

/**
 * Clase que representa a un empleado
 * Almacena la informacion de identificacion y correo de un empleado
 */
public class Empleado {
    private String id;         // id del empleado
    private String apellidos;  // apellidos del empleado
    private String nombre;     // nombre del empleado
    private String correo;     // correo del empleado

    /**
     * Constructor de clase Empleado
     * @param id          id del empleado
     * @param apellidos   apellidos del empleado
     * @param nombre      nombre del empleado
     * @param correo      correo del empleado
     */
    public Empleado(String id, String apellidos, String nombre, String correo) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
    }

    /**
     * Metodo toString con la identificacion completa del empleado
     *
     * @return String con nombre, apellidos, id y correo del empleado
     */
    @Override
    public String toString(){
        return "Empleado{nombre = "+nombre + ", apellidos = " + apellidos + ", id = " + id + ", correo = " + correo + "}";
    }
}