/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.ArrayList;
import java.util.Scanner;
import ec.edu.espol.model.Vehiculo;
import ec.edu.espol.model.Util;

/**
 *
 * @author davidperez
 */
public class Vendedor extends Usuario{
    
    private ArrayList<Vehiculo> vehiculos;    

    //Constructor
    
    public Vendedor (ArrayList<Vehiculo> vehiculos) {
        super();
        this.vehiculos = vehiculos;
    }
    
    //Getters y setters

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    
    //metodos
    
    
    public String ingresarVehiculo(Vehiculo v, Scanner sc, ArrayList<ArrayList<Vehiculo>> lvv) {
        
        
        super.validarUsuario();
        
        //tipo
        
        System.out.println("Ingrese el tipo de vehiculo (carro,moto o camioneta)");
        String tipo = sc.next().toUpperCase();
        while (  (tipo != "CARRO") && (tipo != "MOTO") && (tipo != "CAMIONETA") ) {
            System.out.println("ERROR! Ingrese un tipo correcto");
            tipo = sc.next();
        }
        
        
        //Atributos
        
        //placa
        
        System.out.println("Ingrese la placa del vehiculo");
        Util.validarPlaca(sc.next().toUpperCase(), sc);
        
        //marca
        
        System.out.println("Ingrese la marca del vehiculo");
        String marca = sc.next();
        

        //modelo
                
        System.out.println("Ingrese el modelo del vehiculo");
        String modelo = sc.next();
        
        //motor
                
        System.out.println("Ingrese el tipo de motor del vehiculo");
        String motor = sc.next();
                
        //año
        
        System.out.println("Ingrese el año del vehiculo");
        int anio = sc.nextInt();
             
        while (anio < 1856) {
            System.out.println("ERROR! año invalido");
            System.out.println("Ingrese el año del vehiculo");
            anio = sc.nextInt();
        }
        
        //recorrido 
        
        System.out.println("Ingrese el recorrido que tiene el vehiculo");
        int recorrido = sc.nextInt();
        
        while (recorrido < 0) {
            System.out.println("ERROR! recorrido invalido");
            System.out.println("Ingrese el recorrido que tiene el vehiculo");
            recorrido = sc.nextInt();
        }
        
        //color
        
        System.out.println("Ingrese el color del vehiculo");
        String color = sc.next();
        
        //Combustible
        
        System.out.println("Ingrese el tipo de combustible del vehiculo (SUPER,EXTRA,ECOPAIS,DIESEL)");
        String combustible = sc.next().toUpperCase();
              
        while ( (combustible != "SUPER"  ) && ( combustible != "EXTRA" ) && ( combustible != "ECOPAIS") && ( combustible != "DIESEL")  ) {
            System.out.println("ERROR! combustible invalido");
            System.out.println("Ingrese el tipo de combustible del vehiculo (SUPER,EXTRA,ECOPAIS,DIESEL)");
            combustible = sc.next().toUpperCase();
        }
        
        //precio
        
        System.out.println("Ingrese el precio del vehiculo");
        int precio = sc.nextInt();
        
        while (precio < 0 ) {
            System.out.println("ERROR! precio invalido");
            System.out.println("Ingrese el precio del vehiculo");
            precio = sc.nextInt();
        }
        
        //validaciones del tipo
        
        if (tipo != "MOTO") {
            System.out.println("Ingrese el tipo de vidrio del vehiculo");
            String vidrios = sc.next().toUpperCase();
            
            System.out.println("Ingrese la transmision del vehiculo");
            String transmision = sc.next().toUpperCase();
            
            while ( (transmision != "MANUAL") && (transmision != "AUTOMATICO") ) {
                System.out.println("ERROR! transmision erronea");
                System.out.println("Ingrese la transmision del vehiculo");
                transmision = sc.next().toUpperCase();

            }
            if (tipo == "CARRO") {
                
                Vehiculo vehiculo = new Vehiculo();

                vehiculos.add(vehiculo); 

                Util.saveFileVehiculos(lvv, this.getCorreo() );
                
            }else if (tipo == "CAMIONETA") {
                System.out.println("Ingrese el tipo de traccion del vehiculo");
                String traccion = sc.next();   

                Vehiculo vehiculo = new Vehiculo();

                vehiculos.add(vehiculo); 

                Util.saveFileVehiculos(lvv.add(vehiculos), "Vehiculos.txt" );
            }
        }
        
        else if (tipo == "MOTO"){
            Vehiculo vehiculo = new Vehiculo();

            vehiculos.add(vehiculo); 

            Util.saveFileVehiculos(lvv.add(vehiculos), "Vehiculos.txt" );

        }
            

       
        
        return "Se ha ingresado su vehiculo al sistema correctamente! ";
    }
    

    
    public String aceptarOferta (Scanner sc) {
        sc.useDelimiter("\n");
        super.validarUsuario();
        
        System.out.println("Ingrese la placa del vehiculo");
        Util.validarPlaca(sc.next().toUpperCase(), sc);
        
        ArrayList ofertas = new ArrayList<Oferta>();
        Vehiculo carroEscogido = new Vehiculo();
        
        //vehiculos no , debe ser archivo
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
                            Util.saveFileVehiculos(lvv.add(vehiculos), "Vehiculos.txt" );


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
                            Util.saveFileVehiculos(lvv.add(vehiculos), "Vehiculos.txt" );



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
}
