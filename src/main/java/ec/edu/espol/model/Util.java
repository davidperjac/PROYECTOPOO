/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;
import ec.edu.espol.model.Vendedor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author davidperez
 */
public class Util {
    
    public static boolean isNumeric(String str) { 
        try {  
          Double.parseDouble(str);  
          return true;
        } catch(NumberFormatException e){  
          return false;  
        }  
    }
    
    public static String validarPlaca (String placa, Scanner sc) {
        
        StringBuilder resultado= new StringBuilder();
        
        boolean puerta = false; 
        while (puerta == false) {
            if ((placa.length() == 8 && placa.length() == 7)) {

                for (int i = 0 ; i < 3 ; i++) {
                   
                    if ( false == Util.isNumeric(Character.toString(placa.charAt(i))) )  {
                        resultado.append(placa.charAt(i));        
                    }
                }
                    
                if (resultado.length() == 3) {
                    if (Character.toString(placa.charAt(3)) == "-") {
                        
                        
                        for (int i = 4 ; i < placa.length() ; i++) {
                            if ( true == Util.isNumeric(Character.toString(placa.charAt(i))) )  {
                            resultado.append(placa.charAt(i));        
                            }
                        }
                        
                        if ( (resultado.length() == 7  )&&( resultado.length() == 8 ) ) {
                            
                            boolean igualdad = false ; 
                            
                            //acceder al archivo del sistema para verificar que no haya otro carro en el sistema
                            for () {
                                
                                if (vehiculo.getPlaca() == resultado.toString() ) { 
                                    igualdad = true;
                                    System.out.println("ERORR! , Este vehiculo ya se encuentra en el sistema");
                                    System.out.println("Ingrese la placa del vehiculo");
                                    placa = sc.next();                                   
                                }

                            }
                            
                            if (igualdad = false){
                                return resultado.toString();
                            }
                            
                            
                        }else{
                            System.out.println("ERROR! Los ultimos 3 o 4 caracteres deben ser digitos ");
                            System.out.println("Ingrese la placa del vehiculo");
                            placa = sc.next();
                        }

                    } else {
                        System.out.println("ERROR! El 4 caracter es un - ");
                        System.out.println("Ingrese la placa del vehiculo");
                        placa = sc.next();
                    }
                }else {
                    System.out.println("ERROR! Los primeros 3 caracteres son letras");
                    System.out.println("Ingrese la placa del vehiculo");
                    placa = sc.next();
                }          
            }else {
                System.out.println("ERROR! Ingrese un tamaño de placa valida");
                System.out.println("Ingrese la placa del vehiculo");
                placa = sc.next();
            }
        }        
    }
    
    //agregar y sobreescribir
    public static void saveFileVehiculos(String nomfile) {
        
        ArrayList<ArrayList<Vehiculo>> listaDeListasVehiculos = new ArrayList<ArrayList<Vehiculo>>();
        
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile))) ) {
            
            for (ArrayList<Vehiculo> vehiculos : listaDeListasVehiculos  ) {
                for (Vehiculo v : vehiculos) {
                    if (v.getTipo() == "CARRO") {
                        pw.println( v.getPlaca()+"|"+v.getMarca()+"|"+v.getModelo()+"|"+v.getMotor()+"|"+v.getAnio()+"|"+v.getRecorrido()+"|"+v.getColor()+"|"+v.getCombustible()+"|"+v.getVidrios()+"|"+v.getTransmision()+"|"+v.getPrecio() );                                        
                    }else if (v.getTipo() == "MOTO") {
                        pw.println( v.getPlaca()+"|"+v.getMarca()+"|"+v.getModelo()+"|"+v.getMotor()+"|"+v.getAnio()+"|"+v.getRecorrido()+"|"+v.getColor()+"|"+v.getCombustible()+"|"+v.getPrecio() );                                        
                    }else if (v.getTipo() == "CAMIONETA"){
                        pw.println( v.getPlaca()+"|"+v.getMarca()+"|"+v.getModelo()+"|"+v.getMotor()+"|"+v.getAnio()+"|"+v.getRecorrido()+"|"+v.getColor()+"|"+v.getCombustible()+"|"+v.getVidrios()+"|"+v.getTransmision()+"|"+v.getTraccion()+"|"+v.getPrecio() );                                        
                    }
                }
            }

            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }                                   
    
    //agregar 
    public static void saveFileUsuarios(Usuario u, String nomfile) {
                
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile)),true) ) {
            
            pw.println(u.getNombres()+"|"+u.getApellidos()+"|"+u.getOrganizacion()+"|"+u.getCorreo()+"|"+u.getClave());

            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }      
    
    
    //agregar y sobreescribir
    public static void saveFileOfertas() {
        
    }
    
    //contraseña
    
}

