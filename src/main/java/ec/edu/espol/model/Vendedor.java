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
    
    public Vendedor ( String correo, String clave, String nombres, String apellidos, String organizacion) {
        super(correo,clave,nombres,apellidos,organizacion);
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
    
    
    public String ingresarVehiculo(Scanner sc) {
        //super.validarCorreo();
        
        //tipo
        
        System.out.println("Ingrese el tipo de vehiculo (carro,moto o camioneta)");
        String tipo = sc.next().toUpperCase();
        while (  (!tipo.equals("CARRO")) && (!tipo.equals("MOTO") ) && (!tipo.equals("CAMIONETA")) ) {
            System.out.println("ERROR! Ingrese un tipo correcto");
            tipo = sc.next();
        }
        
        
        //Atributos
        
        //placa
        
        System.out.println("Ingrese la placa del vehiculo");
        String placa = sc.next();   //Util.validarPlaca(sc.next().toUpperCase(), sc);
        
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
              
        while ( ( !combustible.equals("SUPER")  ) && ( !combustible.equals("EXTRA") ) && ( !combustible.equals("ECOPAIS")) && ( !combustible.equals("DIESEL"))  ) {
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
        
        //idVendedor 
        
        String idVendedor = this.correo;
        
        //validaciones del tipo
        
        if (!tipo.equals("MOTO")) {
            System.out.println("Ingrese el tipo de vidrio del vehiculo");
            String vidrios = sc.next().toUpperCase();
            
            System.out.println("Ingrese la transmision del vehiculo");
            String transmision = sc.next().toUpperCase();
            
            while ( !(transmision.equals("MANUAL")) && ( !transmision.equals("AUTOMATICO")) ) {
                System.out.println("ERROR! transmision erronea");
                System.out.println("Ingrese la transmision del vehiculo");
                transmision = sc.next().toUpperCase();

            }
            if (tipo.equals("CARRO")) {
                
                Vehiculo vehiculo = new Vehiculo(idVendedor, placa, marca, motor, anio, modelo, recorrido,color,combustible, precio, vidrios, transmision,tipo);

                vehiculos.add(vehiculo); 

                Util.saveFileVehiculos(vehiculos);
                
            }else if (tipo.equals("CAMIONETA")) {
                System.out.println("Ingrese el tipo de traccion del vehiculo");
                String traccion = sc.next();   

                Vehiculo vehiculo = new Vehiculo(idVendedor, placa, marca, motor, anio, modelo, recorrido,color,combustible, precio, vidrios, transmision,traccion,tipo);

                vehiculos.add(vehiculo); 

                Util.saveFileVehiculos(vehiculos);
            }
        }
        
        else if (tipo.equals("MOTO")) {
            Vehiculo vehiculo = new Vehiculo(idVendedor, placa, marca, motor, anio, modelo, recorrido,color,combustible, precio,tipo);

            vehiculos.add(vehiculo); 

            Util.saveFileVehiculos(vehiculos);

        }

        return "Se ha ingresado su vehiculo al sistema correctamente! ";
    }
    

    /*
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
