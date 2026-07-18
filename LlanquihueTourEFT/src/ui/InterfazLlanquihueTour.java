package ui;


import data.GestorDatos;
import model.*;

import javax.swing.*;
import java.awt.*;


/**
 * Interfaz gráfica principal de Llanquihue Tour.
 */
public class InterfazLlanquihueTour extends JFrame {


    private GestorDatos gestor;

    private JTextArea areaTexto;



    public InterfazLlanquihueTour(GestorDatos gestor) {


        this.gestor = gestor;


        setTitle("Llanquihue Tour");


        setSize(500,600);


        setLocationRelativeTo(null);


        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );


        crearInterfaz();


        setVisible(true);


    }





    private void crearInterfaz(){


        JPanel panelBotones =
                new JPanel(
                        new GridLayout(5,1,5,5)
                );



        JButton btnCliente =
                new JButton("Agregar Cliente");


        JButton btnEmpleado =
                new JButton("Agregar Empleado");


        JButton btnProveedor =
                new JButton("Agregar Proveedor");


        JButton btnProducto =
                new JButton("Agregar Producto");


        JButton btnMostrar =
                new JButton("Mostrar Registros");



        Dimension tamaño =
                new Dimension(180,30);



        btnCliente.setPreferredSize(tamaño);
        btnEmpleado.setPreferredSize(tamaño);
        btnProveedor.setPreferredSize(tamaño);
        btnProducto.setPreferredSize(tamaño);
        btnMostrar.setPreferredSize(tamaño);



        panelBotones.add(btnCliente);
        panelBotones.add(btnEmpleado);
        panelBotones.add(btnProveedor);
        panelBotones.add(btnProducto);
        panelBotones.add(btnMostrar);



        areaTexto =
                new JTextArea();


        areaTexto.setEditable(false);



        JScrollPane scroll =
                new JScrollPane(areaTexto);



        add(
                panelBotones,
                BorderLayout.NORTH
        );


        add(
                scroll,
                BorderLayout.CENTER
        );





        btnMostrar.addActionListener(e -> {


            areaTexto.setText(
                    gestor.obtenerRegistrosTexto()
            );


        });




        btnCliente.addActionListener(e ->
                registrarCliente()
        );



        btnEmpleado.addActionListener(e ->
                registrarEmpleado()
        );



        btnProveedor.addActionListener(e ->
                registrarProveedor()
        );



        btnProducto.addActionListener(e ->
                registrarProducto()
        );


    }







    //====================================
    // CLIENTE
    //====================================


    private void registrarCliente(){


        try{


            String nombre =
                    JOptionPane.showInputDialog(
                            "Nombre cliente:"
                    );


            String rut =
                    JOptionPane.showInputDialog(
                            "RUT completo:"
                    );


            String correo =
                    JOptionPane.showInputDialog(
                            "Correo:"
                    );



            Cliente cliente =
                    new Cliente(
                            nombre,
                            new Rut(rut),
                            solicitarDireccion(),
                            correo
                    );



            gestor.agregarCliente(cliente);



            JOptionPane.showMessageDialog(
                    this,
                    "Cliente agregado correctamente"
            );



        }
        catch(Exception e){


            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage()
            );


        }


    }







    //====================================
    // EMPLEADO
    //====================================


    private void registrarEmpleado(){


        try{


            String nombre =
                    JOptionPane.showInputDialog(
                            "Nombre empleado:"
                    );


            String rut =
                    JOptionPane.showInputDialog(
                            "RUT completo:"
                    );


            String cargo =
                    JOptionPane.showInputDialog(
                            "Cargo:"
                    );


            double sueldo =
                    Double.parseDouble(
                            JOptionPane.showInputDialog(
                                    "Sueldo:"
                            )
                    );



            Empleado empleado =
                    new Empleado(
                            nombre,
                            new Rut(rut),
                            solicitarDireccion(),
                            cargo,
                            sueldo
                    );



            gestor.agregarEmpleado(
                    empleado
            );



            JOptionPane.showMessageDialog(
                    this,
                    "Empleado agregado correctamente"
            );



        }
        catch(Exception e){


            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage()
            );


        }


    }







    //====================================
    // PROVEEDOR
    //====================================


    private void registrarProveedor(){


        try{


            String nombre =
                    JOptionPane.showInputDialog(
                            "Nombre proveedor:"
                    );


            String rut =
                    JOptionPane.showInputDialog(
                            "RUT completo:"
                    );


            String empresa =
                    JOptionPane.showInputDialog(
                            "Empresa:"
                    );



            Proveedor proveedor =
                    new Proveedor(
                            nombre,
                            new Rut(rut),
                            solicitarDireccion(),
                            empresa
                    );



            gestor.agregarProveedor(
                    proveedor
            );



            JOptionPane.showMessageDialog(
                    this,
                    "Proveedor agregado correctamente"
            );



        }
        catch(Exception e){


            JOptionPane.showMessageDialog(
                    this,
                    e.getMessage()
            );


        }


    }







    //====================================
    // PRODUCTO
    //====================================


    private void registrarProducto(){


        try{


            String nombre =
                    JOptionPane.showInputDialog(
                            "Nombre producto:"
                    );


            double precio =
                    Double.parseDouble(
                            JOptionPane.showInputDialog(
                                    "Precio:"
                            )
                    );



            Producto producto =
                    new Producto(
                            nombre,
                            precio
                    );



            gestor.agregarProducto(
                    producto
            );



            JOptionPane.showMessageDialog(
                    this,
                    "Producto agregado correctamente"
            );



        }
        catch(Exception e){


            JOptionPane.showMessageDialog(
                    this,
                    "Error al agregar producto"
            );


        }


    }







    //====================================
    // DIRECCION NUEVA
    //====================================


    private Direccion solicitarDireccion(){


        String direccion =
                JOptionPane.showInputDialog(
                        "Ingrese dirección completa:"
                );



        String ciudad =
                JOptionPane.showInputDialog(
                        "Ingrese ciudad:"
                );



        return new Direccion(
                direccion,
                ciudad
        );


    }


}