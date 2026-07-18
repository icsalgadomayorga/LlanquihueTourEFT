package model;


/**
 * Representa un proveedor externo.
 */
public class Proveedor extends Persona {


    private String empresa;



    public Proveedor(
            String nombre,
            Rut rut,
            Direccion direccion,
            String empresa) {


        super(nombre, rut, direccion);


        this.empresa = empresa;

    }



    @Override
    public String mostrarDatosTexto(){

        return super.mostrarDatosTexto()
                + "\nEmpresa: "
                + empresa;

    }


}