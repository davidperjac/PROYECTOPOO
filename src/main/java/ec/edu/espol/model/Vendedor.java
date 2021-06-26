/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.ArrayList;
import java.util.Scanner;
import ec.edu.espol.model.Vehiculo;

/**
 *
 * @author davidperez
 */
public class Vendedor extends Usuario{
    
    private ArrayList<Vehiculo> vehiculos;    
    
    Scanner sc = new Scanner(System.in);
    
    public String ingresarVehiculo(Vehiculo v, Scanner sc) {
        
        sc.useDelimiter("\n");
        this.validarUsuario();
        
        System.out.println("Ingrese el tipo de vehiculo");
        String tipo = sc.next();
        
        //Atributos
        
        System.out.println("Ingrese la placa del vehiculo");
        String placa = sc.next();
        
        for (Vehiculo vehiculo : vehiculos) {
            while (vehiculo.getPlaca() == placa ) { 
                System.out.println("ERORR! , Este vehiculo ya se encuentra en el sistema");
            }
        }
        
        System.out.println("Ingrese la marca del vehiculo");
        String marca = sc.next();
                
        System.out.println("Ingrese el modelo del vehiculo");
        String modelo = sc.next();
                
        System.out.println("Ingrese el tipo de motor del vehiculo");
        String motor = sc.next();
                
        System.out.println("Ingrese el año del vehiculo");
        String anio = sc.next();
                 
        System.out.println("Ingrese el recorrido que tiene el vehiculo");
        String recorrido = sc.next();
                
        System.out.println("Ingrese el color del vehiculo");
        String color = sc.next();
        
        System.out.println("Ingrese el tipo de combustible del vehiculo");
        String combustible = sc.next();
              
        System.out.println("Ingrese el precio del vehiculo");
        String precio = sc.next();
        
        if (tipo != "moto") {
            System.out.println("Ingrese el tipo de vidrio del vehiculo");
            String vidrios = sc.next();
            
            System.out.println("Ingrese la traccion del vehiculo");
            String traccion = sc.next();
        }

        else if (tipo == "camioneta") {
            System.out.println("Ingrese el tipo de vidrio del vehiculo");
            String vidrios = sc.next();        
        }
        
        Vehiculo vehiculo = new Vehiculo();
        
        vehiculos.add(vehiculo); 
        
        return "Se ha ingresado su vehiculo al sistema correctamente! ";
    }
    
    public void revisarOfertas(String placa) {
        
    }
    
    public String aceptarOferta (int oferta) {
        sc.useDelimiter("\n");
        this.validarUsuario();
        
        System.out.println("Ingrese la placa del vehiculo");
        String placa = sc.next();
        
        ArrayList ofertas = new ArrayList();
        Vehiculo carroEscogido = new Vehiculo();
        
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca() == placa ) {
               ofertas = vehiculo.getOfertas();
               carroEscogido = vehiculo;
            }
        }
        
        System.out.println(carroEscogido.getNombre()+"Precio:"+carroEscogido.getPrecio());
        System.out.println("Se han realizado "+ofertas.size()+" ofertas");
        
        boolean aceptar = false ; 
        while (aceptar == false) {
            for (int i = 0 ; i < ofertas.size(); i++ ) {
                int numeroOferta = 1 ; 
                boolean opcion = false;
                while (opcion == false ) {
                    System.out.println("Oferta "+numeroOferta);
                    System.out.println("Correo: "+ ofertas.get(i).getComprador().getCorreo());
                    System.out.println("Precio Ofertado: "+ofertas.get(i).getprecioOfertado());
                    
                    if (i == 0) {
                        System.out.println("1.- Siguiente Oferta");
                        System.out.println("2.- Aceptar Oferta");
                    }else if (i > 0 ) {
                        System.out.println("1.- Siguiente Oferta");
                        System.out.println("2.- Anterior Oferta");
                        System.out.println("3.- Aceptar Oferta");
                    }
                }
            }
        }


        
        return null;   
    }
}
