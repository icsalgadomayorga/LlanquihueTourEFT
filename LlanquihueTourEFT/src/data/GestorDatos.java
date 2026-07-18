package data;


import interfaces.Registrable;
import model.Cliente;
import model.Direccion;
import model.Empleado;
import model.Persona;
import model.Producto;
import model.Proveedor;
import model.Rut;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Gestiona los datos del sistema Llanquihue Tour.
 */
public class GestorDatos {


    private ArrayList<Persona> personas;

    private ArrayList<Registrable> registros;

    private ArrayList<Producto> productos;

    private HashMap<String, Persona> mapaPersonas;



    public GestorDatos(){


        personas = new ArrayList<>();

        registros = new ArrayList<>();

        productos = new ArrayList<>();

        mapaPersonas = new HashMap<>();


    }





    //====================================
    // CARGAR CLIENTES
    //====================================

    public void cargarClientes(){


        try{


            BufferedReader br =
                    new BufferedReader(
                            new FileReader(
                                    "resources/clientes.txt"
                            )
                    );


            String linea;



            while((linea = br.readLine()) != null){


                String[] datos =
                        linea.split(";");



                Cliente cliente =
                        new Cliente(
                                datos[0],
                                new Rut(datos[1]),
                                new Direccion(
                                        datos[2],
                                        datos[3]
                                ),
                                datos[4]
                        );



                agregarCliente(cliente);


            }


            br.close();


        }
        catch(Exception e){


            System.out.println(
                    "Error cargando clientes: "
                            + e.getMessage()
            );


        }


    }







    //====================================
    // CARGAR EMPLEADOS
    //====================================

    public void cargarEmpleados(){


        try{


            BufferedReader br =
                    new BufferedReader(
                            new FileReader(
                                    "resources/empleados.txt"
                            )
                    );



            String linea;



            while((linea = br.readLine()) != null){


                String[] datos =
                        linea.split(";");



                Empleado empleado =
                        new Empleado(
                                datos[0],
                                new Rut(datos[1]),
                                new Direccion(
                                        datos[2],
                                        datos[3]
                                ),
                                datos[4],
                                Double.parseDouble(datos[5])
                        );



                agregarEmpleado(
                        empleado
                );


            }



            br.close();


        }
        catch(Exception e){


            System.out.println(
                    "Error cargando empleados: "
                            + e.getMessage()
            );


        }


    }







    //====================================
    // CARGAR PROVEEDORES
    //====================================

    public void cargarProveedores(){


        try{


            BufferedReader br =
                    new BufferedReader(
                            new FileReader(
                                    "resources/proveedores.txt"
                            )
                    );



            String linea;



            while((linea = br.readLine()) != null){


                String[] datos =
                        linea.split(";");



                Proveedor proveedor =
                        new Proveedor(
                                datos[0],
                                new Rut(datos[1]),
                                new Direccion(
                                        datos[2],
                                        datos[3]
                                ),
                                datos[4]
                        );



                agregarProveedor(
                        proveedor
                );


            }



            br.close();


        }
        catch(Exception e){


            System.out.println(
                    "Error cargando proveedores: "
                            + e.getMessage()
            );


        }


    }







    //====================================
    // CARGAR PRODUCTOS
    //====================================

    public void cargarProductos(){


        try{


            BufferedReader br =
                    new BufferedReader(
                            new FileReader(
                                    "resources/productos.txt"
                            )
                    );



            String linea;



            while((linea = br.readLine()) != null){


                String[] datos =
                        linea.split(";");



                Producto producto =
                        new Producto(
                                datos[0],
                                Double.parseDouble(datos[1])
                        );



                agregarProducto(producto);


            }



            br.close();


        }
        catch(Exception e){


            System.out.println(
                    "Error cargando productos: "
                            + e.getMessage()
            );


        }


    }







    //====================================
    // AGREGAR DATOS
    //====================================


    public void agregarCliente(Cliente cliente){


        personas.add(cliente);

        registros.add(cliente);


        mapaPersonas.put(
                cliente.getRut().toString(),
                cliente
        );


    }





    public void agregarEmpleado(Empleado empleado){


        personas.add(empleado);

        registros.add(empleado);


        mapaPersonas.put(
                empleado.getRut().toString(),
                empleado
        );


    }





    public void agregarProveedor(Proveedor proveedor){


        personas.add(proveedor);

        registros.add(proveedor);


        mapaPersonas.put(
                proveedor.getRut().toString(),
                proveedor
        );


    }





    public void agregarProducto(Producto producto){


        productos.add(producto);


    }







    //====================================
    // MOSTRAR REGISTROS ORGANIZADOS
    //====================================

    public String obtenerRegistrosTexto(){


        StringBuilder texto =
                new StringBuilder();



        texto.append(
                "===== CLIENTES =====\n\n"
        );



        for(Registrable registro : registros){


            if(registro instanceof Cliente){


                texto.append(
                        registro.mostrarDatosTexto()
                );


                texto.append(
                        "\n----------------------------\n"
                );


            }


        }




        texto.append(
                "\n===== EMPLEADOS =====\n\n"
        );



        for(Registrable registro : registros){


            if(registro instanceof Empleado){


                texto.append(
                        registro.mostrarDatosTexto()
                );


                texto.append(
                        "\n----------------------------\n"
                );


            }


        }




        texto.append(
                "\n===== PROVEEDORES =====\n\n"
        );



        for(Registrable registro : registros){


            if(registro instanceof Proveedor){


                texto.append(
                        registro.mostrarDatosTexto()
                );


                texto.append(
                        "\n----------------------------\n"
                );


            }


        }





        texto.append(
                "\n===== PRODUCTOS TURISTICOS =====\n\n"
        );



        for(Producto producto : productos){


            texto.append(
                    producto.toString()
            );


            texto.append(
                    "\n----------------------------\n"
            );


        }



        return texto.toString();


    }







    //====================================
    // BUSCAR PERSONA
    //====================================

    public Persona buscarPersona(String rut){


        return mapaPersonas.get(rut);


    }







    //====================================
    // ELIMINAR PERSONA
    //====================================

    public void eliminarPersona(String rut){


        Persona persona =
                mapaPersonas.get(rut);



        if(persona != null){


            personas.remove(persona);

            registros.remove(persona);

            mapaPersonas.remove(rut);


        }


    }





    public ArrayList<Producto> getProductos(){


        return productos;


    }


}