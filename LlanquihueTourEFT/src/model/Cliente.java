package model;


/**
 * Representa un cliente de Llanquihue Tour.
 */
public class Cliente extends Persona {


    private String correo;



    public Cliente(
            String nombre,
            Rut rut,
            Direccion direccion,
            String correo) {


        super(nombre, rut, direccion);

        this.correo = correo;

    }



    public String getCorreo() {

        return correo;

    }



    public void setCorreo(String correo) {

        this.correo = correo;

    }



    @Override
    public String mostrarDatosTexto(){

        return super.mostrarDatosTexto()
                + "\nCorreo: "
                + correo;

    }


}