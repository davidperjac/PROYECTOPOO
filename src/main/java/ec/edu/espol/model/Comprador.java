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
    
    
}
