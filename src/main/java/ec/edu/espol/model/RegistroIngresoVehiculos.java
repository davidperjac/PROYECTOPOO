/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author davidperez
 */
public class RegistroIngresoVehiculos {
    private String id;
    private String id_Vendedor;
    private String id_Vehiculo;
    private String correo_vendedor;
    private String placa_vehiculo;
    private Vehiculo vehiculo;
    private Vendedor vendedor;
    
    //constructor

    public RegistroIngresoVehiculos(String id, String id_Vendedor, String id_Vehiculo, String correo_vendedor, String placa_vehiculo, Vehiculo vehiculo, Vendedor vendedor) {
        this.id = id;
        this.id_Vendedor = id_Vendedor;
        this.id_Vehiculo = id_Vehiculo;
        this.correo_vendedor = correo_vendedor;
        this.placa_vehiculo = placa_vehiculo;
        this.vehiculo = vehiculo;
        this.vendedor = vendedor;
    }
    
    //getters y setters 

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_Vendedor() {
        return id_Vendedor;
    }

    public void setId_Vendedor(String id_Vendedor) {
        this.id_Vendedor = id_Vendedor;
    }

    public String getId_Vehiculo() {
        return id_Vehiculo;
    }

    public void setId_Vehiculo(String id_Vehiculo) {
        this.id_Vehiculo = id_Vehiculo;
    }

    public String getCorreo_vendedor() {
        return correo_vendedor;
    }

    public void setCorreo_vendedor(String correo_vendedor) {
        this.correo_vendedor = correo_vendedor;
    }

    public String getPlaca_vehiculo() {
        return placa_vehiculo;
    }

    public void setPlaca_vehiculo(String placa_vehiculo) {
        this.placa_vehiculo = placa_vehiculo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
    
    public static ArrayList<RegistroIngresoVehiculos> readFileRegistro (String nomfile) {
        ArrayList<RegistroIngresoVehiculos> vehiculos = new ArrayList<RegistroIngresoVehiculos>();
        
        try (Scanner sc = new Scanner(new File(nomfile))) {
            
            String linea = sc.nextLine();
            String [] tokens = linea.split("\\|");
            
            
            
            
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public static void link() {

        }
    }
    
    
    
    
    
    
    
    
    
    
}
