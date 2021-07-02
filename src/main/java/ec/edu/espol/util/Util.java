/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;
import ec.edu.espol.model.Usuario;
import ec.edu.espol.model.Vehiculo;
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
    
    private Util(){}
    
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
    
    
                                  
    

    //extras

    
    
    public static int nextID(String nomfile) {
        int id = 0;
        try (Scanner sc = new Scanner (new File(nomfile))) {
            
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String [] tokens = linea.split ("\\|");
                id = Integer.parseInt(tokens[0]);
            }
            
            
        }catch(Exception e) {
            
        }
        return id+1;
    }
    
    public static String validarAtributos(Scanner sc){
        System.out.println("Ingrese la placa del vehiculo");
        String placa = Util.validarPlaca(sc.next().toUpperCase(), sc);          
        System.out.println("Ingrese la marca del vehiculo");
        String marca = sc.next();             
        System.out.println("Ingrese el modelo del vehiculo");
        String modelo = sc.next();                 
        System.out.println("Ingrese el tipo de motor del vehiculo");
        String motor = sc.next();       
        System.out.println("Ingrese el año del vehiculo");
        int anio = sc.nextInt();
        double recorrido;
        do{
        System.out.println("Ingrese el recorrido que tiene el vehiculo");
        recorrido = sc.nextInt();
        }while (recorrido < 0);
        System.out.println("Ingrese el color del vehiculo");
        String color = sc.next();
        String combustible;
        do{
        System.out.println("Ingrese el tipo de combustible del vehiculo (SUPER,EXTRA,ECOPAIS,DIESEL)");
        combustible = sc.next().toUpperCase();        
        }while( ( !combustible.equals("SUPER")  ) && ( !combustible.equals("EXTRA") ) && ( !combustible.equals("ECOPAIS")) && ( !combustible.equals("DIESEL")));
        int precio;
        do{
        System.out.println("Ingrese el precio del vehiculo");
        precio = sc.nextInt();      
        }while (precio < 0 );
        return placa + "," + marca + "," + motor + "," + anio + "," + modelo + "," + recorrido + "," + color + "," + combustible + "," + precio;
    }
    
}



