/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyecto_1p;
import ec.edu.espol.model.Vendedor;
import ec.edu.espol.util.Util;
import java.util.Scanner;

/**
 *
 * @author davidperez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    Scanner sc = new Scanner(System.in);
    
    sc.useDelimiter("\n");
        
    Vendedor v = new Vendedor("davidperjac@hotmail.com","123","David","Perez","ESPOL");    
    
    String mensaje = v.ingresarVehiculo(sc);
    
    System.out.println(v.getVehiculos().get(0));
    
    Vendedor h = new Vendedor("dfgdfgf","123","David","Perez","ESPOL");    
    
    String mensaje2 = h.ingresarVehiculo(sc);
    
    System.out.println(h.getVehiculos().get(0));    
        
        
    }
    
}
