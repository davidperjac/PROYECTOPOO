/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author davidperez
 */
public class Oferta {
    private String id;
    private String id_Comprador;
    private String id_Vehiculo;
    private String correo_comprador;
    private double precio_ofertado;
    private String placa_vehiculo;
    private Vehiculo vehiculo;
    private Comprador comprador;

    public Oferta(String id, String correo_comprador, double precio_ofertado, String placa_vehiculo, String id_Comprador, String id_vehiculo) {
        this.id = id;
        this.id_Comprador = id_Comprador;
        this.id_Vehiculo = id_Vehiculo;
        this.correo_comprador = correo_comprador;
        this.precio_ofertado = precio_ofertado;
        this.placa_vehiculo = placa_vehiculo;
        this.vehiculo = vehiculo;
        this.comprador = comprador;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorreo_comprador() {
        return correo_comprador;
    }

    public void setCorreo_comprador(String correo_comprador) {
        this.correo_comprador = correo_comprador;
    }

    public double getPrecio_ofertado() {
        return precio_ofertado;
    }

    public void setPrecio_ofertado(double precio_ofertado) {
        this.precio_ofertado = precio_ofertado;
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

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }
    
    
    
    
    @Override
    public String toString(){
        return "Correo: " + this.correo_comprador + "\nPrecio Ofertado: " + this.precio_ofertado; 
    }
    
    //extras
    
    public  void saveFileOfertas() {
        
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File("Ofertas.txt")),true) ) {
            
            pw.println (this.id+"|"+this.id_Comprador+"|"+this.id_Vehiculo+"|"+this.correo_comprador+"|"+this.precio_ofertado+"|"+this.placa_vehiculo);

            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<Oferta> readFileOferta (String nomfile) {
        ArrayList<Oferta> vehiculos = new ArrayList<Oferta>();
        
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
