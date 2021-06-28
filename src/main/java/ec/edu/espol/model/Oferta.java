/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.model;

/**
 *
 * @author davidperez
 */
public class Oferta {
    private String id;
    private String correo_comprador;
    private double precio_ofertado;
    private String placa_vehiculo;
    private Vehiculo vehiculo;
    private Comprador comprador;

    public Oferta(String id, String correo_comprador, double precio_ofertado, String placa_vehiculo, Vehiculo vehiculo, Comprador comprador) {
        this.id = id;
        this.correo_comprador = correo_comprador;
        this.precio_ofertado = precio_ofertado;
        this.placa_vehiculo = placa_vehiculo;
        this.vehiculo = vehiculo;
        this.comprador = comprador;
    }
    
    
    @Override
    public String toString(){
        return "Correo: " + this.correo_comprador + "\nPrecio Ofertado: " + this.precio_ofertado; 
    }
}
