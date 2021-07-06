/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.util;
import ec.edu.espol.model.Comprador;
import ec.edu.espol.model.Oferta;
import ec.edu.espol.model.Usuario;
import ec.edu.espol.model.Vehiculo;
import ec.edu.espol.model.Vendedor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    
    public static String recuperarPlaca(String placa,Scanner sc) {
 
        while (!Util.validarPlaca(placa)) {
            System.out.println("ERROR! Ingrese una placa valida");
            placa = sc.next();
        }
        boolean puerta = false;
        while(!puerta){
            if(!Util.validarPlaca(placa)){
                System.out.println("ERROR! Ingrese una placa valida");
                placa = sc.next();
            }
            else if (Vehiculo.searchByPlaca(Vehiculo.readFile("vehiculos.txt"), placa) != null ){
                System.out.println("Este vehiculo ya esta registrado en el sistema! Por favor ingrese de nuevo");
                placa = sc.next();
            }else {
                puerta = true;
            }
            
        }
        
        return placa;
        
    }
    
    public static boolean validarPlaca(String placa){
        String regex = "^[A-Z][A-Z][A-Z]-[0-9]{3,4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(placa);
        return matcher.matches();
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
    
    //sacar de util
    public static String validarAtributos(Scanner sc){
        System.out.println("Ingrese la placa del vehiculo");
        String placa = Util.recuperarPlaca(sc.next(), sc);          
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
    
    // Editar
    public static int menuVendedor(Scanner sc){
        int opcion;
        do{
        System.out.println("1. Ingresar nuevo vendedor\n2. Registrar un vehiculo\n3. Aceptar Ofertas\n4. Regresar");
        opcion = sc.nextInt();
        } while(opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4);
        return opcion;
    }
    
    // Editar
    public static int menuComprador(Scanner sc){
        int opcion;
        do{
        System.out.println("1. Registrar nuevo comprador\n2. Ofertar por un vehiculo\n3. Regresar");
        opcion = sc.nextInt();
        } while(opcion != 1 && opcion != 2 && opcion != 3);
        return opcion;
    }
     
    public static Comprador inicioSesionC(Scanner sc) throws NoSuchAlgorithmException{
        String correo;
        String clave;

        do{
            System.out.println( "Introduzca su correo electrónico: " );
            correo = sc.next();
            System.out.println( "Introduzca su clave: " );
            clave = sc.next();
        }while(!Usuario.validarUsuario(correo,clave,"compradores.txt"));
        Comprador comp = new Comprador(Usuario.recuperarUsuario(correo, "compradores.txt"));
        return comp;
    }
    
    public static Vendedor inicioSesionV(Scanner sc) throws NoSuchAlgorithmException{
        String correo;
        String clave;

        do{
            System.out.println( "Introduzca su correo electrónico: " );
            correo = sc.next();
            System.out.println( "Introduzca su clave: " );
            clave = sc.next();
        }while(!Usuario.validarUsuario(correo,clave,"vendedores.txt"));
        Vendedor u = new Vendedor(Usuario.recuperarUsuario(correo, "vendedores.txt"));
        return u;
    }
    
    public static void removerLinea(String nomFile, int id, int num){
        File oldFile = new File(nomFile);
        File newFile = new File("temp.txt");
        try{
            PrintWriter pw = new PrintWriter(new FileOutputStream(newFile), true);
            Scanner sc = new Scanner(oldFile); 
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] tokens = line.split("\\|");
                if(Integer.parseInt(tokens[num]) != id){
                    pw.println(String.join("|", tokens));
                }
            }
            sc.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(nomFile);
            newFile.renameTo(dump);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void actualizar(ArrayList<Vendedor> vendedores, ArrayList<Comprador> compradores, ArrayList<Oferta> ofertas, ArrayList<Vehiculo> vehiculos ){
        Oferta.link(compradores, vehiculos, ofertas);
        Vehiculo.link(vehiculos, vendedores);
    }
    
}



