package model;


/**
 * Representa el RUT de una persona.
 */
public class Rut {


    private String numeroCompleto;



    public Rut(String numeroCompleto) {


        if(numeroCompleto == null || numeroCompleto.isBlank()) {

            throw new IllegalArgumentException(
                    "El RUT no puede estar vacío."
            );

        }


        this.numeroCompleto = numeroCompleto;

    }



    public String getNumeroCompleto() {

        return numeroCompleto;

    }



    public void setNumeroCompleto(String numeroCompleto) {

        this.numeroCompleto = numeroCompleto;

    }



    @Override
    public String toString() {

        return numeroCompleto;

    }

}