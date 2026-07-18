package app;


import data.GestorDatos;
import ui.InterfazLlanquihueTour;



public class Main {


    public static void main(String[] args) {


        GestorDatos gestor =
                new GestorDatos();



        gestor.cargarClientes();

        gestor.cargarEmpleados();

        gestor.cargarProveedores();

        gestor.cargarProductos();



        new InterfazLlanquihueTour(gestor);


    }

}