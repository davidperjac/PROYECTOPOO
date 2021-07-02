/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import ec.edu.espol.util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author davidperez
 */
public class Usuario {
    protected int id;
    protected String correo;
    protected String clave;
    protected String nombres;
    protected String apellidos;
    protected String organizacion;
    
    
    public Usuario(String id, String correo, String clave, String nombres, String apellidos, String organizacion){
        this.id = id;
        this.correo = correo;
        this.clave = clave;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.organizacion = organizacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(String organizacion) {
        this.organizacion = organizacion;
    }
    
    // crea lista de correos
    public static ArrayList<String> recuperarCorreos(String nomfile){
        ArrayList<String> correos = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(nomfile))){
            while(sc.hasNextLine()){
                // linea = correo|...
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                String correo = tokens[1];
                correos.add(correo);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return correos;
    }
    
    //valida que el correo sea unico
    public static boolean validarCorreo(String correo,String nomfile){
        ArrayList<String> correos = recuperarCorreos(nomfile);
        return correos.contains(correo);
    }
    
    public static Usuario nextUsuario(Scanner sc, String nomfile){
        sc.useDelimiter("\n");
        System.out.println("REGISTRAR UN NUEVO USUARIO");
        System.out.println( "Introduzca su correo electrónico: " );
        String correo = sc.next();
        while(validarCorreo(correo, nomfile)){
            System.out.println("El correo que ingresó ya posee una cuenta, por favor ingrese otro correo si desea continuar.");
            correo = sc.next();
        }
        System.out.println( "Introduzca una clave: " );
        String clave = sc.next();
        System.out.println( "Introduzca sus nombres: " );
        String nombres = sc.next();
        System.out.println( "Introduzca sus apellidos: " );
        String apellidos = sc.next();
        System.out.println( "Introduzca su organizacion: " );
        String organizacion = sc.next();
        Usuario u = new Usuario(correo, clave, nombres, apellidos, organizacion);
        return u;
    }
    
    //comportamientos extras
    
    public static ArrayList<Usuario> readFileUsuarios (String nomfile) {
        ArrayList<Usuario> vehiculos = new ArrayList<Usuario>();
        
        try (Scanner sc = new Scanner(new File(nomfile))) {
            
            String linea = sc.nextLine();
            String [] tokens = linea.split("\\|");
            
            
            
            
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public void saveFileUsuarios() {
                
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File("Usuarios.txt")),true) ) {
            
            pw.println (this.nombres+"|"+this.apellidos+"|"+this.organizacion+"|"+this.correo+"|"+this.clave);

            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        
    }   
    
}
