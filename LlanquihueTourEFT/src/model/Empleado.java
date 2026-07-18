package model;


/**
 * Representa un empleado de la agencia.
 */
public class Empleado extends Persona {


    private String cargo;

    private double sueldo;



    public Empleado(
            String nombre,
            Rut rut,
            Direccion direccion,
            String cargo,
            double sueldo) {


        super(nombre, rut, direccion);


        this.cargo = cargo;

        this.sueldo = sueldo;


    }



    @Override
    public String mostrarDatosTexto(){

        return super.mostrarDatosTexto()
                + "\nCargo: "
                + cargo
                + "\nSueldo: "
                + sueldo;

    }


}