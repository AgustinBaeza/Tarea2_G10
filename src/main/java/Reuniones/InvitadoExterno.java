package Reuniones;

import Reuniones.Excepciones.InvitadoInvalidoException;

/**
 * Clase que representa a un invitado externo a la empresa
 * Implementa interfaz Invitable para poder ser invitado a las reuniones que se realicen
 * Se requiere de un nombre y apellidos del invitado ademas de su correo electronico
 */
public class InvitadoExterno implements Invitable{
    private String nombre;
    private String apellidos;
    private String correo;

    /**
     * Constructor de la clase InvitadoExterno
     * @param nombre nombre del invitado externo
     * @param apellidos apellidos del invitado externo
     * @param correo correo electronico del invitado externo
     * @throws InvitadoInvalidoException puede lanzar esta excepción si el nombre/apellidos o el correo ingresado son nulos o estan vacios
     */
    public InvitadoExterno(String nombre, String apellidos, String correo){

        if(nombre == null || nombre.isBlank()){
            throw new InvitadoInvalidoException("El nombre del invitado externo debe ser valido.");
        }

        if(apellidos == null || apellidos.isBlank()){
            throw new InvitadoInvalidoException("Los apellidos del invitado externo deben ser validos.");
        }

        if(correo == null || correo.isBlank()){
            throw new InvitadoInvalidoException("El correo del invitado externo debe ser valido.");
        }

        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
    }

    /**
     * Getter del nombre del invitado externo
     * @return nombre del invitado externo
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * Getter de los apellidos del invitado externo
     * @return apellidos del invitado externo
     */
    public String getApellidos(){
        return apellidos;
    }

    /**
     * Setter del nombre del invitado externo
     * @param nombre recibe nuevo nombre del invitado externo
     * @throws InvitadoInvalidoException puede lanzar esta excepcion si el nombre es nulo o esta vacío
     */
    public void setNombre(String nombre){
        if(nombre == null || nombre.isBlank()){
            throw new InvitadoInvalidoException("El nombre del invitado externo debe ser valido.");
        }

        this.nombre = nombre;
    }

    /**
     * Setter de los apellidos invitado externo
     * @param apellidos recibe nuevos apellidos del invitado externo
     * @throws InvitadoInvalidoException puede lanzar esta excepcion si los apellidos son nulos o estan vacios
     */
    public void setApellidos(String apellidos){
        if(apellidos == null || apellidos.isBlank()){
            throw new InvitadoInvalidoException("Los apellidos del invitado externo deben ser validos.");
        }
    }

    /**
     * Setter del correo del invitado externo
     * @param correo se recibe nuevo correo del invitado externo
     * @throws InvitadoInvalidoException puede lanzar esta excepcion si el correo esta vacio o es nulo
     */
    public void setCorreo(String correo){
        if(correo == null || correo.isBlank()){
            throw new InvitadoInvalidoException("El correo del invitado externo debe ser valido.");
        }

        this.correo = correo;
    }

    /**
     * Metodo que envia la invitacion al invitado externo, siendo la implementacion del metodo declarado en la interfaz Invitable
     * Muestra en consola la invitacion realizada, especificando nombre/apellidos junto al correo del invitado
     */
    @Override
    public void invitar(){
        System.out.println("Invitacion enviada a invitado externo, Nombre completo: "+nombre+" "+apellidos+", Correo: "+correo);
    }

    /**
     * toString que devuelve una representacion del invitado externo en texto
     * @return String con los atributos mas relevantes del invitado externo, su nombre/apellidos y su correo
     */
    @Override
    public String toString(){
        return "InvitadoExterno{nombre = "+nombre+", apellidos = "+apellidos+", correo = "+correo+"}";
    }
}
