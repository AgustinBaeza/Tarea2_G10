package Reuniones;

import Reuniones.Excepciones.DepartamentoInvalidoException;
import Reuniones.Excepciones.DepartamentoVacioException;
import Reuniones.Excepciones.EmpleadoInvalidoException;

import java.util.ArrayList;

public class Departamento implements Invitable {

    private String nombre;
    private ArrayList<Empleado> departamento;


    /**
     * Constructor de la clase Departamento.
     * @param nombre nombre del departamento
     * @throws DepartamentoInvalidoException puede lanzar esta excepcion si el nombre es nulo o esta vacio
     */
    public Departamento(String nombre){
        if(nombre == null || nombre.isBlank()){
            throw new DepartamentoInvalidoException("El nombre del departamento no puede ser vacio");
        }

        this.nombre = nombre;
        departamento = new ArrayList<>();
    }

    /**
     * Metodo para agregar empleados al departamento
     * @param empleado empleado a agregar
     * @throws EmpleadoInvalidoException puede lanzar esta excepcion si el empleado es nulo
     */
    public void addEmpleado(Empleado empleado){
        if (empleado == null){
            throw new EmpleadoInvalidoException("El empleado no puede ser nulo");
        }

        departamento.add(empleado);
    }

    /**
     * Elimina un empleado especifico del departamento
     * @param empleado empleado que se quiere eliminar
     * @throws EmpleadoInvalidoException puede lanzar esta excepcion si el empleado ingresado no esta en el ArrayList departamento
     */
    public void removeEmpleado(Empleado empleado){
        if(!departamento.remove(empleado)){
            throw new EmpleadoInvalidoException("El empleado no es parte de este departamento");
        };
    }

    /**
     * Getter de un empleado del departamento en una posicion especifica
     * @param pos indice del empleado en el ArrayList departamento
     * @return empleado en la posicion indicada
     * @throws EmpleadoInvalidoException puede lanzar esta excepcion si el indice esta fuera de rango
     */
    public Empleado getEmpleadoDepartamento(int pos){
        if(pos < 0 || pos >= departamento.size()){
            throw new EmpleadoInvalidoException("El indice del empleado en el departamento esta fuera de rango");
        }

        return departamento.get(pos);
    }

    /**
     * Metodo que devuelve la cantidad actual de empleados del departamento
     * @return numero de empleados en el departamento
     */
    public int obtenerCantidadEmpleados(){
        return departamento.size();
    }

    /**
     * Getter del departamento
     * @return ArrayList con la lista de empleados del departamento
     */
    public ArrayList<Empleado> getDepartamento(){
        return departamento;
    }

    /**
     * Setter del nombre del departamento
     * @param nombre nombre nuevo a asignar al departamento
     * @throws DepartamentoVacioException puede lanzar esta excepcion si se intenta ingresar un nombre nulo o vacio al departamento
     */
    public void setNombre(String nombre){
        if(nombre == null || nombre.isBlank()){
            throw new DepartamentoInvalidoException("El nombre del departamento no puede ser vacio");
        }
        this.nombre = nombre;
    }

    /**
     * Metodo para invitar a cada uno de los empleados dentro del departamento, utiliza metodo de interfaz Invitable implementado en Empleado
     * @throws DepartamentoVacioException puede lanzar esta excepcion si el departamento al que se intenta invitar no posee empleados dentro
     */
    @Override
    public void invitar(){
        if (departamento.size() == 0) {
            throw new DepartamentoVacioException("El departamento a invitar no puede estar vacio.");
        }

        for (int i = 0; i < departamento.size(); i++){
            Empleado e = getEmpleadoDepartamento(i);
            e.invitar();
        }

        System.out.println("Invitaciones enviadas al departamento: " + nombre+" con un total de "+departamento.size()+" invitaciones.");
    }


    /**
     * toString que devuelve una representacion en texto del departamento
     * @return String con el nombre y el ArrayList de empleados del departamento
     */
    @Override
    public String toString(){
        return "Departamento{nombre = " + nombre + ", departamento = " + departamento + "}";
    }
}
