package model;


/**
 * Representa la dirección de una persona.
 */
public class Direccion {


    private String direccion;

    private String ciudad;



    public Direccion(String direccion, String ciudad){


        this.direccion = direccion;

        this.ciudad = ciudad;


    }



    public String getDireccion(){

        return direccion;

    }



    public void setDireccion(String direccion){

        this.direccion = direccion;

    }



    public String getCiudad(){

        return ciudad;

    }



    public void setCiudad(String ciudad){

        this.ciudad = ciudad;

    }



    @Override
    public String toString(){

        return direccion + ", " + ciudad;

    }


}