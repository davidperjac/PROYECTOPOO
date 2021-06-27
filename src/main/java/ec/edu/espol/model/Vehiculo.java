/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

import java.util.ArrayList;

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
    private ArrayList<Oferta> oferta;
    private String correo_vendedor;
    private Vendedor vendedor; 
    private String vidrios;  
    private String transmision;
    private String traccion; 
    private String tipo;
    
    
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
    
    
}
