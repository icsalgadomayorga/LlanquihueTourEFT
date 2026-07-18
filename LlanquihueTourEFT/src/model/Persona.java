package model;

import interfaces.Registrable;


/**
 * Clase base para representar personas
 * dentro del sistema Llanquihue Tour.
 */
public class Persona implements Registrable {


    private String nombre;

    private Rut rut;

    private Direccion direccion;



    /**
     * Constructor de Persona.
     *
     * @param nombre Nombre de la persona.
     * @param rut RUT de la persona.
     * @param direccion Dirección de la persona.
     */
    public Persona(String nombre, Rut rut, Direccion direccion) {


        this.nombre = nombre;

        this.rut = rut;

        this.direccion = direccion;

    }



    public String getNombre() {

        return nombre;

    }



    public void setNombre(String nombre) {

        this.nombre = nombre;

    }



    public Rut getRut() {

        return rut;

    }



    public void setRut(Rut rut) {

        this.rut = rut;

    }



    public Direccion getDireccion() {

        return direccion;

    }



    public void setDireccion(Direccion direccion) {

        this.direccion = direccion;

    }



    /**
     * Método definido por la interfaz Registrable.
     */
    @Override
    public void registrar() {


        System.out.println(
                "Registro creado: "
                        + nombre
        );


    }



    /**
     * Muestra información por consola.
     * Se mantiene por compatibilidad.
     */
    @Override
    public void mostrarDatos() {


        System.out.println(
                mostrarDatosTexto()
        );


    }



    /**
     * Devuelve la información como String
     * para utilizarla en interfaces gráficas.
     */
    @Override
    public String mostrarDatosTexto() {


        return
                "Nombre: " + nombre +
                        "\nRUT: " + rut +
                        "\nDirección: " + direccion;


    }



    @Override
    public String toString() {


        return mostrarDatosTexto();


    }

}