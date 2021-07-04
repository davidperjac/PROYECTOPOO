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
public class Comprador extends Usuario{
    private ArrayList<Oferta> ofertas;
    
    public Comprador(int id,String correo, String clave, String nombres, String apellidos, String organizacion){
        super(id,correo, clave, nombres, apellidos, organizacion);
        this.ofertas = new ArrayList<>();
    }

    public ArrayList<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(ArrayList<Oferta> ofertas) {
        this.ofertas = ofertas;
    }
    
    public static Comprador searchByID(ArrayList<Comprador> compradores, int id){
        for(Comprador c : compradores){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }
    
    
}
