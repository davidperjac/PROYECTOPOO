/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author davidperez
 */
public class Vehiculo {

    private String placa;
    private String marca;
    private String motor;
    private String anio;
    private String modelo;
    private double recorrido;
    private String color; 
    private String combustible; 
    private double precio;  
    private String vidrios;  
    private String transmision;
    private String traccion; 
    private String tipo;
    private ArrayList<Oferta> ofertas;
    private String correo_vendedor;
    private Vendedor vendedor;
    
    
    // Constructor de Autos
 
    public Vehiculo(String placa, String marca, String motor, String anio, String modelo, double recorrido, String color, String combustible, double precio, String vidrios, String transmision){
        this.placa = placa;
        this.marca = marca;
        this.motor = motor;
        this.anio = anio;
        this.modelo = modelo;
        this.recorrido = recorrido;
        this.color = color;
        this.combustible = combustible;
        this.precio = precio;
        this.vidrios = vidrios;
        this.transmision = transmision;
    }
    
    // Constructor de Camionetas
    
    public Vehiculo(String placa, String marca, String motor, String anio, String modelo, double recorrido, String color, String combustible, double precio, String vidrios, String transmision, String traccion){
        this.placa = placa;
        this.marca = marca;
        this.motor = motor;
        this.anio = anio;
        this.modelo = modelo;
        this.recorrido = recorrido;
        this.color = color;
        this.combustible = combustible;
        this.precio = precio;
        this.vidrios = vidrios;
        this.transmision = transmision;
        this.traccion = traccion;
    }
    
    // Constructor de motos
    
    public Vehiculo(String placa, String marca, String motor, String anio, String modelo, double recorrido, String color, String combustible, double precio){
        this.placa = placa;
        this.marca = marca;
        this.motor = motor;
        this.anio = anio;
        this.modelo = modelo;
        this.recorrido = recorrido;
        this.color = color;
        this.combustible = combustible;
        this.precio = precio;
    }

    public String getPlaca() {
        return placa;
    }

    public double getPrecio() {
        return precio;
    }
    
    /* 
    Metodo para  permitirle al vendedor revisar ofertas del vehiculo;
    Puede avanzar o retroceder de oferta
    Puede aceptar la oferta
    Puede salir 
    */
    
    public void verOfertas(Scanner sc){
        if(!this.ofertas.isEmpty()){
            System.out.println("Se han realizado: " + this.ofertas.size());
            int i = 0;
            int opcion = 0;
            while(opcion != 4){
                System.out.println("Oferta " + (i+1) + "\n" + ofertas.get(i));
                System.out.println("1 : siguiente oferta\n2: anterior oferta\n3 : aceptar oferta\n4 : salir");
                opcion = sc.nextInt();
                if(opcion == 1){
                    if(i == (this.ofertas.size() - 1))
                        i = 0;
                    else
                        i += 1;       
                }
                else if(opcion == 2){
                    if(i == 0)
                        i = this.ofertas.size() - 1;
                    else
                        i -= 1;
                }
                else if(opcion == 3)
                    this.vendedor.aceptarOferta(i);
                    this.ofertas.remove(i);
                    opcion = 4;
            }
        }
        else
            System.out.println("No hay ofertas para este vehiculo");       
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "placa: " + placa + ", marca: " + marca + ", motor: " + motor + ", anio: " + anio + ", modelo: " + modelo + ", recorrido: " + recorrido + ", color: " + color + ", combustible: " + combustible + ", precio: " + precio + ", tipo: " + tipo + ", vendedor: " + vendedor + '}';
    }
    
    @Override
    public boolean equals(Object o){
        if(o == null)
            return false;
        if(o == this)
            return true;
        if(o.getClass() != this.getClass())
            return false;
        
        Vehiculo other = (Vehiculo)o;
        
        return Objects.equals(this.placa, other.placa);   
    }
        
}
