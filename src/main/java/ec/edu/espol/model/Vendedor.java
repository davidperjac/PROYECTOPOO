/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.ArrayList;
import java.util.Scanner;
import ec.edu.espol.model.Vehiculo;
import ec.edu.espol.util.Util;

/**
 *
 * @author davidperez
 */
public class Vendedor extends Usuario{
    
    private ArrayList<Vehiculo> vehiculos;    

    //Constructor
    
    public Vendedor ( String id,String correo, String clave, String nombres, String apellidos, String organizacion) {
        super(id,correo,clave,nombres,apellidos,organizacion);
        this.vehiculos = new ArrayList<Vehiculo>();
    }
    
    //Getters y setters

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    //metodos
    
    
    public String ingresarVehiculo(Scanner sc, Vehiculo v) {
        
        this.vehiculos.add(v);

        return "Su vehiculo se ha ingresado al sistema exitosamente";
        
    }
    

    /*
    public String aceptarOferta (Scanner sc) {
        sc.useDelimiter("\n");
        super.validarUsuario();
        
        System.out.println("Ingrese la placa del vehiculo");
        Util.validarPlaca(sc.next().toUpperCase(), sc);
        
        //busca en base de datos 
        for (Vehiculo vehiculo : vehiculos) {
            
        }
        
        System.out.println(carroEscogido.getNombre()+"Precio:"+carroEscogido.getPrecio());
        System.out.println("Se han realizado "+ofertas.size()+" ofertas");
        
        boolean aceptar = false ; 
        while (aceptar == false) {
            int numeroOferta = 1 ; 
            for (int i = 0 ; i < ofertas.size(); i++ ) {             
                boolean opcion = false;      
                while (opcion == false ) {
                    System.out.println("Oferta "+numeroOferta);
                    System.out.println("Correo: "+ ofertas.get(i).getComprador().getCorreo());
                    System.out.println("Precio Ofertado: "+ofertas.get(i).getprecioOfertado());  
                    if (i == 0) {
                        int seleccion = 0 ;
                            while ( (seleccion != 1) && (seleccion != 2) ) {
                                System.out.println("1.- Siguiente Oferta");
                                System.out.println("2.- Aceptar Oferta");
                                seleccion = sc.nextInt();
                            }
                        if (seleccion == 1) {   
                            opcion = true ;
                            numeroOferta++;
                        }else if (seleccion == 2) {
                            //eliminacion de oferta en sistema y en la lista
                            vehiculos.remove(ofertas.get(i).getVehiculo());
                            Util.saveFileVehiculos("Vehiculos.txt" );
                            //enviar correo al usuario
                            //salir del menu
                            aceptar = true;
                        }
                    }else if (i > 0 ) {   
                        int seleccion = 0 ;
                        while ( (seleccion != 1) && (seleccion != 2) && (seleccion != 3) ) {
                            System.out.println("1.- Siguiente Oferta");
                            System.out.println("2.- Anterior Oferta");
                            System.out.println("3.- Aceptar Oferta");
                            seleccion = sc.nextInt();
                        }  
                        if (seleccion == 1) {        
                            opcion = true ;
                            numeroOferta++;        
                        }else if (seleccion == 2) {
                            i -= 2;
                            opcion = true; 
                            numeroOferta--;
                        }else if (seleccion == 3) {
                            //eliminacion de oferta en sistema y en la lista
                            vehiculos.remove(ofertas.get(i).getVehiculo());
                            Util.saveFileVehiculos("Vehiculos.txt" );
                            //enviar correo al usuario             
                            //salir del menu
                            aceptar = true;
                        }
                    }
                }
            }
        }

        return "Se ha aceptado la oferta exitosamente !";   
    }
    */
}
